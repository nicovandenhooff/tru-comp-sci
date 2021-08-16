import jsjf.*;
import java.util.*;

/**
 * Graph.Java COMP 2231 Assignment 5: Part 2
 *
 * Graph represents an adjacency matrix implementation of a graph. A portion of
 * this code was completed by the authors of Java Foundations. I have added
 * detailed comments to the methods that I completed as part of this assignment.
 *
 * @author Nico Van den Hooff
 * @version 1.0
 */
public class Graph<T> implements GraphADT<T> {
    protected final int DEFAULT_CAPACITY = 5; // default graph capacity
    protected int numVertices; // number of vertices in the graph
    protected boolean[][] adjMatrix; // adjacency matrix
    protected T[] vertices; // values of vertices
    protected int modCount; // modifier count

    /**
     * Creates an empty graph.
     */
    public Graph() {
        numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    public void addEdge(T vertex1, T vertex2) {
        addEdge(getIndex(vertex1), getIndex(vertex2));
    }

    /**
     * Inserts an edge between two vertices of the graph.
     *
     * @param index1 the first index
     * @param index2 the second index
     */
    public void addEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
            modCount++;
        }
    }

    /**
     * Removes an edge between two vertices of the graph.
     *
     * @param vertex1 the first vertex
     * @param vertex2 the second vertex
     */
    public void removeEdge(T vertex1, T vertex2) {
        // get indices and call other version of removeEdge
        removeEdge(getIndex(vertex1), getIndex(vertex2));
    }

    /**
     * Removes an edge between two vertices of the graph.
     *
     * @param index1 the first index
     * @param index2 the second index
     */
    public void removeEdge(int index1, int index2) {
        // check if indicies are valid
        if (indexIsValid(index1) && indexIsValid(index2)) {
            // remove edges by setting adjacency matrix cells to false
            adjMatrix[index1][index2] = false;
            adjMatrix[index2][index1] = false;

            // update modcount
            modCount++;
        }
    }

    /**
     * Adds a vertex to the graph, expanding the capacity of the graph if necessary.
     */
    public void addVertex() {
        // expand capacity if needed
        if ((numVertices + 1) == adjMatrix.length)
            expandCapacity();

        // set new vertex to null
        vertices[numVertices] = null;

        // set edges with new vertex to false
        for (int i = 0; i < numVertices; i++) {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }

        // increment number of vertices and modifications
        numVertices++;
        modCount++;
    }

    /**
     * Adds a vertex to the graph, expanding the capacity of the graph if necessary.
     * It also associates an object with the vertex.
     *
     * @param vertex the vertex to add to the graph
     */
    public void addVertex(T vertex) {
        if ((numVertices + 1) == adjMatrix.length)
            expandCapacity();

        vertices[numVertices] = vertex;
        for (int i = 0; i < numVertices; i++) {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;
        modCount++;
    }

    /**
     * Removes a single vertex with the given value from the graph.
     *
     * @param vertex the vertex to be removed from the graph
     */
    public void removeVertex(T vertex) {
        // get index and call other version of removeVertex
        removeVertex(getIndex(vertex));
    }

    /**
     * Removes a vertex at the given index from the graph. Note that this may affect
     * the index values of other vertices.
     *
     * @param index the index at which the vertex is to be removed from
     */
    public void removeVertex(int index) {
        if (indexIsValid(index)) {
            // edge case: removing the last vertex in array
            if (index == vertices.length - 1) {
                vertices[index] = null;

                for (int i = 0; i < numVertices; i++) {
                    adjMatrix[numVertices][i] = false;
                    adjMatrix[i][numVertices] = false;
                }

                numVertices--;
                modCount++;
            }
            // otherwise shift elements in array
            else {
                // shift elements in vertices array to the left by one
                for (int i = index; i < numVertices; i++)
                    vertices[i] = vertices[i + 1];

                // shift adjacency matrix values one row up
                for (int i = index; i < numVertices; i++)
                    for (int j = 0; j <= numVertices; j++)
                        adjMatrix[i][j] = adjMatrix[i + 1][j];

                // shift adjacency matrix values one column over
                for (int i = index; i < numVertices; i++)
                    for (int j = 0; j < numVertices; j++)
                        adjMatrix[j][i] = adjMatrix[j][i + 1];

                // update last row/column of adjacency matrix to false
                adjMatrix[numVertices][numVertices] = false;
                adjMatrix[numVertices][numVertices] = false;

                // decrement vertex count
                numVertices--;

                // increment mod count
                modCount++;
            }
        }
    }

    /**
     * Returns an iterator that performs a depth first traversal starting at the
     * given index.
     *
     * @param startIndex the index from which to begin the traversal
     * @return an iterator that performs a depth first traversal
     */
    public Iterator<T> iteratorDFS(int startIndex) {
        Integer x;
        boolean found;
        StackADT<Integer> traversalStack = new LinkedStack<Integer>();
        UnorderedListADT<T> resultList = new ArrayUnorderedList<T>();
        boolean[] visited = new boolean[numVertices];

        if (!indexIsValid(startIndex))
            return resultList.iterator();

        for (int i = 0; i < numVertices; i++)
            visited[i] = false;

        traversalStack.push(new Integer(startIndex));
        resultList.addToRear(vertices[startIndex]);
        visited[startIndex] = true;

        while (!traversalStack.isEmpty()) {
            x = traversalStack.peek();
            found = false;

            // Find a vertex adjacent to x that has not been visited
            // and push it on the stack
            for (int i = 0; (i < numVertices) && !found; i++) {
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalStack.push(new Integer(i));
                    resultList.addToRear(vertices[i]);
                    visited[i] = true;
                    found = true;
                }
            }
            if (!found && !traversalStack.isEmpty())
                traversalStack.pop();
        }
        return new GraphIterator(resultList.iterator());
    }

    /**
     * Returns an iterator that performs a depth first search traversal starting at
     * the given vertex.
     *
     * @param startVertex the vertex to begin the search from
     * @return an iterator that performs a depth first traversal
     */
    public Iterator<T> iteratorDFS(T startVertex) {
        return iteratorDFS(getIndex(startVertex));
    }

    /**
     * Returns an iterator that performs a breadth first traversal starting at the
     * given index.
     *
     * @param startIndex the index from which to begin the traversal
     * @return an iterator that performs a breadth first traversal
     */
    public Iterator<T> iteratorBFS(int startIndex) {
        Integer x;
        QueueADT<Integer> traversalQueue = new LinkedQueue<Integer>();
        UnorderedListADT<T> resultList = new ArrayUnorderedList<T>();

        if (!indexIsValid(startIndex))
            return resultList.iterator();

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++)
            visited[i] = false;

        traversalQueue.enqueue(new Integer(startIndex));
        visited[startIndex] = true;

        while (!traversalQueue.isEmpty()) {
            x = traversalQueue.dequeue();
            resultList.addToRear(vertices[x.intValue()]);

            // Find all vertices adjacent to x that have not been visited
            // and queue them up

            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalQueue.enqueue(new Integer(i));
                    visited[i] = true;
                }
            }
        }

        return new GraphIterator(resultList.iterator());
    }

    /**
     * Returns an iterator that performs a breadth first search traversal starting
     * at the given vertex.
     *
     * @param startVertex the vertex to begin the search from
     * @return an iterator that performs a breadth first traversal
     */
    public Iterator<T> iteratorBFS(T startVertex) {
        return iteratorBFS(getIndex(startVertex));
    }

    /**
     * Returns an iterator that contains the indices of the vertices that are in the
     * shortest path between the two given vertices.
     *
     * @param startIndex  the starting index
     * @param targetIndex the the target index
     * @return the an iterator containing the indices of the of the vertices making
     *         the shortest path between the given indices
     */
    protected Iterator<Integer> iteratorShortestPathIndices(int startIndex, int targetIndex) {
        int index = startIndex;
        int[] pathLength = new int[numVertices];
        int[] predecessor = new int[numVertices];
        QueueADT<Integer> traversalQueue = new LinkedQueue<Integer>();
        UnorderedListADT<Integer> resultList = new ArrayUnorderedList<Integer>();

        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex) || (startIndex == targetIndex))
            return resultList.iterator();

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++)
            visited[i] = false;

        traversalQueue.enqueue(new Integer(startIndex));
        visited[startIndex] = true;
        pathLength[startIndex] = 0;
        predecessor[startIndex] = -1;

        while (!traversalQueue.isEmpty() && (index != targetIndex)) {
            index = (traversalQueue.dequeue()).intValue();

            // Update the pathLength for each unvisited vertex adjacent
            // to the vertex at the current index.
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[index][i] && !visited[i]) {
                    pathLength[i] = pathLength[index] + 1;
                    predecessor[i] = index;
                    traversalQueue.enqueue(new Integer(i));
                    visited[i] = true;
                }
            }
        }
        if (index != targetIndex) // no path must have been found
            return resultList.iterator();

        StackADT<Integer> stack = new LinkedStack<Integer>();
        index = targetIndex;
        stack.push(new Integer(index));
        do {
            index = predecessor[index];
            stack.push(new Integer(index));
        } while (index != startIndex);

        while (!stack.isEmpty())
            resultList.addToRear(((Integer) stack.pop()));

        return new GraphIndexIterator(resultList.iterator());
    }

    /**
     * Returns an iterator that contains the shortest path between the two vertices.
     *
     * @param startIndex  the starting index
     * @param targetIndex the target index
     * @return an iterator that contains the shortest path between the given
     *         vertices
     */
    public Iterator<T> iteratorShortestPath(int startIndex, int targetIndex) {
        UnorderedListADT<T> resultList = new ArrayUnorderedList<T>();
        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex))
            return resultList.iterator();

        Iterator<Integer> it = iteratorShortestPathIndices(startIndex, targetIndex);
        while (it.hasNext())
            resultList.addToRear(vertices[((Integer) it.next()).intValue()]);
        return new GraphIterator(resultList.iterator());
    }

    /**
     * Returns an iterator that contains the shortest path between the two vertices.
     *
     * @param startVertex  the starting vertex
     * @param targetVertex the target vertex
     * @return an iterator that contains the shortest path between the given
     *         vertices
     */
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex) {
        return iteratorShortestPath(getIndex(startVertex), getIndex(targetVertex));
    }

    /**
     * Returns the weight of the least weight path in the network. Returns positive
     * infinity if no path is found.
     *
     * @param startIndex  the starting index
     * @param targetIndex the target index
     * @return the integer weight of the least weight path in the network
     */
    public int shortestPathLength(int startIndex, int targetIndex) {
        int result = 0;
        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex))
            return 0;

        int index1, index2;
        Iterator<Integer> it = iteratorShortestPathIndices(startIndex, targetIndex);

        if (it.hasNext())
            index1 = ((Integer) it.next()).intValue();
        else
            return 0;

        while (it.hasNext()) {
            result++;
            it.next();
        }

        return result;
    }

    /**
     * Returns the weight of the least weight path in the network. Returns positive
     * infinity if no path is found.
     *
     * @param startVertex  the starting vertex
     * @param targetVertex the target vertex
     * @return the integer weight of the least weight path in the network
     */
    public int shortestPathLength(T startVertex, T targetVertex) {
        return shortestPathLength(getIndex(startVertex), getIndex(targetVertex));
    }

    /**
     * Returns a minimum spanning tree of the graph.
     *
     * @return a minimum spanning tree of the graph
     */
    public Graph<T> getMST() {
        int x, y;
        int[] edge = new int[2];
        StackADT<int[]> vertexStack = new LinkedStack<int[]>();
        Graph<T> resultGraph = new Graph<T>();

        if (isEmpty() || !isConnected())
            return resultGraph;

        resultGraph.adjMatrix = new boolean[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++)
            for (int j = 0; j < numVertices; j++)
                resultGraph.adjMatrix[i][j] = false;

        resultGraph.vertices = (T[]) (new Object[numVertices]);
        boolean[] visited = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++)
            visited[i] = false;

        edge[0] = 0;
        resultGraph.vertices[0] = this.vertices[0];
        resultGraph.numVertices++;
        visited[0] = true;

        // Add all edges that are adjacent to vertex 0 to the stack.
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i] && this.adjMatrix[0][i]) {
                edge[1] = i;
                vertexStack.push(edge.clone());
                visited[i] = true;
            }
        }

        while ((resultGraph.size() < this.size()) && !vertexStack.isEmpty()) {
            // Pop an edge off the stack and add it to the resultGraph.
            edge = vertexStack.pop();
            x = edge[0];
            y = edge[1];
            resultGraph.vertices[y] = this.vertices[y];
            resultGraph.numVertices++;
            resultGraph.adjMatrix[x][y] = true;
            resultGraph.adjMatrix[y][x] = true;
            visited[y] = true;

            // Add all unvisited edges that are adjacent to vertex y
            // to the stack.
            for (int i = 0; i < numVertices; i++) {
                if (!visited[i] && this.adjMatrix[i][y]) {
                    edge[0] = y;
                    edge[1] = i;
                    vertexStack.push(edge.clone());
                    visited[i] = true;
                }
            }
        }

        return resultGraph;
    }

    /**
     * Creates new arrays to store the contents of the graph with twice the
     * capacity.
     */
    protected void expandCapacity() {
        T[] largerVertices = (T[]) (new Object[vertices.length * 2]);
        boolean[][] largerAdjMatrix = new boolean[vertices.length * 2][vertices.length * 2];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                largerAdjMatrix[i][j] = adjMatrix[i][j];
            }
            largerVertices[i] = vertices[i];
        }

        vertices = largerVertices;
        adjMatrix = largerAdjMatrix;
    }

    /**
     * Returns the number of vertices in the graph.
     *
     * @return the integer number of vertices in the graph
     */
    public int size() {
        // returns number of vertices
        return numVertices;
    }

    /**
     * Returns true if the graph is empty and false otherwise.
     *
     * @return true if the graph is empty
     */
    public boolean isEmpty() {
        // determines if number of vertices is zero
        return numVertices == 0;
    }

    /**
     * Returns true if the graph is connected and false otherwise. Performs a
     * breadth first traversal for each vertex v in the graph containing n vertices
     * and determines if the size of the traversal starting at v is n.
     *
     * @return true if the graph is connected
     */
    public boolean isConnected() {
        // size of breadth first traversal
        int n;

        // perform a breadth first traversal for each vertex v
        for (int v = 0; v < numVertices; v++) {
            // create an iterator for this vertex
            Iterator<T> it = iteratorBFS(v);

            // initailize size of traversal to zero
            n = 0;

            // count the size of the breadth first traversal
            while (it.hasNext()) {
                it.next();
                n++;
            }

            // if size of traversal does not equal number of vertices
            // for this vertex return false and method ends
            if (n != numVertices) {
                return false;
            }
        }

        // if we've reached this point, the graph is connected so
        // return true
        return true;
    }

    /**
     * Returns the index value of the first occurrence of the vertex. Returns -1 if
     * the key is not found.
     *
     * @param vertex the vertex whose index value is being sought
     * @return the index value of the given vertex
     */
    public int getIndex(T vertex) {
        int found = -1; // -1 means not found
        int index = 0; // index counter

        // loop through vertices array while vertex is not found and index
        // is less than number of verticies in array
        while (found == -1 && index < numVertices) {
            // compare element in vertices to vertex passed to method
            if (vertices[index].equals(vertex))
                found = index;

            // increment index
            index++;
        }

        return found;
    }

    /**
     * Returns true if the given index is valid.
     *
     * @param index the index whose validity is being queried
     * @return true if the given index is valid
     */
    protected boolean indexIsValid(int index) {
        // determine if index within valid bounds
        return (index >= 0) && (index <= numVertices);
    }

    /**
     * Returns a copy of the vertices array.
     *
     * @return a copy of the vertices array
     */
    public Object[] getVertices() {
        // uses Arrays to return a copy
        return Arrays.copyOf(vertices, vertices.length);
    }

    /**
     * Returns a string representation of the adjacency matrix.
     *
     * @return a string representation of the adjacency matrix
     */
    public String toString() {
        if (numVertices == 0)
            return "Graph is empty";

        String result = "Adjacency Matrix\n";
        result += "----------------\n";
        result += "index\t";

        for (int i = 0; i < numVertices; i++) {
            result += "" + i;
            if (i < 10)
                result += " ";
        }
        result += "\n\n";

        for (int i = 0; i < numVertices; i++) {
            result += "" + i + "\t";

            for (int j = 0; j < numVertices; j++) {
                if (adjMatrix[i][j])
                    result += "1 ";
                else
                    result += "0 ";
            }
            result += "\n";
        }

        result += "\n\nVertex Values";
        result += "\n-------------\n";
        result += "index\tvalue\n\n";

        for (int i = 0; i < numVertices; i++) {
            result += "" + i + "\t";
            result += vertices[i].toString() + "\n";
        }
        result += "\n";
        return result;
    }

    /**
     * Inner class to represent an iterator over the elements of this graph
     */
    protected class GraphIterator implements Iterator<T> {
        private int expectedModCount;
        private Iterator<T> iter;

        /**
         * Sets up this iterator using the specified iterator.
         *
         * @param iter the list iterator created by a graph traversal
         */
        public GraphIterator(Iterator<T> iter) {
            this.iter = iter;
            expectedModCount = modCount;
        }

        /**
         * Returns true if this iterator has at least one more element to deliver in the
         * iteration.
         *
         * @return true if this iterator has at least one more element to deliver in the
         *         iteration
         * @throws ConcurrentModificationException if the collection has changed while
         *                                         the iterator is in use
         */
        public boolean hasNext() throws ConcurrentModificationException {
            if (!(modCount == expectedModCount))
                throw new ConcurrentModificationException();

            return (iter.hasNext());
        }

        /**
         * Returns the next element in the iteration. If there are no more elements in
         * this iteration, a NoSuchElementException is thrown.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iterator is empty
         */
        public T next() throws NoSuchElementException {
            if (hasNext())
                return (iter.next());
            else
                throw new NoSuchElementException();
        }

        /**
         * The remove operation is not supported.
         * 
         * @throws UnsupportedOperationException if the remove operation is called
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Inner class to represent an iterator over the indexes of this graph
     */
    protected class GraphIndexIterator implements Iterator<Integer> {
        private int expectedModCount;
        private Iterator<Integer> iter;

        /**
         * Sets up this iterator using the specified iterator.
         *
         * @param iter the list iterator created by a graph traversal
         */
        public GraphIndexIterator(Iterator<Integer> iter) {
            this.iter = iter;
            expectedModCount = modCount;
        }

        /**
         * Returns true if this iterator has at least one more element to deliver in the
         * iteration.
         *
         * @return true if this iterator has at least one more element to deliver in the
         *         iteration
         * @throws ConcurrentModificationException if the collection has changed while
         *                                         the iterator is in use
         */
        public boolean hasNext() throws ConcurrentModificationException {
            if (!(modCount == expectedModCount))
                throw new ConcurrentModificationException();

            return (iter.hasNext());
        }

        /**
         * Returns the next element in the iteration. If there are no more elements in
         * this iteration, a NoSuchElementException is thrown.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iterator is empty
         */
        public Integer next() throws NoSuchElementException {
            if (hasNext())
                return (iter.next());
            else
                throw new NoSuchElementException();
        }

        /**
         * The remove operation is not supported.
         * 
         * @throws UnsupportedOperationException if the remove operation is called
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}