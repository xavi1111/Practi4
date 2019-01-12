package Data;

import Exceptions.DigitalSignatureException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DigitalSignatureTest {
    static DigitalSignature firmaTest;
    @BeforeAll
    static void setParty(){
        try {
            firmaTest = new DigitalSignature("viloc");
        } catch (DigitalSignatureException e) {
            e.printStackTrace();
        }
    }
    @Test
    void MailConstructorTest () {
        assertThrows(DigitalSignatureException.class,()->{ new DigitalSignature(null);});
    }
    @Test
    void getSignatureTest() {
        assertEquals(firmaTest.getSignature(),"viloc");
        assertNotEquals(firmaTest.getSignature(),"viloc");
    }
}