package Structures;

public interface IGraph<T> {

    public void addVertex(Vertex<T> value);
    public String addEdge(Vertex<T> valueToInsert,Vertex<T> destination, boolean bidirectional);

    public String bfs(Vertex<T> start);
    public String dfs(Vertex<T> start);
}
