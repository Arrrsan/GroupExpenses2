package com.example.myapplication;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyTest {
    Money m1;
    Money m2;
    Money m3;

    @BeforeEach
    void setUp() {
        m1 = new Money(3.50);
        m2 = new Money(4.99);
        m3 = new Money(50.0);
    }

    @Test
    void getAmountString() {
        assertEquals("3.50" , m1.getAmountString());
        assertEquals("4.99" , m2.getAmountString());
        assertEquals("50.00" , m3.getAmountString());
    }

    @Test
    void getAmount() {
        assertEquals(3.50 , m1.getAmount());
        assertEquals(4.99 , m2.getAmount());
        assertEquals(50.00 , m3.getAmount());
    }

    @Test
    void add() {
        m1 = m1.add(new Money(6.50));
        assertEquals(10.00 , m1.getAmount());
    }

    @Test
    void subtract() {
        m3 = m3.subtract(new Money(5.0));
        assertEquals(45.00 , m3.getAmount());
    }
}