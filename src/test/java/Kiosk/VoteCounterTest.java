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
    static VoteCounter contadorVots;
    @BeforeAll
    static void setVoteCounter() throws PartyException {
        Party [] partitsArray = new Party[2];
        PP = new Party("PP");
        PSOE = new Party("PSOE");
        partitsArray[0]=PP;
        partitsArray[1]=PSOE;
        partitsTest = new HashSet<Party>(Arrays.asList(partitsArray));
        try {
            contadorVots = new VoteCounter(partitsTest);
        } catch (VoteCounterException e) {
            e.printStackTrace();
        }
    }

    @Test
    void countPartyTest() throws VoteCounterException {
        contadorVots.countParty(PP);
        assertEquals(contadorVots.getVotesFor(PP),1);
    }

    @Test
    void countNullTest() {
        contadorVots.countNull();
        assertEquals(contadorVots.getNulls(), 1);
    }

    @Test
    void countBlankTest() {
        contadorVots.countBlank();
        assertEquals(contadorVots.getBlanks(),1);
    }

    @Test
    void scrutinizeTest() throws VoteCounterException {
        contadorVots.scrutinize(PSOE);
        assertEquals(contadorVots.getVotesFor(PSOE),1);
        assertThrows(VoteCounterException.class, ()-> contadorVots.scrutinize(new Party("DD")));
    }
}