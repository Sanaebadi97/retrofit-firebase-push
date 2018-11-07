package app;

import android.app.Application;

import ir.sanaebadi.retrofiteWithFirebase.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by sanaebadi on 3/13/18.
 */

public class AppController extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
      .setDefaultFontPath("fonts/arirdbd.TTF")
      .setFontAttrId(R.attr.fontPath)
      .build()
    );
  }
}
