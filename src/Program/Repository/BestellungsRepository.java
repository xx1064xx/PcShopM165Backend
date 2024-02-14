package Program.Repository;

import Program.Interfaces.IBestellung;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class BestellungsRepository implements IBestellung {


    ArrayList<Bestellung> bestellungen;

    public BestellungsRepository() {
        this.bestellungen = new ArrayList<>();
    }

    @Override
    public ArrayList<Bestellung> getAll() {
        // Rückgabe aller Bestellungen
        return bestellungen;
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
    public void insert(Bestellung bestellung) {
        // Einfügen einer neuen Bestellung
        bestellungen.add(bestellung);
    }


    @Override
    public void update(Bestellung bestellung) {
        // Aktualisierung einer vorhandenen Bestellung
        for (int i = 0; i < bestellungen.size(); i++) {
            if (bestellungen.get(i).getBestellungsId() == bestellung.getBestellungsId()) {
                bestellungen.set(i, bestellung);
                break;
            }
        }
    }


    @Override
    public void delete(ObjectId bestellungsId) {
        // Löschen einer Bestellung anhand der ID
        for (int i = 0; i < bestellungen.size(); i++) {
            if (bestellungen.get(i).getBestellungsId() == bestellungsId) {
                bestellungen.remove(i);
                break;
            }
        }
    }


    @Override
    public void save() {
        // Speichern der Änderungen
        // Implementierung je nach Bedarf (z. B. Speichern in einer Datenbank)
    }


}
