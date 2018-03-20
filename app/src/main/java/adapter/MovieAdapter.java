package adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import activity.DetailsActivity;
import ir.sanaebadi.retrofiteWithFirebase.R;
import model.Movie;

/**
 * Created by sanaebadi on 3/9/18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

  private static final String TAG = "MovieAdapter";
  private Context context;
  private List<Movie> movies;

  public MovieAdapter(Context context, List<Movie> movies) {
    this.context = context;
    this.movies = movies;
  }

  @NonNull
  @Override
  public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.row_list, parent, false);

    return new MovieViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

    final Movie movie = movies.get(position);

    Glide.with(context).load(movie.getImageUrl())
      .diskCacheStrategy(DiskCacheStrategy.ALL)
      .crossFade()
      .into(holder.img_photo);

    holder.txt_bio.setText(movie.getBio());

    holder.txt_name.setText(movie.getName());
    holder.txt_first_app.setText("Year No : " + movie.getFirstAppearance());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent intent = new Intent(context, DetailsActivity.class);

        intent.putExtra("PHOTO", movie.getImageUrl());
        intent.putExtra("NAME", movie.getName());
        intent.putExtra("BIO", movie.getBio());
        intent.putExtra("REAL_NAME", movie.getRealName());
        intent.putExtra("CREATED_BY", movie.getCreatedBy());
        intent.putExtra("PUBLISHER", movie.getPublisher());
        intent.putExtra("FIRST_APP", movie.getFirstAppearance());
        intent.putExtra("TEAM", movie.getTeam());

        context.startActivity(intent);
      }
    });


  }

  @Override
  public int getItemCount() {
    try {
      return movies.size();
    } catch (Exception e) {
      return 0;
    }
  }

  public class MovieViewHolder extends RecyclerView.ViewHolder {

    private ImageView img_photo;
    private TextView txt_name, txt_bio, txt_first_app;

    public MovieViewHolder(View itemView) {
      super(itemView);

      img_photo = itemView.findViewById(R.id.img_photo);
      txt_bio = itemView.findViewById(R.id.txt_bio);
      txt_name = itemView.findViewById(R.id.txt_name);
      txt_first_app = itemView.findViewById(R.id.txt_first_app);


    }
  }
}
