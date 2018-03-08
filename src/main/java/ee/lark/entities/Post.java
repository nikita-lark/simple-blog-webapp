package ee.lark.entities;

import ee.lark.adapters.UUIDAdapter;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Parameter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.UUID;

@Entity
@Indexed
@AnalyzerDef(
        name = "textanalyzer",
        tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
        filters = {
                @TokenFilterDef(factory = LowerCaseFilterFactory.class)
        }
)
@Table(name="posts")
@XmlRootElement
public class Post {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false)
    @XmlJavaTypeAdapter(UUIDAdapter.class)
    private UUID id;

    @Field(analyzer = @Analyzer(definition = "textanalyzer"))
    @Column(name="title", columnDefinition="TEXT")
    private String title;

    @Field(analyzer = @Analyzer(definition = "textanalyzer"))
    @Column(name="text", columnDefinition="TEXT")
    private String text;

    @ManyToOne
    @IndexedEmbedded
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public Post() {
        this.createdAt = new Date();
    }

    public Post(String title, String text, User user) {
        this.title = title;
        this.text = text;
        this.user = user;

        this.createdAt = new Date();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String lastName) {
        this.text = lastName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
