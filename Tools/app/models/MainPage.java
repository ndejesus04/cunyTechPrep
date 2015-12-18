package models;

import play.data.validation.Constraints;

/**
 * Created by ShantoiS on 12/18/15.
 */
public class MainPage {
    @Constraints.Required
    public String title;
}
