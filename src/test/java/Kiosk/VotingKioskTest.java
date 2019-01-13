package Kiosk;

import Data.DigitalSignature;
import Data.MailAddress;
import Data.Nif;
import Data.Party;
import Exceptions.*;
import Services.ElectoralOrganism;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ElectoralOrganismForTest implements ElectoralOrganism{
    DigitalSignature firma;

    public boolean canVote(Nif DNI){ throw new UnsupportedOperationException();}
    public void disableVoter(Nif DNI){
        return;
    }
    public DigitalSignature askForDigitalSignature (Party partit) {
        try {
            firma = new DigitalSignature("viloc");
            return firma;
        } catch (DigitalSignatureException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class VotingKioskTest {
    static Set<Party> partitsTest;
    static Party PP;
    static Party PSOE;
    static Party ERC;
    static VoteCounter contadorVots;
    static Nif DNI;
    static MailAddress adreça;
    static VotingKiosk terminal;
    static  ElectoralOrganismForTest organismeElectoral;
    @BeforeAll
    static void setUp() throws PartyException, NifException, MailException, VoteCounterException {
        Party [] partitsArray = new Party[3];
        PP = new Party("PP");
        PSOE = new Party("PSOE");
        ERC = new Party("ERC");
        partitsArray[0]=PP;
        partitsArray[1]=PSOE;
        partitsArray[2]=ERC;
        partitsTest = new HashSet<Party>(Arrays.asList(partitsArray));

        contadorVots = new VoteCounter(partitsTest);

        DNI = new Nif("48055507C");
        adreça = new MailAddress("hola@mon.com");
        terminal = new VotingKiosk(DNI,adreça,contadorVots);
        organismeElectoral = new ElectoralOrganismForTest();
        terminal.setElectoralOrganism(organismeElectoral);
    }

    @Test
    void voteTest() throws VoteCounterException, PartyException {
        terminal.vote(PP);
        assertEquals(contadorVots.getVotesFor(PP),1);
        terminal.vote(null);
        assertEquals(contadorVots.getNulls(),1);
        terminal.vote(new Party(""));
        assertEquals(contadorVots.getBlanks(),1);
    }



}