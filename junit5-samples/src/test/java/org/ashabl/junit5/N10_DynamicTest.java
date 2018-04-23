package org.ashabl.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * Dynamic test
 */
class N10_DynamicTest {

    @TestFactory
    Stream<DynamicTest> testDynamicTest() {
        return Stream.of(
                dynamicTest("foo", () -> assumeTrue(true)),
                dynamicTest("bar", () -> assumeTrue(false))
        );
    }

    @TestFactory
    @DisplayName("Generates tests for the first 10 even integers.")
    Stream<DynamicTest> dynamicTestsFromIntStream() {
        return IntStream.iterate(0, n -> n + 2)
                .limit(10)
                .mapToObj(n ->
                        dynamicTest("test" + n,
                                () -> assertTrue(n % 2 == 0)));
    }
}