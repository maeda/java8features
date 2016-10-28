package java8._01_language.typeannotations;

import java8._01_language.typeannotations.code.MyTypeAnnotation;
import java8._01_language.typeannotations.code.MyWatcher;
import java8._01_language.typeannotations.code.NonNull;
import org.junit.Test;

public class TypeAnnotationsTest {

    class MyClass<@MyTypeAnnotation T> {

        public void doSomething(@MyWatcher MyClass<T> this/* just allow type annotation on receptor */, @NonNull String word) {
            // do something important
        }
    }

    @Test
    public void testTypeAnnotations() {
        MyClass<@MyTypeAnnotation String> myClass = new MyClass<>();
        myClass.doSomething("foo");
    }

}
