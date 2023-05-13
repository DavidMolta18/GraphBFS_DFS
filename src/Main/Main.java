package Main;

import Structures.Graph;
import Structures.Vertex;

import java.util.*;

public class Main {
    Graph<Integer> G = new Graph<>();
    public static void main(String[] args) {

    Main m = new Main();
    m.start();

    }

    private void start() {
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        Vertex<Integer> v6 = new Vertex<>(6);
        Vertex<Integer> v7 = new Vertex<>(7);


        G.addVertex(v0);
        G.addVertex(v1);
        G.addVertex(v2);
        G.addVertex(v3);
        G.addVertex(v4);
        G.addVertex(v5);
        G.addVertex(v7);

        G.addEdge(v0,v1,false);
        G.addEdge(v0,v5,false);
        G.addEdge(v0,v6,true);
        G.addEdge(v1,v3,false);
        G.addEdge(v1,v4,false);
        G.addEdge(v1,v5,false);
        G.addEdge(v4,v2,false);
        G.addEdge(v4,v6,false);


        System.out.println(G.dfs(v1));


    }
}