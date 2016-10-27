package java8._01_language.defaultmethod;

import com.sun.tools.javac.util.List;
import java8._01_language.defaultmethod.code.FormatData;
import java8._01_language.defaultmethod.code.FormatDataNewLine;
import java8._01_language.defaultmethod.code.FormatDataPipe;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class DefaultMethodTest {

    private List<String> list;

    @Before
    public void setup() {
        this.list = List.of("a", "b", "c");
    }

    @Test
    public void shouldFormatToNewLine() {
        String expected = "a\nb\nc";
        FormatData format = new FormatDataNewLine();
        System.out.println(format.format(list).get());
        assertEquals(expected, format.format(list).get());
    }

    @Test
    public void shouldFormatToPipe() {
        String expected = "a|b|c";
        FormatData format = new FormatDataPipe();
        System.out.println(format.format(list).get());
        assertEquals(expected, format.format(list).get());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptEmptyListPipe() {
        FormatData format = new FormatDataPipe();
        format.formatOrFail(Collections.emptyList());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotAcceptEmptyListNewLine() {
        FormatData format = new FormatDataPipe();
        format.formatOrFail(Collections.emptyList());
    }

    @Test
    public void shouldGetCharSize() {
        int expected = "a\nb\nc".length();
        FormatData format = new FormatDataNewLine();
        System.out.println(format.charSize(list));
        assertEquals(expected, format.charSize(list));
    }

}