package Program.Interfaces;

import Program.Repository.Bestellung;
import Program.Repository.Computer;
import Program.Repository.Kunde;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public interface IBestellung {
    ArrayList<Bestellung> getAll();
    Bestellung getByIndex(int index);
    Bestellung getById(ObjectId bestellungsId);
    void update(Bestellung bestellung);
    void delete(ObjectId bestellungsId);
    void setAll(ArrayList<Bestellung> bestellungen);
}
