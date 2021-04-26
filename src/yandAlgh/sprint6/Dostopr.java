package yandAlgh.sprint6;

import java.util.ArrayList;
import java.util.List;

public class Dostopr {


    public class EdgeWeightedDigraph
    {
        private final int V;
        private final List<DirectedEdge>[] adj;
        public EdgeWeightedDigraph(int V)
        {
            this.V = V;
            adj =  new ArrayList[V];
            for (int v = 0; v < V; v++)
                adj[v] = new ArrayList<DirectedEdge>() {
                };
        }
        public void addEdge(DirectedEdge e)
        {
            int v = e.from();
            adj[v].add(e);
        }
        public Iterable<DirectedEdge> adj(int v)
        { return adj[v]; }
    }

    public class DirectedEdge
    {
        private final int v, w;

        private final int weight;

        public DirectedEdge(int v, int w, int weight)
        {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }
        public int from(

        )
        { return v; }
        public int to()
        { return w; }

        public int weight()
        { return weight; }
    }

}
