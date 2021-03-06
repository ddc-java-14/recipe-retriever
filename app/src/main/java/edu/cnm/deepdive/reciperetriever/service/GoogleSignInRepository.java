package edu.cnm.deepdive.reciperetriever.service;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import edu.cnm.deepdive.reciperetriever.BuildConfig;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

/**
 *
 */
public class GoogleSignInRepository {

  private static final String BEARER_TOKEN_FORMAT = "Bearer %s";

  private static Application context;

  private final GoogleSignInClient client;


  private GoogleSignInRepository() {
    GoogleSignInOptions options = new GoogleSignInOptions.Builder()
        .requestEmail()
        .requestId()
        .requestProfile()
//        .requestIdToken(BuildConfig.CLIENT_ID)
        .build();
    client = GoogleSignIn.getClient(context, options);
  }

  /**
   *
   * @param context
   */
  public static void setContext(Application context) {
    GoogleSignInRepository.context = context;
  }

  /**
   *
   * @return
   */
  public static GoogleSignInRepository getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   *
   * @return
   */
  public Single<GoogleSignInAccount> refresh() {
    return Single
        .create((SingleOnSubscribe<GoogleSignInAccount>) (emitter) ->
                client
                    .silentSignIn()
//                .addOnSuccessListener(this::logAccount)
                    .addOnSuccessListener(emitter::onSuccess)
                    .addOnFailureListener(emitter::onError)
        )
        .observeOn(Schedulers.io());
  }

  /**
   *
   * @return
   */
  public Single<String> refreshBearerToken() {
    return refresh()
        .map(this::getBearerToken);
  }

  /**
   *
   * @param launcher
   */
  public void startSignIn(ActivityResultLauncher<Intent> launcher) {
    launcher.launch(client.getSignInIntent());
  }

  /**
   *
   * @param result
   * @return
   */
  public Single<GoogleSignInAccount> completeSignIn(ActivityResult result) {
    return Single
        .create((SingleOnSubscribe<GoogleSignInAccount>) (emitter) -> {
          try {
            Task<GoogleSignInAccount> task =
                GoogleSignIn.getSignedInAccountFromIntent(result.getData());
            GoogleSignInAccount account = task.getResult(ApiException.class);
//            logAccount(account);
            emitter.onSuccess(account);
          } catch (ApiException e) {
            emitter.onError(e);
          }
        })
        .observeOn(Schedulers.io());
  }

  /**
   *
   * @return
   */
  public Completable signOut() {
    return Completable
        .create((emitter) ->
                client
                    .signOut()
                    .addOnSuccessListener((ignored) -> emitter.onComplete())
//                .addOnCompleteListener((ignored) -> logAccount(null))
                    .addOnFailureListener(emitter :: onError)

        )
        .subscribeOn(Schedulers.io());
  }

  private void logAccount(GoogleSignInAccount account) {
    if (account != null) {
      Log.d(getClass().getSimpleName(),
          (account.getIdToken() != null) ? getBearerToken(account) : "(none)");
    }
  }

  private String getBearerToken(GoogleSignInAccount account) {
    return String.format(BEARER_TOKEN_FORMAT, account.getIdToken());
  }

  private static class InstanceHolder {

    private static final GoogleSignInRepository INSTANCE = new GoogleSignInRepository();
  }

}
