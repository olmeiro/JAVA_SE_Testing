package movies.data;

import movies.model.Genre;
import movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class MovieRepositoryImplJdbc implements MovieRepository {

    private JdbcTemplate jdbcTemplate;

    public MovieRepositoryImplJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        //args:
        Object[] args = { id };
        return jdbcTemplate.queryForObject("select * from movies where id = ?", args, movieMapper);
    }

    @Override
    public Movie findByNameMovie(String name) {
        //args:
        Object[] args = { name };
        return jdbcTemplate.queryForObject("select * from movies where name = ?", args, movieMapper);
    }

    @Override
    public Movie findByNameDirector(String name) {
        //args:
        Object[] args = { name };
        return jdbcTemplate.queryForObject("select * from movies where director = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("select * from movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("insert into movies (name, minutes, genre) values(?,?,?)",movie.getName(), movie.getMinutes(), movie.getGenre().toString(), movie.getDirector());
    }

    private static RowMapper<Movie> movieMapper = new RowMapper<Movie>() {
        @Override
        public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
            return new Movie(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("minutes"),
                    Genre.valueOf(resultSet.getString("genre")),
                    resultSet.getString("director"));
        }
    };
}
