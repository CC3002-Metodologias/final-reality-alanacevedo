package com.github.alanacevedo.finalreality.model.character.enemy;
import com.github.alanacevedo.finalreality.controller.Settings;

import java.util.Arrays;

/**
 * Class that represents a group (mob) of enemies.
 */
public class EnemyGroup implements IEnemyGroup {
    private int maxSize = Settings.maxEnemies;
    private Enemy[] group;
    private int currentEnemies;

    /**
     * Initializes a new enemy group.
     */
    public EnemyGroup() {
        group = new Enemy[maxSize];
        this.wipeGroup();
    }

    public void wipeGroup(){
        Arrays.fill(group, null);
        currentEnemies = 0;
    }

    public void addEnemy(Enemy enemy) {
        group[currentEnemies] = enemy;
        currentEnemies++;
    }

    public Enemy getEnemy(int slot) {
        return group[slot];
    }

    public int getCurrentGroupSize() {
        return currentEnemies;
    }


}
