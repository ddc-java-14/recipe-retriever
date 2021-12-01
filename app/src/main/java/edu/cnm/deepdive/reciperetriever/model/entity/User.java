package edu.cnm.deepdive.reciperetriever.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import java.util.Date;

/**
 *
 */
@Entity(
    tableName = "user",
    indices = {
        @Index(value = {"email"}, unique = true)
    }
)
public class User {

  @PrimaryKey(autoGenerate = true)
  @Expose
  @ColumnInfo(name = "user_id", index = true)
  private long id;

  @NonNull
  @Expose
  @ColumnInfo(index = true)
  private Date created;

  @NonNull
  @Expose
  @ColumnInfo(name = "user_name", index = true)
  private String name;

  @NonNull
  @Expose
  private String email;

  /**
   *
   * @return
   */
  public long getId() {
    return id;
  }

  /**
   *
   * @param id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   *
   * @return
   */
  @NonNull
  public Date getCreated() {
    return created;
  }

  /**
   *
   * @param created
   */
  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  /**
   *
   * @return
   */
  @NonNull
  public String getName() {
    return name;
  }

  /**
   *
   * @param name
   */
  public void setName(@NonNull String name) {
    this.name = name;
  }

  /**
   *
   * @return
   */
  @NonNull
  public String getEmail() {
    return email;
  }

  /**
   *
   * @param email
   */
  public void setEmail(@NonNull String email) {
    this.email = email;
  }
}
