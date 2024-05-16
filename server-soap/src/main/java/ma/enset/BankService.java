package ma.enset;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;

@WebService(serviceName = "BankWS")
public class BankService {
    @WebMethod(operationName = "conversionEuroToDh")
    public double conversion(@WebParam(name = "montant") double mt){
        return mt*11;
    }

    @WebMethod
    public Compte getCompte(@WebParam(name="code") int code){
        Compte cp = new Compte();
        cp.setCode(code);
        cp.setSolde(Math.random()*5000);
        cp.setDateCreation(new Date());
        return cp;
    }

    @WebMethod
    public List<Compte> listComptes(){
        return List.of(
                new Compte(1, 2000, new Date()),
                new Compte(2, 3000, new Date()),
                new Compte(3, 4000, new Date())
        );
    }
}
