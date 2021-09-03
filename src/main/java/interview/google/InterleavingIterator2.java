package interview.google;

import com.google.common.base.Preconditions;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class InterleavingIterator2<T> {

    // Every iterator in this queue is guaranteed to be non-empty
    private final Queue<Iterator<T>> queue;

    public InterleavingIterator2(Iterator<Iterator<T>> origin) {
        queue = new ArrayDeque<>();
        while (origin.hasNext()) {
            Iterator<T> iterator = origin.next();
            if (iterator.hasNext()) {
                queue.add(iterator);
            }
        }
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Iterator<T> current = queue.remove();
        // Queue invariant - each iterator is not empty
        Preconditions.checkState(current.hasNext());
        T element = current.next();

        // If still some element left - we will use it later
        // Otherwise if it’s empty, we don’t need it back in the queue
        if (current.hasNext()) {
            queue.add(current);
        }

        return element;
    }
}
