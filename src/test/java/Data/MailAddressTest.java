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

    @Test
    void equalsTest() {
        try {
            MailAddress igual = new MailAddress("prova@gmail.com");
            MailAddress prova2 = new MailAddress("hola@mon.com");
            assertEquals(address.equals(igual),true);
            assertEquals(address.equals(prova2),false);
            assertEquals(address.equals(null),false);
            assertEquals(address.equals("h@w.com"),false);
            assertEquals(address.equals(""),false);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }

    @Test
    void hashCodeTest() {
        assertEquals(address.hashCode(),-11355639);
    }

    @Test
    void toStringTest() {
        assertEquals(address.toString(),"Mail{address='prova@gmail.com'}");
    }
}