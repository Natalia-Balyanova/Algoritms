package src.balyanova.lesson7;

import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final int[][] adjMatrix; //для ДЗ
    //private final boolean[][] adjMatrix;
    private final boolean[][] visitedMatrix;

//    public GraphImpl(int maxVertexCount) {
//        this.vertexList = new ArrayList<>(maxVertexCount);
//        this.adjMatrix = new boolean[maxVertexCount][maxVertexCount];
//    }

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
        this.visitedMatrix = new boolean[2 * maxVertexCount][2 * maxVertexCount];
    }

    @Override
    public void addVertex(String label) {//добавление узла
        vertexList.add(new Vertex(label));
    }

//    @Override
//    public boolean addEdge(String startLabel, String secondLabel) {//добавление нового ребра
//        int startIndex = indexOf(startLabel);
//        int endIndex = indexOf(secondLabel);
//
//        if (startIndex == -1 || endIndex == -1) {
//            return false;
//        }
//
//        adjMatrix[startIndex][endIndex] = true; //либо вес
////        adjMatrix[endIndex][startIndex] = true; //в обратную сторону для двустороннего
//        return true;
//    }

    public boolean addEdge(String startLabel, String secondLabel, int distant) {//добавление нового ребра
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        if (distant < 0) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = distant; //либо вес
//        adjMatrix[endIndex][startIndex] = true; //в обратную сторону для двустороннего
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;// если ничего не нашлось
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);

        for (String other : others) {
            result &= addEdge(startLabel, other);
        }

        return result;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel) {
        return false;
    }

    public String findShortWay(String startLabel, String finishLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(finishLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("неверная вершина " + startLabel);
        }
        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        int currentWay = 0;
        int shortDistance = Integer.MAX_VALUE;

        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (startIndex == indexOf(startLabel)) {
                vertexList.get(endIndex).setIsVisited(false);
            }

            if (vertex != null) {
                visitVertex(stack, vertex);
                currentWay += adjMatrix[startIndex][indexOf(vertex.getLabel())];
                startIndex = indexOf(vertex.getLabel());
                if (vertex == vertexList.get(endIndex)) {
                    if (shortDistance > currentWay) {
                        shortDistance = currentWay;
                        System.out.println("Самый короткий путь = " + shortDistance);//выводим города и длину пути
                    }
                    currentWay = 0;
                }
            } else {
                stack.pop();
                startIndex = indexOf(startLabel);
            }
        }
        return "Расстояние самого короткого пути = " + shortDistance;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] > 0) {
                    sb.append(" -> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("неверная вершина " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex == null) {
                stack.pop();
            } else {
                visitVertex(stack, vertex);
            }
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);

        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] > 0 && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.push(vertex);
        vertex.setIsVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        queue.add(vertex);
        vertex.setIsVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("неверная вершина " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
    }
}