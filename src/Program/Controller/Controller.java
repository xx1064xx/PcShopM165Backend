package Program.Controller;

import Program.DbAccess.DbAccess;
import Program.Repository.Kunde;
import Program.Service.Service;
import Program.View.ApplicationUi;

public class Controller {

    ApplicationUi applicationUi;
    Service service = new Service();

    public Controller() {
        applicationUi = new ApplicationUi(this);
    }

    public void run() {

        DbAccess dbAccess = new DbAccess();

        applicationUi.setVisible(true);

        dbAccess.connectToDb();
    }

    public void setKunde(Kunde kunde) {
        service.setKunde(kunde);
    }

}
