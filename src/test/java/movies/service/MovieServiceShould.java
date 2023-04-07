package movies.service;

import movies.data.MovieRepository;
import movies.model.Genre;
import movies.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

class MovieServiceShould {

    private MovieService movieService;

    @BeforeEach
    void setUp() {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        //simulacion:
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION, "Christopher Nolan"),
                        new Movie(2, "Memento", 113, Genre.THRILLER, "Christopher Nolan"),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY, "Peter Farrelly, Bobby Farrelly"),
                        new Movie(4, "Super 8", 112, Genre.THRILLER, "J. J. Abrams"),
                        new Movie(5, "Scream", 111, Genre.HORROR, "Wes Craven"),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY, "Chris Columbus, Raja Gosnell, Peter Hewitt, Rod Daniel"),
                        new Movie(7, "Matrix", 136, Genre.ACTION, "Hermanas Wachowski"),
                        new Movie(8, "Dark Knight Rises", 152, Genre.ACTION, "Christopher Nolan"),
                        new Movie(9, "The Matrix Reloaded", 136, Genre.ACTION, "Hermanas Wachowski"),
                        new Movie(10, "The Matrix Revolutions", 136, Genre.ACTION, "Hermanas Wachowski")
                )
        );

         movieService = new MovieService(movieRepository);
    }

    @Test
    void return_movies_by_genre() {

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);
        List<Integer> moviesIds = getMoviesId(movies);
        assertThat(moviesIds, is(Arrays.asList(3,6)));

    }

    private static List<Integer> getMoviesId(Collection<Movie> movies) {
        List<Integer> moviesIds = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
        return moviesIds;
    }

    @Test
    void return_movies_by_duration() {
        Collection<Movie> movies = movieService.findMoviesByDuration(119);

        //List<Integer> moviesIds = movies.stream().map(movie -> movie.getId()).collect(Collectors.toList());
        List<Integer> moviesIds = getMoviesId(movies);

        assertThat(moviesIds, is(Arrays.asList(2,3,4,5,6)));

    }
    @Test
    void return_movies_by_name() {
        Collection<Movie> movies = movieService.findByName("Memento");
        assertThat(getMoviesId(movies), is(Arrays.asList(2)));

    }
    @Test
    void return_movies_by_director() {
        Collection<Movie> movies = movieService.findMoviesByDirector("nolan");
        assertThat(getMoviesId(movies), is(Arrays.asList(1, 2, 8)));
    }

    // MARK
    @Test
    public void return_movies_by_action_genre_and_2_and_30_hours_lenght() {

        Collection<Movie> movies =
                movieService.findMoviesByTemplate(new Movie(null, 150, Genre.ACTION,null));
        assertThat(getMoviesIds(movies), is(Arrays.asList(7, 9, 10)) );
    }

    @Test
    public void return_movies_by_name_and_135_minutes_lenght() {

        Collection<Movie> movies =
                movieService.findMoviesByTemplate(new Movie("the", 135, null,null));
        assertThat(getMoviesIds(movies), is(Arrays.asList(3)) );
    }

    @Test
    public void return_movies_by_name_and_genre() {

        Collection<Movie> movies =
                movieService.findMoviesByTemplate(new Movie("the", null, Genre.COMEDY,null));
        assertThat(getMoviesIds(movies), is(Arrays.asList(3)) );
    }

    @Test
    public void return_movies_by_name_by_action_genre_and_2_and_45_hours_lenght() {

        Collection<Movie> movies =
                movieService.findMoviesByTemplate(new Movie("riseS", 165, Genre.ACTION,null));
        assertThat(getMoviesIds(movies), is(Arrays.asList(8)) );
    }

    @Test
    public void return_movies_by_director_and_2_and_30_hours_lenght() {

        Collection<Movie> movies =
                movieService.findMoviesByTemplate(new Movie(null, null, 150, null, "Nolan"));
        assertThat(getMoviesIds(movies), is(Arrays.asList(2)) );
    }

    @Test
    public void return_movies_by_director_and_name() {

        Collection<Movie> movies =
                movieService.findMoviesByTemplate(new Movie(null, "dark", null, null, "nolan"));
        assertThat(getMoviesIds(movies), is(Arrays.asList(1, 8)) );
    }

    @Test
    public void return_movies_by_director_and_thriller_genre() {

        Collection<Movie> movies =
                movieService.findMoviesByTemplate(new Movie(null, null, null, Genre.THRILLER, "NolaN"));
        assertThat(getMoviesIds(movies), is(Arrays.asList(2)) );
    }

    @Test
    public void return_movies_by_id_and_director() {

        Collection<Movie> movies =
                movieService.findMoviesByTemplate(new Movie(4, null, null, null, "abrams"));
        assertThat(getMoviesIds(movies), is(Arrays.asList(4)) );
    }

    @Test
    public void return_movies_by_id_and_2_and_30_hours_lenght() {

        Collection<Movie> movies =
                movieService.findMoviesByTemplate(new Movie(6, null, 150, null, null));
        assertThat(getMoviesIds(movies), is(Arrays.asList(6)) );
    }

    @Test
    public void negative_length() {

        Collection<Movie> movies =
                movieService.findMoviesByTemplate(new Movie(null, -150, null,null));
        assertThat(getMoviesIds(movies), is(Arrays.asList()) );
    }


    private List<Integer> getMoviesIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}