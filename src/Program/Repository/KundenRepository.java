package Program.Repository;

import Program.Interfaces.IKunde;
import Program.Service.KundenService;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class KundenRepository implements IKunde {

    private ArrayList<Kunde> kunden;

    public KundenRepository() {
        this.kunden = new ArrayList<>();

    }

    @Override
    public ArrayList<Kunde> getAll() {

        return kunden;
    }

    @Override
    public Kunde getByIndex(int index) {

        Kunde kunde = kunden.get(index);

        return kunde;
    }

    @Override
    public void update(Kunde updatedKunde) {

        ObjectId updatedKundenId = updatedKunde.getKundenId();

        for (Kunde kunde : kunden) {
            if (kunde.getKundenId().equals(updatedKundenId)) {

                kunde.setGeschlecht(updatedKunde.getGeschlecht());
                kunde.setNachname(updatedKunde.getNachname());
                kunde.setVorname(updatedKunde.getVorname());
                kunde.setAdresse(updatedKunde.getAdresse());
                kunde.setTelefon(updatedKunde.getTelefon());
                kunde.setEmail(updatedKunde.getEmail());
                kunde.setSprache(updatedKunde.getSprache());
                kunde.setGeburtsdatum(updatedKunde.getGeburtsdatum());

                break;
            }
        }


    }

    @Override
    public void delete(ObjectId kundenId) {

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
