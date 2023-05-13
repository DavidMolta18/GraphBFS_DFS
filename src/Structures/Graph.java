package Structures;

import java.util.*;

public class Graph<T> implements IGraph<T>{

    ArrayList<Vertex<T>> vertex;

    public ArrayList<Vertex<T>> getVertex() {
        return vertex;
    }

    public Graph(){
        vertex = new ArrayList<>();
    }
    @Override
    public void addVertex(Vertex<T> value) {
        if(!vertex.contains(value))vertex.add(value);




    }

    @Override
    public String addEdge(Vertex<T> principal, Vertex<T> destination, boolean bidirectional) {

            int indexPrincipal = searchIndex(principal);
            int indexValueDestination = searchIndex(destination);


            if(!vertex.contains(principal)){
                addVertex(principal);
                addEdge(principal,destination,bidirectional);
            }

            if(!vertex.contains(destination)){
                addVertex(destination);
                addEdge(principal,destination,bidirectional);
            }


            if(bidirectional){

                vertex.get(indexPrincipal).getAdj().add(vertex.get(indexValueDestination));
                vertex.get(indexValueDestination).getAdj().add((vertex.get(indexPrincipal)));

            }else{
                vertex.get(indexPrincipal).getAdj().add((vertex.get(indexValueDestination)));
            }



    return null;
    }
    public int searchIndex(Vertex<T> value) {

        int index=0;
        for (int i=0; i<vertex.size();i++){
            if(vertex.get(i)==value){
                index = i;
            }
        }
        return index;
    }



    @Override
    public String dfs(Vertex<T> start) {
        String msg="";
    Deque<Vertex<T>> stack = new LinkedList<>();
    stack.push(start);
    while(!stack.isEmpty()){
        Vertex<T> current = stack.pop();
        if(!current.isVisited()) {
            current.setVisited(true);
            System.out.println(current.getValue() + " " + current.isVisited());
            msg += current.getValue() + " ";
            Collections.reverse(current.getAdj());
            current.getAdj().forEach(stack::push);
        }
    }
    return msg;
    }

    @Override
    public String bfs(Vertex<T> start) {
        String msg ="";
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){

            Vertex<T> current = queue.poll();
            if(!current.isVisited()){
                current.setVisited(true);
                System.out.println(current.getValue() + " " + current.isVisited());
                msg += current.getValue() + " ";
                queue.addAll(current.getAdj());

            }

        }
        return msg;
    }

}




