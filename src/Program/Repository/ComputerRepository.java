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
    public void update(Computer updatedComputer) {

        ObjectId updatedComputerId = updatedComputer.getComputerId();

        for (Computer computer : computers) {
            if (computer.getComputerId().equals(updatedComputerId)) {

                computer.setHersteller(updatedComputer.getHersteller());
                computer.setModell(updatedComputer.getModell());
                computer.setArbeitsspeicher(updatedComputer.getArbeitsspeicher());
                computer.setCpu(updatedComputer.getCpu());
                computer.setMassenspeicher(updatedComputer.getMassenspeicher());
                computer.setTyp(updatedComputer.getTyp());
                computer.setEinzelpreis(updatedComputer.getEinzelpreis());
                computer.setSchnittstellen(updatedComputer.getSchnittstellen());

                break;
            }
        }
    }

    @Override
    public void delete(ObjectId computerId) {

        for (int i = 0; i < computers.size(); i++) {
            if (computers.get(i).getComputerId() == computerId) {
                computers.remove(i);
                break;
            }
        }

    }

    @Override
    public void setAll(ArrayList computers) {

        this.computers = computers;
    }

}
