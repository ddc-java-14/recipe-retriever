package edu.cnm.deepdive.reciperetriever.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.reciperetriever.service.RecipeRepository;
import java.util.List;

/**
 *
 */
public class FavoriteRecipesViewModel extends AndroidViewModel {

  private final RecipeRepository repository;

  /**
   *
   * @param application
   */
  public FavoriteRecipesViewModel(@NonNull Application application) {
    super(application);
    repository = new RecipeRepository(application);
  }

//
}
