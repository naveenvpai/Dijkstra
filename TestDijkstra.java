/**
 * Created by Naveen on 2/8/15.
 */
public class TestDijkstra {

    public static void main(String[] args) {
        /*

        Sample Adjacency Matrix from Clemson Notes
            0 1 2 3 4 5 6 7
        0   0 8 0 0 0 10 0 0
        1   0 0 4 0 10 0 0 0
        2   0 0 0 3 0 0 0 0
        3   0 0 0 0 25 18 0 0
        4   0 0 0 9 0 0 7 0
        5   5 7 3 0 2 0 0 0
        6   0 0 0 2 0 0 0 3
        7   4 9 0 0 0 0 0 0

        */

        int[][]readingAM = $(
                $(0, 8, 0, 0, 0, 10, 0, 0),
                $(0, 0, 4, 0, 10, 0, 0, 0),
                $(0, 0, 0, 3, 0, 0, 0, 0),
                $(0, 0, 0, 0, 25, 18, 0, 0),
                $(0, 0, 0, 9, 0, 0, 7, 0),
                $(5, 7, 3, 0, 2, 0, 0, 0),
                $(0, 0, 0, 2, 0, 0, 0, 3),
                $(4, 9, 0, 0, 0, 0, 0, 0)
        );

        System.out.println("Adjacency Matrix of the Reading's Sample Graph");
        print(readingAM);

        int[][] test = Dijkstra.shortestPaths(0, readingAM);

        System.out.println("Dv:");
        print(test[Dijkstra.d]);
        System.out.println("Kv:");
        print(test[Dijkstra.k]);
    }


    private static void print(boolean[] ar) {
        System.out.print("[");
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i]);
            if (i+1 != ar.length) System.out.print(", ");
        }
        System.out.print("]\n");
    }

    private static void print(boolean isRow, int... els) {
        String limitor1 = isRow ? "|" : "[";
        String limitor2 = isRow ? "|" : "]";

        StringBuilder s = new StringBuilder(limitor1);
        for (int i = 0; i < els.length; i++) {
            s.append(els[i]);
            if (i != els.length-1) s.append(", ");
        }
        s.append(limitor2);
        System.out.println(s);
    }

    private static void print(int... els) {
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < els.length; i++) {
            s.append(els[i]);
            if (i != els.length-1) s.append(", ");
        }
        s.append("]");
        System.out.println(s);
    }

    private static void print(int[]... els) {
        for (int[] el : els) {
            print(true,el);
        }
    }

    /** $yntactic $ugar
     * Avoids the bulky syntax for instantiating an array in java
     * @param els  A 2d array represented as a comma separated list of integer arrays
     * @return The array, made with ease of creation
     */
    private static int[][] $(int[]... els) {
        return els;
    }

    /** $yntactic $ugar (Overloaded)
     * Avoids the bulky syntax for instantiating an array in java
     * @param els  An array represented as a comma separated list of integers
     * @return The array, made with ease of creation
     */
    private static int[] $(int... els) {
        return els;
    }
}
