
package ee.lark.entities;

import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.search.annotations.*;

import javax.persistence.*;
import javax.persistence.Parameter;
import java.util.UUID;

@Entity
@Indexed
@Table(name="users")
public class User {

    @Id
    private UUID id;

    @Field(analyzer = @Analyzer(definition = "textanalyzer"))
    private String firstName;

    @Field(analyzer = @Analyzer(definition = "textanalyzer"))
    private String lastName;

    public User() {
    }

    public User(UUID id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
