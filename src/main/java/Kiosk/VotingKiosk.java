package Kiosk;

import Data.DigitalSignature;
import Data.MailAddress;
import Data.Nif;
import Data.Party;
import Exceptions.VoteCounterException;
import Services.ElectoralOrganism;

/**
 * Implements a simplification of Use Case: Emit eVote
 */
public class VotingKiosk {

    static Nif DNI;
    static DigitalSignature Firma;
    static VoteCounter contador;
    static ElectoralOrganism organismeElectoral;
    static services.MailerService servidorMail;

    public VotingKiosk(Nif DNI, VoteCounter contador)
    {
        this.DNI = DNI;
        this.contador = contador;
    }

    public void setElectoralOrganism(ElectoralOrganism eO)
    {
        this.organismeElectoral = eO;
    }
    public void setMailerService(services.MailerService mService)
    {
        this.servidorMail = mService;
    }
    public void vote(Party party) throws VoteCounterException {
        contador.scrutinize(party);
        Firma = organismeElectoral.askForDigitalSignature(party);
        organismeElectoral.disableVoter(DNI);
    }
    public void sendeReceipt(MailAddress Adreça) {
        servidorMail.send(Adreça,Firma);
    }
}


