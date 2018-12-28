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

    @Test
    void equalsTest() {
        try {
            Party pp = new Party("PP");
            Party psoe = new Party("PSOE");
            assertEquals(party.equals(pp),true);
            assertEquals(party.equals(psoe),false);
            assertEquals(party.equals(null),false);
            assertEquals(party.equals("PP"),false);
            assertEquals(party.equals(""),false);
        } catch (PartyException e) {
            e.printStackTrace();
        }
    }

    @Test
    void hashCodeTest() {
        assertEquals(party.hashCode(),2560);
    }

    @Test
    void toStringTest() {
        assertEquals(party.toString(),"Party{name='PP'}");
    }
}