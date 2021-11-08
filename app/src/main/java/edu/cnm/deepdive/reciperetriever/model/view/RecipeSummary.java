package edu.cnm.deepdive.reciperetriever.model.view;

import androidx.room.ColumnInfo;
import androidx.room.DatabaseView;
import edu.cnm.deepdive.reciperetriever.model.entity.Recipe;
 TODO EDIT BELOW.
@DatabaseView( value = RecipeSummary viewName = "recipe_summary")
public class RecipeSummary extends Recipe {

//  TODO fix Query and add fields if needed.

//  @ColumnInfo(name = "guess_count")
//  private int guessCount;
//
//  @ColumnInfo(name = "total_time")
//  private long totalTime;
//
//  public int getGuessCount() {
//    return guessCount;
//  }
//
//  public void setGuessCount(int guessCount) {
//    this.guessCount = guessCount;
//  }
//
  public long getTotalTime() {
    return totalTime;
  }

  public void setTotalTime(long totalTime) {
    this.totalTime = totalTime;
  }

}
