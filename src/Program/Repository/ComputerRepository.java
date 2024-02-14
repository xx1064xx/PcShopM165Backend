package Program.Repository;

import Program.Interfaces.IComputer;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class ComputerRepository implements IComputer {

    private ArrayList<Computer> computers;

    public ComputerRepository() {
        this.computers = new ArrayList<>();
    }

    @Override
    public ArrayList<Computer> getAll() {
        // Rückgabe aller Computer
        return computers;
    }

    @Override
    public Computer getByIndex(int index) {

        Computer computer = computers.get(index);

        return computer;
    }

    @Override
    public void insert(Computer computer) {
        // Einfügen eines neuen Computers
        computers.add(computer);
    }

    @Override
    public void update(Computer computer) {

    }

    @Override
    public void delete(ObjectId computerId) {

    }

    @Override
    public void setAll(ArrayList computers) {

        this.computers = computers;
    }

}
