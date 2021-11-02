package edu.cnm.deepdive.reciperetriever.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import java.util.Date;

@Entity(
    tableName = "ingredient"
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
  @ColumnInfo(name = "unit_of_measure", index = true)
  private double unitOfMeasure;

  @Expose
  @ColumnInfo(name = "min_carb", index = true)
  private double minCarb;

  @Expose
  @ColumnInfo(name = "max_carb", index = true)
  private double maxCarb;

  @Expose
  @ColumnInfo(name = "min_protein", index = true)
  private double minProtein;

  @Expose
  @ColumnInfo(name = "max_protein", index = true)
  private double maxProtein;

  @Expose
  @ColumnInfo(name = "min_fat", index = false)
  private double minFat;

  @Expose
  @ColumnInfo(name = "max_fat", index = false)
  private double maxFat;

  @Expose
  @NonNull
  @ColumnInfo(index = true)
  private Date created;

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

  public double getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(double unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public double getMinCarb() {
    return minCarb;
  }

  public void setMinCarb(double minCarb) {
    this.minCarb = minCarb;
  }

  public double getMaxCarb() {
    return maxCarb;
  }

  public void setMaxCarb(double maxCarb) {
    this.maxCarb = maxCarb;
  }

  public double getMinProtein() {
    return minProtein;
  }

  public void setMinProtein(double minProtein) {
    this.minProtein = minProtein;
  }

  public double getMaxProtein() {
    return maxProtein;
  }

  public void setMaxProtein(double maxProtein) {
    this.maxProtein = maxProtein;
  }

  public double getMinFat() {
    return minFat;
  }

  public void setMinFat(double minFat) {
    this.minFat = minFat;
  }

  public double getMaxFat() {
    return maxFat;
  }

  public void setMaxFat(double maxFat) {
    this.maxFat = maxFat;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  public void setCreated(@NonNull Date created) {
    this.created = created;
  }
}
