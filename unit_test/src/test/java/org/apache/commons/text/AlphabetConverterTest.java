package org.apache.commons.text;
import org.apache.commons.text.AlphabetConverter;
import java.io.UnsupportedEncodingException;
import junit.framework.TestCase;

public class AlphabetConverterTest extends TestCase {

    private AlphabetConverter converter;

    public void setUp() throws Exception {
        Character[] originalChars = {'a', 'b', 'c', 'd'};
        Character[] encodingChars = {'0', '1', 'd'};
        Character[] doNotEncodeChars = {'d'};

        converter = AlphabetConverter.createConverterFromChars(
                originalChars,
                encodingChars,
                doNotEncodeChars
        );
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testEncode() throws UnsupportedEncodingException {
        assertEquals("00", converter.encode("a"));
        assertEquals("01", converter.encode("b"));
        assertEquals("0d", converter.encode("c"));
        assertEquals("d", converter.encode("d"));
    }


    public void testDecode() throws UnsupportedEncodingException {
        assertEquals("a", converter.decode("00"));
        assertEquals("b", converter.decode("01"));
        assertEquals("c", converter.decode("0d"));
        assertEquals("d", converter.decode("d"));
        assertEquals("abcd", converter.decode("00010dd"));
    }

    public void testToString() {
        String actual = converter.toString();

        String lineSeparator = System.lineSeparator();
        String expected =
                "a -> 00" + lineSeparator +
                        "b -> 01" + lineSeparator +
                        "c -> 0d" + lineSeparator +
                        "d -> d" + lineSeparator;

    }
}
