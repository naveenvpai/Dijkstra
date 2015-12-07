import java.lang.Comparable;
import java.lang.Object;import java.lang.Override;//Had conceptual conversation with Matthew Seligson over necessity of this class

/**
 *
 * Naveen Pai, 2° APCS, Due Feb. 10, 2015
 *
 * Pole:
 *
 * This class serves as a representation of two nodes and the edge that connects them (a piece of a Graph).
 *
 * Note: the idea for this model came from a conceptual discussion with Matthew Seligson.
 * In class, we talked about the way to represent nodes, how to store adjacency matrices, etc.
 * however, no code was shared, copied, or referenced.
 *
 * Each field of Pole is an integer:
 *  start   - the index that represents the first node
 *  edge    - the edge (cost, distance, etc.) of the connecting edge
 *  end     - the index that represents the second node.
 *
 *  This class implements Comparable because it is intended to be inserted into a Priority Queue.
 *      * only the edge (i.e. distance or cost) is used for comparison between poles
 *      * the Pole is only intended to be compared to other Poles.
 *
 */

public class Pole implements Comparable {
    int start;
    int end;
    int edge;

    public Pole(int start, int distance, int end) {
        this.edge   = distance;
        this.start  = start;
        this.end    = end;
    }

    @Override
    /**
     * Comparison between two Poles (only), as used by PriorityQueue<Pole>
    */
    public int compareTo(Object o) {
        Pole other = (Pole)o;
        if          (edge == other.edge)    return  0;
        return      (edge < other.edge)     ?       -1 : 1;
    }

    /**
     * toString method used during testing
     * @return A string representation of the Pole
     */
    public String toString() {
        return " ("+start +" --" + edge + "--> " + end+") ";
    }
}