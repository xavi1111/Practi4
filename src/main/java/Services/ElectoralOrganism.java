package Services;

import Data.DigitalSignature;
import Data.Nif;
import Data.Party;

/**
 * External service for signing votes and manage the electoral roll
 */
public interface ElectoralOrganism {
    boolean canVote(Nif nif);
    void disableVoter(Nif nif);
    DigitalSignature askForDigitalSignature(Party party);
}

