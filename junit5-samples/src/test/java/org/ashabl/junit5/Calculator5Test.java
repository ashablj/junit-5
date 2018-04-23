package org.ashabl.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class Calculator5Test {

    private Calculator calc;

    @BeforeEach
    void init() {
        calc = new Calculator();
    }

    /// assertions

    @Test
    void testAssertions() {
        assertTrue(true, "is not true");
        assertEquals("a", "a");
        assertEquals(2, 1 + 1, "Optional message");
        assertEquals(2, 1 + 1, () -> "Assertion message " + "can be lazily evaluated");
    }

    @Test
    void testThrows() {
        Throwable th = assertThrows(
                IllegalArgumentException.class,
                () -> calc.sum(null, -5)
        );
        assertEquals(th.getMessage(), "'a' can't be null!");
    }

    @Test
    void testGroupedAssertions() {
        assertAll("group test",
                () -> assertEquals(calc.sum(2, 4), 6),
                () -> assertEquals(calc.sum(3, 4), 3),
                () -> assertEquals(calc.sum(4, 4), 8),
                () -> assertEquals(calc.sum(5, 4), 2)
        );
    }

    /// assumptions, display names

    @Nested
    class AssumptionTest {

        @Test
        void testAssumptionsEnable() {
            Assumptions.assumeTrue(Runtime.getRuntime().availableProcessors() > 1);

            assertEquals(calc.sum(3, 5), 8);
        }

        @Test
        void testAssumptionsDisable() {
            Assumptions.assumeTrue(Runtime.getRuntime().availableProcessors() < 1);

            assertEquals(calc.sum(3, 5), 8);
        }
    }

    /// tagging

    @Test
    @Tag("major")
    void testTagMajor() {
        assertEquals(calc.sum(2, 2), 4);
    }

    @Test
    @Tag("slow")
    void testTagSlow() {
        assertEquals(calc.sum(4, 4), 8);
    }

    /// parameterized tests

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void testWithMethodSource(int a, int b) {
        assertEquals(calc.sum(a, b), a + b);
    }

    private static Stream<Arguments> valuesProvider() {
        return Stream.of(Arguments.of(30, 50), Arguments.of(40, 90));
    }

    /// dynamic tests

    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        return Stream.generate(Math::random)
                .limit(16)
                .mapToInt(v -> (int) (v * 100))
                .mapToObj(v -> dynamicTest(
                        "test sum operation for value: " + v,
                        () -> assertTrue(calc.sum(v, v) > 0)
                ));
    }
}