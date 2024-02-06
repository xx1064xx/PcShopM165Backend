package Program.Interfaces;

import Program.Repository.Computer;
import Program.Repository.Kunde;

import java.util.ArrayList;

public interface IKunde {

    ArrayList<Kunde> getAll();
    Kunde getById(int kundenId);
    void insert(Kunde kunde);
    void update(Kunde kunde);
    void delete(int kundenId);
    void save();
}
