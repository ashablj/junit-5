package org.ashabl.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Assertions
 */
class N02_AssertionsTest {

    @Test
    void testAssertions() {
        assertTrue(true, "Is not true");
        assertFalse(false, "Is not false");
        assertEquals("a", "a");
        assertEquals(2, 1 + 1, "Optional message");
        assertEquals(2, 1 + 1, () -> "Assertion message can be lazily evaluated");
    }

    @Test
    void testThrows() {
        Throwable th = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    throw new IllegalArgumentException("!!!BOOM!!!");
                }
        );
        assertEquals(th.getMessage(), "!!!BOOM!!!");
    }

    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(50),
                () -> {
                    Thread.sleep(5);
                });

        assertTimeoutPreemptively(Duration.ofMillis(50),
                () -> Thread.sleep(5));
    }

    @Test
    void testGrouped() {
        assertAll("group test",
                () -> assertEquals(2 + 4, 6),
                () -> assertEquals(3 + 4, 3),
                () -> assertEquals(4 + 4, 8),
                () -> assertEquals(5 + 4, 2)
        );
    }

    @Test
    void testIterable() {
        assertIterableEquals(asList(1, 2, 3), asList(1, 2, 3));
    }

    @Test
    void testSubString() {
        Assertions.assertLinesMatch(
                asList("you can string compare", "by regex: \\d{2}\\.\\d{2}\\.\\d{4}"),
                asList("you can string compare", "by regex: 12.09.2017")
        );
    }
}
