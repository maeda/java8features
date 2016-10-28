package java8._01_language.defaultmethod.tailcall;

import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * Tail Recursion: https://leanpub.com/whatsnewinjava8/read#leanpub-auto-tail-call-optimization
 */
public class TailCallTest {

    @FunctionalInterface
    public interface Tail <T> {
        Tail<T> apply();

        default boolean isDone() {
            return false;
        }

        default T result() {
            throw new UnsupportedOperationException("Not done yet.");
        }

        default T invoke() {
            return Stream.iterate(this, Tail::apply)
                    .filter(Tail::isDone)
                    .findFirst()
                    .get()
                    .result();
        }

        static <T> Tail<T> done (T value) {
            return new Tail<T>() {
                @Override
                public Tail<T> apply() {
                    throw new UnsupportedOperationException("Not supported.");
                }

                @Override
                public T result() {
                    return value;
                }

                @Override
                public boolean isDone() {
                    return true;
                }
            };
        }
    }

    @Test
    public void testTailCall() {
        System.out.println(factorial(100_000));
    }

    public static BigInteger factorial(int n) {
        return streamFactorial(BigInteger.ONE, n).invoke();
    }

    private static Tail<BigInteger> streamFactorial(BigInteger x, int n) {
        return () -> {
            switch (n) {
                case 1:
                    return Tail.done(x);
                default:
                    return streamFactorial(x.multiply(BigInteger.valueOf(n)), n -1);
            }
        };
    }
}
