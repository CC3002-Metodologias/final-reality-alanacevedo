package com.github.alanacevedo.finalreality.controller.factory;

import com.github.alanacevedo.finalreality.controller.GameController;
import com.github.alanacevedo.finalreality.model.character.enemy.Enemy;
import com.github.alanacevedo.finalreality.model.character.player.charClasses.*;

import java.util.concurrent.ThreadLocalRandom;

public class CharacterFactory {
    GameController controller;

    public CharacterFactory(GameController controller) {
        this.controller = controller;
    }

    /**
     * Creates a Black Mage with the given name and adds it to the player's party.
     */
    public void addBlackMageToPlayerParty(String name) {
        BlackMage character = new BlackMage(name, controller.getTurnsQueue());
        controller.addListenersToPlayerChar(character);
        controller.getPlayer().addCharacterToParty(character);
    }

    /**
     * Creates a White Mage with the given name and adds it to the player's party.
     */
    public void addWhiteMageToPlayerParty(String name) {
        WhiteMage character = new WhiteMage(name, controller.getTurnsQueue());
        controller.addListenersToPlayerChar(character);
        controller.getPlayer().addCharacterToParty(character);
    }

    /**
     * Creates a Knight with the given name and adds it to the player's party.
     */
    public void addKnightToPlayerParty(String name) {
        Knight character = new Knight(name, controller.getTurnsQueue());
        controller.addListenersToPlayerChar(character);
        controller.getPlayer().addCharacterToParty(character);
    }

    /**
     * Creates a Thief with the given name and adds it to the player's party.
     */
    public void addThiefToPlayerParty(String name) {
        Thief character = new Thief(name, controller.getTurnsQueue());
        controller.addListenersToPlayerChar(character);
        controller.getPlayer().addCharacterToParty(character);
    }

    /**
     * Creates an Engineer with the given name and adds it to the player's party.
     */
    public void addEngineerToPlayerParty(String name) {
        Engineer character = new Engineer(name, controller.getTurnsQueue());
        controller.addListenersToPlayerChar(character);
        controller.getPlayer().addCharacterToParty(character);
    }

    /**
     *  *NEEDS BALANCING*
     *  Cretes a new enemy group, with strenght depending of the level given.
     *
     * @param lvl level of the enemy group. Affects HP, ATK, DEF.
     * @param size size of the group.
     * @param names names of the enemies.
     */
    public void spawnEnemyGroup(int lvl, int size, String... names) {
        controller.getEnemyGroup().wipeGroup();
        for (int i=0; i<size; i++) {
            int randInt1 = ThreadLocalRandom.current().nextInt(10, 15); // generates random number
            int randInt2 = ThreadLocalRandom.current().nextInt(3, 8);

            int hp = randInt1 * lvl;
            int atk = randInt2 * lvl;
            int def = randInt2 * lvl / 5;

            Enemy enemy = new Enemy(names[i], 10+i, controller.getTurnsQueue(), hp, 20, 70); // balance later
            controller.addListenersToEnemy(enemy);
            controller.getEnemyGroup().addEnemy(enemy);
        }
        controller.updateEnemyGroupSize();
    }

    public void setupStandardPlayerParty() {
        addKnightToPlayerParty("Hector");
        addBlackMageToPlayerParty("Vivi");
        addEngineerToPlayerParty("Cid");
    }

}
