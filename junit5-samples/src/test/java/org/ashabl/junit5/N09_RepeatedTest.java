package org.ashabl.junit5;

import org.junit.jupiter.api.RepeatedTest;

/**
 * Repeated
 */
class N09_RepeatedTest {

    @RepeatedTest(3)
    void testRepeaterd() {
        System.out.println("It will be executed 3 times.");
    }

    @RepeatedTest(value = 5, name = "{displayName} {currentRepetition} from {totalRepetitions}")
    void testRepeaterdExt() {
        System.out.println("It will be executed 5 times.");
    }
}
