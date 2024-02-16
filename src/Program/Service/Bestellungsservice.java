package Program.Service;

import Program.Controller.Controller;
import Program.DbAccess.BestellungsDbAccess;
import Program.Repository.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class Bestellungsservice {

    private Controller controller;
    private BestellungsDbAccess bestellungsDbAccess;
    private BestellungsRepository bestellungsRepository;

    public Bestellungsservice(Controller controller) {
        this.controller = controller;
        this.bestellungsRepository = new BestellungsRepository(this);
        this.bestellungsDbAccess = new BestellungsDbAccess(this);
    }

    public void addNewBestellung(Bestellung bestellung) {

        bestellungsDbAccess.addNewBestellung(bestellung);

        // es müssen alle Kunden neu ausgelesen werden, damit auch der neue Kunde seine ObjectId erhält
        ArrayList<Bestellung> bestellungsList = bestellungsDbAccess.getAllBestellungen();
        bestellungsRepository.setAll(bestellungsList);
    }

    public Kunde getKundeById(ObjectId kundenId) {
        Kunde kunde = controller.getKundeById(kundenId);
        return kunde;
    }

    public Computer getComputerById(ObjectId computerId) {
        Computer computer = controller.getComputerById(computerId);
        return computer;
    }

    public ArrayList<Bestellung> getAllBestellungen() {
        ArrayList<Bestellung> bestellungen = bestellungsRepository.getAll();
        return bestellungen;
    }

    public void readAllBestellungen() {
        ArrayList<Bestellung> bestellungsList = bestellungsDbAccess.getAllBestellungen();
        bestellungsRepository.setAll(bestellungsList);
    }

    public Bestellung getByIndex(int index) {
        Bestellung bestellung = bestellungsRepository.getByIndex(index);
        return bestellung;
    }

    public void updateBestellung(Bestellung bestellung) {
        bestellungsDbAccess.updateBestellung(bestellung);

        bestellungsRepository.update(bestellung);
    }

    public void deleteBestellung(ObjectId bestellungsId) {

        bestellungsDbAccess.deleteBestellung(bestellungsId);
        bestellungsRepository.delete(bestellungsId);

    }


}
