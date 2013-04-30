package in.kumar.dao;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;
import in.kumar.models.Hello;
import org.bson.types.ObjectId;

/**
 * Created with IntelliJ IDEA.
 * User: kumar
 * Date: 30/4/13
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloDao extends BasicDAO<Hello, ObjectId> {

    public HelloDao(Datastore ds) {
        super(ds);
    }
}
