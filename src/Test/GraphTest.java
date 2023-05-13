package Test;
import Structures.Graph;
import Structures.Vertex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
public class GraphTest {
    @Test
    public void addVertexTest(){
        Graph<Integer> graph = new Graph<>();
        Vertex<Integer> v1 = new Vertex<>(1);
        graph.addVertex(v1);

        assertEquals(v1,graph.getVertex().get(0));
    }
    @Test
    public void addVertexTestAlreadyExists(){
        Graph<Integer> graph = new Graph<>();
        Vertex<Integer> v1 = new Vertex<>(1);
        graph.addVertex(v1);
        graph.addVertex(v1);

        assertEquals(1,graph.getVertex().size());
    }

    @Test
    public void addMoreThan1Vertex(){
        Graph<Integer> graph = new Graph<>();
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);

        assertEquals(5,graph.getVertex().size());
    }

    @Test
    public void testEdgesDirectional(){
        Graph<Integer> G = new Graph<>();
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        G.addVertex(v0);
        G.addVertex(v1);


        G.addEdge(v0,v1,false);


        assertEquals(v1,v0.getAdj().get(0));
        assertEquals(0,v1.getAdj().size());
        assertEquals(1,v0.getAdj().size());

    }
    @Test
    public void testEdgesBidirectional(){
        Graph<Integer> G = new Graph<>();
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        G.addVertex(v0);
        G.addVertex(v1);


        G.addEdge(v0,v1,true);


        assertEquals(v1,v0.getAdj().get(0));
        assertEquals(v0,v1.getAdj().get(0));
        assertEquals(1,v1.getAdj().size());
        assertEquals(1,v0.getAdj().size());

    }
    @Test
    public void testEdgesNoAddedVertex(){
        Graph<Integer> G = new Graph<>();
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(1);


        G.addEdge(v0,v1,true);
        G.addEdge(v2,v1,false);


        assertEquals(v0,v1.getAdj().get(0));

    }

    @Test
    public void searchIndexTest(){
        Graph<Integer> G = new Graph<>();
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(1);


        G.addVertex(v0);
        G.addVertex(v1);
        G.addVertex(v2);


        assertEquals(0,G.searchIndex(v0));

    }
    @Test
    public void searchIndexTest2(){
        Graph<Integer> G = new Graph<>();
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(1);


        G.addVertex(v0);
        G.addVertex(v1);
        G.addVertex(v2);


        assertEquals(1,G.searchIndex(v1));

    }
    @Test
    public void searchIndexTest3(){
        Graph<Integer> G = new Graph<>();
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(1);


        G.addVertex(v0);
        G.addVertex(v1);
        G.addVertex(v2);


        assertEquals(2,G.searchIndex(v2));

    }
    @Test
    public void testDFS1(){
        Graph<Integer> G = new Graph<>();
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

        String msg = G.dfs(v0);

        Assertions.assertEquals("0 1 3 4 2 6 5 ", msg);
    }
    @Test
    public void testDFS2(){
        Graph<Integer> G = new Graph<>();
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
        String msg = G.dfs(v1);
        Assertions.assertEquals("1 3 4 2 6 0 5 ", msg);

    }

    @Test
    public void testDFS3(){
        Graph<Integer> G = new Graph<>();
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
        G.addEdge(v4,v2,true);
        G.addEdge(v4,v6,false);
        String msg = G.dfs(v2);
        Assertions.assertEquals("2 4 6 0 1 3 5 ", msg);

    }
    @Test
    public void testBFS1(){
        Graph<Integer> G = new Graph<>();
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

        String msg = G.bfs(v0);

        Assertions.assertEquals("0 1 5 6 3 4 2 ", msg);
    }
    @Test
    public void testBFS2(){
        Graph<Integer> G = new Graph<>();
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
        String msg = G.bfs(v1);
        Assertions.assertEquals("1 3 4 5 2 6 0 ", msg);

    }

    @Test
    public void testBFS3(){
        Graph<Integer> G = new Graph<>();
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
        G.addEdge(v4,v2,true);
        G.addEdge(v4,v6,false);
        String msg = G.bfs(v2);
        Assertions.assertEquals("2 4 6 0 1 5 3 ", msg);

    }


}
