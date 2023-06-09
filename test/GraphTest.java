import structures.Graph;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class GraphTest {

    @Test
    public void addNewVertex() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        assertEquals(1, graph.getVertexCount());
    }

    @Test
    public void addMoreVertex() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        assertEquals(4, graph.getVertexCount());
    }

    @Test
    public void duplicatedVertex() {
        Graph<String> graph = new Graph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("A");
        assertEquals(3, graph.getVertexCount());
    }

    @Test
    public void newDirectedEdge() {
        Graph<String> graph = new Graph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 5, false);
        assertEquals(1, graph.getEdgesCount(false));
    }

    @Test
    public void newBidirectionalEdge() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(1, 2, 6, true);
        graph.addEdge(3, 1, 7, true);
        assertEquals(2, graph.getEdgesCount(true));
    }

    @Test
    public void BFSSimpleDirectedGraph() {
        Graph<String> graph = new Graph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addEdge("A", "B", 1, false);
        graph.addEdge("B", "C", 2, false);
        graph.addEdge("C", "D", 3, false);
        graph.addEdge("D", "A", 4, false);
        assertEquals("A B C D ", graph.bfs("A"));
    }

    @Test
    public void BFSUndirectedGraph() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addEdge(1, 2, 5, true);
        graph.addEdge(2, 3, 4, true);
        graph.addEdge(3, 4, 3, true);
        graph.addEdge(4, 1, 2, true);
        assertEquals("1 2 4 3 ", graph.bfs(1));
    }

    @Test
    public void BFSDisconnectedGraph() {
        Graph<Character> graph = new Graph<>();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addEdge('A', 'B', 2, false);
        graph.addEdge('B', 'C', 3, false);
        graph.addEdge('C', 'D', 4, false);
        assertEquals("E ", graph.bfs('E'));
    }

    @Test
    public void DFSSimpleDirectedGraph() {
        Graph<String> graph = new Graph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addEdge("A", "B", 5, false);
        graph.addEdge("B", "C", 8, false);
        graph.addEdge("C", "D", 9, false);
        graph.addEdge("D", "A", 2, false);
        assertEquals("A ", graph.dfs("A"));
    }

    @Test
    public void DFSSimpleUndirectedGraph() {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addEdge(1, 2, 5, true);
        graph.addEdge(2, 3, 4, true);
        graph.addEdge(3, 4, 3, true);
        graph.addEdge(4, 1, 2, true);
        assertEquals("1 ", graph.dfs(1));
    }

    @Test
    public void DFSDisconnectedGraph() {
        Graph<Character> graph = new Graph<>();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addEdge('A', 'B', 2, false);
        graph.addEdge('B', 'C', 3, false);
        graph.addEdge('C', 'D', 4, false);
        assertEquals("E ", graph.dfs('E'));
    }

    @Test
    public void testSimpleGraph() {
        Graph<String> graph = new Graph<>();
        graph.addEdge("A", "B", 2, true);
        graph.addEdge("A", "C", 4, true);
        graph.addEdge("B", "C", 1, true);
        graph.addEdge("B", "D", 5, true);
        graph.addEdge("C", "D", 3, true);

        Map<String, Object> result = graph.Dijkstra("A", "D");

        assertEquals(6, result.get("distance"));
        assertEquals(List.of("A", "B", "C", "D"), result.get("path"));
    }

    @Test
    void testFloydWarshallSingleEdge() {
        Graph<String> graph = new Graph<>();
        graph.addEdge("A", "B", 5, false);

        int[][] result = graph.floydWarshall();

        assertEquals(0, result[0][0]); // Distance from A to A
        assertEquals(5, result[0][1]); // Distance from A to B
        assertEquals(Integer.MAX_VALUE, result[1][0]); // Distance from B to A
        assertEquals(0, result[1][1]); // Distance from B to B
    }

    @Test
    void testFloydWarshallDisconnectedVertices() {
        Graph<String> graph = new Graph<>();
        graph.addEdge("A", "B", 5, false);
        graph.addEdge("C", "D", 10, false);

        int[][] result = graph.floydWarshall();

        assertEquals(0, result[0][0]); // Distance from A to A
        assertEquals(5, result[0][1]); // Distance from A to B
        assertEquals(0, result[1][1]); // Distance from B to B
        assertEquals(0, result[2][2]); // Distance from C to C
        assertEquals(10, result[2][3]); // Distance from C to D
        assertEquals(0, result[3][3]); // Distance from D to D
    }

    @Test
    void testFloydWarshallCompleteGraph() {
        Graph<String> graph = new Graph<>();
        graph.addEdge("A", "B", 5, false);
        graph.addEdge("A", "C", 3, false);
        graph.addEdge("B", "C", 1, false);
        graph.addEdge("B", "D", 7, false);
        graph.addEdge("C", "D", 2, false);

        int[][] result = graph.floydWarshall();

        assertEquals(0, result[0][0]); // Distance from A to A
        assertEquals(5, result[0][1]); // Distance from A to B
        assertEquals(3, result[0][2]); // Distance from A to C
        assertEquals(5, result[0][3]); // Distance from A to D
        assertEquals(0, result[1][1]); // Distance from B to B
        assertEquals(1, result[1][2]); // Distance from B to C
        assertEquals(3, result[1][3]); // Distance from B to D
        assertEquals(0, result[2][2]); // Distance from C to C
        assertEquals(2, result[2][3]); // Distance from C to D
        assertEquals(0, result[3][3]); // Distance from D to D
    }
}