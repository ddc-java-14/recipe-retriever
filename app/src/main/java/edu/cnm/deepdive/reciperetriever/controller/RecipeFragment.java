package edu.cnm.deepdive.reciperetriever.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.snackbar.Snackbar;
import edu.cnm.deepdive.reciperetriever.R;
import edu.cnm.deepdive.reciperetriever.databinding.FragmentRecipeBinding;
import edu.cnm.deepdive.reciperetriever.viewmodel.RecipeViewModel;

public class RecipeFragment extends Fragment {

  private RecipeViewModel viewModel;
  private FragmentRecipeBinding binding;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
//    setHasOptionsMenu(true);
  }

  public View onCreateView(
      @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    binding = FragmentRecipeBinding.inflate(inflater, container, false);
    binding.search.setOnClickListener((v) -> { /* TODO submitSearch to viewModel */ });
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    //noinspection ConstantConditions
    viewModel = new ViewModelProvider(getActivity()).get(RecipeViewModel.class);
    getLifecycle().addObserver(viewModel);
    viewModel.getThrowable().observe(getViewLifecycleOwner(), this::displayError);
//    viewModel.getRecipe().observe(getViewLifecycleOwner(), this::update);
  }

  @Override
  public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    inflater.inflate(R.menu.recipe_actions, menu);
  }

  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    boolean handled;
    if (item.getItemId() == R.id.new_recipe_search) {
      handled = true;
      viewModel.getRecipe();
    } else {
      handled = super.onOptionsItemSelected(item);
    }
    return handled;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

//  TODO create a search recipe method.

//  TODO create update method for recipe.

//  TODO create update search method.

//  TODO update controls. want to create a recipe.isRecipe boolean to determine if the id is a recipe and
//  to display the ingredients, picture, instructions, and etc when it's a match.



  private void displayError(Throwable throwable) {
    if (throwable != null) {
      Snackbar snackbar = Snackbar.make(binding.getRoot(),
          getString(R.string.play_error_message, throwable.getMessage()),
          Snackbar.LENGTH_INDEFINITE);
      snackbar.setAction(R.string.error_dismiss, (v) -> snackbar.dismiss());
      snackbar.show();
    }
  }




}
