package Data;

import Exceptions.NifException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NifTest {
    static Nif DNI;
    @BeforeAll
    static void setParty(){
        try {
            DNI = new Nif("48055507C");
        } catch (NifException e) {
            e.printStackTrace();
        }
    }
    @Test
    void PartyConstructorTest ()
    {
        assertThrows(NifException.class,()->{ new Nif(null);});
        assertThrows(NifException.class,()->{ new Nif("782139871239384719823479132847132487");});
        assertThrows(NifException.class,()->{ new Nif("12321c123C");});
        assertThrows(NifException.class,()->{ new Nif("1717171717");});
    }
}