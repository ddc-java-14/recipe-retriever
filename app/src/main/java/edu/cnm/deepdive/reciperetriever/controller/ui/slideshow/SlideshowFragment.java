package edu.cnm.deepdive.reciperetriever.controller.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.reciperetriever.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

  private edu.cnm.deepdive.codebreaker.controller.ui.slideshow.SlideshowViewModel slideshowViewModel;
  private FragmentSlideshowBinding binding;

  public View onCreateView(@NonNull LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {
    slideshowViewModel =
        new ViewModelProvider(this).get(
            edu.cnm.deepdive.codebreaker.controller.ui.slideshow.SlideshowViewModel.class);

    binding = FragmentSlideshowBinding.inflate(inflater, container, false);
    View root = binding.getRoot();

    final TextView textView = binding.textSlideshow;
    slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
      @Override
      public void onChanged(@Nullable String s) {
        textView.setText(s);
      }
    });
    return root;
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }
}