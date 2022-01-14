/**
 * A fairly simple arraylist implementation extending custom list interface.
 * Default size is 2, grows by size * 2 when needed.
 * When an element is added or removed at an index other elements are not re-arranged
 *
 * @param <e>
 */
public class ArrayList<E> implements ListInterface<E> {
    private object[] array;
    private int size;
    private int maxSize;
}
