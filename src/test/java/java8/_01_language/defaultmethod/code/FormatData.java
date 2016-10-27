package java8._01_language.defaultmethod.code;

import java.util.List;
import java.util.Optional;

public interface FormatData {
    Optional<String> format(List<String> data);

    default String formatOrFail(List<String> data) throws IllegalArgumentException {
        return format(data).orElseThrow(IllegalArgumentException::new);
    }

    default int charSize(List<String> data) {
        return formatOrFail(data).length();
    }
}
