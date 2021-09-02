package interview.google;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class InterleavingIteratorTest {

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1|2,3;1,2,3",
            "1,5|2,3,4;1,2,5,3,4",
    })
    void test(String inputString, String resultString) {
        List<Iterator<Integer>> input = Stream.of(inputString.split("\\|"))
                .map(s -> Stream.of(s.split(",")).map(Integer::parseInt).collect(Collectors.toList()).iterator())
                .collect(Collectors.toList());
        List<Integer> result = Stream.of(resultString.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        final InterleavingIterator<Integer> iterator = new InterleavingIterator<Integer>(input.iterator());
        List<Integer> actualResult = new ArrayList<>();
        while (iterator.hasNext()) {
            actualResult.add(iterator.next());
        }
        Assertions.assertThat(actualResult).isEqualTo(result);
    }

}