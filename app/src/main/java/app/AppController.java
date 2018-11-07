package app;

import android.app.Application;

import ir.sanaebadi.retrofiteWithFirebase.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;



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
