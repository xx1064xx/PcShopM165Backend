package Program.Repository;

import Program.Interfaces.IComputer;

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
    public Computer getById(int computerId) {
        // Rückgabe des Computers mit der angegebenen ID
        for (Computer computer : computers) {
            if (computer.getComputerId() == computerId) {
                return computer;
            }
        }
        return null; // Wenn kein Computer mit der angegebenen ID gefunden wurde
    }

    @Override
    public void insert(Computer computer) {
        // Einfügen eines neuen Computers
        computers.add(computer);
    }

    @Override
    public void update(Computer computer) {
        // Aktualisierung eines vorhandenen Computers
        for (int i = 0; i < computers.size(); i++) {
            if (computers.get(i).getComputerId() == computer.getComputerId()) {
                computers.set(i, computer);
                break;
            }
        }
    }

    @Override
    public void delete(int computerId) {
        // Löschen eines Computers anhand der ID
        for (int i = 0; i < computers.size(); i++) {
            if (computers.get(i).getComputerId() == computerId) {
                computers.remove(i);
                break;
            }
        }
    }

    @Override
    public void save() {
        // Speichern der Änderungen
        // Implementierung je nach Bedarf (z. B. Speichern in einer Datenbank)
    }

}
