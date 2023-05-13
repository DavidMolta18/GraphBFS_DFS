package Structures;

import java.util.*;

public class Vertex<T> {

   ArrayList<Vertex<T>> adj;
    T value;
    boolean visited;

    int distance;
    Vertex<T> pred;
    public Vertex(T value){
        this.value=value;
        adj = new ArrayList<>();
        visited = false;
         pred = null;
        distance =0;

    }

    public List<Vertex<T>> getAdj() {
        return adj;
    }
    public T getValue() {
        return value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setAdj(ArrayList<Vertex<T>> adj) {
        this.adj = adj;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Vertex<T> getPred() {
        return pred;
    }

    public void setPred(Vertex<T> pred) {
        this.pred = pred;
    }
}
