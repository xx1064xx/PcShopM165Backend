package Program.Controller;

import Program.Repository.Kunde;
import Program.Service.Bestellungsservice;
import Program.Service.ComputerService;
import Program.Service.KundenService;
import Program.View.MainUi;
import org.bson.types.ObjectId;

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
    public Kunde getKundeByIndex(int index) {
        Kunde kunde = kundenservice.getByIndex(index);
        return kunde;
    }
    public void addNewKunde(Kunde kunde) {
        kundenservice.addNewKunde(kunde);
    }
    public void updateKunde(Kunde kunde) {
        kundenservice.updateKunde(kunde);
    }
    public void deleteKunde(ObjectId kundenId) {
        kundenservice.deleteKunde(kundenId);
    }


}
