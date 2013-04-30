package in.kumar.mongo;


import in.kumar.configuration.ServicesConfiguration;

public class Connection {
    private String host;
    private int port;
    private String dbName;

    public Connection(String dbName){
        this.dbName = dbName;
    }
    
    public Connection(String dbName, String host, int port) {
        this.dbName = dbName;
        this.host = host;
        this.port = port;
    }
    
    public Connection(ServicesConfiguration configuration) {
        this.dbName = configuration.mongodb;
        this.host = configuration.mongohost;
        this.port = configuration.mongoport;
    }
    
    
    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
    
    public String getDbName() {
       return dbName;
    }

}