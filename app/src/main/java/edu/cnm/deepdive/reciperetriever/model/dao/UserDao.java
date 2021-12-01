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

/**
 *
 */
@Dao
public interface UserDao {

  /**
   *
   * @param user
   * @return
   */
  @Insert
  Single<Long> insert(User user);

  /**
   *
   * @param users
   * @return
   */
  @Insert
  Single<List<Long>> insert(User... users);

  /**
   *
   * @param users
   * @return
   */
  @Insert
  Single<List<Long>> insert(Collection<User> users);

  /**
   *
   * @param user
   * @return
   */
  @Update
  Single<Integer> update(User user);

  /**
   *
   * @param users
   * @return
   */
  @Update
  Single<Integer> update(User... users);

  /**
   *
   * @param users
   * @return
   */
  @Update
  Single<Integer> update(Collection<User> users);

  /**
   *
   * @param user
   * @return
   */
  @Delete
  Single<Integer> delete(User user);

  /**
   *
   * @param users
   * @return
   */
  @Delete
  Single<Integer> delete(User... users);

  /**
   *
   * @param users
   * @return
   */
  @Delete
  Single<Integer> delete(Collection<User> users);

  /**
   *
   * @param userId
   * @return
   */
  @Transaction
  @Query("SELECT * FROM user WHERE user_id = :userId")
  LiveData<UserWithRecipes> select(long userId);

}
