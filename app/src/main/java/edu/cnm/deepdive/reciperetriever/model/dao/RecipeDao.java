package edu.cnm.deepdive.reciperetriever.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.reciperetriever.model.entity.Recipe;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface RecipeDao {

  @Insert
  Single<Long> insert(Recipe recipe);

  @Insert
  Single<List<Long>> insert(Recipe... recipes);

  @Insert
  Single<List<Long>> insert(Collection<Recipe> recipes);

  @Update
  Single<Integer> update(Recipe recipe);

  @Update
  Single<Integer> update(Recipe... recipes);

  @Update
  Single<Integer> update(Collection<Recipe> recipes);

  @Delete
  Single<Integer> delete(Recipe recipe);

  @Delete
  Single<Integer> delete(Recipe... recipes);

  @Delete
  Single<Integer> delete(Collection<Recipe> recipes);

  @Query("SELECT * FROM recipe WHERE cuisine_type_id ORDER BY cuisine_type_id DESC")
  LiveData<List<Recipe>> selectAll();

  @Query("SELECT * FROM recipe WHERE recipe_id =:recipeId")
  LiveData<List<Recipe>> selectAll(long recipeId);

}

