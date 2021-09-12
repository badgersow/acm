package util;

import java.util.stream.Stream;

public class TestUtil {
    public static int[] toArray(String commaDelimited) {
        return Stream.of(commaDelimited.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
