
package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiscountCalculatorTest {

    private final DiscountCalculator calculator =
            new DiscountCalculator();

    @Test
    void testGuest() {
        assertEquals(100, calculator.calculateDiscount(100, "GUEST"));
    }

    @Test
    void testMemberBelow100() {
        assertEquals(94.05, calculator.calculateDiscount(100 - 1, "MEMBER"), 0.001);
    }

    @Test
    void testMemberAbove100() {
        assertEquals(90, calculator.calculateDiscount(100, "MEMBER"));
    }

    @Test
    void testVip() {
        assertEquals(80, calculator.calculateDiscount(100, "VIP"));
    }

    @Test
    void testNegativePrice() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateDiscount(-10, "VIP"));
    }

    @Test
    void testInvalidMemberType() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateDiscount(100, "STUDENT"));
    }
}
