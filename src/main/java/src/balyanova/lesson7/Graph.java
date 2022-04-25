package src.balyanova.lesson7;

public interface Graph {
    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, String... others); //в дз не будет
    boolean addEdge(String startLabel, String secondLabel);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel);

    /**
     * англ. breadth-first search, BFS
     */
    void bfs(String startLabel);
}
