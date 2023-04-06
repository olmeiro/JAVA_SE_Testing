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
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Marty", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(7, "Matrix", 136, Genre.ACTION)
                )
        );

         movieService = new MovieService(movieRepository);
    }

    @Test
    void return_movies_by_genre() {
        //MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        ////simulacion:
        //Mockito.when(movieRepository.findAll()).thenReturn(
        //Arrays.asList(
        //new Movie(1, "Dark Knight", 152, Genre.ACTION),
        //new Movie(2, "Memento", 113, Genre.THRILLER),
        //new Movie(3, "There's Something About Marty", 119, Genre.COMEDY),
        // new Movie(4, "Super 8", 112, Genre.THRILLER),
        // new Movie(5, "Scream", 111, Genre.HORROR),
        // new Movie(6, "Home Alone", 103, Genre.COMEDY),
        // new Movie(7, "Matrix", 136, Genre.ACTION)
        // )
        //);
        //MovieService movieService = new MovieService(movieRepository);

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        //Validación por ids:
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
}