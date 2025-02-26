package list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayListTest {

    private SimpleArrayList list;

    @BeforeEach
    void setUp() {
        list = new SimpleArrayList();
    }

    @Test
    void 값추가_메서드_성공하면_true_반환한다() {
        assertTrue(list.add("hello"));
        assertEquals(1, list.size());
    }

    @Test
    void 인덱스순서에_값을_추가한다() {
        list.add("a");
        list.add("c");
        list.add(1, "b");

        assertEquals("a", list.get(0));
        assertEquals("b", list.get(1));
        assertEquals("c", list.get(2));
    }

    @Test
    void 특정_인덱스의_값을_변경한다() {
        list.add("a");
        list.add("b");

        assertEquals("b", list.set(1, "c"));
        assertEquals("c", list.get(1));
    }

    @Test
    void 특정_인덱스의_값을_가져온다() {
        list.add("x");
        assertEquals("x", list.get(0));
    }

    @Test
    void 리스트에_값이_포함되어있는지_확인한다() {
        list.add("apple");
        assertTrue(list.contains("apple"));
        assertFalse(list.contains("banana"));
    }

    @Test
    void 특정_값의_인덱스를_찾는다() {
        list.add("first");
        list.add("second");

        assertEquals(1, list.indexOf("second"));
        assertEquals(-1, list.indexOf("third"));
    }

    @Test
    void 리스트의_크기를_확인한다() {
        assertEquals(0, list.size());
        list.add("item");
        assertEquals(1, list.size());
    }

    @Test
    void 리스트가_비어있는지_확인한다() {
        assertTrue(list.isEmpty());
        list.add("data");
        assertFalse(list.isEmpty());
    }

    @Test
    void 특정_값을_제거한다() {
        list.add("one");
        list.add("two");
        list.add("three");

        assertTrue(list.remove("two"));
        assertFalse(list.contains("two"));
        assertEquals(2, list.size());
    }

    @Test
    void 특정_인덱스의_값을_제거한다() {
        list.add("one");
        list.add("two");
        list.add("three");

        assertEquals("two", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("three", list.get(1));
    }

    @Test
    void 리스트를_초기화한다() {
        list.add("data1");
        list.add("data2");
        list.clear();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }
}
