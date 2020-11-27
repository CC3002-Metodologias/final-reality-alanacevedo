package com.github.alanacevedo.finalreality.model.character.enemy;
import com.github.alanacevedo.finalreality.controller.Settings;

import java.util.Arrays;


public class EnemyGroup {
    private int maxSize = Settings.maxEnemies;
    private Enemy[] group;
    private int currentEnemies;

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

    public int getCurrentEnemies() {
        return currentEnemies;
    }

    public int getEnemyIndex(Enemy enemy) {
        for (int i=0; i<maxSize; i++) {
            if (group[i] == enemy) {
                return i;
            }
        }

        return -1; // Shouldn't get here
    }
}
