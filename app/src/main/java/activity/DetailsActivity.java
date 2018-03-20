package activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import ir.sanaebadi.retrofiteWithFirebase.R;


/**
 * Created by sanaebadi on 3/13/18.
 */

public class DetailsActivity extends BaseActivity {

  private TextView txt_real_name, txt_team, txt_bio, txt_created_by, txt_publisher;
  private ImageView img_photo;
  private String imageUrl;
  private String realName;
  private String team;
  private String bio;
  private String createdBy;
  private String publisher;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.details_layout);

    img_photo = findViewById(R.id.img_photo);

    txt_real_name = findViewById(R.id.txt_real_name);
    txt_team = findViewById(R.id.txt_team);
    txt_bio = findViewById(R.id.txt_bio);
    txt_created_by = findViewById(R.id.txt_created_by);
    txt_publisher = findViewById(R.id.txt_publisher);

    Intent intent = getIntent();

    imageUrl = intent.getStringExtra("PHOTO");
    realName = intent.getStringExtra("REAL_NAME");
    team = intent.getStringExtra("TEAM");
    bio = intent.getStringExtra("BIO");
    createdBy = intent.getStringExtra("CREATED_BY");
    publisher = intent.getStringExtra("PUBLISHER");


    Glide.with(this).load(imageUrl)
      .diskCacheStrategy(DiskCacheStrategy.ALL)
      .crossFade()
      .into(img_photo);

    txt_real_name.setText(realName);
    txt_team.setText(team);
    txt_bio.setText(bio);
    txt_created_by.setText("Created By : " + createdBy);
    txt_publisher.setText("Published By : " + publisher);


  }


}
