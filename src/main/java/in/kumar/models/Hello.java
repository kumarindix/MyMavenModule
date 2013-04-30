package in.kumar.models;

import com.google.code.morphia.annotations.Id;
import org.bson.types.ObjectId;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: kumar
 * Date: 30/4/13
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Hello {

    @Id
    private ObjectId id;

    @JsonProperty
    private String name;

    @JsonIgnore
    private String greetings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGreetings() {
        return greetings;
    }

    public void setGreetings(String greetings) {
        this.greetings = greetings;
    }
}
