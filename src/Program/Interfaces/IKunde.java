package Program.Interfaces;

import Program.Repository.Computer;
import Program.Repository.Kunde;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public interface IKunde {

    ArrayList<Kunde> getAll();
    Kunde getById(ObjectId kundenId);
    void insert(Kunde kunde);
    void update(Kunde kunde);
    void delete(ObjectId kundenId);
    void setAll(ArrayList<Kunde> kunden);
}
