package edu.cnm.deepdive.reciperetriever.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import java.util.Date;

@Entity(
    tableName = "recipe"
)
public class Recipe {

  @PrimaryKey(autoGenerate = true)
  @Expose
  @ColumnInfo(name = "recipe_id")
  private long id;

  @NonNull
  @Expose
  @ColumnInfo(index = true)
  private String title;

  @Expose
  @NonNull
  private String description;

  @NonNull
  @Expose
  @ColumnInfo(index = true)
  private Date created;

  @NonNull
  @Expose
  private String steps;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getTitle() {
    return title;
  }

  public void setTitle(@NonNull String title) {
    this.title = title;
  }

  @NonNull
  public String getDescription() {
    return description;
  }

  public void setDescription(@NonNull String description) {
    this.description = description;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  @NonNull
  public String getSteps() {
    return steps;
  }

  public void setSteps(@NonNull String steps) {
    this.steps = steps;
  }
}
