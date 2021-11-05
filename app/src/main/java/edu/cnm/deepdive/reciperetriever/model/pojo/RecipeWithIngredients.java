package edu.cnm.deepdive.reciperetriever.model.pojo;

import androidx.room.Relation;
import edu.cnm.deepdive.reciperetriever.model.entity.Ingredient;
import edu.cnm.deepdive.reciperetriever.model.entity.Recipe;
import java.util.List;

public class RecipeWithIngredients extends Recipe {

  @Relation(
      entity = Ingredient.class,
      entityColumn = "recipe_id",
      parentColumn = "recipe_id"
  )
  private List<Ingredient> ingredients;

  @Override
  public List<Ingredient> getIngredients(){
    return ingredients;
  }

  public void setIngredients(
      List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }
}
