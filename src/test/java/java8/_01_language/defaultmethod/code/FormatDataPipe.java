package java8._01_language.defaultmethod.code;

import java.util.List;
import java.util.Optional;

public class FormatDataPipe implements FormatData {
    @Override
    public Optional<String> format(List<String> data) {
        return data.stream().reduce((a, b) -> a + "|" + b);
    }
}
