package Data;

import Exceptions.DigitalSignatureException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DigitalSignatureTest {
    static DigitalSignature firmaTest;
    @BeforeAll
    static void setDigitalSignature(){
        try {
            firmaTest = new DigitalSignature("viloc");
        } catch (DigitalSignatureException e) {
            e.printStackTrace();
        }
    }
    @Test
    void DigitalSidnatureConstructorTest () {
        assertThrows(DigitalSignatureException.class,()->{ new DigitalSignature(null);});
    }
    @Test
    void getSignatureTest() {
        assertEquals(firmaTest.getSignature(),"viloc");
        assertNotEquals(firmaTest.getSignature(),"johny melavo");
    }
    @Test
    void equalsTest() {
        try {
            DigitalSignature igual = new DigitalSignature("viloc");
            DigitalSignature prova2 = new DigitalSignature("marcmova");
            assertEquals(firmaTest.equals(igual),true);
            assertEquals(firmaTest.equals(prova2),false);
            assertEquals(firmaTest.equals(null),false);
            assertEquals(firmaTest.equals("minion"),false);
            assertEquals(firmaTest.equals(""),false);
        } catch (DigitalSignatureException e) {
            e.printStackTrace();
        }
    }
    @Test
    void hashCodeTest() { assertEquals(firmaTest.hashCode(),112210861); }
}