package org.ashabl.junit5;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Parameterized
 */
class N11_ParametrizedTest {

    @ParameterizedTest
    @EnumSource(TimeUnit.class)
    void testWithEnumSource(TimeUnit timeUnit) {
        assertNotNull(timeUnit);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Hello", "World"})
    void testWithStringSource(String argument) {
        assertNotNull(argument);
    }

    @ParameterizedTest
    @CsvSource({"1,2", "4,-1", "-3,9", "0,5"})
    void testWithCsvSource(int a, int b) {
        assertTrue(a + b > 0);
    }

    @ParameterizedTest
    @ArgumentsSource(ValuesArgumentsProvider.class)
    void testWithArgumentsSource(String argument) {
        assertNotNull(argument);
    }

    static class ValuesArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of("foo", "bar").map(Arguments::of);
        }
    }
}
