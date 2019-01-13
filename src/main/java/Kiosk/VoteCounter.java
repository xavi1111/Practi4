package Kiosk;

import Data.Party;
import Exceptions.VoteCounterException;

import java.util.Set;

public class VoteCounter {

    private Set<Party> parties;
    private int nulls = 0;
    private int blanks = 0;
    private int [] votesForParty;

    public VoteCounter(Set<Party> validParties) throws VoteCounterException {
        if(validParties.size()!=0){
            this.parties = validParties;
            votesForParty = new int [validParties.size()];
        }else{
            throw new VoteCounterException("The list of parties is empty");
        }
    }

    public void countParty(Party party){

        int partyPosition=0;

        for(Party partyCheck : parties){
            if (partyCheck.equals(party)){
                votesForParty[partyPosition]++;
                break;
            }
            partyPosition++;
        }
    }

    public void countNull() {
        nulls++;
    }

    public void countBlank() {
        blanks++;
    }

    public void scrutinize(Party party) throws VoteCounterException {
        if(party ==null){
            countNull();
        }else{
            if(party.getName().equals("")){
                countBlank();
            }else{
                if(parties.contains(party)){
                    countParty(party);
                }else{
                    throw new VoteCounterException("Invalid Party");
                }
            }
        }
    }

    public int getVotesFor(Party party) throws VoteCounterException {
        if(parties.contains(party)){
            int partyPosition=0;
            for(Party partyCheck : parties){
                if (partyCheck.equals(party)){
                    return votesForParty[partyPosition];
                }
                partyPosition++;
            }
        }else {
            throw new VoteCounterException("Invalid Party");
        }
        return -1;
    }

    public int getNulls() {
        return nulls;
    }

    public int getBlanks() {
        return blanks;
    }

    public int getTotal() {
        int totalvotes=0;
        for(int party : votesForParty){
            totalvotes=+party;
        }
        totalvotes=+getBlanks();
        totalvotes+=getNulls();
        return totalvotes;
    }
}

