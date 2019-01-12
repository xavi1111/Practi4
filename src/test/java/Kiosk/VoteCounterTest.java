package Kiosk;

import Data.Party;
import Exceptions.PartyException;
import Exceptions.VoteCounterException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VoteCounterTest {
    static Set<Party> partitsTest;
    static Party PP;
    static Party PSOE;
    static VoteCounter partits;
    @BeforeAll
    static void setVoteCounter() throws PartyException {
        Party [] partitsArray = new Party[2];
        PP = new Party("PP");
        PSOE = new Party("PSOE");
        partitsArray[0]=PP;
        partitsArray[1]=PSOE;
        partitsTest = new HashSet<Party>(Arrays.asList(partitsArray));
        try {
            partits = new VoteCounter(partitsTest);
        } catch (VoteCounterException e) {
            e.printStackTrace();
        }
    }

    @Test
    void countPartyTest() throws VoteCounterException {
        partits.countParty(PP);
        assertEquals(partits.getVotesFor(PP),1);
    }

    @Test
    void countNullTest() {
        partits.countNull();
        assertEquals(partits.getNulls(), 1);
    }

    @Test
    void countBlankTest() {
        partits.countBlank();
        assertEquals(partits.getBlanks(),1);
    }

    @Test
    void scrutinizeTest() {
    }

    @Test
    void getVotesForTest() {
    }

    @Test
    void getNullsTest() {
    }

    @Test
    void getBlanksTest() {
    }

    @Test
    void getTotalTest() {
    }
}