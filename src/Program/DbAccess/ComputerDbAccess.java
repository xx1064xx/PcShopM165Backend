package Program.DbAccess;

import Program.Repository.Computer;
import Program.Repository.Kunde;
import Program.Repository.Schnittstelle;
import Program.Service.Computerservice;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class ComputerDbAccess {

    private Computerservice computerService;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private String database = "pcShopM165";
    private String connectionString = "mongodb://localhost:27017";
    private String collectionName = "computer";

    public ComputerDbAccess (Computerservice computerService) {
        this.computerService = computerService;
        connectToDb();
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

    public void addNewComputer(Computer computer) {

        Document computerDocument = new Document();
        computerDocument.append("hersteller", computer.getHersteller());
        computerDocument.append("modell", computer.getModell());
        computerDocument.append("arbeitsspeicher", computer.getArbeitsspeicher());
        computerDocument.append("cpu", computer.getCpu());
        computerDocument.append("massenspeicher", computer.getMassenspeicher());
        computerDocument.append("typ", computer.getTyp());
        computerDocument.append("einzelpreis", computer.getEinzelpreis());

        List<Document> schnittstellenList = new ArrayList<>();
        for (Schnittstelle schnittstelle : computer.getSchnittstellen()) {
            Document schnittstelleDoc = new Document("name", schnittstelle.getSchnittstelle());
            schnittstellenList.add(schnittstelleDoc);
        }
        computerDocument.append("schnittstellen", schnittstellenList);

        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

        collection.insertOne(computerDocument);


    }

    // hilfsmethoden
    private Computer documentToComputer(Document document) {

        ArrayList<Schnittstelle> schnittstellen = new ArrayList<>();
        List<Document> schnittstellenList = (List<Document>) document.get("schnittstellen");
        for (Document schnittstelleDoc : schnittstellenList) {
            String schnittstellenName = schnittstelleDoc.getString("name");
            Schnittstelle schnittstelle = new Schnittstelle(schnittstellenName);
            schnittstellen.add(schnittstelle);
        }


        ObjectId computerId = document.getObjectId("_id");
        String hersteller = document.getString("hersteller");
        String modell = document.getString("modell");
        int arbeitsspeicher = document.getInteger("arbeitsspeicher");
        String cpu = document.getString("cpu");
        int massenspeicher = document.getInteger("massenspeicher");
        String typ = document.getString("typ");
        double einzelpreis = document.getDouble("einzelpreis");


        return new Computer(computerId, hersteller, modell, arbeitsspeicher, cpu, massenspeicher, typ, einzelpreis, schnittstellen);
    }

    public void deleteComputer(ObjectId objectId) {

        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

        collection.deleteOne(Filters.eq("_id", objectId));
    }

    public void updateComputer(Computer updatedComputer) {

        ObjectId computerId = updatedComputer.getComputerId();


        Document updatedComputerDocument = new Document();
        updatedComputerDocument.append("hersteller", updatedComputer.getHersteller());
        updatedComputerDocument.append("modell", updatedComputer.getModell());
        updatedComputerDocument.append("arbeitsspeicher", updatedComputer.getArbeitsspeicher());
        updatedComputerDocument.append("cpu", updatedComputer.getCpu());
        updatedComputerDocument.append("massenspeicher", updatedComputer.getMassenspeicher());
        updatedComputerDocument.append("typ", updatedComputer.getTyp());
        updatedComputerDocument.append("einzelpreis", updatedComputer.getEinzelpreis());

        List<Document> schnittstellenList = new ArrayList<>();
        for (Schnittstelle schnittstelle : updatedComputer.getSchnittstellen()) {
            Document schnittstelleDoc = new Document("name", schnittstelle.getSchnittstelle());
            schnittstellenList.add(schnittstelleDoc);
        }
        updatedComputerDocument.append("schnittstellen", schnittstellenList);

        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

        collection.updateOne(
                Filters.eq("_id", computerId),
                new Document("$set", updatedComputerDocument)
        );
    }



}
