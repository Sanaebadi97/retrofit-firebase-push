package firebaseConfig;

import android.annotation.SuppressLint;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by sanaebadi on 3/19/18.
 */

@SuppressLint("Registered")
public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
  private static final String TAG = "MyFirebaseInstanceIdSer";

  @Override
  public void onTokenRefresh() {

    //Get Updated Token

    String refreshedToken = FirebaseInstanceId.getInstance().getToken();
    Log.d(TAG, "onTokenRefresh: " + refreshedToken);

    //You Can Save The Token Into Third Party Server To Do AnyThing You Want


  }
}
