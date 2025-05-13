package com.example.myapplication;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person jack;
    Person arson;
    Person jared;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        jack = new Person(0 , "Jack");
        arson = new Person(0 , "Arson");
        jared = new Person(0 , "Jared");
    }

    @org.junit.jupiter.api.Test
    void addCharge() {
        arson.addCharge(new Money(4.0));
        arson.addCharge(new Money(6.50));
        arson.addCharge(new Money(1.0));
        for (int i = 0; i < arson.charges.size() ; i++) {
            System.out.println(arson.charges.get(i) + " ");
        }
    }

    @org.junit.jupiter.api.Test
    void removeCharge() {
        jack.addCharge(new Money(10.0));
        jack.addCharge(new Money(13.79));
        jack.addCharge(new Money(4.99));
        jack.removeCharge(new Money(10.0));
        assertEquals(18.78 , jack.getTotalDebt());
    }

    @org.junit.jupiter.api.Test
    void getCharge() {
        jack.addCharge(new Money(10.0));
        jack.addCharge(new Money(13.79));
        jack.addCharge(new Money(4.99));
        assertEquals(28.78 , jack.getTotalDebt());
    }

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("Jack" , jack.getName());
        assertEquals("Arson" , arson.getName());
        assertEquals("Jared" , jared.getName());
    }

}