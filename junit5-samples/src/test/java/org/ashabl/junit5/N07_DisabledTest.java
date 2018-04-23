package org.ashabl.junit5;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Disabled
 */
class N07_DisabledTest {

    @Test
    @Disabled
    @DisplayName("This test was ignored")
    void testIgnore() {
        assertTrue(true);
    }
}
