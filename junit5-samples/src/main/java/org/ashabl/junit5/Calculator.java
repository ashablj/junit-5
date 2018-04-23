package org.ashabl.junit5;

import static java.util.Optional.ofNullable;

public class Calculator {

    public int sum(Integer a, int b) {
        return ofNullable(a)
                .map(val -> a + b)
                .orElseThrow(() -> new IllegalArgumentException("'a' can't be null!"));
    }
}
