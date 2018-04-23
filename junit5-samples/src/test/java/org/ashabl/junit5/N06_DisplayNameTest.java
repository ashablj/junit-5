package org.ashabl.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * DisplayName
 */
@DisplayName("Test class name \uD83D\uDE31")
class N06_DisplayNameTest {

    @Test
    @DisplayName("Test hello world \uD83D\uDC4D")
    void testDisplayName() {
        System.out.println("Hello, JUnit5!");
    }
}
