/**
 * Bubble sort works by moving a "bubble" through the array, the bubble is two elements next to each other.
 * For instance the first possible bubble is elements at index 0 and 1.
 * Each time this bubble moves through the array, re-order the two elements into the sorted order
 * Then move the bubble until we reach the last two elements.
 * Repeat this process until we complete one full iteration without making any swaps.
 */

public class IntegerBubbleSort {
    public static void sort(int [] array) {
        int temp;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
