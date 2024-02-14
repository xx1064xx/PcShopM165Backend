package Program.Controller;

import Program.Repository.Kunde;
import Program.Service.Bestellungsservice;
import Program.Service.ComputerService;
import Program.Service.KundenService;
import Program.View.MainUi;

import java.util.ArrayList;

public class Controller {

    private MainUi mainUi;

    // services
    private KundenService kundenservice;
    private ComputerService computerService;
    private Bestellungsservice bestellungsservice;

    public Controller() {
        kundenservice = new KundenService(this);
        mainUi = new MainUi(this);
        computerService = new ComputerService(this);
        bestellungsservice = new Bestellungsservice(this);
    }


    // kunden
    public void readAllKunden() {
        kundenservice.readAllKunden();

    }

    public ArrayList<Kunde> getAllKunden() {

        ArrayList<Kunde> kunden = kundenservice.getAllKunden();

        return kunden;
    }
    public void addNewKunde(Kunde kunde) {
        kundenservice.addNewKunde(kunde);
    }


}
