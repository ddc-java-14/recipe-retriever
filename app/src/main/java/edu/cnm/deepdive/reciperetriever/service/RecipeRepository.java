package edu.cnm.deepdive.reciperetriever.service;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.reciperetriever.model.dao.IngredientDao;
import edu.cnm.deepdive.reciperetriever.model.dao.RecipeDao;
import edu.cnm.deepdive.reciperetriever.model.entity.Ingredient;
import edu.cnm.deepdive.reciperetriever.model.entity.Recipe;
import edu.cnm.deepdive.reciperetriever.model.pojo.RecipeWithIngredients;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

  public Single<RecipeWithIngredients> save(RecipeWithIngredients recipe) {
    Single<RecipeWithIngredients> task;
    if (recipe.getId() == 0) {
      task = recipeDao
          .insert(recipe)
          .map((id) -> assignRecipeId(recipe, id))
          .flatMap((savedRecipe) -> ingredientDao.insert(savedRecipe.getIngredients()))
          .map((ids) -> assignIngredientIds(recipe, ids));
    } else {
      task = recipeDao
          .update(recipe)
          .flatMap((c) -> updateIngredients(recipe))
          .flatMap((c) -> insertNewIngredients(recipe));
    }
    return task
        .subscribeOn(Schedulers.io());
  }

  public LiveData<RecipeWithIngredients> getRecipe(long recipeId) {
    return recipeDao.select(recipeId);
  }

  public LiveData<List<Recipe>> getAll() {
    return recipeDao.selectAll();
  }
  public Completable delete(Recipe recipe) {
    return (recipe.getId() == 0)
        ? Completable.complete()
        : recipeDao
            .delete(recipe)
            .ignoreElement()
            .subscribeOn(Schedulers.io());
  }




//  TODO add search method for database.
//  TODO add search method to search through api.
  @NonNull
  private Single<RecipeWithIngredients> insertNewIngredients(
      RecipeWithIngredients recipe) {
    List<Ingredient> newIngredients = recipe
        .getIngredients()
        .stream()
        .filter((ingredient) -> ingredient.getId() == 0)
        .collect(Collectors.toList());
    return ingredientDao
        .insert(newIngredients)
        .map((ids) -> assignIngredientIds(recipe, ids));
  }

  private Single<Integer> updateIngredients(RecipeWithIngredients recipe) {
    List<Ingredient> updatedIngredients = recipe
        .getIngredients()
        .stream()
        .filter((ingredient) -> ingredient.getId() == 0)
        .collect(Collectors.toList());
    return ingredientDao.update(updatedIngredients);
  }

  @NonNull
  private RecipeWithIngredients assignIngredientIds(RecipeWithIngredients recipe,
      List<Long> ids) {
    Iterator<Long> idIter = ids.iterator();
    Iterator<Ingredient> ingredientIter = recipe.getIngredients().iterator();
    while (idIter.hasNext()) {
      long id = idIter.next();
      Ingredient ingredient = ingredientIter.next();
      ingredient.setId(id);
    }
    return recipe;
  }

  @NonNull
  private RecipeWithIngredients assignRecipeId(RecipeWithIngredients recipe, Long id) {
    recipe.setId(id);
    if (recipe.getIngredients() == null) {
      recipe.setIngredients(new LinkedList<>());
    }
    for (Ingredient ingredient : recipe.getIngredients()) {
      ingredient.setRecipeId(id);
    }
    return recipe;
  }

}
