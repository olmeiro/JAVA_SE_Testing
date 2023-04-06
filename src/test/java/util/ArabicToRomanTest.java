package util;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ArabicToRomanTestShould {
    /**
     * arabicToRoman(1) => "I"
     * arabicToRoman(2) => "II"
     * arabicToRoman(3) => "III"
     * <p>
     * arabicToRoman(5) => "V"
     * arabicToRoman(6) => "VI"
     * arabicToRoman(7) => "VII"
     * <p>
     * arabicToRoman(10) => "X"
     * arabicToRoman(11) => "XI"
     * arabicToRoman(15) => "XV"
     * arabicToRoman(16) => "XVI"
     * <p>
     * arabicToRoman(50) => "L"
     * arabicToRoman(51) => "LI"
     * arabicToRoman(55) => "LV"
     * arabicToRoman(56) => "LVI"
     * arabicToRoman(60) => "LX"
     * arabicToRoman(70) => "LXX"
     * <p>
     * arabicToRoman(80) => "LXXX"
     * arabicToRoman(81) => "LXXXI"
     * arabicToRoman(85) => "LXXXV"
     * arabicToRoman(86) => "LXXXVI"
     * <p>
     * arabicToRoman(126) => "CXXVI"
     * <p>
     * arabicToRoman(2507) => "MMDVII"
     */


    @Test
    public void roman_numbers_when_1_2_3() {

        assertThat(ArabicToRoman.arabicToRoman(1), is("I"));
        assertThat(ArabicToRoman.arabicToRoman(2), is("II"));
        assertThat(ArabicToRoman.arabicToRoman(3), is("III"));
    }

    @Test
    public void roman_numbers_when_5_6_7() {
        assertThat(ArabicToRoman.arabicToRoman(5), CoreMatchers.is("V"));
        assertThat(ArabicToRoman.arabicToRoman(6), CoreMatchers.is("VI"));
        assertThat(ArabicToRoman.arabicToRoman(7), CoreMatchers.is("VII"));
    }

    @Test
    public void roman_numbers_when_10_11_15_16() {
        assertThat(ArabicToRoman.arabicToRoman(10), CoreMatchers.is("X"));
        assertThat(ArabicToRoman.arabicToRoman(11), CoreMatchers.is("XI"));
        assertThat(ArabicToRoman.arabicToRoman(15), CoreMatchers.is("XV"));
        assertThat(ArabicToRoman.arabicToRoman(16), CoreMatchers.is("XVI"));
    }

    @Test
    public void roman_numbers_when_50_51_55_56() {
        assertThat(ArabicToRoman.arabicToRoman(50), CoreMatchers.is("L"));
        assertThat(ArabicToRoman.arabicToRoman(51), CoreMatchers.is("LI"));
        assertThat(ArabicToRoman.arabicToRoman(55), CoreMatchers.is("LV"));
        assertThat(ArabicToRoman.arabicToRoman(56), CoreMatchers.is("LVI"));
    }

    @Test
    public void roman_numbers_when_60_70() {
        assertThat(ArabicToRoman.arabicToRoman(60), CoreMatchers.is("LX"));
        assertThat(ArabicToRoman.arabicToRoman(70), CoreMatchers.is("LXX"));
    }

    @Test
    public void roman_numbers_when_80_81_85_86() {
        assertThat(ArabicToRoman.arabicToRoman(80), CoreMatchers.is("LXXX"));
        assertThat(ArabicToRoman.arabicToRoman(81), CoreMatchers.is("LXXXI"));
        assertThat(ArabicToRoman.arabicToRoman(85), CoreMatchers.is("LXXXV"));
        assertThat(ArabicToRoman.arabicToRoman(86), CoreMatchers.is("LXXXVI"));
    }

    @Test
    public void roman_numbers_when_126() {
        assertThat(ArabicToRoman.arabicToRoman(126), CoreMatchers.is("CXXVI"));
    }

    @Test
    public void roman_numbers_when_2507() {
        assertThat(ArabicToRoman.arabicToRoman(2507), CoreMatchers.is("MMDVII"));
    }

    /**
     * arabicToRoman(4) => "IV"
     * arabicToRoman(14) => "XIV"
     * arabicToRoman(24) => "XXIV"
     * <p>
     * arabicToRoman(40) => "XL"
     * arabicToRoman(44) => "XLIV"
     * <p>
     * arabicToRoman(400) => "CD"
     * <p>
     * arabicToRoman(9) => "IX"
     * arabicToRoman(19) => "XIX"
     * arabicToRoman(49) => "XLIX"
     * <p>
     * arabicToRoman(90) => "XC"
     * arabicToRoman(99) => "XCIX"
     * <p>
     * arabicToRoman(900) => "CM"
     */

    @Test
    public void roman_numbers_when_4_14_24() {
        assertThat(ArabicToRoman.arabicToRoman(4), CoreMatchers.is("IV"));
        assertThat(ArabicToRoman.arabicToRoman(14), CoreMatchers.is("XIV"));
        assertThat(ArabicToRoman.arabicToRoman(24), CoreMatchers.is("XXIV"));
    }

    @Test
    public void roman_numbers_when_40() {
        assertThat(ArabicToRoman.arabicToRoman(40), CoreMatchers.is("XL"));
        assertThat(ArabicToRoman.arabicToRoman(44), CoreMatchers.is("XLIV"));
    }

    @Test
    public void roman_numbers_when_400() {
        assertThat(ArabicToRoman.arabicToRoman(400), CoreMatchers.is("CD"));
    }

    @Test
    public void roman_numbers_when_9_19_49() {
        assertThat(ArabicToRoman.arabicToRoman(9), CoreMatchers.is("IX"));
        assertThat(ArabicToRoman.arabicToRoman(19), CoreMatchers.is("XIX"));
        assertThat(ArabicToRoman.arabicToRoman(49), CoreMatchers.is("XLIX"));
    }

    @Test
    public void roman_numbers_when_90_99() {
        assertThat(ArabicToRoman.arabicToRoman(90), CoreMatchers.is("XC"));
        assertThat(ArabicToRoman.arabicToRoman(99), CoreMatchers.is("XCIX"));
    }

    @Test
    public void roman_numbers_when_900() {
        assertThat(ArabicToRoman.arabicToRoman(900), CoreMatchers.is("CM"));
    }
}