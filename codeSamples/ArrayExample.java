import java.util.ArrayList;
import java.util.Arrays;

public class ArrayExample {

    public static void main(String[] arg) {

        /**
         * 
         * Static Arrays
         * 
         */

        // array decleration of type String
        String[] colours = new String[6];
        // initialisation
        colours[0] = "yellow"; // zero index
        colours[1] = "green";
        colours[2] = "blue";
        colours[3] = "black";
        colours[4] = "orange";
        colours[5] = "purple";
        /* colours[6] = "pink"; results in ArrayIndexOutOfBounds due to illegal index */

        // initialisation with decleration
        int[] ages = { 23, 28, 43, 55, 60, 5 };

        // printing elements with the help of java utility Arrays
        System.out.println(Arrays.toString(ages));

        // java utility Arrays also offers methods to sort & perform binary search on
        // Arrays
        Arrays.sort(ages);
        int index = Arrays.binarySearch(ages, 5);

        /**
         * 
         * Multidimensional Arrays / Jagged Arrays
         * 
         */

        // 2D array - stored in row-major order
        int[][] coordintes = { { 1, 2 }, { 4, 1 }, { 6, 6 } };

        System.out.println("Row-Major Order");
        // Row-Major Order : traversal occurs across rows
        for (int i = 0; i < coordintes[0].length; i++) {
            for (int j = 0; j < coordintes.length; j++) {
                System.out.print(coordintes[j][i]);
            }
        }
        System.out.println("\n Coloum-Major Order");
        // Column-Major Order : traversal occurs across columns
        for (int i = 0; i < coordintes.length; i++) {
            for (int j = 0; j < coordintes.length; j++) {
                System.out.print(coordintes[i][j]);
            }
        }

        // 3D array - array of 2D arrays [array_index][row_index][column_index]
        int[][][] _3dArray = { { { 4, 5 }, { 6, 7 }, { 8, 9 } }, { { 13, 15 }, { 18, 20 }, { 17, 68 } } };
        int seven = _3dArray[0][1][1];
        int eighteen = _3dArray[1][1][0];
        System.out.println(seven);
        System.out.println(eighteen);


        /**
         * 
         * Dynamic Arrays
         * 
         */
        ArrayList<String> dynamicColours = new ArrayList<String>(10);
        dynamicColours.add("blue");
        dynamicColours.add("green");
        dynamicColours.remove("orange");
    }

}
