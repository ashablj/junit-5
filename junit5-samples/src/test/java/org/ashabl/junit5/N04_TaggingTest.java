package org.ashabl.junit5;

import org.ashabl.junit5.api.Major;
import org.ashabl.junit5.api.MajorTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Tagging
 */
class N04_TaggingTest {

    /// tag

    @Tag("major")
    @Test
    void testTag() {
        assumeTrue(true);
    }

    /// custom tag

    @Major
    @Test
    void testCustomTag() {
        assumeTrue(true);
    }

    /// composite tag

    @MajorTest
    void testComposedTag() {
        assumeTrue(true);
    }
}
