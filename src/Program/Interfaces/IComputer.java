package Program.Interfaces;

import Program.Repository.Computer;

import java.util.ArrayList;

public interface IComputer {

    ArrayList<Computer> getAll();
    Computer getById(int computerId);
    void insert(Computer computer);
    void update(Computer computer);
    void delete(int computerId);
    void save();


}
