package Data;

import Exceptions.DigitalSignatureException;

public class DigitalSignature {
    private final String firma;

    public DigitalSignature (String address) throws DigitalSignatureException {
        if (!(address == null))
            this.firma = address;
        else
            throw new DigitalSignatureException("Null signature");
    }

    public String getSignature() { return firma; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalSignature firma1 = (DigitalSignature) o;
        return firma.equals(firma1.firma);
    }

    @Override
    public int hashCode() {
        return firma.hashCode();
    }

    @Override
    public String toString() {
        return "Signatura{" + "='" + firma + '\'' + '}';
    }
}
