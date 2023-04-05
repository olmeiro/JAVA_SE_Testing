package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringUtilTest {
    @Test
    public void testRepeat() {
        assertEquals("holahola", StringUtil.repeat("hola",3));
        assertEquals(StringUtil.repeat("hola",1), "hola");
    }
}