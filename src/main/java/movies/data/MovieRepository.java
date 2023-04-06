package movies.data;

import movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {
    Movie findById(long id);

    Movie findByNameMovie(String name);

    Movie findByNameDirector(String name);

    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
}
