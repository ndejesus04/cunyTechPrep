package controllers;
import models.Genre;
import java.lang.String;
import play.data.Form;
import play.mvc.Result;
import models.Tool;
import java.util.List;

import static play.data.Form.form;
import static play.mvc.Results.ok;

/**
 * Created by ShantoiS on 12/2/15.
 */
public class Tools {
    public Result index() {
        List<Tool> tools = Tool.find.all();
        List<Genre> genres = Genre.find.all();
        return ok(views.html.tools.index.render(tools, genres));
    }

    public Result create() {
        Form<Tool> toolForm = form(Tool.class).bindFromRequest();
        String genre_id = toolForm.data().get("genre_id");

        Genre genre = Genre.find.byId(Long.parseLong(genre_id));
        if(genre == null) {
            //flash("error", "Invalid Genre: " + genre_id + " Try again.");
            //return redirect(routes.Tools.index());
        }

        //Tool tool = toolForm.get();
        //Tool.genre = genre;
        //Tool.save();
       // flash("success", "Saved new Movie: " + Tool.title);
        //return redirect(routes.Tools.index());
        return null;
   }



}

