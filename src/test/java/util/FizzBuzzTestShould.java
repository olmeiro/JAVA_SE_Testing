package util;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class FizzBuzzTestShould {
    @Test
    public void return_Fizz_when_n_is_divided_by_3() {
        assertThat(FizzBuzz.fizzBuzz(3), is("Fizz"));
    }

    @Test
    public void return_Buzz_when_n_is_divided_by_5() {
        assertThat(FizzBuzz.fizzBuzz(5), is("Buzz"));
    }

    @Test
    public void return_Buzz_when_n_is_divided_by_3_and_5() {
        assertThat(FizzBuzz.fizzBuzz(15), is("FizzBuzz"));
    }

    @Test
    public void return_n_when_n_not_divisible_by_three_and_five() {
        assertThat(FizzBuzz.fizzBuzz(2), is("2"));
    }
}