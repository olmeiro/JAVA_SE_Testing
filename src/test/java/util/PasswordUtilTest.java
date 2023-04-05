package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static util.PasswordUtil.SecurityLevel.*;

class PasswordUtilTest {
    @Test
    public void weak_when_has_less_than_8_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("123aa!"));
    }

    @Test
    public void weak_when_has_less_only_letters() {
        assertEquals(WEAK, PasswordUtil.assessPassword("abcdefgh"));
    }

    @Test
    public void medium_when_has_letters_and_numbers() {
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abcdefgh1234"));
    }

    @Test
    public void strong_when_has_letters_and_numbers_and_symbols() {
        assertEquals(STRONG, PasswordUtil.assessPassword("abcdefgh!"));
    }
}