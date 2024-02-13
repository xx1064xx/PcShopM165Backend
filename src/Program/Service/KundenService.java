package Program.Service;

import Program.Controller.Controller;
import Program.DbAccess.KundenDbAccess;
import Program.Repository.Kunde;
import Program.Repository.KundenRepository;

public class KundenService {

    private Controller controller;
    private KundenDbAccess kundenDbAccess;
    private KundenRepository kundenRepository;

    public KundenService(Controller controller) {
        this.controller = controller;

        kundenDbAccess = new KundenDbAccess(this);
        kundenRepository = new KundenRepository(this);
    }

    public void addNewKunde(Kunde kunde) {



    }

}
