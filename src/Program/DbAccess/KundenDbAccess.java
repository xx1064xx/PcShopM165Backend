package Program.DbAccess;

import Program.Service.KundenService;
import com.mongodb.client.*;
import org.bson.Document;


import java.util.ArrayList;

public class KundenDbAccess {

    private KundenService kundenService;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private String database = "pcShopM165";
    private String connectionString = "mongodb://localhost:27017";

    public KundenDbAccess(KundenService kundenService) {

        this.kundenService = kundenService;
        connectToDb();
    }
    public void connectToDb() {

        mongoClient = MongoClients.create(connectionString);
        mongoDatabase = mongoClient.getDatabase(database);

        System.out.println("Mit Datenbank verbunden");

    }

    public ArrayList<Document> getAll(String collectionName) {

        ArrayList<Document> documentsList = new ArrayList<>();
        MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {
            documentsList.add(doc);
        }

        return documentsList;
    }

    public void getById(String collectionString){

    }

    public void insert(String collectionString) {

    }

    public void update(String collectionString) {

    }

    public void delete(String collectionString) {

    }

    public void save(String collectionString) {

    }


}
