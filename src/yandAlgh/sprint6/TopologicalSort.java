package yandAlgh.sprint6;

import java.io.*;
import java.util.*;

public class TopologicalSort {

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
            graph.addEdge(u,v);
        }

        TopologicalSearch paths = new TopologicalSearch(graph);

        StringBuilder builder = new StringBuilder();
        while (!paths.topol.isEmpty()) {
            builder.append(paths.topol.pop()).append(" ");
        }
        System.out.println(builder.toString());
    }

    static class Graph
    {
        private final int V;

        private final TreeSet<Integer>[] adj;

        public Graph(int V)
        {
            this.V = V;
            adj = new TreeSet[V+1];
            for (int v = 1; v < V+1; v++) {
                adj[v] = new TreeSet<>();
            }
        }

        public void addEdge(int v, int w)
        {
            adj[v].add(w);
        }

        public Iterable<Integer> adj(int v)
        { return adj[v]; }

    }

    static class TopologicalSearch
    {
        private byte[] color;
        private int[] edgeTo;
        private int s;

        public Stack<Integer> topol;

        public TopologicalSearch(Graph G)
        {
            topol = new Stack<>();
            color = new byte[G.V+1];
            for (int i = 1; i < G.V+1; i++) {
                if (color[i] == 0) topolog(G, i);
            }
        }

        private void topolog(Graph G, int v)
        {
            color[v] = 1;

            for (int w : G.adj(v))
                if (color[w] == 0)
                {
                    topolog(G, w);
                }
            color[v] = 2;
            topol.add(v);
        }

    }

}
