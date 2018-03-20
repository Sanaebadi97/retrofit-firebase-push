package activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import adapter.MovieAdapter;
import ir.sanaebadi.retrofiteWithFirebase.R;
import model.Movie;
import rest.ApiClient;
import rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {
  private static final String TAG = "MainActivity";

  private ApiInterface apiInterface;
  private Call<List<Movie>> movieCall;
  private RecyclerView movie_list;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getMovie();

    movie_list = findViewById(R.id.movie_list);

    movie_list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
      false));
    movie_list.setHasFixedSize(true);
    movie_list.setItemAnimator(new DefaultItemAnimator());

  }

  private void getMovie() {

    apiInterface = ApiClient.createApi();
    movieCall = apiInterface.getMovies();

    movieCall.enqueue(new Callback<List<Movie>>() {
      @Override
      public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
        showDialog();

        List<Movie> movies = response.body();

        MovieAdapter movieAdapter = new MovieAdapter(MainActivity.this,
          movies);

        hideDialog();
        movie_list.setAdapter(movieAdapter);
      }

      @Override
      public void onFailure(Call<List<Movie>> call, Throwable t) {

        hideDialog();
        Log.e(TAG, "onFailure: " + t.getMessage());
        Toast.makeText(MainActivity.this, "onFailure: " + t.getMessage(), Toast.LENGTH_SHORT).show();
      }
    });
  }
}
