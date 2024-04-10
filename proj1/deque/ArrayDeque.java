package deque;

public class ArrayDeque<T> implements Deque<T> {
    T[] items;
    int size;
    int head, tail;

    public ArrayDeque() {
        items = (T []) new Object[10];
        size = 0;
        head = 0;
        tail = 1;
    }

    public int prev(int index) {
        if (index == 0) return items.length - 1;
        return index - 1;
    }

    public int next(int index) {
        if (index == items.length - 1) return 0;
        return index + 1;
    }

    public void resize(int newLength) {
        T[] newItems = (T []) new Object[newLength];
        for (int i = next(head), j = 1; i != tail; i = next(i), ++j) {
            newItems[j] = items[i];
        }
        items = newItems;
        head = 0;
        tail = size + 1;
    }

    @Override
    public void addFirst(T item) {
        if (size + 2 == items.length) {
            resize(size * 2 + 2);
        }
        items[head] = item;
        head = prev(head);
        ++size;
    }

    @Override
    public void addLast(T item) {
        if (size + 2 == items.length) {
            resize(size * 2 + 2);
        }
        items[tail] = item;
        tail = next(tail);
        ++size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = next(head); i != tail; i = next(i)) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) return null;
        T itemTobeRemoved = items[next(head)];
        head = next(head);
        --size;
        if (size + 2 < items.length / 4) {
            resize(items.length / 4);
        }
        return itemTobeRemoved;
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;
        T itemTobeRemoved = items[prev(tail)];
        tail = prev(tail);
        --size;
        if (size + 2 < items.length / 4) {
            resize(items.length / 4);
        }
        return itemTobeRemoved;
    }

    @Override
    public T get(int index) {
        index = (index + head + 1) % items.length;
        return items[index];
    }
}
