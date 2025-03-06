package list;

public interface SimpleList<T> {

    boolean add(Object value);

    void add(int index, String value);

    T set(int index, String value);

    void add(int index, Object value);

    T set(int index, Object value);

    T get(int index);

    boolean contains(String value);

    boolean contains(Object value);

    int indexOf(String value);

    int indexOf(Object value);

    int size();

    boolean isEmpty();

    boolean remove(String value);

    boolean remove(Object value);

    T remove(int index);

    void clear();
}
