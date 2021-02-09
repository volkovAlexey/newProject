package com.hillel.task17.task7_forTest;

import com.hillel.task17.task7_forTest.task7.IntList;
import com.hillel.task17.task7_forTest.task7.ListImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListImplTest {
    private ListImpl list = null;

    @Before
    public void init() {
        list = new ListImpl();
    }

    @Test
    public void createEmptyList() {
        ListImpl list1 = new ListImpl();
        int actualSize = list1.size();
        int expectedSize = 0;
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void checkingIndexes() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int actualIndex = list.getIndexByValue(4);
        int expectedIndex = 3;
        Assert.assertEquals(expectedIndex, actualIndex);
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
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void checkWhenArrayOutOfBound() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        try {
            int expectedIndex = list.getByIndex(20);
            Assert.fail();
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
        Assert.assertEquals(subList, actual);
    }

    @Test
    public void pop_RemoveLastElements() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int actual = list.pop();
        int expected = 4;
        Assert.assertEquals(expected, actual);
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
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void peek_RemoveLastElements() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int actual = list.peek();
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void peek_checkSize() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.peek();
        int actual = list.size();
        int expected = 4;
        Assert.assertEquals(expected, actual);
    }
}
