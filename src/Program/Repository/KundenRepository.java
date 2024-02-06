package Program.Repository;

import Program.Interfaces.IKunde;

import java.util.ArrayList;

public class KundenRepository implements IKunde {

    private ArrayList<Kunde> kunden;

    public KundenRepository() {
        this.kunden = new ArrayList<>();
    }

    @Override
    public ArrayList<Kunde> getAll() {
        // Rückgabe aller Kunden
        return kunden;
    }

    @Override
    public Kunde getById(int kundenId) {
        // Rückgabe des Kunden mit der angegebenen ID
        for (Kunde kunde : kunden) {
            if (kunde.getKundenId() == kundenId) {
                return kunde;
            }
        }
        return null; // Wenn kein Kunde mit der angegebenen ID gefunden wurde
    }

    @Override
    public void insert(Kunde kunde) {
        // Einfügen eines neuen Kunden
        kunden.add(kunde);
    }

    @Override
    public void update(Kunde kunde) {
        // Aktualisierung eines vorhandenen Kunden
        for (int i = 0; i < kunden.size(); i++) {
            if (kunden.get(i).getKundenId() == kunde.getKundenId()) {
                kunden.set(i, kunde);
                break;
            }
        }
    }

    @Override
    public void delete(int kundenId) {
        // Löschen eines Kunden anhand der ID
        for (int i = 0; i < kunden.size(); i++) {
            if (kunden.get(i).getKundenId() == kundenId) {
                kunden.remove(i);
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
