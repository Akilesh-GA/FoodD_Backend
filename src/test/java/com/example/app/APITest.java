package com.example.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class APITest {
    @Test
    public void testEquals() {
        int res = 20 + 30;
        assertEquals(50, res);
    }

    @Test
    public void testNotEquals() {
        int res = 20 + 30;
        assertNotEquals(51, res);
    }

    @Test
    public void testTrue() {
        int res = 20 + 30;
        assertTrue(res == 50);
    }

    @Test
    public void testFalse() {
        int res = 20 + 30;
        assertFalse(res == 51);
    }

    @Test
    public void testNotNull() {
        int res = 20 + 30;
        assertNotNull(res);
    }

    @Test
    public void testNull() {
        assertNull(null);
    }
}
