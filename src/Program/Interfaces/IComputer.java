package Program.Interfaces;

import Program.Repository.Computer;
import Program.Repository.Kunde;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public interface IComputer {

    ArrayList<Computer> getAll();
    Computer getByIndex(int index);
    void update(Computer computer);
    void delete(ObjectId computerId);
    void setAll(ArrayList<Kunde> computers);
    Computer getById(ObjectId computerId);


}
