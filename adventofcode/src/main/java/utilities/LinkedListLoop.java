package utilities;

import java.util.ArrayList;
import java.util.List;

public class LinkedListLoop<T> {

    Node<T> first;
    Node<T> last;
    int size;

    public LinkedListLoop() {
    }

    public LinkedListLoop(T val) {
        insert(val);
    }

    public LinkedListLoop(List<T> lst) {
        for (T val : lst) {
            insert(val);
        }
    }

    public Node<T> insert(Node<T> n) {
        if (first == null) {
            first = n;
            last = first;
            first.next = last;
            first.prev = last;
            last.next = first;
            last.prev = first;
            size = 1;
        } else {
            n.next = first;
            n.prev = last;
            first.prev = n;
            last.next = n;
            last = n;
            size++;
        }
        return n;
    }

    public Node<T> insert(T val) {
        Node<T> n = new Node<T>(val);
        insert(n);
        return n;
    }

    public int getSize(){
        return size;
    }

    public void move(int index, int distance) {
        // modulo wraps around to give you the in range index
        int targetIndex = distance + index % (size-1);
        distance = targetIndex - index;

        // start at 0
        Node<T> walker = first;
        for (int i = 0; i < index; i++) {
            walker = walker.next;
        }

        // removed from list
        walker.next.prev = walker.prev;
        walker.prev.next = walker.next;

        if (index == 0) {
            first = walker.next;
        } else if (index == size - 1) {
            last = walker.prev;
        }

        // while we need to change our index
        while (distance != 0) {
            if (distance > 0) {
                walker.next = walker.next.next;
                distance--;
            } else {
                walker.next = walker.next.prev;
                distance++;
            }
        }

        // insert into the space looking 1 ahead
        walker.prev = walker.next.prev;
        walker.next.prev = walker;
        walker.prev.next = walker;
    }

    public void move(Node<T> n, int distance) {
        // start at 0
        Node<T> walker = first;
        int startIndex = 0;
        while (walker != n) {
            walker = walker.next;
            startIndex++;
        }
        move(startIndex, distance);
    }

    public List<T> toList() {
        List<T> ret = new ArrayList<>();
        Node<T> walker = first;
        do {
            ret.add(walker.value);
            walker = walker.next;
        } while (walker != first);
        return ret;
    }

    public T get(int index) {
        index = index % size;
        Node<T> walker = first;
        do {
            walker = walker.next;
        } while (index-- > 0);
        return walker.value;
    }

    public int getFirstIndex(T value) {
        Node<T> walker = first;
        int index = -1;
        do {
            walker = walker.next;
            index++;
            // we stop when we've hit our size limit, or find the value
        } while (index < size && walker.value != value);
        if (index == size) {
            return -1;
        }
        return index;
    }
}
