package Program.Controller;

import Program.Repository.Computer;
import Program.Repository.Kunde;
import Program.Service.Bestellungsservice;
import Program.Service.Computerservice;
import Program.Service.KundenService;
import Program.View.MainUi;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class Controller {

    private MainUi mainUi;

    // services
    private KundenService kundenservice;
    private Computerservice computerservice;
    private Bestellungsservice bestellungsservice;

    public Controller() {
        kundenservice = new KundenService(this);
        computerservice = new Computerservice(this);
        bestellungsservice = new Bestellungsservice(this);
        mainUi = new MainUi(this);
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

    // computer

    public void readAllComputer() {
        computerservice.readAllComputer();
    }
    public ArrayList<Computer> getAllComputer() {

        ArrayList<Computer> computers = computerservice.getAllComputer();

        return computers;
    }

    public Computer getComputerByIndex(int index) {
        Computer computer = computerservice.getByIndex(index);
        return computer;
    }

    public void addNewComputer(Computer computer) {
        computerservice.addNewComputer(computer);
    }
    public void deleteComputer(ObjectId computerId) {
        computerservice.deleteComputer(computerId);
    }

}
