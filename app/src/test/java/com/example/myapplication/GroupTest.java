package com.example.myapplication;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GroupTest {
    Group ameba;

    @BeforeEach
    void setUp() {
        ameba = new Group("Ameba");
    }

    @Test
    void isEmptyGroup() {
        assertTrue(ameba.isEmptyGroup());
        ameba.addMember(new Person(0.0 , "Jack"));
        assertFalse(ameba.isEmptyGroup());
    }

    @Test
    void isEmptyItem() {
        assertTrue(ameba.isEmptyItem());
        ameba.addItem(new Item("Lays" , new Money(4.50)));
        assertFalse(ameba.isEmptyItem());
    }

    @Test
    void removeMember() {
        ameba.addMember(new Person(0.0 , "Jack"));
        ameba.addMember(new Person(0.0 , "Jared"));
        ameba.addMember(new Person(0.0 , "Arson"));
        ameba.removeMember(new Person(0.0 , "Jack"));
        for (int i = 0 ; i < ameba.personList.size() ; i++) {
            System.out.println(ameba.personList.get(i) + ", ");
        }
    }

    @Test
    void addMember() {
        ameba.addMember(new Person(0.0 , "Jack"));
        ameba.addMember(new Person(0.0 , "Jared"));
        ameba.addMember(new Person(0.0 , "Arson"));
        for (int i = 0 ; i < ameba.personList.size() ; i++) {
            System.out.println(ameba.personList.get(i) + ", ");
        }
    }

    @Test
    void removeItem() {
    }

    @Test
    void addItem() {
        ameba.addItem(new Item("Water" , new Money(3.50)));
        ameba.addItem(new Item("Beef Jerky" , new Money(8.99)));
        for (int i = 0 ; i < ameba.itemList.size() ; i++) {
            System.out.println(ameba.itemList.get(i));
        }
    }

    @Test
    void getGroupName() {
        assertEquals("Ameba" , ameba.getGroupName());
    }

    @Test
    void changeGroupName() {
        ameba.changeGroupName("Bungle");
        assertEquals("Bungle" , ameba.getGroupName());
    }

    @Test
    void deleteGroup() {
        ameba.addMember(new Person(0.0 , "jack"));
        ameba.addMember(new Person(0.0 , "Arson"));
        ameba.addMember(new Person(0.0 , "Jared"));
        ameba.deleteGroup();
        assertTrue(ameba.personList.isEmpty());
    }

    @Test
    void listGroup() {
        ameba.addMember(new Person(0.0 , "jack"));
        ameba.addMember(new Person(0.0 , "Arson"));
        ameba.addMember(new Person(0.0 , "Jared"));
        ameba.listGroup();
    }

    @Test
    void listItems() {
        ameba.addItem(new Item("Water" , new Money(3.50)));
        ameba.addItem(new Item("Beef Jerky" , new Money(8.99)));
        ameba.listItems();
    }

    @Test
    void getTotalDebt() {
        ameba.addMember(new Person(4.0 , "jack"));
        ameba.addMember(new Person(10.0 , "Arson"));
        ameba.addMember(new Person(3.0 , "Jared"));
        assertEquals(new Money(17.0) , ameba.getTotalDebt());
    }
}