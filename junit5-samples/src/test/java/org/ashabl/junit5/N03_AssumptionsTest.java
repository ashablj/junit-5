package org.ashabl.junit5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

/**
 * Assumptions
 */
class N03_AssumptionsTest {

    @Test
    @DisplayName("Test Java 8 installed")
    void testOnJava8() {
        assumeTrue(System.getProperty("java.version").startsWith("1.8"));
        System.out.println("Not too old version");
    }

    @Test
    @DisplayName("Test Java 7 installed")
    void testOnJava7() {
        assumingThat(
                System.getProperty("java.version").startsWith("1.7"),
                () -> System.out.println("Need to update")
        );
    }
}
