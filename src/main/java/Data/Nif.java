package Data;

import Exceptions.NifException;

import java.util.ArrayList;
import java.util.List;

public class Nif {
    private  final  String NIF;

    public Nif (String NIF) throws NifException {
        if (!(NIF == null)){
            this.NIF = NIF;
            if (this.NIF.length()==10){
                List<String> parts = new ArrayList<>();
                int length = this.NIF.length();
                for (int i = 0; i < length; i += 9) {
                    parts.add(NIF.substring(i, Math.min(length, i + 9)));
                }

                try { double d = Double.parseDouble(parts.get(0)); }
                catch(NumberFormatException nfe) { throw new NifException("Nif incorrecte"); }

                try {
                    double d = Double.parseDouble(parts.get(0));
                    throw new NifException("Nif incorrecte");
                }
                catch(NumberFormatException nfe) { }

            }else
                throw new NifException("Nif must have 10 characters.");
        }
        else
            throw new NifException("Nif is null");
    }
}
