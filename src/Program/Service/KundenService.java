package Program.Service;

import Program.Controller.Controller;
import Program.DbAccess.KundenDbAccess;
import Program.Repository.Kunde;
import Program.Repository.KundenRepository;

import java.util.ArrayList;

public class KundenService {

    private Controller controller;
    private KundenDbAccess kundenDbAccess;
    private KundenRepository kundenRepository;

    public KundenService(Controller controller) {
        this.controller = controller;

        kundenDbAccess = new KundenDbAccess(this);
        kundenRepository = new KundenRepository(this);
    }

    // functions

    public void readAllKunden() {

        ArrayList<Kunde> kundenList = kundenDbAccess.getAllKunden();

        kundenRepository.setAll(kundenList);

    }

    public ArrayList<Kunde> getAllKunden() {
        ArrayList<Kunde> kunden = kundenRepository.getAll();

        return kunden;
    }

    public Kunde getByIndex(int index) {
        Kunde kunde = kundenRepository.getByIndex(index);
        return kunde;
    }
    public void addNewKunde(Kunde kunde) {

        kundenDbAccess.addNewKunde(kunde);

        // es müssen alle Kunden neu ausgelesen werden, damit auch der neue Kunde seine ObjectId erhält
        ArrayList<Kunde> kundenList = kundenDbAccess.getAllKunden();
        kundenRepository.setAll(kundenList);

    }

    public void updateKunde(Kunde kunde) {

        kundenDbAccess.updateKunde(kunde);

        kundenRepository.update(kunde);

    }

}
