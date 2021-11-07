package edu.cnm.deepdive.reciperetriever.service;

import edu.cnm.deepdive.reciperetriever.model.dao.IngredientDao;
import edu.cnm.deepdive.reciperetriever.model.dao.RecipeDao;
import edu.cnm.deepdive.reciperetriever.model.entity.Recipe;
import io.reactivex.Single;

public class RecipeRepository {

  private final WebServiceProxy proxy;
  private final RecipeDao recipeDao;
  private final IngredientDao ingredientDao;

  public RecipeRepository() {
    proxy = WebServiceProxy.getInstance();
    RecipeRetrieverDatabase database = RecipeRetrieverDatabase.getInstance();
    recipeDao = database.getRecipeDao();
    ingredientDao = database.getIngredientDao();
  }

  public Single<Recipe> save(Recipe recipe) {
    return proxy
  }

}
