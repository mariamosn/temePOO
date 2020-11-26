package action.query.video;

import fileio.ActionInputData;
import files.ModifiableDB;

public class MovieQuery {
    private ModifiableDB dataBase;
    private ActionInputData action;
    public MovieQuery(final ModifiableDB dataBase, final ActionInputData action) {
        this.dataBase = dataBase;
        this.action = action;
        if (action.getCriteria().equals("ratings")) {
            new MovieRatings(dataBase, action);
        } else if (action.getCriteria().equals("favorite")) {
            new MovieFavorite(dataBase, action);
        } else if (action.getCriteria().equals("longest")) {
            new MovieLongest(dataBase, action);
        } else if (action.getCriteria().equals("most_viewed")) {
            new MovieViewed(dataBase, action);
        } else {
            System.out.println("Invalid criteria!");
        }
    }
}

