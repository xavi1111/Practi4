package Kiosk;

import Exceptions.PartyException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartyTest {
    static Party party;
    @BeforeAll
    static void setParty(){
        try {
            party = new Party("PP");
        } catch (PartyException e) {
            e.printStackTrace();
        }
    }
    @Test
    void PartyConstructorTest () {
        assertThrows(PartyException.class,()->{ new Party(null);});
    }

    @Test
    void getNameTest() {
        assertEquals(party.getName(),"PP");
        assertNotEquals(party.getName(),"PSOE");
    }

    @org.junit.jupiter.api.Test
    void equalsTest() {
    }

    @org.junit.jupiter.api.Test
    void hashCodeTest() {
    }

    @org.junit.jupiter.api.Test
    void toStringTest() {
    }
}