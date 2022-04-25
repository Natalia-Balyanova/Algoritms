package src.balyanova.lesson7;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        //testGraph();
        //testDfs();
        //testBfs();

        findShortWay();

    }

    private static void findShortWay() {
        GraphImpl cities = new GraphImpl(10);

        cities.addVertex("Москва");
        cities.addVertex("Тула");
        cities.addVertex("Липецк");
        cities.addVertex("Воронеж");
        cities.addVertex("Рязань");
        cities.addVertex("Тамбов");
        cities.addVertex("Саратов");
        cities.addVertex("Калуга");
        cities.addVertex("Орел");
        cities.addVertex("Курск");

        cities.addEdge("Москва", "Тула", 184);
        cities.addEdge("Тула", "Липецк", 295);
        cities.addEdge("Липецк", "Воронеж", 134);//613

        cities.addEdge("Москва", "Рязань", 201);
        cities.addEdge("Рязань", "Тамбов", 291);
        cities.addEdge("Тамбов", "Саратов", 384);
        cities.addEdge("Саратов", "Воронеж", 516);//1392

        cities.addEdge("Москва", "Калуга", 160);
        cities.addEdge("Калуга", "Орел", 210);
        cities.addEdge("Орел", "Курск", 172);
        cities.addEdge("Курск", "Воронеж", 222);//764

        System.out.println("Size of graph is " + cities.getSize());
        cities.display();
        System.out.println(cities.findShortWay("Москва", "Воронеж"));//Москва Тула Липецк Воронеж Самый короткий путь = 613
    }

//    private static void testBfs() {
//        Graph graph = new GraphImpl(8);
//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//        graph.addVertex("E");
//        graph.addVertex("F");
//        graph.addVertex("G");
//        graph.addVertex("H");
//
//        graph.addEdge("A", "B", "C", "D");
//        graph.addEdge("B", "E");
//        graph.addEdge("E", "H");
//        graph.addEdge("C", "F");
//        graph.addEdge("D", "G");
//
//        graph.bfs("A");
//    }

//    private static void testDfs() {
//        Graph graph = new GraphImpl(7);
//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//        graph.addVertex("E");
//        graph.addVertex("F");
//        graph.addVertex("G");
//
//        graph.addEdge("A", "B", "C", "D");
//        graph.addEdge("B", "E");
//        graph.addEdge("D", "F");
//        graph.addEdge("F", "G");
//
//        graph.dfs("A");
//    }

//    private static void testGraph() {
//        Graph graph = new GraphImpl(7);
//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//
//        graph.addEdge("A", "B", "C");
//        graph.addEdge("B", "C", "D");
//        graph.addEdge("C", "A", "B", "D");
//        graph.addEdge("D", "B", "C");
//
//        System.out.println("Size og graph is " + graph.getSize());
//        graph.display();
//
//    }
}
