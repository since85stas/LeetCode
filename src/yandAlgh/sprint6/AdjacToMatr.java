package yandAlgh.sprint6;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class AdjacToMatr {

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
            for (int j = 0; j < n+1; j++) {
                if (i != 0 && j != 0) {
                    if (digraph.contains(i,j)) {
                        builder.append(1);
                    } else {
                        builder.append(0);
                    }
                    builder.append(" ");
                }
            }
            if (i != 0) builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    static class Digraph
    {
        private final int V;

        private final List<Integer>[] adj;

        public Digraph(int V)
        {
            this.V = V;
            adj = new List[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new ArrayList<>();
                adj[v].add(0);
                for (int i = 0; i < V; i++) {
                    adj[v].add(null);
                }
            }
        }

        public void addEdge(int v, int w)
        {
            adj[v].set(w, 1);
        }

        public Iterable<Integer> adj(int v)
        { return adj[v]; }

//        public TreeSet<Integer> adjList(int v) {
//            return adj[v];
//        }

        public boolean contains(int v, int w) {
            if (adj[v] != null && adj[v].get(w) != null) {
                return true;
            } else {
                return false;
            }
        }
    }

}
