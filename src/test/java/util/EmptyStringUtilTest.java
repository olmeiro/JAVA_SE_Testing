package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyStringUtilTest {

    @Test
    void str_is_not_empty() {
     assertEquals(false,EmptyStringUtil.isEmpty("Hola"));
    }

    @Test
    void str_is_empty() {
     assertEquals(true,EmptyStringUtil.isEmpty(""));
    }

    @Test
    void str_null_is_empty() {
        String str = null;
        assertTrue(EmptyStringUtil.isEmpty(str));
    }

    @Test
    void str_spaces_is_empty() {
        String str = "   ";
        assertTrue(EmptyStringUtil.isEmpty(str));
    }


}