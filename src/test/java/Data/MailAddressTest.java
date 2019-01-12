package Data;

import Exceptions.MailException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailAddressTest {
    static MailAddress address;
    @BeforeAll
    static void setParty(){
        try {
            address = new MailAddress("prova@gmail.com");
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
    @Test
    void MailConstructorTest () {
        assertThrows(MailException.class,()->{ new MailAddress(null);});
    }

    @Test
    void getAddressTest() {
        assertEquals(address.getAddress(),"prova@gmail.com");
        assertNotEquals(address.getAddress(),"incorrecte@res.com");
    }


}