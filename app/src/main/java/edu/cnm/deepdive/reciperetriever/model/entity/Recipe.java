package edu.cnm.deepdive.reciperetriever.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
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

  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  @NonNull
  @Expose
  private String steps;

  @NonNull
  @Expose
  @ColumnInfo(name = "cuisine_type", index = true)
  private CuisineType cuisineType;

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

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  @NonNull
  public String getSteps() {
    return steps;
  }

  public void setSteps(@NonNull String steps) {
    this.steps = steps;
  }

  @NonNull
  public CuisineType getCuisineType() {
    return cuisineType;
  }

  public void setCuisineType(@NonNull CuisineType cuisineType) {
    this.cuisineType = cuisineType;
  }

  public enum CuisineType {

    AFRICAN("African"),
    AMERICAN("American"),
    BRITISH("British"),
    CAJUN("Cajun"),
    CARIBBEAN("Caribbean"),
    CHINESE("Chinese"),
    EASTERN_EUROPEAN("Eastern European"),
    EUROPEAN("European"),
    FRENCH("French"),
    GERMAN("German"),
    GREEK("Greek"),
    INDIAN("Indian"),
    IRISH("Irish"),
    ITALIAN("Italian"),
    JAPANESE("Japanese"),
    JEWISH("Jewish"),
    KOREAN("Korean"),
    LATIN_AMERICAN("Latin American"),
    MEDITERRANEAN("Mediterranean"),
    MEXICAN("Mexican"),
    MIDDLE_EASTERN("Middle Eastern"),
    NORDIC("Nordic"),
    SOUTHERN("Southern"),
    SPANISH("Spanish"),
    THAI("Thai"),
    VIETNAMESE("Vietnamese");

    private final String name;

    CuisineType(String name) {
      this.name = name;
    }


    @TypeConverter
    public static CuisineType of(Integer value) {
      return (value != null) ? values()[value] : null;
    }

    @TypeConverter
    public static Integer toInteger(CuisineType value) {
      return (value != null) ? value.ordinal() : null;

    }

    @NonNull
    @Override
    public String toString() {
      return name;
    }
  }

}
