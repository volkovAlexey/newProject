package com.hillel.task17.task7_forTest.task7;

import java.util.Arrays;
import java.util.Objects;

public class ListImpl implements IntStack, IntList {
    private int[] intArray = new int[10];
    private int top = -1;

    @Override
    public void add(int i) {
        push(i);
    }

    @Override
    public void insert(int index, int value) {
        System.arraycopy(intArray, index, intArray, index + 1,
                top - index);
        intArray[index] = value;
        top++;
    }

    @Override
    public void set(int index, int value) {
        intArray[index] = value;
    }

    @Override
    public int size() {
        if (top < 0) {
            return 0;
        }
        return top;
    }

    @Override
    public int capacity() {
        return intArray.length;
    }

    @Override
    public int getByIndex(int index) {
        return intArray[index];
    }

    @Override
    public Integer getIndexByValue(int value) {
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == value) {
                return i;
            }
        }
        return null;
    }

    @Override
    public boolean contains(int value) {
        return getIndexByValue(value) != null;
    }

    @Override
    public void removeValue(int value) {
        while (contains(value)) {
            int index = getIndexByValue(value);
            System.arraycopy(intArray, index + 1, intArray, index,
                    top - index - 1);
            intArray[--top] = 0;
        }
    }

    @Override
    public void removeByIndex(int index) {
        if (index <= intArray.length) {
            System.arraycopy(intArray, index + 1, intArray, index,
                    top - index - 1);
            intArray[--top] = 0;
        } else {
            System.out.println("Index out of bounds!");
        }
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        IntList newIntList = new ListImpl();
        int[] newList = new int[toIndex - fromIndex];
        System.arraycopy(intArray, fromIndex, newList, 0, toIndex - fromIndex);
        for (int i : newList) {
            newIntList.add(i);
        }
        return newIntList;
    }

    @Override
    public int[] toArray() {
        return intArray;
    }

    @Override
    public void push(int value) {
        if (top < 0) {
            intArray[++top] = value;
            top++;
            return;
        }
        if (top >= intArray.length - 1) {
            int newLength = (intArray.length * 3 / 2) + 1;
            intArray = Arrays.copyOf(intArray, newLength);
        }
        intArray[top] = value;
        top++;
    }

    @Override
    public int pop() {
        int value = intArray[top - 1];
        top--;
        return value;
    }

    @Override
    public int peek() {
        return getByIndex(top - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListImpl)) return false;
        ListImpl list = (ListImpl) o;
        return top == list.top &&
                Arrays.equals(intArray, list.intArray);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(top);
        result = 31 * result + Arrays.hashCode(intArray);
        return result;
    }
}
