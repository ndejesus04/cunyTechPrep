package controllers;
import java.lang.String;
import views.html.newmain;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import java.lang.String;
import play.mvc.*;

import views.html.*;

import static play.data.Form.form;

/**
 * Created by ShantoiS on 12/18/15.
 */
public class mainPage extends Controller{

   public Result index()
    {
        System.out.println("Welcome to the Tool Sharing Community!!!");
        return redirect(routes.Application.index());

    }



}
