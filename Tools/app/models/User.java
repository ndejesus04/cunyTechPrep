package models;
import com.avaje.ebean.Model;
import play.data.validation.Constraints;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="users")
@Entity
public class User extends Model {
    @Id
    public Long id;

    @Constraints.Required
    public String username;


    public String password_hash;

    // A finder object for easier querying
    public static Finder<Long, User> find = new Finder<Long, User>(User.class);


    // NOT FOR PRODUCTION - must ensure this is a valid user first. I have not done that.
    public boolean authenticate(String password) {
        return BCrypt.checkpw(password, this.password_hash);
    }

    public static User createNewUser(String username, String password) {
        if(password == null || username == null || password.length() < 3) {
            return null;
        }

        // Create a password hash
        String passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());

        User user = new User();
        user.username = username;
        user.password_hash = passwordHash;

        return user;
    }




}