package firebaseConfig;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import activity.MainActivity;
import ir.sanaebadi.retrofiteWithFirebase.R;

/**
 * Created by sanaebadi on 3/19/18.
 */

@SuppressLint("Registered")
public class MyFirebaseMessagingService extends FirebaseMessagingService {
  private static final String TAG = "MyFirebaseMessagingServ";

  @Override
  public void onMessageReceived(RemoteMessage remoteMessage) {
    Log.d(TAG, "onMessageReceived: " + remoteMessage.getFrom());

    //Check If The Message Contains Data

    if (remoteMessage.getData().size() > 0) {
      Log.d(TAG, "onMessageData: " + remoteMessage.getData());
    }

    //Check If The Message Contains Notification
    if (remoteMessage.getNotification() != null) {
      Log.d(TAG, "onMessageNotification: " + remoteMessage.getNotification().getBody());

      sendNotification(remoteMessage.getNotification().getBody());
    }

  }

  /**
   * Display The Notification
   *
   * @param body
   */
  private void sendNotification(String body) {

    Intent intent = new Intent(this, MainActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

    PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
      PendingIntent.FLAG_ONE_SHOT);

    //Set Sound Of Notification

    Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

    NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
      .setSmallIcon(R.drawable.firebase)
      .setContentTitle("Firebase Cloud Messaging")
      .setContentText(body)
      .setSound(notificationSound)
      .setContentIntent(pendingIntent);


    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    assert notificationManager != null;
    notificationManager.notify(0, builder.build());
  }
}
