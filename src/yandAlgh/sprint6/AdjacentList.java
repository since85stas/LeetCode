package yandAlgh.sprint6;

import java.io.*;
import java.util.*;

public class AdjacentList {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        short n = Short.parseShort(tokenizer.nextToken());
        short m = Short.parseShort(tokenizer.nextToken());

        Digraph digraph = new Digraph(n+1);

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            short u = Short.parseShort(tokenizer.nextToken());
            short v = Short.parseShort(tokenizer.nextToken());
            digraph.addEdge(u,v);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n+1; i++) {
            if (i != 0) {
                builder.append(digraph.adjList(i).size()).append(" ");
                for (Integer adj :
                        digraph.adjList(i)) {
                    builder.append(adj).append(" ");
                }
                builder.append("\n");
            }
        }
        System.out.println(builder.toString());
    }

    static class Digraph
    {
        private final int V;

        private final TreeSet<Integer>[] adj;

        public Digraph(int V)
        {
            this.V = V;
            adj = new TreeSet[V];
            for (int v = 0; v < V; v++)
                adj[v] = new TreeSet<>();
        }

        public void addEdge(int v, int w)
        {
            adj[v].add(w);
        }

        public Iterable<Integer> adj(int v)
        { return adj[v]; }

        public TreeSet<Integer> adjList(int v) {
            return adj[v];
        }
    }

}
