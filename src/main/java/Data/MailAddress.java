package Data;

import Exceptions.MailException;

public class MailAddress {
    private final String address;

    public MailAddress (String address) throws MailException{
        if (!(address == null))
            this.address = address;
        else
            throw new MailException("Mail address is null");
    }

    public String getAddress() { return address; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailAddress mail1 = (MailAddress) o;
        return address.equals(mail1.address);
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }

    @Override
    public String toString() {
        return "Mail{" + "address='" + address + '\'' + '}';
    }
}
