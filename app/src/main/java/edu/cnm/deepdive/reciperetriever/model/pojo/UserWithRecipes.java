package edu.cnm.deepdive.reciperetriever.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.reciperetriever.model.entity.Recipe;
import edu.cnm.deepdive.reciperetriever.model.entity.User;
import java.util.List;

/**
 *
 */
public class UserWithRecipes extends User {

  @Relation(
      entity = Recipe.class,
      entityColumn = "user_id",
      parentColumn = "user_id"
  )
  private List<Recipe> recipes;

  /**
   *
   * @return
   */
  public List<Recipe> getRecipes() {
    return recipes;
  }

  /**
   *
   * @param recipes
   */
  public void setRecipes(List<Recipe> recipes) {
    this.recipes = recipes;
  }

}
