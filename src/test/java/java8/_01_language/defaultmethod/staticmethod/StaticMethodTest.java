package java8._01_language.defaultmethod.staticmethod;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StaticMethodTest {
    interface MyService {

        void doSomething();

        static String utilsA() {
            return "my utils A";
        }

        static String utilsB() {
            return "my utils B";
        }
    }

    class MyServiceImpl implements MyService {

        @Override
        public void doSomething() {
            // do some processing
        }
    }

    @Test
    public void testStaticMethods() {
        String expected1 = "my utils A";
        String expected2 = "my utils B";
        assertEquals(expected1, MyService.utilsA());
        assertEquals(expected2, MyService.utilsB());
    }
}
