package com.github.cc3002.finalreality.model.character;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.github.alanacevedo.finalreality.model.character.Enemy;
import com.github.alanacevedo.finalreality.model.character.ICharacter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnemyTest {
    protected BlockingQueue<ICharacter> turns;
    Enemy expectedEnemy;
    private static final String ENEMY_NAME = "Skeleton";
    int testHP = 100;
    int testDEF = 50;
    int testWeight = 5;
    int testATK = 20;

    @BeforeEach
    void setUp(){
        var expectedEnemy = new Enemy(ENEMY_NAME, testWeight, turns, testHP, testDEF, testATK);

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

    }

}
