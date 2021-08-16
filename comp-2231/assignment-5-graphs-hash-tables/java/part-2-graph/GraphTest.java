import java.util.*;

/**
 * Graph.Java COMP 2231 Assignment 5: Part 2 Driver
 *
 * Test driver for the Graph class.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class GraphTest {
    public static void main(String[] args) {
        System.out.println("------------------Test 1: Create graph------------------");
        System.out.println("Creating a graph and adding 4 vertices...");

        // create new graph
        Graph graph = new Graph();

        // create array of vertices
        String[] vertices = { "A", "B", "C", "D" };

        // add vertices to graph
        for (String vertex : vertices)
            graph.addVertex(vertex);

        // print graph and test isConnected, isEmpty, and size methods
        System.out.println("Printing the adjacency matrix and information on the graph...");
        System.out.print(graph);
        System.out.println("The graph is connected: " + graph.isConnected());
        System.out.println("The graph is empty: " + graph.isEmpty());
        System.out.println("The size of the graph is: " + graph.size());
        System.out.println();

        System.out.println("------------------Test 2: Connect graph------------------");
        System.out.println("Adding edges so that graph is fully connected...");

        // add edges to create a connected graph
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");

        // print graph and test isConnected, isEmpty, and size methods
        System.out.println("Printing the adjacency matrix and information on the graph...");
        System.out.print(graph);
        System.out.println("The graph is connected: " + graph.isConnected());
        System.out.println("The graph is empty: " + graph.isEmpty());
        System.out.println("The size of the graph is: " + graph.size());
        System.out.println();

        System.out.println("------------------Test 3: Remove some edges------------------");
        System.out.println("Removing two edges from the graph...");

        // remove an edge (this tests both removeEdge methods and the getIndex method)
        graph.removeEdge("D", "A");
        graph.removeEdge("C", "D");

        // print graph and test isConnected, isEmpty, and size methods
        System.out.println("Printing the adjacency matrix and information on the graph...");
        System.out.print(graph);
        System.out.println("The graph is connected: " + graph.isConnected());
        System.out.println("The graph is empty: " + graph.isEmpty());
        System.out.println("The size of the graph is: " + graph.size());
        System.out.println();

        System.out.println("------------------Test 4: Remove last vertex in vertices array------------------");
        System.out.println("Removing the last vertex in the graphs vertex array...");
        System.out.println("The adjacency matrix from test 3 should no longer have row/column 3");

        // remove the last vertex in array
        // this tests boths removeVertex methods since a vertex is passed calling the
        // other version of the method
        graph.removeVertex("D");

        // print graph and test isConnected, isEmpty, and size methods
        System.out.println("Printing the adjacency matrix and information on the graph...");
        System.out.print(graph);
        System.out.println("The graph is connected: " + graph.isConnected());
        System.out.println("The graph is empty: " + graph.isEmpty());
        System.out.println("The size of the graph is: " + graph.size());
        System.out.println();

        System.out.println("------------------Test 5: Remove first vertex in vertices array------------------");
        System.out.println("Removing the first vertex in the graphs vertex array...");
        System.out.println("The adjacency matrix from test 4 should shift one row up, one column left, drop column 2");

        // remove the first vertex in array
        // this tests boths removeVertex methods since a vertex is passed calling the
        // other version of the method
        graph.removeVertex("A");

        // print graph and test isConnected, isEmpty, and size methods
        System.out.println("Printing the adjacency matrix and information on the graph...");
        System.out.print(graph);
        System.out.println("The graph is connected: " + graph.isConnected());
        System.out.println("The graph is empty: " + graph.isEmpty());
        System.out.println("The size of the graph is: " + graph.size());
        System.out.println();

        System.out.println("------------------Test 6: Add new vertices and edges------------------");
        System.out.println("Adding 5 new vertices to the graph...");
        System.out.println("Adding some new edges to the graph...");

        // new verticies to add to the graph
        String[] newVertices = { "E", "F", "G", "H", "I" };

        // add vertices to graph
        for (String vertex : newVertices)
            graph.addVertex(vertex);

        // connect E to every other vertex
        graph.addEdge("E", "B");
        graph.addEdge("E", "C");
        graph.addEdge("E", "F");
        graph.addEdge("E", "G");
        graph.addEdge("E", "H");
        graph.addEdge("E", "I");

        // connect H to every other vertex
        graph.addEdge("H", "B");
        graph.addEdge("H", "C");
        graph.addEdge("H", "E");
        graph.addEdge("H", "F");
        graph.addEdge("H", "G");
        graph.addEdge("H", "I");

        // print graph and test isConnected, isEmpty, and size methods
        System.out.println("Printing the adjacency matrix and information on the graph...");
        System.out.print(graph);
        System.out.println("The graph is connected: " + graph.isConnected());
        System.out.println("The graph is empty: " + graph.isEmpty());
        System.out.println("The size of the graph is: " + graph.size());
        System.out.println();

        System.out.println("------------------Test 7: Remove a middle vertex in vertices array------------------");
        System.out.println("Removing a vertex in the middle of the graphs vertex array...");

        // remove a vertex in the middle of the vertex array
        graph.removeVertex("H");

        // print graph and test isConnected, isEmpty, and size methods
        System.out.println("Printing the adjacency matrix and information on the graph...");
        System.out.print(graph);
        System.out.println("The graph is connected: " + graph.isConnected());
        System.out.println("The graph is empty: " + graph.isEmpty());
        System.out.println("The size of the graph is: " + graph.size());
        System.out.println();

        System.out.println("------------------Test 8: Test remaining methods------------------");

        // test addVertex method that adds a blank vertex
        System.out.println("Adding a blank vertex...");
        System.out.println("Graph size before addition: " + graph.size());
        graph.addVertex();
        System.out.println("Graph size after addition: " + graph.size());
        System.out.println();

        // test indexIsValid method
        System.out.println("-1 is a valid index: " + graph.indexIsValid(-1));
        System.out.println("100 is a valid index: " + graph.indexIsValid(100));
        System.out.println("3 is a valid index: " + graph.indexIsValid(3));
        System.out.println();

        // test getVertices method
        System.out.println("Getting a copy of the graph verticies array...");
        System.out.print(Arrays.toString(graph.getVertices()));
    }
}
