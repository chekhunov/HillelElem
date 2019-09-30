package ua.ithillel.hw10;

import java.util.NoSuchElementException;

public class List<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public List() {
        this.first = this.last = null;
        this.size = 0;
    }

    public void addArrayToList(T[] array) {
        int arr = array.length;
        for (T t : array) {
            addLast(t);
        }
        this.size = arr;
    }

    public int size() {
        return this.size;
    }

    void addFirst(T data) {
        Node<T> list = new Node<T>(data);
        list.data = data;

        if (this.first == null) {
            this.first = list;
            this.last = list;
        } else {
            list.next = this.first;
            this.first = list;
        }
        this.size++;
    }

    public void addLast(T data) {
        Node<T> node = new Node<T>(data);
        if (this.first == null) {
            this.first = this.last = node;
        } else {
            this.last.setNext(node);
            this.last = node;
        }
        this.size++;
    }

    public void addByIndex(T data, int index) {
        Node crunchifyTemp = new Node<T>(data);
        Node crunchifyCurrent = this.first;

        for (int i = 1; i < index && crunchifyCurrent.getNext() != null; i++) {
            crunchifyCurrent = crunchifyCurrent.getNext();
        }
        crunchifyTemp.setNext(crunchifyCurrent.getNext());
        crunchifyCurrent.setNext(crunchifyTemp);
        this.size++;
    }

    public boolean removeIndex(int index) {
        if (index < 1 || index > size())
            return false;

        Node<T> crunchifyCurrent = this.first;
        for (int i = 1; i < index; i++) {
            if (crunchifyCurrent.getNext() == null)
                return false;

            crunchifyCurrent = crunchifyCurrent.getNext();
        }
        crunchifyCurrent.setNext(crunchifyCurrent.getNext().getNext());
        this.size++;
        return true;
    }

    public void remove(T data) {
        if (this.first == null) {
            throw new NoSuchElementException();
        } else if (this.first.getData().equals(data)) {
            this.first = this.first.getNext();
            this.size--;
            return;
        }

        Node<T> current = this.first;
        Node<T> next = current.getNext();
        while (next != null) {
            if (next.getData().equals(data)) {
                current.setNext(next.getNext());
                if (current.getNext() == null) {
                    this.last = current;
                }
                this.size--;
                return;
            }
            current = next;
            next = current.getNext();
        }

        throw new

                NoSuchElementException();
    }

    public void isEmpty() {
        if (this.first != null) {
            System.out.println("Список не пуст");
        } else
            System.out.println("Список пуст");
    }

    public void reversByIndex(int firstIndex, int secondIndex) {
        if (firstIndex > secondIndex || firstIndex >= this.size || secondIndex >= this.size) {
            throw new NoSuchElementException();
        } else if (firstIndex == secondIndex) {
            return;
        } else {
            interLink(firstIndex, secondIndex);
        }
    }

    private void interLink(int firstIndex, int secondIndex) {
        int position = 1;
        Node<T> firstPairPrevious = this.first;
        Node<T> firstPairCurrent = this.first.getNext();

        while (position < firstIndex) {
            firstPairPrevious = firstPairCurrent;
            firstPairCurrent = firstPairCurrent.getNext();
            position++;
        }

        Node<T> firstPairLast = firstPairCurrent.getNext();

        position = 1;
        Node<T> secondPairPrevious = this.first;
        Node<T> secondPairCurrent = this.first.getNext();

        while (position < secondIndex) {
            secondPairPrevious = secondPairCurrent;
            secondPairCurrent = secondPairCurrent.getNext();
            position++;
        }

        Node<T> secondPairLast = secondPairCurrent.getNext();

        firstPairPrevious.next = secondPairCurrent;
        secondPairCurrent.next = firstPairLast;
        secondPairPrevious.next = firstPairCurrent;
        firstPairCurrent.next = secondPairLast;
    }


    @Override
    public String toString() {
        if (this.first == null) {
            return "[ ]";
        }
        StringBuilder buffer = new StringBuilder();
        buffer.append("{");

        Node<T> current = this.first;
        while (current != null) {
            buffer.append(current.getData());

            if (current.getNext() != null) {
                buffer.append(", ");
            }

            current = current.getNext();
        }

        buffer.append("}");

        return buffer.toString();
    }

    private class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }
    }
}


