package org.ashabl.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Basic test and annotations
 */
class N01_BasicAnnotationsTest {

    private String testText;

    @BeforeAll
    static void initBefore() {
        System.out.println("===> before class");
    }

    @BeforeEach
    void init() {
        testText = "foo";
        System.out.println("--> init value");
    }

    @Test
    void testFirstTest() {
        assertEquals("foo", testText);
        assertTrue(true);
        System.out.println("*** test executed ***");
    }

    @AfterEach
    void reset() {
        testText = null;
        System.out.println("--> reset value");
    }

    @AfterAll
    static void exit() {
        System.out.println("===> after class");
    }
}