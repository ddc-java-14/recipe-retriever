package edu.cnm.deepdive.reciperetriever.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.reciperetriever.adapter.IngredientItemAdapter.Holder;
import edu.cnm.deepdive.reciperetriever.model.view.RecipeSummary;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.List;

public class RecipeSummaryAdapter extends RecyclerView.Adapter<Holder> {

  private final LayoutInflater inflater;
  private final DateFormat dateFormat;
  private final NumberFormat numberFormat;
  private final List<RecipeSummary> recipes;

  public RecipeSummaryAdapter(Context context, List<RecipeSummary> recipes) {
    inflater = LayoutInflater.from(context);
    dateFormat = android.text.format.DateFormat.getDateFormat(context);
    numberFormat = NumberFormat.getIntegerInstance();
    this.recipes = recipes;
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(ItemRecipeSummaryBinding.inflate(inflater, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position)
  }

  @Override
  public int getItemCount() {
    return recipes.size();
  }

  class Holder extends RecyclerView.ViewHolder{

    private final ItemRecipeSummaryBinding binding;

    private Holder(@NonNull ItemRecipeSummaryBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    private void bind(int position)
  }


}
