package org.ashabl.junit5;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Calculator4Test {

    private Calculator calc;

    @Before
    public void init() {
        calc = new Calculator();
    }

    @Ignore
    @Test
    public void testIgnore() {
        assertTrue(true);
    }

    @Test
    public void testAddTwoPositive() {
        assertEquals(calc.sum(3, 5), 8);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrows() {
        calc.sum(null, -5);
    }
}