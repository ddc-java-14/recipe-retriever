package edu.cnm.deepdive.reciperetriever.controller;

import android.os.Bundle;
import androidx.preference.PreferenceFragmentCompat;
import edu.cnm.deepdive.reciperetriever.R;

/**
 *
 */
public class SettingsFragment extends PreferenceFragmentCompat {


  @Override
  public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
    setPreferencesFromResource(R.xml.settings, rootKey);
  }
}
