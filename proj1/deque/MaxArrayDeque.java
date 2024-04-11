package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        } else {
            T maxItem = get(0);
            for (int i = 1; i < size(); i++) {
                if (comparator.compare(get(i), maxItem) > 0) {
                    maxItem = get(i);
                }
            }
            return maxItem;
        }
    }

    public T max() {
        return max(comparator);
    }

    
}
