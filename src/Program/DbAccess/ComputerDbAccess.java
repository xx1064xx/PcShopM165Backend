package Program.DbAccess;

import Program.Repository.Adresse;
import Program.Repository.Computer;
import Program.Repository.Kunde;
import Program.Repository.Schnittstelle;
import Program.Service.ComputerService;
import Program.Service.KundenService;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComputerDbAccess {

    private ComputerService computerService;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private String database = "pcShopM165";
    private String connectionString = "mongodb://localhost:27017";
    private String collectionName = "computer";

    public ComputerDbAccess (ComputerService computerService) {
        this.computerService = computerService;
    }

    public void connectToDb() {

        mongoClient = MongoClients.create(connectionString);
        mongoDatabase = mongoClient.getDatabase(database);

        System.out.println("Mit Datenbank verbunden");

    }

    public ArrayList<Computer> getAllComputer() {

        ArrayList<Computer> computerList = new ArrayList<>();
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {
            Computer computer = documentToComputer(doc);
            computerList.add(computer);
        }

        return computerList;
    }

    // hilfsmethoden
    private Computer documentToComputer(Document document) {
        ObjectId computerId = document.getObjectId("_id");
        String hersteller = document.getString("hersteller");
        String modell = document.getString("modell");
        int arbeitsspeicher = document.getInteger("arbeitsspeicher");
        String cpu = document.getString("cpu");
        int massenspeicher = document.getInteger("massenspeicher");
        String typ = document.getString("typ");
        double einzelpreis = document.getDouble("einzelpreis");

        ArrayList<Schnittstelle> schnittstellen = new ArrayList<>();
        List<Document> schnittstellenList = (List<Document>) document.get("schnittstellen");
        for (Document schnittstelleDoc : schnittstellenList) {
            String schnittstellenName = schnittstelleDoc.getString("schnittstellenName");
            Schnittstelle schnittstelle = new Schnittstelle(schnittstellenName);
            schnittstellen.add(schnittstelle);
        }

        return new Computer(computerId, hersteller, modell, arbeitsspeicher, cpu, massenspeicher, typ, einzelpreis, schnittstellen);
    }

}
