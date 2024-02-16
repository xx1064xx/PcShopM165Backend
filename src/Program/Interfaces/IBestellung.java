package Program.Interfaces;

import Program.Repository.Bestellung;
import Program.Repository.Kunde;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public interface IBestellung {
    ArrayList<Bestellung> getAll();
    Bestellung getById(ObjectId bestellungsId);
    void update(Bestellung bestellung);
    void delete(ObjectId bestellungsId);
    void setAll(ArrayList<Bestellung> bestellungen);
}
