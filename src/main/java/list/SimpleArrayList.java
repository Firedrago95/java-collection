package list;

import java.util.Arrays;

public class SimpleArrayList<T> implements SimpleList<T> {

    private static final int INIT_SIZE = 10;
    private Object[] values;
    private int lastIndex;

    public SimpleArrayList() {
        this.values = new Object[INIT_SIZE];
        this.lastIndex = 0;
    }

    @Override
    public boolean add(Object value) {
        if (lastIndex == values.length) {
            expandValues();
        }
        values[lastIndex++] = value;
        return true;
    }

    @Override
    public void add(int index, Object value) {
        if (index < 0 || index > lastIndex) {
            throw new IndexOutOfBoundsException();
        }
        if (lastIndex == values.length) {
            expandValues();
        }
        System.arraycopy(values, index, values, index + 1, lastIndex - index);
        values[index] = value;
        lastIndex++;
    }

    @Override
    public void add(int index, String value) {
        add(index, (Object) value);
    }

    @Override
    public T set(int index, Object value) {
        if (index < 0 || index >= lastIndex) {
            throw new IndexOutOfBoundsException();
        }
        T oldValue = (T) values[index];
        values[index] = value;
        return oldValue;
    }

    @Override
    public T set(int index, String value) {
        return set(index, (Object) value);
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= lastIndex) {
            throw new IndexOutOfBoundsException();
        }
        return (T) values[index];
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public boolean contains(String value) {
        return contains((Object) value);
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < lastIndex; i++) {
            if (values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int indexOf(String value) {
        return indexOf((Object) value);
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
    public boolean remove(Object value) {
        int index = indexOf(value);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public boolean remove(String value) {
        return remove((Object) value);
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= lastIndex) {
            throw new IndexOutOfBoundsException();
        }
        T removedValue = (T) values[index];
        System.arraycopy(values, index + 1, values, index, lastIndex - index - 1);
        values[--lastIndex] = null;
        return removedValue;
    }

    @Override
    public void clear() {
        Arrays.fill(values, 0, lastIndex, null);
        lastIndex = 0;
    }

    private void expandValues() {
        values = Arrays.copyOf(values, values.length + INIT_SIZE);
    }
}
