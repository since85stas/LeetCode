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

        MaxST st = new MaxST(graph);

        StringBuilder builder = new StringBuilder();
        System.out.println(builder.toString());
    }

    private static class MaxST {

//        HashSet<Integer> notAdded;
        HashSet<Integer> added;

        EdgeWeightedGraph G;

        long sum;

        public MaxST(EdgeWeightedGraph G) {
            this.G = G;

            int v = 1;

            added = new HashSet<>();

            PriorityQueue<Edge> queue = new PriorityQueue<>();

            queue.addAll(G.adj[v]);

            while (!G.vert.isEmpty() && !queue.isEmpty()) {
//                G.vert.remove(v);

                Edge max = queue.poll();

                G.vert.remove(max.from());
                G.vert.remove(max.to());

//                queue.removeIf(it -> it.from() == max.from() && it.to() == max.to());

                sum = sum + max.weight;

                added.add(max.from());
                added.add(max.to());

                for (Edge e :
                        G.adj(max.to())) {
                    if ( !added.contains(e.to())) {
                        queue.add(e);
                    }
                }
            }

            if (added.size() == G.V) System.out.println(sum);
            else System.out.println("Oops! I did it again");
        }

        public void addVertex(Edge e) {

        }
    }

    public static class EdgeWeightedGraph
    {
        private final int V;

        private final List<Edge>[] adj;

//        TreeSet<Edge> addedEdges = new HashMap<>();
        HashSet<Integer> vert = new HashSet<>();

        int countEdg = 0;

        public EdgeWeightedGraph(int V)
        {
            this.V = V;
            adj = (List<Edge>[]) new List[V+1];
            for (int v = 1; v < V+1; v++) {
                adj[v] = new ArrayList<>();
                vert.add(v);
            }
        }

        public void addEdge(Edge e)
        {
                int v = e.from();
                adj[v].add(e);
                Edge rev = e.reverse();
                adj[rev.v].add(rev);
                countEdg = countEdg + 1;
        }


        public Iterable<Edge> adj(int v)
        { return adj[v]; }
    }

    public static class Edge implements Comparable<Edge>
    {
        private final int v, w;
        int weight;
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

        @Override
        public int compareTo(Edge edge) {
            return Integer.compare(edge.weight, this.weight);
        }
    }

}




