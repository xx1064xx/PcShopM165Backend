package Program.Service;

import Program.Interfaces.IKunde;
import Program.Repository.Kunde;
import Program.Repository.KundenRepository;

public class Service {

    KundenRepository kundenRepository = new KundenRepository();

    public void setKunde(Kunde kunde) {
        kundenRepository.insert(kunde);
    }

}
