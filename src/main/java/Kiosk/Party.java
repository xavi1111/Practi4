package Kiosk;

import Exceptions.PartyException;

public class Party {
    private final String name;

    public Party(String name) throws PartyException{
        if (!name.equals(null))
            this.name = name;
        else
            throw new PartyException("Party name is null");
    }

    public String getName() { return name; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party1 = (Party) o;
        return name.equals(party1.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Party{" + "name='" + name + '\'' + '}';
    }
}

