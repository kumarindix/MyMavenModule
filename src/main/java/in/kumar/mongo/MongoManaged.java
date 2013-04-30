package in.kumar.mongo;

import com.mongodb.Mongo;
import com.yammer.dropwizard.lifecycle.Managed;

public class MongoManaged implements Managed {
    private Mongo m;
    
    public MongoManaged(Mongo m) {
        this.m = m;
    }

    @Override
    public void start() throws Exception {
        
    }

    @Override
    public void stop() throws Exception {
        
    }
}
