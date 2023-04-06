package movies.data;

import movies.model.Genre;
import movies.model.Movie;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieRepositoryJdbcIntegrationTest {
    private JdbcTemplate jdbcTemplate;
    private DriverManagerDataSource dataSource;

    @BeforeEach
    void setUp() throws SQLException {
        //conexion a BBDD
         dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "root", "root");

        //Para cargar el script SQL:
        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));


         jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Test
    public void load_all_movies() throws SQLException {
        MovieRepositoryImplJdbc movieRepository = new MovieRepositoryImplJdbc(jdbcTemplate);

        Collection<Movie> moviesCollection = movieRepository.findAll();
        Collection<Movie> list=Arrays.asList(
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
        );

        assertEquals(moviesCollection,list);
    }

    @Test
    public void load_movie_by_id() {
        MovieRepositoryImplJdbc movieRepository = new MovieRepositoryImplJdbc(jdbcTemplate);

        Movie movie = movieRepository.findById(2);

        assertThat(movie, is(new Movie(2, "Memento", 113, Genre.THRILLER, "Christopher Nolan")));
    }

    @Test
    void insert_a_movie() {
        MovieRepositoryImplJdbc movieRepository = new MovieRepositoryImplJdbc(jdbcTemplate);

        Movie movie = new Movie("Super 8", 112, Genre.THRILLER,"Christopher Nolan");
        movieRepository.saveOrUpdate(movie);

        Movie movieLoaded = movieRepository.findById(4); //el próximo id generado

        assertThat(movieLoaded, is(new Movie(4,"Super 8", 112, Genre.THRILLER, "J. J. Abrams")));
    }

    //reiniciamos la BBDD con una notación:
    @AfterEach
    public void tearDown() throws Exception {
        //ejecutamos sentencia que borra datos de la BBDD
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files"); //shutdown is also enough for mem db.
    }
}