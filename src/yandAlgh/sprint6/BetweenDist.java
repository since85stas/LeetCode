package yandAlgh.sprint6;

import java.io.*;
import java.util.*;

public class BetweenDist {

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
        int end = Integer.parseInt(tokenizer.nextToken());

        BreedFirstPaths paths = new BreedFirstPaths(graph, start);

        StringBuilder builder = new StringBuilder();
//        while (!paths.path.isEmpty()) {
//            builder.append(paths.path.poll()).append(" ");
//        }
        int dist = paths.distance[end];
        if (!paths.marked[end]) System.out.println(-1);
        else System.out.println(dist);
//        System.out.println(Arrays.stream(paths.distance).max().getAsInt());

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

    static class BreedFirstPaths
    {
        private boolean[] marked;
        private int[] edgeTo;
        private int s;

        int[] distance;

        public Queue<Integer> path;

        public BreedFirstPaths(Graph G, int s)
        {
            path = new LinkedList<>();
            marked = new boolean[G.V+1];
            edgeTo = new int[G.V+1];
            distance = new int[G.V+1];
            bfs(G, s);
        }


        private void bfs(Graph G, int s)
        {
            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            path.add(s);
            marked[s] = true;
            while (!q.isEmpty())
            {
                int v = q.poll();
                for (int w : G.adj(v))
                {
                    if (!marked[w])
                    {
                        path.add(w);
                        q.add(w);
                        marked[w] = true;
                        edgeTo[w] = v;

                        distance[w] = distance[v] + 1;
                    }
                }
            }
        }

    }

}
