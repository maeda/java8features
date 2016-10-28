package java8._01_language.typeannotations.code;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE, ElementType.TYPE})
public @interface MyWatcher {
}
