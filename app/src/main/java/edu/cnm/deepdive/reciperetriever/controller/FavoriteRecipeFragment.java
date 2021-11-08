package edu.cnm.deepdive.reciperetriever.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.reciperetriever.adapter.RecipeSummaryAdapter;
import edu.cnm.deepdive.reciperetriever.databinding.FragmentFavoriteRecipeBinding;
import edu.cnm.deepdive.reciperetriever.databinding.FragmentRecipeBinding;
import edu.cnm.deepdive.reciperetriever.model.view.RecipeSummary;
import edu.cnm.deepdive.reciperetriever.viewmodel.FavoriteRecipesViewModel;

public class FavoriteRecipeFragment extends Fragment {

  private FavoriteRecipesViewModel viewModel;
  private FragmentFavoriteRecipeBinding binding;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentFavoriteRecipeBinding.inflate(inflater, container, false);
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(this).get(FavoriteRecipesViewModel.class);
    viewModel
        .getRecipes()
        .observe(getViewLifecycleOwner(), (recipes) -> {
          RecipeSummaryAdapter adapter = new RecipeSummaryAdapter(getContext(), recipes);
          binding.recipes.setAdapter(adapter);
        });
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}
