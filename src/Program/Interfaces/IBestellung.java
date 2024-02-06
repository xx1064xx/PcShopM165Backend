package Program.Interfaces;

import Program.Repository.Bestellung;
import Program.Repository.Kunde;

import java.util.ArrayList;

public interface IBestellung {
    ArrayList<Bestellung> getAll();
    Bestellung getById(int bestellungsId);
    void insert(Bestellung bestellung);
    void update(Bestellung bestellung);
    void delete(int bestellungsId);
    void save();
}
