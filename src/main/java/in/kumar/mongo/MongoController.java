package in.kumar.mongo;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.*;

import java.net.UnknownHostException;

public class MongoController {

    private Mongo mongo;
    private DB db;
    private final Morphia morphia;

    public MongoController(Connection connection) throws UnknownHostException {
        if (connection.getHost() == null) {
            mongo = new Mongo();
        } else {
            MongoOptions options = new MongoOptions();
            options.setConnectionsPerHost(100);
            mongo = new Mongo(connection.getHost(),options);
        }
        db = mongo.getDB(connection.getDbName());
        morphia = new Morphia();
    }
    
    public Datastore getDataStore() {
        return morphia.createDatastore(mongo, db.toString());
    }
    
    public Mongo getMongo() {
        return mongo;
    }
    
    public void mapClass(Class entityClass) {
        morphia.map(entityClass);
    }
}