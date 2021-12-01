package edu.cnm.deepdive.reciperetriever.viewmodel;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.Transformations;
import androidx.preference.PreferenceManager;
import edu.cnm.deepdive.reciperetriever.R;
import edu.cnm.deepdive.reciperetriever.model.dto.ResultsContainer.Result;
import edu.cnm.deepdive.reciperetriever.model.entity.Recipe;
import edu.cnm.deepdive.reciperetriever.controller.RecipeFragment;
import edu.cnm.deepdive.reciperetriever.model.pojo.RecipeWithIngredients;
import edu.cnm.deepdive.reciperetriever.service.RecipeRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

/**
 * Controls the user interface data of the {@link RecipeFragment} of the application.
 */
public class RecipeViewModel extends AndroidViewModel implements LifecycleObserver {

  private final RecipeRepository repository;
  private final LiveData<RecipeWithIngredients> recipe;
  private final MutableLiveData<Long> recipeId;
  private final MutableLiveData<List<Result>> searchResults;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;
  private final SharedPreferences preferences;
  private final String recipePrefKey;
  private final int recipePrefDefault;

  /**
   * Creates an instance of the fields in this class.
   * @param application instance of the {@link RecipeViewModel} class
   */
  public RecipeViewModel(@NonNull Application application) {
    super(application);
    repository = new RecipeRepository(application);
    recipeId = new MutableLiveData<>();
    recipe = Transformations.switchMap(recipeId, repository::getRecipe);
    searchResults = new MutableLiveData<>();
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
    preferences = PreferenceManager.getDefaultSharedPreferences(application);
    Resources resources = application.getResources();
    recipePrefKey = resources.getString(R.string.recipe_pref_key);
    recipePrefDefault = resources.getInteger(R.integer.recipe_pref_default);
  }

  /**
   * gets a single {@link LiveData} of a recipe with ingredients attached.
   * @return {@link LiveData} of the {@link RecipeWithIngredients} pojo.
   */
  public LiveData<RecipeWithIngredients> getRecipe() {
    return recipe;
  }

  /**
   * gets a {@link List} of the {@link LiveData} for recipes.
   * @return {@link List} of {@link LiveData} for a {@link Recipe}.
   */
  public LiveData<List<Recipe>> getRecipes() {
    return repository.getAll();
  }

  /**
   *
   * @param id
   */
  public void setRecipeId(long id) {
    recipeId.setValue(id);
  }

  /**
   *
   * @return
   */
  public LiveData<List<Result>> getSearchResults() {
    return searchResults;
  }

  /**
   *
   * @return
   */
  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  /**
   *
   * @param searchTerm
   */
  public void startSearch(String searchTerm) {
    throwable.postValue(null);
    // TODO invoke and subscribe to results of repository.recipeRepository.search.findRecipe
    pending.add(
        repository
            .search(searchTerm, preferences.getInt(recipePrefKey, recipePrefDefault))
            .subscribe(
                searchResults::postValue,
                this::postThrowable
            )
    );
  }

  /**
   * saves a {@link Recipe}.
   * @param recipe a {@link Recipe} with ingredients attached.
   */
  public void save(RecipeWithIngredients recipe) {
    pending.add(
        repository
            .save(recipe)
            .subscribe(
                (savedRecipe) -> {},
                this::postThrowable
            )
    );
  }

  private void postThrowable(Throwable throwable) {
    Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable);
    this.throwable.postValue(throwable);
  }

  @OnLifecycleEvent(Event.ON_STOP)
  private void clearPending() {
    pending.clear();
  }
}
