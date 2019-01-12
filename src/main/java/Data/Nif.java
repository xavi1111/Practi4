package Data;

import Exceptions.NifException;

import java.util.ArrayList;
import java.util.List;

public class Nif {
    private  final  String NIF;

    public Nif (String NIF) throws NifException {
        if (!(NIF == null)){
            this.NIF = NIF;
            if (this.NIF.length()==9){
                List<String> parts = new ArrayList<>();
                parts.add(NIF.substring(0,8));
                parts.add(NIF.substring(8,9));
                System.out.println(parts);
                try { double d = Double.parseDouble(parts.get(0)); }
                catch(NumberFormatException nfe) { throw new NifException("Nif incorrecte numeros"); }
                char[] lletra = parts.get(1).toCharArray();
                if(!Character.isLetter(lletra[0])) {
                    throw new NifException("Nif incorrecte lletra");
                }
            }else
                throw new NifException("Nif must have 10 characters.");
        }
        else
            throw new NifException("Nif is null");
    }

    public String getNif() { return this.NIF; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nif nif1 = (Nif) o;
        return NIF.equals(nif1.NIF);
    }

    @Override
    public int hashCode() {
        return NIF.hashCode();
    }

    @Override
    public String toString() {
        return "NIF{" + "='" + NIF + '\'' + '}';
    }



}
