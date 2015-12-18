package controllers;
import java.lang.String;
import models.User;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import java.lang.String;
import play.mvc.*;

import views.html.*;

import static play.data.Form.form;

public class Application extends Controller {

    public Result index() {

        System.out.println("Welcome to the Tool Sharing Community!!!");

        return ok(index.render("Hello Welcome to your personal Tool Trader"));
    }

    public Result login() {
        DynamicForm userForm = form().bindFromRequest();
        String username = userForm.data().get("username");
        String password = userForm.data().get("password");

        User user = User.find.where().eq("username", username).findUnique();

        if(user != null && user.authenticate(password)) {
            session("user_id", user.id.toString());
            flash("Hello!! ", "Welcome Back " + user.username);
        } else {
            flash("error", "Invalid login. Check your username and password.");
        }

        return redirect(routes.Application.index());

    }

    public Result signup() {
        DynamicForm userForm = form().bindFromRequest();
        String username = userForm.data().get("username");
        String password = userForm.data().get("password");

        User user = User.createNewUser(username, password);

        if(user == null) {
            flash("error", "Invalid user");
            return redirect(routes.Application.index());
        }

        user.save();

        flash("success", "Welcome new user " + user.username);
        session("user_id", user.id.toString());
        return redirect(routes.Application.index());
    }

    public Result logout() {
        session().remove("user_id");
        return redirect(routes.Application.index());
    }

}
