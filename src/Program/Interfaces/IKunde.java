package Program.Interfaces;

import Program.Repository.Computer;
import Program.Repository.Kunde;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public interface IKunde {

    ArrayList<Kunde> getAll();
    Kunde getByIndex(int index);
    void update(Kunde kunde);
    void delete(ObjectId kundenId);
    void setAll(ArrayList<Kunde> kunden);
    Kunde getById(ObjectId kundenId);
}
