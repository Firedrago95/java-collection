package list;

public class SimpleLinkedList implements SimpleList {

    private static class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public SimpleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean add(String value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value);
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, String value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node newNode = new Node(value);
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public String set(int index, String value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        String oldValue = current.value;
        current.value = value;
        return oldValue;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public boolean contains(String value) {
        Node current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(String value) {
        Node current = head;
        int index = 0;
        while (current != null) {
            if (current.value.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(String value) {
        if (head == null) {
            return false;
        }

        if (head.value.equals(value)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null && !current.next.value.equals(value)) {
            current = current.next;
        }

        if (current.next == null) {
            return false;
        }

        current.next = current.next.next;
        size--;
        return true;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        String removedValue;
        if (index == 0) {
            removedValue = head.value;
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedValue = current.next.value;
            current.next = current.next.next;
        }
        size--;
        return removedValue;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }
}
