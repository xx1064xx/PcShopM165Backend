package Program.DbAccess;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class DbAccess {

    private Connection con;
    private String connectionString = "mongodb://localhost:27017";
    public void connectToDb() {

        MongoClient mongoClient = MongoClients.create(connectionString);

        List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());

        System.out.println(databases);

    }

}
