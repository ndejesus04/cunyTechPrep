package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by ShantoiS on 12/2/15.
 */
@Entity
public class Genre extends Model {
    @Id
    public Long id;

    @Constraints.Required
    public String name;

    @OneToMany
    public List<Tool> toolsList;

    // A finder object for easier querying
    public static Finder<Long, Genre> find = new Finder<Long, Genre>(Genre.class);

}
