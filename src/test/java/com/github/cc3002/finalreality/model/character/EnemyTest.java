package com.github.cc3002.finalreality.model.character;

import com.github.alanacevedo.finalreality.model.character.enemy.Enemy;
import com.github.alanacevedo.finalreality.model.character.ICharacter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.github.alanacevedo.finalreality.model.character.enemy.EnemyGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnemyTest extends AbsCharacterTest{
    protected BlockingQueue<ICharacter> turns;
    private static final String ENEMY_NAME = "Skeleton";

    @BeforeEach
    void setUp(){
        generateCharactersAndWeapons();

    }

    @Test
    void constructorTest(){
        turns = new LinkedBlockingQueue<>();
        var expectedEnemy = new Enemy(ENEMY_NAME, testWeight, turns, testHP, testDEF, testATK);
        var sameEnemy = new Enemy(ENEMY_NAME, testWeight, turns, testHP, testDEF, testATK);
        var difATK = new Enemy(ENEMY_NAME, testWeight, turns, testHP, testDEF, 10);
        var difHP = new Enemy(ENEMY_NAME, testWeight, turns, 1, testDEF, testATK);
        var difDEF = new Enemy(ENEMY_NAME, testWeight, turns, testDEF, 1, testATK);
        var difName = new Enemy("Creeper", testWeight, turns, testHP, testDEF, testATK);
        expectedEnemy.waitTurn();
        assertEquals(expectedEnemy, sameEnemy);
        assertNotEquals(expectedEnemy, difATK);
        assertNotEquals(expectedEnemy, difHP);
        assertNotEquals(expectedEnemy, difDEF);
        assertNotEquals(expectedEnemy, difName);

        assertNotEquals(expectedEnemy, testKnight);
        assertEquals(expectedEnemy, expectedEnemy);
        assertEquals(expectedEnemy.hashCode(), sameEnemy.hashCode());

    }

    @Test
    void enemyGroupTest() {
        EnemyGroup group = new EnemyGroup();
        assertEquals(0, group.getCurrentEnemies());
        group.addEnemy(testEnemy);
        assertEquals(1, group.getCurrentEnemies());
        assertEquals(testEnemy, group.getEnemy(0));
        group.wipeGroup();
        assertEquals(0, group.getCurrentEnemies());
        assertNull(group.getEnemy(0));

    }

}
