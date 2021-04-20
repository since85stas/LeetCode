package yandAlgh.sprint6;

import java.io.*;
import java.util.*;

public class DFSrec {

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

        tokenizer = new StringTokenizer(reader.readLine());
        int start = Integer.parseInt(tokenizer.nextToken());

        DepthFirstPaths paths = new DepthFirstPaths(graph, start);

        StringBuilder builder = new StringBuilder();
        while (!paths.path.isEmpty()) {
            builder.append(paths.path.poll()).append(" ");
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

//        public TreeSet<Integer> adjList(int v) {
//            return adj[v];
//        }
//
//        public boolean contains(int v, int w) {
//            if (adj[v] != null && adj[v].get(w) != null) {
//                return true;
//            } else {
//                return false;
//            }
//        }
    }

    static class DepthFirstPaths
    {
        private boolean[] marked;
        private int[] edgeTo;
        private int s;

        public Queue<Integer> path;

        public DepthFirstPaths(Graph G, int s)
        {
            path = new LinkedList<>();
            marked = new boolean[G.V+1];
            edgeTo = new int[G.V+1];
            dfs(G, s);
        }

        private void dfs(Graph G, int v)
        {
            marked[v] = true;
            path.add(v);
            for (int w : G.adj(v))
                if (!marked[w])
                {
                    dfs(G, w);
                    edgeTo[w] = v;
                }
        }

        public boolean hasPathTo(int v)
        { return marked[v]; }

        public Iterable<Integer> pathTo(int v)
        {
            if (!hasPathTo(v)) return null;
            Stack<Integer> path = new Stack<Integer>();
            for (int x = v; x != s; x = edgeTo[x])
                path.push(x);
            path.push(s);
            return path;
        }
    }

}
