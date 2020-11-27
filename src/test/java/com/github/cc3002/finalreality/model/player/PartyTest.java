package com.github.cc3002.finalreality.model.player;
import static org.junit.jupiter.api.Assertions.*;

import com.github.alanacevedo.finalreality.model.character.ICharacter;
import com.github.alanacevedo.finalreality.model.character.IPlayableCharacter;
import com.github.alanacevedo.finalreality.model.character.player.charClasses.*;
import com.github.alanacevedo.finalreality.model.player.Party;
import com.github.alanacevedo.finalreality.controller.Settings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PartyTest {
    final int maxSize = Settings.partySize;
    BlockingQueue<ICharacter> turnsQueue = new LinkedBlockingQueue<>();
    IPlayableCharacter char1, char1Copy, char2, char2Copy;
    Party party;


    @BeforeEach
    void setUp(){
        party = new Party();
        char1 = new Knight("caballero", turnsQueue);
        char2 = new WhiteMage("mago", turnsQueue);
        char1Copy = new Knight("caballero", turnsQueue);
        char2Copy = new WhiteMage("mago", turnsQueue);
    }

    @Test
    void constructorTest() {
        assertEquals(0, party.getCurrentSize());
        party.addCharacter(char1);
        party.addCharacter(char2);
        assertEquals(2, party.getCurrentSize());
        assertEquals(char1, party.getCharacter(0));
        assertEquals(char2, party.getCharacter(1));
        for (int i=2; i<maxSize; i++) {
            assertNull(party.getCharacter(i));
        }
    }

    @Test
    void equalsTest() {
        Party otherParty = new Party();
        party.addCharacter(char1);
        party.addCharacter(char2);
        otherParty.addCharacter(char1Copy);
        otherParty.addCharacter(char2Copy);
        assertEquals(party, otherParty);
        assertNotEquals(party, char1);
        otherParty.addCharacter(char1);
        assertNotEquals(party, otherParty);
        assertEquals(party, party);
        otherParty = new Party();
        otherParty.addCharacter(char2);
        otherParty.addCharacter(char1);
        assertNotEquals(party, otherParty);
    }
}
