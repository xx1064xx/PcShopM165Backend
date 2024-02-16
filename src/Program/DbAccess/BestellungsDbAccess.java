package Program.DbAccess;

import Program.Repository.*;
import Program.Service.Bestellungsservice;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BestellungsDbAccess {

    private Bestellungsservice bestellungsservice;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private String database = "pcShopM165";
    private String connectionString = "mongodb://localhost:27017";
    private String collectionName = "bestellung";

    public BestellungsDbAccess(Bestellungsservice bestellungsservice) {
        this.bestellungsservice = bestellungsservice;
        connectToDb();

    }

    public void connectToDb() {

        mongoClient = MongoClients.create(connectionString);
        mongoDatabase = mongoClient.getDatabase(database);

        System.out.println("Mit Datenbank verbunden");

    }

    public void addNewBestellung(Bestellung bestellung) {

        Kunde kunde = bestellung.getKunde();

        Document bestellungsDocument = new Document();
        bestellungsDocument.append("bestelldatum", bestellung.getBestelldatum());
        bestellungsDocument.append("kunde", kunde.getKundenId());
        bestellungsDocument.append("total", bestellung.getTotal());

        List<Document> bestellpositionenList = new ArrayList<>();
        for (Bestellposition bestellposition : bestellung.getBestellpositionen()) {

            Computer computer = bestellposition.getComputer();

            Document bestellpositionDoc = new Document("computer", computer.getComputerId());
            bestellpositionDoc.append("preis", bestellposition.getPreis());
            bestellpositionDoc.append("stueckzahl", bestellposition.getStueckzahl());

            bestellpositionenList.add(bestellpositionDoc);
        }
        bestellungsDocument.append("bestellpositionen", bestellpositionenList);

        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

        collection.insertOne(bestellungsDocument);


    }

    public ArrayList<Bestellung> getAllBestellungen() {

        ArrayList<Bestellung> bestellungsList = new ArrayList<>();
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {
            Bestellung bestellung = documentToBestellung(doc);
            bestellungsList.add(bestellung);
        }

        return bestellungsList;

    }

    public void deleteBestellung(ObjectId bestellungsId) {
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

        collection.deleteOne(Filters.eq("_id", bestellungsId));
    }

    public void updateBestellung(Bestellung updatedBestellung) {

        ObjectId bestellungsId = updatedBestellung.getBestellungsId();

        Kunde kunde = updatedBestellung.getKunde();

        Document updatedBestellungDocument = new Document();
        updatedBestellungDocument.append("bestelldatum", updatedBestellung.getBestelldatum());
        updatedBestellungDocument.append("kunde", kunde.getKundenId());
        updatedBestellungDocument.append("total", updatedBestellung.getTotal());


        List<Document> bestellpositionenList = new ArrayList<>();
        for (Bestellposition bestellposition : updatedBestellung.getBestellpositionen()) {

            Computer computer = bestellposition.getComputer();

            Document bestellpositionDoc = new Document("computer", computer.getComputerId());
            bestellpositionDoc.append("preis", bestellposition.getPreis());
            bestellpositionDoc.append("stueckzahl", bestellposition.getStueckzahl());

            bestellpositionenList.add(bestellpositionDoc);
        }
        updatedBestellungDocument.append("bestellpositionen", bestellpositionenList);

        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

        collection.updateOne(
                Filters.eq("_id", bestellungsId),
                new Document("$set", updatedBestellungDocument)
        );
    }

    // hilfsmethoden
    private Bestellung documentToBestellung(Document document) {

        ArrayList<Bestellposition> bestellpositionen = new ArrayList<>();

        List<Document> bestellpositionenList = (List<Document>) document.get("bestellpositionen");

        for (Document bestellpositionDoc : bestellpositionenList) {

            ObjectId computerId = bestellpositionDoc.getObjectId("computer");
            double preis = bestellpositionDoc.getDouble("preis");
            int stueckzahl = bestellpositionDoc.getInteger("stueckzahl");

            Computer computer = bestellungsservice.getComputerById(computerId);

            Bestellposition bestellposition = new Bestellposition(
                    computer,
                    preis,
                    stueckzahl
            );

            bestellpositionen.add(bestellposition);

        }

        ObjectId bestellungsId = document.getObjectId("_id");
        Date date = document.getDate("bestelldatum");
        ObjectId kundenid = document.getObjectId("kunde");
        double total = document.getDouble("total");

        Kunde kunde = bestellungsservice.getKundeById(kundenid);

        return new Bestellung(bestellungsId, date, kunde, bestellpositionen, total);
    }

}
