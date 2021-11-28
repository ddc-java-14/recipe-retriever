package edu.cnm.deepdive.reciperetriever.viewmodel;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.Transformations;
import edu.cnm.deepdive.reciperetriever.model.entity.Recipe;
import edu.cnm.deepdive.reciperetriever.model.pojo.RecipeWithIngredients;
import edu.cnm.deepdive.reciperetriever.service.RecipeRepository;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

public class RecipeViewModel extends AndroidViewModel implements LifecycleObserver {

  private final RecipeRepository repository;
  private final LiveData<RecipeWithIngredients> recipe;
  private final MutableLiveData<Long> recipeId;
  private final MutableLiveData<Throwable> throwable;
  private final CompositeDisposable pending;

  public RecipeViewModel(@NonNull Application application) {
    super(application);
    repository = new RecipeRepository();
    recipeId = new MutableLiveData<>();
    recipe = Transformations.switchMap(recipeId, repository::getRecipe);
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
    startSearch();
  }

  public LiveData<RecipeWithIngredients> getRecipe() {
    return recipe;
  }

  public LiveData<List<Recipe>> getRecipes() {
    return repository.getAll();
  }

  public void setRecipeId(long id) {
    recipeId.setValue(id);
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public void startSearch() {
    throwable.postValue(null);
    Recipe recipe = new Recipe();
  }

  public void save(Recipe recipe) {
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
