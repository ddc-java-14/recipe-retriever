package edu.cnm.deepdive.reciperetriever.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.reciperetriever.BuildConfig;
import edu.cnm.deepdive.reciperetriever.model.dto.ResultsContainer;
import edu.cnm.deepdive.reciperetriever.model.entity.Ingredient;
import edu.cnm.deepdive.reciperetriever.model.entity.Recipe;
import edu.cnm.deepdive.reciperetriever.model.entity.Recipe.CuisineType;
import io.reactivex.Single;
import java.util.List;
import kotlin.ParameterName;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 *
 */
public interface WebServiceProxy {

  /**
   *
   * @param cuisineType
   * @return
   */
  @POST("cuisine")
  Single<CuisineType> searchCuisine(@Body CuisineType cuisineType);

  /**
   *
   * @param apiKey
   * @param count
   * @param searchTerm
   * @return
   */
  @GET("complexSearch")
  Single<ResultsContainer> findRecipe(@Query("apiKey") String apiKey, @Query("number") int count, @Query("query") String searchTerm);

  default Single<ResultsContainer> findRecipe(String searchTerm, int count) {
    return findRecipe(BuildConfig.API_KEY, count, searchTerm);
  }
  /**
   *
   * @param ingredient
   * @param id
   * @return
   */
  @POST("{id}/information")
  List<Ingredient> findIngredients(@Body Ingredient ingredient, @Path("{recipeId}") long id );

  /**
   *
   * @param apiKey
   * @param value
   * @return
   */
  @GET("{id}/analyzedInstructions")
  List<Recipe> findRecipeSteps(@Query("apiKey") String apiKey, @Query("stepsBreakdown") Boolean value);

  static WebServiceProxy getInstance() {
    return InstanceHolder.INSTANCE;
  }

  class InstanceHolder {

    private static final WebServiceProxy INSTANCE;

    static {
      Gson gson = new GsonBuilder()
          .excludeFieldsWithoutExposeAnnotation()
          .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
          .create();
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(Level.BODY);
      OkHttpClient client = new Builder()
          .addInterceptor(interceptor)
          .build();
      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl("https://api.spoonacular.com/recipes/")
          .addConverterFactory(GsonConverterFactory.create(gson))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .client(client)
          .build();
      INSTANCE = retrofit.create(WebServiceProxy.class);
    }

  }

}
