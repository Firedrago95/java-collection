package list;

import java.util.Arrays;

public class SimpleArrayList implements SimpleList {

    private static final int INIT_SIZE = 10;

    private String[] values;
    private int lastIndex;

    public SimpleArrayList() {
        this.values = new String[INIT_SIZE];
        this.lastIndex = 0;
    }

    @Override
    public boolean add(String value) {
        if (lastIndex == values.length) {
            expandValues();
        }
        values[lastIndex] = value;
        lastIndex++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index < 0 || index > lastIndex) {
            throw new IndexOutOfBoundsException();
        }

        if (lastIndex == values.length) {
            expandValues();
        }

        for (int i = lastIndex; i > index; i--) {
            values[i] = values[i - 1];
        }
        values[index] = value;
        lastIndex++;
    }

    @Override
    public String set(int index, String value) {
        if (index < 0 || index >= lastIndex) {
            throw new IndexOutOfBoundsException();
        }
        String oldValue = values[index];
        values[index] = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= lastIndex) {
            throw new IndexOutOfBoundsException();
        }
        return values[index];
    }

    @Override
    public boolean contains(String value) {
        for (int i = 0; i < lastIndex; i++) {
            if (values[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        for (int i = 0; i < lastIndex; i++) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return lastIndex;
    }

    @Override
    public boolean isEmpty() {
        return lastIndex == 0;
    }

    @Override
    public boolean remove(String value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= lastIndex) {
            throw new IndexOutOfBoundsException();
        }
        String removedValue = values[index];

        for (int i = index; i < lastIndex - 1; i++) {
            values[i] = values[i + 1];
        }
        values[lastIndex - 1] = null;
        lastIndex--;
        return removedValue;
    }

    @Override
    public void clear() {
        Arrays.fill(values, 0, lastIndex, null);
        lastIndex = 0;
    }

    private void expandValues() {
        int newSize = values.length + INIT_SIZE;
        String[] newValues = new String[newSize];
        System.arraycopy(values, 0, newValues, 0, values.length);
        this.values = newValues;
    }
}
