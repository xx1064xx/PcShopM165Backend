package Program.Service;

import Program.Controller.Controller;
import Program.DbAccess.ComputerDbAccess;
import Program.Repository.Computer;
import Program.Repository.ComputerRepository;
import Program.Repository.Kunde;

import java.util.ArrayList;

public class ComputerService {

    private Controller controller;
    private ComputerDbAccess computerDbAccess;
    private ComputerRepository computerRepository;

    public ComputerService(Controller controller) {
        this.controller = controller;
        computerRepository = new ComputerRepository();
        computerDbAccess = new ComputerDbAccess(this);


    }

    public void readAllComputer() {

        ArrayList<Computer> computerList = computerDbAccess.getAllComputer();

        computerRepository.setAll(computerList);
    }

}
