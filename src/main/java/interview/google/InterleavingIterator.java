package interview.google;

import com.google.common.base.Preconditions;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class InterleavingIterator<T> {

    private static class ListNode<T> {
        // Each of the iterators contained here is not empty
        Iterator<T> value;
        // next == null indicates the last element
        ListNode<T> next;
        // prev == null indicates the fist element
        ListNode<T> prev;

        ListNode(Iterator<T> value) {
            this.value = value;
        }
    }

    private ListNode<T> head;

    private ListNode<T> tail;

    private ListNode<T> current;

    public InterleavingIterator(Iterator<Iterator<T>> iterators) {
        head = null;
        tail = null;
        while (iterators.hasNext()) {
            Iterator<T> nextIterator = iterators.next();
            if (nextIterator.hasNext()) {
                addToList(nextIterator);
            }
            // If the iterator is empty, we don’t care about it
        }
        current = head;
        tail.next = head;
        head.prev = tail;
    }

    private boolean isListEmpty() {
        return head == null;
    }

    private void addToList(Iterator<T> element) {
        // This is the first element
        if (head == null) {
            head = tail = new ListNode<>(element);
        } else {
            ListNode<T> newTail = new ListNode<>(element);
            tail.next = newTail;
            newTail.prev = tail;
            tail = newTail;
        }
    }

    private void removeFromCircularList(ListNode node) {
        Preconditions.checkState(head != null, "Trying to remove from the empty list !");
        // Removing the only element
        if (node.next == node) {
            head = null;
            tail = null;
            return;
        }

        // Removing something in the middle
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    /**
     * Returns true if there are more elements available, false otherwise
     */
    boolean hasNext() {
        return !isListEmpty();
    }

    /**
     * Returns the next element, or will throw NoSuchElement exception if there is none
     */
    T next() {
        // This check is cheap
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        T element = current.value.next();
        ListNode<T> nextNode = current.next;
        if (!current.value.hasNext()) {
            removeFromCircularList(current);
        }
        if (isListEmpty()) {
            current = null;
        } else {
            current = nextNode;
        }

        return element;
    }

}
