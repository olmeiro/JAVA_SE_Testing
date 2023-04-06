package movies.service;

import movies.data.MovieRepository;
import movies.model.Genre;
import movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByDuration(int duration) {
        return movieRepository.findAll().stream().filter(movie -> movie.getMinutes() <= duration).collect(Collectors.toList());
    }

    public Collection<Movie> findByName(String name) {
        String nameMovie = name.toLowerCase();
        return movieRepository.findAll().stream().filter(movie -> movie.getName().toLowerCase().contains(nameMovie)).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByDirector(String director) {
        return movieRepository.findAll().stream().filter(movie -> movie.getDirector().toLowerCase().contains((director))).collect(Collectors.toList());
    }
}
