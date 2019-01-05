package kiosk;

import Data.MailAddress;
import Data.Party;
import Services.ElectoralOrganism;

/**
 * Implements a simplification of Use Case: Emit eVote
 */
public class VotingKiosk {

    public VotingKiosk() { }
    public void setElectoralOrganism(ElectoralOrganism eO) { }
    public void setMailerService(services.MailerService mService){ }
    public void vote(Party party) { }
    public void sendeReceipt(MailAddress address) {  }
}


