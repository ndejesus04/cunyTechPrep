package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by ShantoiS on 12/2/15.
 */
@Entity
public class Tool extends Model {
    @Id
    public Long id;

    @Constraints.Required
    public String title;

    public String summary;

    public String url;

    @ManyToOne
    public Genre genre;

    // A finder object for easier querying
    public static Finder<Long, Tool> find = new Finder<Long, Tool>(Tool.class);
}