package edu.cnm.deepdive.reciperetriever.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import edu.cnm.deepdive.reciperetriever.model.entity.Ingredient;
import edu.cnm.deepdive.reciperetriever.model.entity.Recipe;
import edu.cnm.deepdive.reciperetriever.model.entity.User;
import edu.cnm.deepdive.reciperetriever.model.pojo.UserWithRecipes;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface UserDao {

  @Insert
  Single<Long> insert(User user);

  @Insert
  Single<List<Long>> insert(User... users);

  @Insert
  Single<List<Long>> insert(Collection<User> users);

  @Update
  Single<Integer> update(User user);

  @Update
  Single<Integer> update(User... users);

  @Update
  Single<Integer> update(Collection<User> users);

  @Delete
  Single<Integer> delete(User user);

  @Delete
  Single<Integer> delete(User... users);

  @Delete
  Single<Integer> delete(Collection<User> users);

  @Transaction
  @Query("SELECT * FROM user WHERE user_id = :userId")
  LiveData<UserWithRecipes> select(long userId);

}
