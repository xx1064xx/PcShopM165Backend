package Program.Service;

import Program.Controller.Controller;
import Program.DbAccess.ComputerDbAccess;
import Program.Repository.Computer;
import Program.Repository.ComputerRepository;
import Program.Repository.Kunde;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class Computerservice {

    private Controller controller;
    private ComputerDbAccess computerDbAccess;
    private ComputerRepository computerRepository;

    public Computerservice(Controller controller) {
        this.controller = controller;
        computerRepository = new ComputerRepository();
        computerDbAccess = new ComputerDbAccess(this);

    }

    public void readAllComputer() {

        ArrayList<Computer> computerList = computerDbAccess.getAllComputer();

        computerRepository.setAll(computerList);
    }

    public ArrayList<Computer> getAllComputer() {
        ArrayList<Computer> computers = computerRepository.getAll();

        return computers;
    }

    public Computer getByIndex(int index) {
        Computer computer = computerRepository.getByIndex(index);
        return computer;
    }

    public void addNewComputer(Computer computer) {

        computerDbAccess.addNewComputer(computer);

        // es müssen alle Kunden neu ausgelesen werden, damit auch der neue Kunde seine ObjectId erhält
        ArrayList<Computer> computerList = computerDbAccess.getAllComputer();
        computerRepository.setAll(computerList);

    }

    public void deleteComputer(ObjectId computerId) {

        computerDbAccess.deleteComputer(computerId);
        computerRepository.delete(computerId);

    }

    public void updateComputer(Computer computer) {

        computerDbAccess.updateComputer(computer);

        computerRepository.update(computer);

    }

}
