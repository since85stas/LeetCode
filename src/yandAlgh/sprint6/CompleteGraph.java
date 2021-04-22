package yandAlgh.sprint6;

import java.io.*;
import java.util.*;

public class CompleteGraph {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        Graph graph = new Graph(n);

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            if (u != v) {
                graph.addEdge(u, v);
            }
        }

        StringBuilder builder = new StringBuilder();
        if (graph.V* (graph.V-1)/2 == graph.countEdge) System.out.println("YES");
        else System.out.println("NO");
        System.out.println(builder.toString());
    }

    static class Graph
    {
        private final int V;

        private final TreeSet<Integer>[] adj;

        private final HashSet<Edge> addedEdge;

        int countEdge = 0;

        public Graph(int V)
        {
            this.V = V;
            adj = new TreeSet[V+1];
            addedEdge = new HashSet<>();
            for (int v = 1; v < V+1; v++) {
                adj[v] = new TreeSet<>();
            }
        }

        public void addEdge(int v, int w)
        {
            Edge pr = new Edge(v,w);
            Edge rev = new Edge(w,v);

            if (!addedEdge.contains(pr) || !addedEdge.contains(rev)) {
                adj[v].add(w);
                adj[w].add(v);

                addedEdge.add(pr);
                addedEdge.add(rev);

                countEdge = countEdge+1;
            }
        }

        public Iterable<Integer> adj(int v)
        { return adj[v]; }

    }

    public static class Edge
    {
        private final int v, w;

        public Edge(int v, int w)
        {
            this.v = v;
            this.w = w;
        }
        public int from(

        )
        { return v; }
        public int to()
        { return w; }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Edge)) return false;
            Edge edge = (Edge) o;
            return v == edge.v &&
                    w == edge.w;
        }

        @Override
        public int hashCode() {
            return Objects.hash(v, w);
        }
    }



}
