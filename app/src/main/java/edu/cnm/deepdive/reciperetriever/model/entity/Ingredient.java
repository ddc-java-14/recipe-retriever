package edu.cnm.deepdive.reciperetriever.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import java.util.Date;

@Entity(
    tableName = "ingredient",
    indices = {
        @Index(
            value = {"amount_of_recipes"},
            unique = true)
    }
)
public class Ingredient {

  @PrimaryKey(autoGenerate = true)
  @NonNull
  @Expose
  @ColumnInfo(name = "ingredient_id")
  private String id;

  @NonNull
  @Expose
  private String name;

  @Expose
  @NonNull
  @ColumnInfo(index = true)
  private Date created;

  @Expose
  @ColumnInfo(name = "amount_of_recipes")
  private int amountOfRecipes;

  @NonNull
  public String getId() {
    return id;
  }

  public void setId(@NonNull String id) {
    this.id = id;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  public int getAmountOfRecipes() {
    return amountOfRecipes;
  }

  public void setAmountOfRecipes(int amountOfRecipes) {
    this.amountOfRecipes = amountOfRecipes;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  public void setCreated(@NonNull Date created) {
    this.created = created;
  }
}
