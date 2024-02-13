package Program.DbAccess;

import Program.Repository.Adresse;
import Program.Repository.Kunde;
import Program.Service.KundenService;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KundenDbAccess {

    private KundenService kundenService;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private String database = "pcShopM165";
    private String connectionString = "mongodb://localhost:27017";
    private String collectionName = "kunden";

    public KundenDbAccess(KundenService kundenService) {

        this.kundenService = kundenService;
        connectToDb();
    }
    public void connectToDb() {

        mongoClient = MongoClients.create(connectionString);
        mongoDatabase = mongoClient.getDatabase(database);

        System.out.println("Mit Datenbank verbunden");

    }

    public ArrayList<Kunde> getAllKunden() {

        ArrayList<Kunde> kundenList = new ArrayList<>();
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {
            Kunde kunde = documentToKunde(doc);
            kundenList.add(kunde);
        }

        return kundenList;
    }

    public void addNewKunde(Kunde kunde) {

        Document kundeDocument = new Document();
        kundeDocument.append("geschlecht", kunde.getGeschlecht());
        kundeDocument.append("nachname", kunde.getNachname());
        kundeDocument.append("vorname", kunde.getVorname());
        kundeDocument.append("adresse", new Document()
                .append("strasse", kunde.getAdresse().getStrasse())
                .append("plz", kunde.getAdresse().getPlz())
                .append("ort", kunde.getAdresse().getOrt()));
        kundeDocument.append("telefon", kunde.getTelefon());
        kundeDocument.append("email", kunde.getEmail());
        kundeDocument.append("sprache", kunde.getSprache());
        kundeDocument.append("geburtsdatum", kunde.getGeburtsdatum());


        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);

        collection.insertOne(kundeDocument);


    }

    // hilfsmethoden
    private Kunde documentToKunde(Document document) {
        ObjectId kundenId = document.getObjectId("_id");
        String geschlecht = document.getString("geschlecht");
        String nachname = document.getString("nachname");
        String vorname = document.getString("vorname");
        String telefon = document.getString("telefon");
        String email = document.getString("email");
        String sprache = document.getString("sprache");
        Date geburtsdatum = document.getDate("geburtsdatum");

        Document adresseDoc = (Document) document.get("adresse");
        String strasse = adresseDoc.getString("strasse");
        int plz = adresseDoc.getInteger("plz");
        String ort = adresseDoc.getString("ort");
        Adresse adresse = new Adresse(strasse, plz, ort);

        return new Kunde(kundenId, geschlecht, nachname, vorname, adresse, telefon, email, sprache, geburtsdatum);
    }


}
