package components;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

import java.util.PriorityQueue;


public class IndexPriorityQueue<T> {
    private PriorityQueue<Element> queue;
    private T[] data;
    private int size;

    private class Element {
        int index;
        T value;
        Element(int index, T value) {
            this.index = index;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public IndexPriorityQueue(int capacity) {
    	 this.queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.index));
         this.data = (T[]) new Object[capacity];
         this.size = 0;
    }

    public void add(int index, T value) {
        if (index >= data.length || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        // Update element and priority queue
        data[index] = value;
        queue.add(new Element(index, value));
        size++;
    }

    public IndexValue<T> poll() {
        Element element = queue.poll();
        if (element != null) {
            T value = data[element.index];
            data[element.index] = null;
            size--;
            return new IndexValue<>(element.index, value);
        }
        return null;
    }

    public IndexValue<T> remove(int index) {
        if (index >= data.length || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        // Remove element from priority queue and data array
        Element toRemove = null;
        for (Element e : queue) {
            if (e.index == index) {
                toRemove = e;
                break;
            }
        }
        if (toRemove != null) {
            queue.remove(toRemove);
            T value = data[index];
            data[index] = null;
            size--;
            return new IndexValue<>(index, value);
        }
        return null;
    }

    public T get(int index) {
        if (index >= data.length || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return data[index];
    }

    public int size() {
        return size;
    }
    
    public List<T> getElements() {
        List<T> elements = new ArrayList<>();
        for (Element e : queue) {
            elements.add(e.value);
        }
        return elements;
    }

    public static class IndexValue<T> {
        public final int index;
        public final T value;

        public IndexValue(int index, T value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return "IndexValue{" +
                    "index=" + index +
                    ", value=" + value +
                    '}';
        }
    }
}
