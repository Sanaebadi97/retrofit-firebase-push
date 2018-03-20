package rest;

import java.util.List;

import model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sanaebadi on 3/12/18.
 */

public interface ApiInterface {

  @GET("get-data.php")
  Call<List<Movie>> getMovies();
}
