package helper;

import static org.junit.Assert.*;

import core.helper.Helper;
import org.junit.Test;

public class HelperTest {

    @Test
    public void shouldConvertCamelCaseToNormal() {
        assertEquals("Dupa Blada", Helper.convertCamelCasesToNormal("DupaBlada"));
        assertEquals("Dupa", Helper.convertCamelCasesToNormal("Dupa"));
        assertEquals("Dupa", Helper.convertCamelCasesToNormal("dupa"));

        //corner cases
        assertEquals("", Helper.convertCamelCasesToNormal(""));
        assertEquals("A", Helper.convertCamelCasesToNormal("A"));
        assertEquals("A", Helper.convertCamelCasesToNormal("a"));
        assertEquals("ABC", Helper.convertCamelCasesToNormal("ABC"));
        assertEquals("AB Cd EF", Helper.convertCamelCasesToNormal("ABCdEF"));
        assertEquals("Äbb Öoo", Helper.convertCamelCasesToNormal("ÄbbÖoo"));
    }
}
