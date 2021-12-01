package edu.cnm.deepdive.reciperetriever.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.reciperetriever.model.entity.Recipe;
import edu.cnm.deepdive.reciperetriever.model.entity.Recipe.CuisineType;
import edu.cnm.deepdive.reciperetriever.model.pojo.RecipeWithIngredients;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 *
 */
@Dao
public interface RecipeDao {

  /**
   *
   * @param recipe
   * @return
   */
  @Insert
  Single<Long> insert(Recipe recipe);

  /**
   *
   * @param recipes
   * @return
   */
  @Insert
  Single<List<Long>> insert(Recipe... recipes);

  /**
   *
   * @param recipes
   * @return
   */
  @Insert
  Single<List<Long>> insert(Collection<? extends Recipe> recipes);

  /**
   *
   * @param recipe
   * @return
   */
  @Update
  Single<Integer> update(Recipe recipe);

  /**
   *
   * @param recipes
   * @return
   */
  @Update
  Single<Integer> update(Recipe... recipes);

  /**
   *
   * @param recipes
   * @return
   */
  @Update
  Single<Integer> update(Collection<? extends Recipe> recipes);

  /**
   *
   * @param recipe
   * @return
   */
  @Delete
  Single<Integer> delete(Recipe recipe);

  /**
   *
   * @param recipes
   * @return
   */
  @Delete
  Single<Integer> delete(Recipe... recipes);

  /**
   *
   * @param recipes
   * @return
   */
  @Delete
  Single<Integer> delete(Collection<? extends Recipe> recipes);

  /**
   *
   * @return
   */
  @Query("SELECT * FROM recipe ORDER BY title ASC")
  LiveData<List<Recipe>> selectAll();

  /**
   *
   * @param recipeId
   * @return
   */
  @Query("SELECT * FROM recipe WHERE recipe_id =:recipeId")
  LiveData<RecipeWithIngredients> select(long recipeId);

  /**
   *
   * @param cuisineType
   * @return
   */
  @Query("SELECT * FROM recipe WHERE cuisine_type= :cuisineType ORDER BY title ASC")
  LiveData<List<Recipe>> selectByCuisine(CuisineType cuisineType);

}

