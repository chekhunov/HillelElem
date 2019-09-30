package ua.ithillel.hw13;

import ua.ithillel.hw13.interfaces.DescendingIterator;
import ua.ithillel.hw13.interfaces.Linked;

import java.util.Iterator;

public class LinkedList<T> implements Linked<T>, Iterable<T>, DescendingIterator<T> {
    private Node<T> fstNode;
    private Node<T> lstNode;
    private int size;

    public LinkedList() {
        lstNode = new Node<T>(null, fstNode, null);
        fstNode = new Node<T>(null, null, lstNode);
    }

    @Override
    public void addAll(T[] array) {
        int arr = array.length;
        for (T t : array) {
            addLast(t);
        }
        size = arr;
    }

    @Override
    public void addFirst(T t) {
        Node<T> next = fstNode;
        next.setCurrentElement(t);
        fstNode = new Node<>(null, null, next);
        next.setPrevElement(fstNode);
        size++;
    }

    @Override
    public void addCenter(T t) {
        int length = size / 2;
        Node<T> current = fstNode;
        current.setCurrentElement(t);
        fstNode = new Node<T>((T) current, null, null);
        current.setPrevElement(fstNode);

        Node<T> middle = fstNode;
        middle.setCurrentElement(t);
        fstNode = new Node<>(null, null, current);
        current.setPrevElement(fstNode);
        while (current.getNextElement() != null) {
            length++;
            if (length % 2 == 0) {
                middle = middle.getNextElement();
            }
            current = current.getNextElement();
        }
        if (length % 2 == 1) {
            middle = middle.getNextElement();
        }

        size++;
    }

    @Override
    public void addLast(T t) {
        Node<T> prev = lstNode;
        prev.setCurrentElement(t);
        lstNode = new Node<T>(null, prev, null);
        prev.setNextElement(lstNode);
        size++;
    }

    @Override
    public void delElementFirst(T t) {

    }

    @Override
    public void delElementLast(T t) {

    }

    @Override
    public void delElementN(T t) {

    }

    @Override
    public void printList() {

        Iterator iterator = iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Override
    public void interChangeTwoListNodes() {

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean checkForEmptiness(T t) {
        return false;
    }

    @Override
    public T getElementByIndex(int counter) {
        Node<T> target = fstNode.getNextElement();
        for (int i = 0; i < counter; i++) {
            target = getNextElement(target);
        }
        return target.getCurrentElement();
    }

    private Node<T> getNextElement(Node<T> current) {
        return current.getNextElement();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public T next() {
                return getElementByIndex(counter++);
            }
        };
    }

    @Override
    public Iterator<T> descendingIterator() {
        return new Iterator<T>() {
            int counter = size - 1;

            @Override
            public boolean hasNext() {
                return counter >= 0;
            }

            @Override
            public T next() {
                return getElementByIndex(counter--);
            }
        };
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");

        Node<T> current = fstNode;
        while (current != null) {
            buffer.append(current.getCurrentElement());

            if (current.getNextElement() != null) {
                buffer.append(", ");
            }

            current = current.getNextElement();
        }

        buffer.append("}");

        return buffer.toString();
    }

    private class Node<T> {

        private T currentElement;
        private Node<T> nextElement;
        private Node<T> prevElement;

        public Node(T currentElement, Node<T> prevElement, Node<T> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        public T getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(T currentElement) {
            this.currentElement = currentElement;
        }

        public Node<T> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<T> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<T> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<T> prevElement) {
            this.prevElement = prevElement;
        }
    }
}
