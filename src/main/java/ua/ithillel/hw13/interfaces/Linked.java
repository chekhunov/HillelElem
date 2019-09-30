package ua.ithillel.hw13.interfaces;

public interface Linked<T> {
    void addAll(T[] array);
    void addFirst(T t);
    void addCenter(T t);
    void addLast(T t);
    void delElementFirst(T t);
    void delElementLast(T t);
    void delElementN(T t);
    void printList();
    void interChangeTwoListNodes();
    int size();
    boolean checkForEmptiness(T t);
    T getElementByIndex(int counter);

}
