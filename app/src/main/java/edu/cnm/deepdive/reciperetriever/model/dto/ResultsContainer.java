package edu.cnm.deepdive.reciperetriever.model.dto;

import androidx.annotation.NonNull;
import com.google.gson.annotations.Expose;
import java.util.LinkedList;
import java.util.List;

public class ResultsContainer {

  @Expose
  private List<Result> results = new LinkedList<>();

  public List<Result> getResults() {
    return results;
  }

  public void setResults(
      List<Result> results) {
    this.results = results;
  }

  public static class Result {

    @Expose
    private int id;

    @Expose
    private String title;

    @Expose
    private String image;

    @Expose
    private String imageType;

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public String getImage() {
      return image;
    }

    public void setImage(String image) {
      this.image = image;
    }

    public String getImageType() {
      return imageType;
    }

    public void setImageType(String imageType) {
      this.imageType = imageType;
    }

    @NonNull
    @Override
    public String toString() {
      return title;
    }
  }

}
