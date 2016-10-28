package java8._01_language.methodreference;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MethodReferenceTest {
    @Test
    public void testStaticMethod() {
        List<String> expected = Arrays.asList("A", "B", "C");
        List<String> result = Stream.of("a", "b", "c").map(String::toUpperCase).collect(Collectors.toList());
        result.stream().peek(item -> assertTrue(expected.contains(item)));
    }

    @Test
    public void testInstanceMethod() {
        class MyComparator {
            public <T extends Comparable<T>> int compare(T t, T t1) {
                return t.compareTo(t1);
            }

         }

        MyComparator myComparator = new MyComparator();
        String[] actual = {"B", "C", "A"};
        String[] expected = {"A", "B", "C"};

        Arrays.sort(actual, myComparator::compare);
//        Arrays.sort(actual, (a, b) -> a.compareTo(b));
        assertTrue(Arrays.equals(actual, expected));
    }

    /**
     * source: https://bitbucket.org/katoquro/jdk8-lambda-samples/src/0664defd8e4bf974058996cd9f88fda20a2eec5f/src/test/java/net/openjdk/lambda/MethodRefTest.java?at=master&fileviewer=file-view-default
     */
    @Test
    public void testMethodRefInstance2() {
        // Predicate<T>   ~  boolean test(T t);
        Predicate<String> isTrue = "true"::equalsIgnoreCase;
        assertTrue(isTrue.test("TruE"));
        assertFalse(isTrue.test("FalsE"));
    }
}
