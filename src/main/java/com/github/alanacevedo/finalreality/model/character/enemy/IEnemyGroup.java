package com.github.alanacevedo.finalreality.model.character.enemy;

public interface IEnemyGroup {

    /**
     * Removes every enemy from the group
     */
    void wipeGroup();

    /**
     * Adds an enemy to the group
     * @param enemy enemy to be added
     */
    void addEnemy(Enemy enemy);

    /**
     * Returns the enemy located in the given group slot.
     * @param slot slot to be searched.
     * @return enemy located in that slot (can be null)
     */
    Enemy getEnemy(int slot);

    /**
     * Returns the ammount of enemies in the group
     */
    int getCurrentGroupSize();
}
