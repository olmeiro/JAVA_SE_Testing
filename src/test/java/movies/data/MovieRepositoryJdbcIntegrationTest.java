package movies.data;

import movies.model.Genre;
import movies.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieRepositoryJdbcIntegrationTest {
    @Test
    void load_all_movies() throws SQLException {
        //conexion a BBDD
        DataSource dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "root", "root");

        //Para cargar el script SQL:
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource); //necesita un data source
        MovieRepositoryImplJdbc movieRepository = new MovieRepositoryImplJdbc(jdbcTemplate);

        Collection<Movie> moviesCollection = movieRepository.findAll();
        Collection<Movie> list=Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION) ,
                new Movie(2, "Memento", 113, Genre.THRILLER) ,
                new Movie(3, "Matrix", 136, Genre.ACTION)
        );

        assertEquals(moviesCollection,list);

    }
}