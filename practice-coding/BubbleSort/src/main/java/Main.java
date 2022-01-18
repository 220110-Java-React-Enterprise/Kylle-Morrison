public class Main {
    public static void main(String ...args) {
        //This code is the IntegerSelectionSort
        int[] array = new int[]{44, 73, 1, -5, -5,  6, 1001, 19, 77, 52, -100, 35, 82, 82, -5};

        IntegerSelectionSort.sort(array);

        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        // This code is the IntegerBubbleSort
        int[] array2 = new int[]{44, 73, 1, -5, -5,  6, 1001, 19, 77, 52, -100, 35, 82, 82, -5};

        IntegerBubbleSort.sort(array2);

        for(int i = 0; i < array2.length; i++)
            System.out.print(array2[i] + " ");

    }
}
