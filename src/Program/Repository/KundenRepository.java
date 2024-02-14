package Program.Repository;

import Program.Interfaces.IKunde;
import Program.Service.KundenService;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class KundenRepository implements IKunde {

    private KundenService kundenService;
    private ArrayList<Kunde> kunden;

    public KundenRepository(KundenService kundenService) {
        this.kunden = new ArrayList<>();
        this.kundenService = kundenService;
    }

    @Override
    public ArrayList<Kunde> getAll() {

        return kunden;
    }

    @Override
    public Kunde getByIndex(ObjectId kundenId) {

        for (Kunde kunde : kunden) {
            if (kunde.getKundenId() == kundenId) {
                return kunde;
            }
        }
        return null;
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
    public void delete(ObjectId kundenId) {
        // Löschen eines Kunden anhand der ID
        for (int i = 0; i < kunden.size(); i++) {
            if (kunden.get(i).getKundenId() == kundenId) {
                kunden.remove(i);
                break;
            }
        }
    }

    @Override
    public void setAll(ArrayList<Kunde> kunden) {
        this.kunden = kunden;
    }

}
