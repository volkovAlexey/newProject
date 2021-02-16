package com.hillel.task17.task7_forTest;

import com.hillel.task17.task7_forTest.task7.IntList;
import com.hillel.task17.task7_forTest.task7.ListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListImplTest {
    private ListImpl list = null;

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
    public void checkWhenArrayOutOfBound() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        try {
            int expectedIndex = list.getByIndex(20);
            Assertions.fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.getMessage();
        }
    }

    @Test
    public void checkSubList() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        IntList subList = list.subList(1, 3);
        IntList actual = new ListImpl();
        actual.add(2);
        actual.add(3);
        Assertions.assertEquals(subList, actual);
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
