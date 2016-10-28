package java8._01_language.defaultmethod.multiple;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultipleDefaultMethodTest {
    interface Foo{
        default String talk() {
            return "Foo!";
        }
    }

    interface Bar{
        default String talk() {
            return "Bar!";
        }
    }
    class FooBar implements Foo, Bar {

        @Override
        public String talk() {
            return Foo.super.talk();
        }
    }

    @Test
    public void testMultipleDefaultMethodOverride() {
        FooBar fooBar = new FooBar();
        String expected = "Foo!";
        assertEquals(expected, fooBar.talk());
    }
}
