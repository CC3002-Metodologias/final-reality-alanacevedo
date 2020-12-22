package com.github.alanacevedo.finalreality.controller;
import com.github.alanacevedo.finalreality.controller.factory.CharacterFactory;
import com.github.alanacevedo.finalreality.controller.factory.WeaponFactory;
import com.github.alanacevedo.finalreality.controller.handler.*;
import com.github.alanacevedo.finalreality.controller.phase.phase.*;
import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import com.github.alanacevedo.finalreality.model.character.enemy.Enemy;
import com.github.alanacevedo.finalreality.model.character.enemy.EnemyGroup;
import com.github.alanacevedo.finalreality.model.character.enemy.IEnemyGroup;
import com.github.alanacevedo.finalreality.model.magic.IMagicSpell;
import com.github.alanacevedo.finalreality.model.player.IPlayer;
import com.github.alanacevedo.finalreality.model.player.Player;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class that represents the game controller. Is in charge of managing the logic of the game and proccesing player input.
 */
public class GameController {
    private final BlockingQueue<ICharacter> turnsQueue = new LinkedBlockingQueue<>();
    private final IPlayer player;
    private final IEnemyGroup enemyGroup;
    private int aliveEnemies;
    private int alivePlayerCharacters = Settings.partySize;
    private boolean attending = false;
    private boolean battleActive = false;
    private final AddToQueueHandler queueHandler = new AddToQueueHandler(this);
    private final PlayerCharTurnStartHandler playerCharTurnStartHandler = new PlayerCharTurnStartHandler(this);
    private final PlayerCharDeathHandler playerCharDeathHandler = new PlayerCharDeathHandler(this);
    private final EnemyTurnStartHandler enemyTurnStartHandler = new EnemyTurnStartHandler(this);
    private final EnemyDeathHandler enemyDeathHandler = new EnemyDeathHandler(this);
    private final CharacterFactory characterFactory = new CharacterFactory(this);
    private final WeaponFactory weaponFactory = new WeaponFactory(this);
    private IPhase currentPhase;
    private IPlayableCharacter currentChar;


    /**
     * Initializes a new game controller
     */
    public GameController() {
        player = new Player(); // Can receive a name
        enemyGroup = new EnemyGroup();
        currentPhase = new WaitingPhase(this);
    }

    /**
     * Adds this controller's handlers to a character listener list.
     */
    public void addListenersToPlayerChar(IPlayableCharacter character) {
        character.setAddToQueueHandler(queueHandler);
        character.setTurnStartHandler(playerCharTurnStartHandler);
        character.setDeathHandler(playerCharDeathHandler);
    }

    public void addListenersToEnemy(Enemy enemy) {
        enemy.setAddToQueueHandler(queueHandler);
        enemy.setTurnStartHandler(enemyTurnStartHandler);
        enemy.setDeathHandler(enemyDeathHandler);
    }

    public CharacterFactory getCharacterFactory() {
        return characterFactory;
    }

    public WeaponFactory getWeaponFactory() {
        return weaponFactory;
    }

    /**
     * Equips a weapon from the player's inventory to a character from the player's party.
     * @param inventorySlot Slot where the weapon will be taken from
     * @param partySlot Slot where the character is located.
     */
    public void equipWeaponToCharacter(int inventorySlot, int partySlot) {
        if (player.getWeaponFromInventory(inventorySlot) != null) {
            player.equipWeaponToCharacter(inventorySlot, partySlot);
        }
    }

    public void equipWeaponToCurrentCharacter(int inventorySlot) {
        int currentCharSlot = player.getCharacterSlot(currentChar);
        player.equipWeaponToCharacter(inventorySlot, currentCharSlot);
    }

    /**
     * Swaps weapons from the player's inventory. Can be used to move a weapon from a slot to
     * an empty one.
     * @param slot1 first inventory slot
     * @param slot2 second inventory slot
     */
    public void swapInventorySlots(int slot1, int slot2) {
        player.swapInventorySlots(slot1, slot2);
    }

    /**
     * Updates the aliveEnemies attribute depending of the current enemy group size. Supposed to be used in
     * conjunction with spawnEnemyGroup.
     */
    public void updateEnemyGroupSize() {
        aliveEnemies = enemyGroup.getCurrentGroupSize();
    }

    /**
     * Reduces the aliveEnemies parameter by one.
     */
    public void enemyDeath() {
        aliveEnemies--;
        if (aliveEnemies== 0) {
            endBattle();
        }
    }

    /**
     * Reduces the alivePlayerCharacters parameter by one.
     */
    public void playerCharacterDeath() {
        alivePlayerCharacters--;
        if (alivePlayerCharacters == 0) {
            endBattle();
        }
    }

    /**
     * Makes a character from the player's party attack an enemy from the enemy group.
     * @param partySlot slot of the party where the attacking character is located.
     * @param mobSlot slot of the enemy group where the attacked enemy is located.
     */
    public void PCharAttackEnemy(int partySlot, int mobSlot) {
        Enemy enemy = enemyGroup.getEnemy(mobSlot);
        player.charAttack(partySlot, enemy);
    }

