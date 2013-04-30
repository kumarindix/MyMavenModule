package in.kumar;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import in.kumar.configuration.ServicesConfiguration;
import in.kumar.dao.HelloDao;
import in.kumar.resource.HelloResource;

/**
 * Created with IntelliJ IDEA.
 * User: kumar
 * Date: 30/4/13
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main extends Service<ServicesConfiguration> {

    public Datastore datastore = null;

    public static void main(String ar[]) throws Exception {
        new Main().run(new String[]{"server", ar[0]});
    }

    @Override
    public void initialize(Bootstrap<ServicesConfiguration> servicesConfigurationBootstrap) {
        servicesConfigurationBootstrap.setName("Kumar-Services");

    }

    @Override
    public void run(ServicesConfiguration servicesConfiguration, Environment environment) throws Exception {
        Mongo mongo = new Mongo("localhost",27017);
        Morphia morphia = new Morphia();
        datastore = morphia.createDatastore(mongo,"kumarDb");

        HelloDao helloDao = new HelloDao(datastore);
        environment.addResource(new HelloResource(helloDao));

    }
}
