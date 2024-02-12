package Program.Controller;

import Program.DbAccess.DbAccess;
import Program.Main;
import Program.Repository.Kunde;
import Program.Service.Bestellungsservice;
import Program.Service.ComputerService;
import Program.Service.KundenService;
import Program.View.MainUi;

public class Controller {

    private MainUi mainUi;

    // services
    private KundenService kundenservice;
    private ComputerService computerService;
    private Bestellungsservice bestellungsservice;

    public Controller() {
        mainUi = new MainUi(this);
        kundenservice = new KundenService(this);
        computerService = new ComputerService(this);
        bestellungsservice = new Bestellungsservice(this);
    }

    public void run() {

        DbAccess dbAccess = new DbAccess();

        mainUi.setVisible(true);

        dbAccess.connectToDb();
    }

    public void setKunde(Kunde kunde) {
        kundenservice.setKunde(kunde);
    }

}
