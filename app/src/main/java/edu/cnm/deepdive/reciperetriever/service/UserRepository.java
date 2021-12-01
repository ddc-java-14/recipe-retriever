package edu.cnm.deepdive.reciperetriever.service;

import android.app.Application;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.reciperetriever.model.dao.RecipeDao;
import edu.cnm.deepdive.reciperetriever.model.dao.UserDao;
import edu.cnm.deepdive.reciperetriever.model.pojo.UserWithRecipes;

/**
 *
 */
public class UserRepository {

  private final Application context;
  private final UserDao userDao;
  private final RecipeDao recipeDao;

  /**
   *
   * @param context
   */
  public UserRepository(Application context) {
    this.context = context;
    RecipeRetrieverDatabase database = RecipeRetrieverDatabase.getInstance();
    userDao = database.getUserDao();
    recipeDao = database.getRecipeDao();
  }

  /**
   *
   * @param userId
   * @return
   */
  public LiveData<UserWithRecipes> get(long userId) {
    return userDao.select(userId);
  }

}
