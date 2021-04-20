package yandAlgh.sprint6;

import java.io.*;
import java.util.*;

public class TimeToLeave {

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

            DepthFirstPaths paths = new DepthFirstPaths(graph, 1);

            StringBuilder builder = new StringBuilder();
            for (int i = 1; i < n+1; i++) {
                builder.append(paths.entry[i]).append(" ").append(paths.leave[i]).append("\n");
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

        static class DepthFirstPaths
        {
            private boolean[] marked;
            private int[] edgeTo;
            private int s;
            int[] entry;
            int[] leave;
            private int time = 0;

            public Queue<Integer> path;

            public DepthFirstPaths(Graph G, int s)
            {
                path = new LinkedList<>();
                marked = new boolean[G.V+1];
                edgeTo = new int[G.V+1];
                entry = new int[G.V+1];
                leave = new int[G.V+1];

                dfs(G, s);
            }

            private void dfs(Graph G, int v)
            {
                marked[v] = true;
                path.add(v);
                entry[v] = time;
                time++;
                for (int w : G.adj(v)) {
                    if (!marked[w]) {
                        dfs(G, w);
                        edgeTo[w] = v;
                    }
                }
                leave[v] = time;
                time++;

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
