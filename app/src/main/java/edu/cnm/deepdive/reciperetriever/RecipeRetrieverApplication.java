package edu.cnm.deepdive.reciperetriever;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.reciperetriever.service.RecipeRetrieverDatabase;
import io.reactivex.schedulers.Schedulers;

/**
 * Initializes (in the {@link #onCreate()} method) application-level resources. This class
 * <strong>must</strong> be referenced in {@code AndroidManifest.xml}, or it will not be loaded and
 * used by the Android system.
 */
public class RecipeRetrieverApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    RecipeRetrieverDatabase.setContext(this);
    RecipeRetrieverDatabase
        .getInstance()
        .getRecipeDao()
        .delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
  }

}
