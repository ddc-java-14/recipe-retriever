package edu.cnm.deepdive.reciperetriever.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import java.util.Date;

/**
 *
 */
@Entity(
    tableName = "ingredient",
    foreignKeys = {
        @ForeignKey(
            entity = Recipe.class,
            parentColumns = {"recipe_id"},
            childColumns = {"recipe_id"},
            onDelete = ForeignKey.CASCADE
        )
    }
)
public class Ingredient {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "ingredient_id")
  private long id;

  @ColumnInfo(name = "recipe_id", index = true)
  private long recipeId;

  @NonNull
  @Expose
  private String name;

  @Expose
  @NonNull
  @ColumnInfo(index = true)
  private Date created;

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
  public long getRecipeId() {
    return recipeId;
  }

  /**
   *
   * @param recipeId
   */
  public void setRecipeId(long recipeId) {
    this.recipeId = recipeId;
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
}
