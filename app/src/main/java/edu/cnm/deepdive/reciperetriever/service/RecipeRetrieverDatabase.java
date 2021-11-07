package edu.cnm.deepdive.reciperetriever.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.reciperetriever.model.dao.IngredientDao;
import edu.cnm.deepdive.reciperetriever.model.dao.RecipeDao;
import edu.cnm.deepdive.reciperetriever.model.entity.Ingredient;
import edu.cnm.deepdive.reciperetriever.model.entity.Recipe;
import edu.cnm.deepdive.reciperetriever.model.view.RecipeSummary;
import edu.cnm.deepdive.reciperetriever.service.RecipeRetrieverDatabase.Converters;
import java.util.Date;

@Database(
    entities = {Recipe.class, Ingredient.class},
    views = {RecipeSummary.class},
    version = 1,
    exportSchema = true
)
@TypeConverters({Converters.class, Recipe.CuisineType.class})
public abstract class RecipeRetrieverDatabase extends RoomDatabase {

  private static Application context;

  public static void setContext(Application context) {
    RecipeRetrieverDatabase.context = context;
  }

  public static RecipeRetrieverDatabase getInstance() {

    return InstanceHolder.INSTANCE;
  }

  public abstract RecipeDao getRecipeDao();

  public abstract IngredientDao getIngredientDao();

  private static  class InstanceHolder {

    private static final RecipeRetrieverDatabase INSTANCE =
        Room.databaseBuilder(context, RecipeRetrieverDatabase.class, "recipeRetriever-db")
            .build();
  }

  public static class Converters {

    @TypeConverter
    public static Long dateToLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date longToDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }



  }

}
