package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringUtilTest {
    @Test
    public void repeat_string_once() {
        assertEquals("hola", StringUtil.repeat("hola",1));
    }

    @Test
    public void repeat_string_multiple_times() {
        assertEquals("holaholahola", StringUtil.repeat("hola",3));
    }
    @Test
    public void repeat_string_zero_times() {
        assertEquals("", StringUtil.repeat("hola",0));
    }
    @Test
    public void repeat_negative_times1() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtil.repeat("hola", -1);
        });
    }

    @Test()
    public void repeat_negative_times2(){
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            StringUtil.repeat("Hola", -1);
        });

        Assertions.assertEquals("Argument times negative", exception.getMessage());
    }
}