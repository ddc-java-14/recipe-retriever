package edu.cnm.deepdive.reciperetriever.model.view;

import androidx.room.DatabaseView;
import edu.cnm.deepdive.reciperetriever.model.entity.Recipe;

@DatabaseView( value = RecipeSummary.QUERY, viewName = "recipe_summary")
public class RecipeSummary extends Recipe {

//  TODO fix Query and add fields if needed.

  static final String QUERY = "SELECT \n"
      + "  r.*, \n"
      + "  i., \n"
      + "  (s.last_guess - s.first_guess) AS total_time \n"
      + "FROM \n"
      + "  recipe AS r \n"
      + "  INNER JOIN ( \n"
      + "    SELECT \n"
      + "      recipe_id, \n"
      + "      COUNT(*) AS guess_count, \n"
      + "      MIN(created) AS first_guess, \n"
      + "      MAX(created) AS last_guess \n"
      + "    FROM \n"
      + "      ingredient \n"
      + "    GROUP BY \n"
      + "       \n"
      + "      \n"
      + "  ) AS  \n"
      + "     ON \n";



}
