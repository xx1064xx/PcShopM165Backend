package Program.Controller;

import Program.DbAccess.DbAccess;

public class Controller {

    public void run() {

        DbAccess dbAccess = new DbAccess();

        System.out.println("huere mongo 2");

        dbAccess.connectToDb();
    }

}
