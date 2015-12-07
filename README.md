An AP Computer Science Project involving an implementation of Dijkstra's Algorithm in Java:

Dijkstra's Algorithm Implementation by Naveen Pai (2° APCS)

To implement Dijkstra's Algorithm, I worked at multiple stages.

The first part of my time I spent trying to understand the algorithm by studying the presentation
as well as looking at the Wikipedia explanation. It was my first time working with graphs and adjacency matrices
so I took my time to develop a conceptual understanding.

*Note: I have come to refer to the three column table shown in Weiss 9.3 as "the table".
Whenever "the table" is mentioned in my description it refers to the storage of K, d(v), and p(v).

The second stage was creating all of the necessary helper methods for array handling that would make life easier
once I actually started working with the logic. I made sure to employ encapsulation to make the code cleaner
and the writing process more efficient. An example of this was the $ method that I used to quickly instantiate
integer arrays, using syntax manipulation to help my writing process.

The last stage was implementing the logic that I had come to understand. I figured out the necessary data structures I
would need (PriorityQueue for example) and created a new one to help. My only confusion was figuring out how to navigate
to the node at the shortest distance from the current position. I knew how to arrange the distances in the PriorityQueue,
but I did not know how to associate this with an actual executable action. I decided (with the the conceptual help
of Matthew Seligson, see Pole documentation) to create a new comparable object that held information about the edge as well as the
nodes connected to it, that was insertable into a PriorityQueue. This allowed me to navigate the graph easily.

Once I was capable of navigating, all I had to do was figure out the tracking of paths into the table (as taught
by the Weiss 9.3 presentation). I designed the logic accordingly:

*Note: A buckle (also called a loop) is an edge from a node to itself.
This serves as a special case that could interfere with the navigation of the graph.

1) Have all distances start at infinity
2) Set the distance from start node to itself as 0, and the last node in that path to start node
3) Insert all possible paths away from start node (except for buckles) into the PriorityQueue in the form of a Pole
4) Enter a while loop that repeatedly examines the shortest distance Pole:
    - set the selected values for each end of the Pole to True
    - examine the tentative distance through this Pole:
        (the shortest established distance (in the table) to the start of the Pole + the edge from start to end of the Pole)
    - examine every possible tentative distance going away from the current Pole (except for buckles):
        (see the above step)
    - if a tentative distance is found that is shorter than the distance in the table, replace it in the table:
        - set the distance value to the tentative distance
        - set the last node value to the start of the Pole

    continue until every node has been selected and examined
5) At the very end, check if there is a buckle (a loop from a node to itself) on the start node, and account for it in the table
    (this makes sure not to interfere with the distances navigating away from the start node by doing this at the end)

Pages referenced:

    Buckles:                http://en.wikipedia.org/wiki/Loop_%28graph_theory%29

    Algorithm Reference:    http://en.wikipedia.org/wiki/Dijkstra%27s_algorithm#Algorithm
    (only description of the Algorithm, no pseudo code was referenced)


Overall, I learned a lot from this project, especially about visualizing a graph and using adjacency matrices.
I enjoyed it a lot, because I enjoy working on algorithms that are independent of graphics and focusing solely on the Model.