    /**
     * Makes a enemy from the enemy group attack a character from the player's party
     * @param mobSlot slot of the enemy group where the attacking enemy is located.
     * @param partySlot slot of the party where the attacked character is located.
     */
    public void EnemyAttackPChar(int mobSlot, int partySlot) {
        Enemy enemy = enemyGroup.getEnemy(mobSlot);
        enemy.attack(player.getCharacterFromParty(partySlot));
    }

    /**
     * Returns the player.
     */
    public IPlayer getPlayer() {
        return player;
    }

    /**
     *
     * Returns the enemy group.
     */
    public IEnemyGroup getEnemyGroup() {
        return enemyGroup;
    }

    /**
     * Returns the turns queue.
     */
    public BlockingQueue<ICharacter> getTurnsQueue() {
        return turnsQueue;
    }

    /**
     * Adss a character to the turns queue.
     * @param character character to be added.
     */
    public void addToQueue(ICharacter character) {
        if (battleActive && character.isAlive()) {
            character.addToQueue();
            if (!attending) {
                attending = true;
                attendQueue();
            }
        }
    }

    /**
     * Polls the first character from the queue and makes it take a turn.
     */
    void attendQueue() {
        ICharacter character = turnsQueue.poll();
        assert character != null;
        character.takeTurn();
    }

    /**
     * Ends a character's turn. Checks if the controller should keep attending the queue or not.
     */
    public void endTurn() {
        if (turnsQueue.isEmpty()) {
            attending = false;
            setPhase(new WaitingPhase(this));
        } else {
            attendQueue();
        }
    }

    /**
     * Makes an enemy Turn take place. The enemy picks a random alive character from the player's party and attacks him
     * @param enemy enemy that takes the turn.
     */
    public void enemyTurn(Enemy enemy) {
        int partySize = Settings.partySize;
        int randSlot = ThreadLocalRandom.current().nextInt(0, partySize);

        // To avoid attacking dead characters
        while(! player.getCharacterFromParty(randSlot).isAlive()){
            randSlot = ThreadLocalRandom.current().nextInt(0, partySize);
        }

        enemy.attack(player.getCharacterFromParty(randSlot));
        enemy.waitTurn();
        endTurn();
    }

    /**
     * Makes a player character Turn take place.
     * @param character player character that takes the turn.
     */
    public void randomPCTurn(IPlayableCharacter character) {
        // For the time being, will function similar to enemyTurn
        // User interaction will be implemented later.
        // later this method will be renamed randomPCTurn.
        int groupSize = enemyGroup.getCurrentGroupSize();
        int randSlot = ThreadLocalRandom.current().nextInt(0, groupSize);

        // to avoid attacking dead players
        while(!enemyGroup.getEnemy(randSlot).isAlive()) {
            randSlot = ThreadLocalRandom.current().nextInt(0, groupSize);
        }

        character.attack(enemyGroup.getEnemy(randSlot));
        character.waitTurn();
        endTurn();
    }



      public void playerCharacterTurn(IPlayableCharacter character) {
              currentChar = character;
              currentPhase.changePhase(new ActionSelectionPhase(this));
          }

    public void setCurrentChar(IPlayableCharacter character) {
        currentChar = character;
    }

    public IPlayableCharacter getCurrentChar() {
        return currentChar;
    }

    public void attackEnemySlot(int enemySlot) {
              Enemy enemy = enemyGroup.getEnemy(enemySlot);
              if (enemy != null) {
                  if (enemy.isAlive()) {
                      currentChar.attack(enemy);
                      currentChar.waitTurn();
                      setPhase(new WaitingPhase(this));
                      endTurn();
                  }
              }
          }

    public void castSpellOnEnemySlot(IMagicSpell spell, int enemySlot) {
        Enemy enemy = enemyGroup.getEnemy(enemySlot);
        if (enemy != null) {
            if (enemy.isAlive()) {
                spell.cast(enemy);
                //currentChar.waitTurn();    for the time being this will not be tested
                //endTurn();
            }
        }
    }


    /**
     * Starts the battle. Makes all player characters and enemies start their turn timer.
     */
    public void startBattle() {
        battleActive = true;
        setPhase(new WaitingPhase(this));
        for (int i=0; i<Settings.partySize; i++) {
            player.getCharacterFromParty(i).waitTurn();
        }

        for (int i = 0; i<enemyGroup.getCurrentGroupSize(); i++) {
            enemyGroup.getEnemy(i).waitTurn();
        }
    }

    /**
     * Ends the battle. Clears the turns queue and makes it so that no more characters can be added to it.
     */
    public void endBattle() {
        battleActive = false;
        turnsQueue.clear();
    }

    /**
     * Returns true if the battle is currently taking place.
     */
    public boolean isBattleActive() {
        return battleActive;
    }

    public void setPhase(IPhase phase) {
        currentPhase = phase;
    }
    public IPhase getPhase() {
        return currentPhase;
    }


    public void setupStandardBattle() {
        characterFactory.setupStandardPlayerParty();
        characterFactory.spawnEnemyGroup(30, 3, "Enemy1", "Enemy2", "Enemy3");
        weaponFactory.setupStandardPlayerInventory();
        startBattle();

    }


}
