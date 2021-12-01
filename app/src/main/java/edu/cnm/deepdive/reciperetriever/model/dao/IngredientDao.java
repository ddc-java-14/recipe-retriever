package edu.cnm.deepdive.reciperetriever.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.reciperetriever.model.entity.Ingredient;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 *
 */
@Dao
public interface IngredientDao {

  /**
   *
   * @param ingredient
   * @return
   */
  @Insert
  Single<Long> insert(Ingredient ingredient);

  /**
   *
   * @param ingredients
   * @return
   */
  @Insert
  Single<List<Long>> insert(Ingredient... ingredients);

  /**
   *
   * @param ingredients
   * @return
   */
  @Insert
  Single<List<Long>> insert(Collection<Ingredient> ingredients);

  /**
   *
   * @param ingredient
   * @return
   */
  @Update
  Single<Integer> update(Ingredient ingredient);

  /**
   *
   * @param ingredients
   * @return
   */
  @Update
  Single<Integer> update(Ingredient... ingredients);

  /**
   *
   * @param ingredients
   * @return
   */
  @Update
  Single<Integer> update(Collection<Ingredient> ingredients);

  /**
   *
   * @param ingredient
   * @return
   */
  @Delete
  Single<Integer> delete(Ingredient ingredient);

  /**
   *
   * @param ingredients
   * @return
   */
  @Delete
  Single<Integer> delete(Ingredient... ingredients);

  /**
   *
   * @param ingredients
   * @return
   */
  @Delete
  Single<Integer> delete(Collection<Ingredient> ingredients);

  /**
   *
   * @return
   */
  @Query("SELECT * FROM ingredient WHERE ingredient_id ORDER BY name DESC")
  LiveData<List<Ingredient>> selectAll();

  /**
   *
   * @param ingredientId
   * @return
   */
  @Query("SELECT * FROM ingredient WHERE ingredient_id =:ingredientId")
  LiveData<List<Ingredient>> selectAll(long ingredientId);

}
