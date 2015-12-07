import java.lang.IllegalArgumentException;
import java.util.PriorityQueue;

/**
 * Created by 95028258 on 2/2/2015.
 *
 * Naveen Pai, 2° APCS, Due Feb. 10, 2015
 *
 * Dijkstra:
 *
 * This class holds the shortestPath method, the implementation of Dijkstra's algorithm.
 * This file contains only static fields and methods, and is not intended for use through instance methods.
 * This class incorporates the Pole class through instantiation in the shortestPath methods, and other helpers.
 * The private helper methods are found after the shortestPath method, organized alphabetically.
 * The demonstration of functionality is found in the TestDijkstra class, where the main method is located
 * Documentation is in the form of /** comments in front of each method.
 * In line comments are found only at key areas that require explanation.
 *
 */

public class Dijkstra {

    /**
     * d and k are the indexes within the array returned by shortestPath.
     * The arrays at index d and k (in the 2d array returned by shortestPath)
     * represent the shortest distances from the startNode,
     * and the last nodes in the path, respectively.
     * (See the second and third columns in the Weiss 9.3 presentation)
     */
    static final int d = 0;
    static final int k = 1;


    /**
     * The representation of infinity (all distances start out as infinity at the beginning of the algorithm)
     * Note: This value has chosen to be negative under the assumption that the adjacency matrix handles only
     * positive edge values. This decision avoids a possible collision with the positive, finite representation of infinity
     * supported by Java, which would pose a hole in the algorithm.
     */
    static final int inf = -2;

    /**
     * No connection is read as -1 (this allows for an edge with a length of 0, however no negative values are permitted
     */
    static final int none = -1;



    /** Dijkstra's Algorithm
     *
     * Requirements: Adjacency Matrix must be square, all costs non-negative
     *
     * @param startNode Start node represented  by an integer index in the graph
     * @param adjMat Adjacency Matrix containing magnitudes of edges (length, cost, etc.):
     *               - (-1) means no connection
     *
     * @return An 2D array: [0] --> the minimum distance from start node to node at [0][x]
     *                      [1] --> the previous node in the shortest path from start node to [1][x]
     */
    public static int[][] shortestPaths(int startNode, int[][] adjMat) {

        for (int[] r : adjMat) {
            //The adjacency matrix is not rectangular --> argument is illegal
            if (adjMat.length != r.length) throw new IllegalArgumentException();
        }

        int numNodes = adjMat.length;

        boolean[]   selected    = new boolean[numNodes];
        int[]       distance    = infinityTable(numNodes);
        int[]       lastNode    = infinityTable(numNodes);

        PriorityQueue<Pole> poss = new PriorityQueue<Pole>();

        for (int i = 0; i < adjMat[startNode].length; i++) {
            int d = adjMat[startNode][i];
            if (d != 0 && i != startNode) {
                poss.add(new Pole(startNode, d, i));
            }
        }
        distance[startNode] = 0;
        lastNode[startNode] = startNode;

        while (!poss.isEmpty()) {

            Pole next = poss.poll();

            selected[next.start]    = true;
            selected[next.end]      = true;
            testPole(next,distance,lastNode);

            for (int i = 0; i < adjMat[next.end].length; i++) {
                //Note: do not want to create a duplicate path (ie. one that goes to an already selected node)
                //By avoiding already selected nodes, buckles are avoided
                //Therefore the only dangerous buckle is the one on the start node
                if (adjMat[next.end][i] != 0 && !selected[i]) {
                    Pole curr = new Pole(next.end, adjMat[next.end][i], i);
                    testPole(curr, distance, lastNode);
                    poss.add(new Pole(next.end, adjMat[next.end][i], i));
                }
            }

        }
        distance[startNode] = adjMat[startNode][startNode];

        return $(distance,lastNode);

    }


    //Private Encapsulate Helper Methods

    /**
     * Used to fill the initial table with infinities (inside of Dijkstra's algorithm)
     * @param length    The specified length of the array to be returned
     * @return          An int array with length, length, containing only values of inf (See fields)
     */
    public static int[] infinityTable(int length) {
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = inf;
        }
        return result;
    }


    /**
     * A method that tests the tentative distance from the start node to the end of the pole
     * Note: tentative distance refers to the distance through the current path from start node to the current node
     * (this may or may not be shorter than the currently established shortest distance in the table)
     *
     * @param p         The pole that ends with the node who's tentative distance is being analyzed
     *
     * @param distance  The column in the table that shows the shortest distances from start node
     *                  to each other node in the graph
     *
     * @param lastNode  The column in the table that shows the last node in the path from start node
     *                  to each other node in the graph
     */
    public static void testPole(Pole p, int[] distance, int[] lastNode) {
        int tentative   = distance[p.start] + p.edge;

        if (tentative < distance[p.end] || distance[p.end] == inf) {
            distance[p.end] = tentative;
            lastNode[p.end] = p.start;
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
