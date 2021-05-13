package yandAlgh.sprint6;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class LinkComponents {

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

        FindComponents paths = new FindComponents(graph);
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for (int i = 1; i < paths.color.length; i++) {
            int col = paths.color[i];

            if (map.containsKey(col)) {
                map.get(col).add(i);
            } else {
                map.put(col, new TreeSet<>());
                map.get(col).add(i);
            }
        }


        StringBuilder builder = new StringBuilder();
        builder.append(map.size()).append("\n");
        for (TreeSet<Integer> comp:
             map.values()) {
            for (Integer color:
                 comp) {
                builder.append(color).append(" ");
            }
            builder.append("\n");
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
            adj[w].add(v);
        }

        public Iterable<Integer> adj(int v)
        { return adj[v]; }

    }

    static class FindComponents
    {
        private int[] color;
        private int[] edgeTo;
        private int s;

        private int colorCount = 1;

        public FindComponents(Graph G)
        {
            color = new int[G.V+1];
            for (int i = 0; i < color.length; i++) {
                color[i] = -1;
            }

            for (int i = 1; i < G.V+1; i++) {
                if (color[i] == -1)  {
                    dfs(G, i);
                    colorCount++;
                }
            }
        }

        private void dfs(Graph G, int v)
        {
            color[v] = colorCount;

            for (int w : G.adj(v))
                if (color[w] == -1)
                {
                    dfs(G, w);
                }
        }

    }

}
