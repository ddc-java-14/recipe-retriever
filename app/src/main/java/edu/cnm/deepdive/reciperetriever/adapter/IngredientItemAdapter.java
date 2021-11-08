package edu.cnm.deepdive.reciperetriever.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import edu.cnm.deepdive.reciperetriever.model.entity.Ingredient;
import java.util.List;

public class IngredientItemAdapter {

  private final Context context;
  private final LayoutInflater inflater;
  private final List<Ingredient> ingredients;

  public IngredientItemAdapter(Context context, List<Ingredient> ingredients) {
    this.context = context;
    this.ingredients = ingredients;
    inflater = LayoutInflater.from(context);
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(IngredientItemAdapter.inflate(inflater, parent, false));
  }

  private static IngredientBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean b) {
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);
  }

  class Holder extends ViewHolder {

    private final IngredientBinding binding;

    public Holder(@NonNull IngredientBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    private void bind(int position) {
      Ingredient ingredient = ingredients.get(position);
      binding.text.setText(ingredient.getText());
    }

  }

}
