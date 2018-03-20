package activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by sanaebadi on 3/13/18.
 */

public abstract class BaseActivity extends AppCompatActivity {

  private ProgressDialog dialog;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    dialog = new ProgressDialog(this);
    dialog.setMessage("loading ...");
  }

  public void showDialog() {
    if (!dialog.isShowing()) {
      dialog.show();
    }

  }

  public void hideDialog() {
    if (dialog.isShowing()) {
      dialog.cancel();
    }
  }

  @Override
  protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
  }
}
