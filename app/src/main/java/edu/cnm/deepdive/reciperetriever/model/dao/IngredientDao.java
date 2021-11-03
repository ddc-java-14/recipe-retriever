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

@Dao
public interface IngredientDao {

  @Insert
  Single<Long> insert(Ingredient ingredient);

  @Insert
  Single<List<Long>> insert(Ingredient... ingredients);

  @Insert
  Single<List<Long>> insert(Collection<Ingredient> ingredients);

  @Update
  Single<Integer> update(Ingredient ingredient);

  @Update
  Single<Integer> update(Ingredient... ingredients);

  @Update
  Single<Integer> update(Collection<Ingredient> ingredients);

  @Delete
  Single<Integer> delete(Ingredient ingredient);

  @Delete
  Single<Integer> delete(Ingredient... ingredients);

  @Delete
  Single<Integer> delete(Collection<Ingredient> ingredients);

  @Query("SELECT * FROM ingredient WHERE ingredient_id ORDER BY ingredient_id DESC")
  LiveData<List<Ingredient>> selectAll();

  @Query("SELECT * FROM ingredient WHERE ingredient_id =:ingredientId")
  LiveData<List<Ingredient>> selectAll(long ingredientId);

}
