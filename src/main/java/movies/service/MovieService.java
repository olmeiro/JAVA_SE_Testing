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

    public Collection<Movie> findMoviesByTemplate(Movie template) {

        Collection<Movie> movies = movieRepository.findAll();

        if ( template.getId() == null) {
            movies = templateFilter(template, movies);
        } else {
            movies = movies.stream().filter(movie -> movie.getId() == template.getId()).collect(Collectors.toList());
        }

        return movies;
    }

    private Collection<Movie> templateFilter(Movie template, Collection<Movie> movies) {
        if ( template.getName() != null) {
            movies = movies.stream().filter(movie -> movie.getName().toLowerCase().contains(template.getName().toLowerCase())).collect(Collectors.toList());
        }

        if (template.getDirector() != null) {
            movies = movies.stream().filter(movie -> movie.getDirector().toLowerCase().contains(template.getDirector().toLowerCase())).collect(Collectors.toList());
        }

        if (template.getMinutes() != null) {
            movies = movies.stream().filter(movie -> movie.getMinutes() <= template.getMinutes()).collect(Collectors.toList());
        }

        if (template.getGenre() != null) {
            movies = movies.stream().filter(movie -> movie.getGenre() == template.getGenre()).collect(Collectors.toList());
        }
        return movies;
    }
}
