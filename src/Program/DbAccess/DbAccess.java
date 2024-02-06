package Program.DbAccess;

import com.mongodb.client.*;
import org.bson.Document;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DbAccess {

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;
    private String database = "pcShopM165";
    private String connectionString = "mongodb://localhost:27017";
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
