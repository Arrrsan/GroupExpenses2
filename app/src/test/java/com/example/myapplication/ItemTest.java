package com.example.myapplication;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemTest {
    Item chips;
    Item pizza;
    Item soda;

    @BeforeEach
    void setUp() {
        chips = new Item("Doritos" , new Money(3.99));
        pizza = new Item("Meat Pizza" , new Money(14.99));
        soda = new Item("Sprite" , new Money(7.99));
    }

    @Test
    void getName() {
        assertEquals("Doritos" , chips.getName());
        assertEquals("Meat Pizza" , pizza.getName());
        assertEquals("Sprite" , soda.getName());
    }

    @Test
    void getPrice() {
        assertEquals(new Money(3.99) , chips.getPrice());
        assertEquals(new Money(14.99) , pizza.getPrice());
        assertEquals(new Money(7.99) , soda.getPrice());
    }
}