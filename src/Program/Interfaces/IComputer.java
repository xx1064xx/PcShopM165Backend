package Program.Interfaces;

import Program.Repository.Computer;
import Program.Repository.Kunde;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public interface IComputer {

    ArrayList<Computer> getAll();
    Computer getById(ObjectId computerId);
    void insert(Computer computer);
    void update(Computer computer);
    void delete(ObjectId computerId);
    void setAll(ArrayList<Kunde> computers);


}
