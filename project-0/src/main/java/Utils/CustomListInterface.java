package Utils;

public interface CustomListInterface<E> {

    // Returns the size of collections
    int size();

    // Adds an item to end of collection
    void add(E e);

    // Returns the element at specified index
    E get(int index);

}
