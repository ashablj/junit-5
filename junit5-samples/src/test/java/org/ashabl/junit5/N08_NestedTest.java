package org.ashabl.junit5;

import org.junit.jupiter.api.*;

/**
 * Nested classes
 */
class N08_NestedTest {

    @BeforeAll
    static void start() {
        System.out.println(">>> main before all");
    }

    @BeforeEach
    void init() {
        System.out.println("=> main before");
    }

    @Test
    void testFirst() {
        System.out.println("* main first test *");
    }

    @Test
    void testSecond() {
        System.out.println("* main second test *");
    }

    @Nested
    @DisplayName("simple test case 1")
    class SimpleTestCase1 {

        @BeforeEach
        void init() {
            System.out.println("--> sub before 1");
        }

        @Test
        void testFirst() {
            System.out.println("** sub first test **");
        }

        @Nested
        @DisplayName("simple test case 2")
        class SimpleTestCase2 {

            @BeforeEach
            void init() {
                System.out.println("---> sub before 2");
            }

            @Test
            void testFirst() {
                System.out.println("*** sub second test ***");
            }

            @AfterEach
            void reset() {
                System.out.println("---> sub after 2");
            }
        }

        @AfterEach
        void reset() {
            System.out.println("--> sub after 1");
        }

       /* not execution *
        @AfterAll
        static void exit() {
            System.out.println("=============================");
        }*/
    }

    @AfterEach
    void reset() {
        System.out.println("=> main after ====================");
    }

    @AfterAll
    static void exit() {
        System.out.println("<<< main after all");
    }
}
