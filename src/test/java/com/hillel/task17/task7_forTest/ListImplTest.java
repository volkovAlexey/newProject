package com.hillel.task17.task7_forTest;

import com.hillel.task17.task7_forTest.task7.IntList;
import com.hillel.task17.task7_forTest.task7.ListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListImplTest {
    private ListImpl list;

    @BeforeEach
    public void init() {
        list = new ListImpl();
    }

    @Test
    public void createEmptyList() {
        ListImpl list1 = new ListImpl();
        int actualSize = list1.size();
        int expectedSize = 0;
        Assertions.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void checkingIndexes() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int actualIndex = list.getIndexByValue(4);
        int expectedIndex = 3;
        Assertions.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void removeElementFromList() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.removeValue(3);
        int actualIndex = list.getIndexByValue(4);
        int expectedIndex = 2;
        Assertions.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testByArrayIndexOutOfBoundsException() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.getByIndex(20));
    }

    @Test
    public void checkSubList() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        IntList actualSubList = list.subList(1, 3);
        IntList expected = new ListImpl();
        expected.add(2);
        expected.add(3);
        Assertions.assertEquals(expected, actualSubList);
    }

    @Test
    public void pop_RemoveLastElements() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int actual = list.pop();
        int expected = 4;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void pop_checkSize() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.pop();
        int actual = list.size();
        int expected = 3;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void push_AddToTheEnd() {
        list.push(2);
        list.push(4);
        list.push(5);
        int actual = list.getIndexByValue(5);
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }
}
