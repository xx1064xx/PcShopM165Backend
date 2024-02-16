package Program.Repository;

import Program.Interfaces.IBestellung;
import Program.Service.Bestellungsservice;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class BestellungsRepository implements IBestellung {


    private ArrayList<Bestellung> bestellungen;
    private Bestellungsservice bestellungsservice;

    public BestellungsRepository(Bestellungsservice bestellungsservice) {
        this.bestellungen = new ArrayList<>();
        this.bestellungsservice = bestellungsservice;
    }

    @Override
    public ArrayList<Bestellung> getAll() {
        return bestellungen;
    }

    public Bestellung getByIndex(int index) {
        Bestellung bestellung = bestellungen.get(index);

        return bestellung;
    }

    @Override
    public Bestellung getById(ObjectId bestellungsId) {
        // Rückgabe der Bestellung mit der angegebenen ID
        for (Bestellung bestellung : bestellungen) {
            if (bestellung.getBestellungsId() == bestellungsId) {
                return bestellung;
            }
        }
        return null; // Wenn keine Bestellung mit der angegebenen ID gefunden wurde
    }


    @Override
    public void update(Bestellung bestellung) {

        for (int i = 0; i < bestellungen.size(); i++) {
            if (bestellungen.get(i).getBestellungsId() == bestellung.getBestellungsId()) {
                bestellungen.set(i, bestellung);
                break;
            }
        }
    }


    @Override
    public void delete(ObjectId bestellungsId) {

        for (int i = 0; i < bestellungen.size(); i++) {
            if (bestellungen.get(i).getBestellungsId() == bestellungsId) {
                bestellungen.remove(i);
                break;
            }
        }
    }

    @Override
    public void setAll(ArrayList<Bestellung> bestellungen) {

        this.bestellungen = bestellungen;

    }


}
