package yandAlgh.sprint6;

import java.io.*;
import java.util.*;

public class MaxOstov {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        EdgeWeightedGraph graph = new EdgeWeightedGraph(n);

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());

            if (u != v) {
                Edge edge = new Edge(u, v, w);
                graph.addEdge(edge);

//                Edge edger = new Edge(v, u, w);
//                graph.addEdge(edger);
            }
        }

        StringBuilder builder = new StringBuilder();
        System.out.println(builder.toString());
    }

    private static class MaxST {

        HashSet<Edge> added;

        EdgeWeightedGraph G;

        public MaxST(EdgeWeightedGraph G) {
            this.G = G;
            added = new HashSet<>();
        }

        public void addVertex(Edge e) {

        }
    }

    public static class EdgeWeightedGraph
    {
        private final int V;

        private final List<Edge>[] adj;

        HashSet<Edge> addedEdges = new HashSet<>();

        int countEdg = 0;

        public EdgeWeightedGraph(int V)
        {
            this.V = V;
            adj = (List<Edge>[]) new ArrayList[V];
            for (int v = 0; v < V; v++)
                adj[v] = new ArrayList<>();
        }

        public void addEdge(Edge e)
        {
            if (!addedEdges.contains(e)) {
                int v = e.from();
                adj[v].add(e);

                Edge rev = e.reverse();

                adj[rev.v].add(rev);

                countEdg = countEdg + 1;
            }
        }


        public Iterable<Edge> adj(int v)
        { return adj[v]; }
    }

    public static class Edge
    {
        private final int v, w;
        private final int weight;
        public Edge(int v, int w, int weight)
        {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }
        public int from()
        { return v; }
        public int to()
        { return w; }

        public int weight()
        { return weight; }

        Edge reverse() {
            return new Edge(w,v,weight);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Edge)) return false;
            Edge edge = (Edge) o;
            return v == edge.v &&
                    w == edge.w &&
                    weight == edge.weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(v, w);
        }
    }

}




