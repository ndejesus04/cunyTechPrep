package controllers;

/**
 * Created by ShantoiS on 12/2/15.
 */

import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import models.User;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

public class UserAuth extends Security.Authenticator {

    // When return is null, Authentication failed
    @Override
    public String getUsername(final Http.Context ctx) {
        String userIdStr = ctx.session().get("user_id");
        if(userIdStr == null) return null;

        User user = User.find.byId(Long.parseLong(userIdStr));
        return (user != null ? user.id.toString() : null);
    }

    @Override
    public Result onUnauthorized(final Http.Context ctx) {
        ctx.flash().put("error",
                "Nice try, but you need to log in first!");
        return redirect(routes.Application.index());
    }
}

