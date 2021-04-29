package yandAlgh.sprint6;

import java.io.*;
import java.util.*;

public class RailWays {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

        Graph graph = new Graph(n);

        for (int i = 1; i < n; i++) {
            String readStr = reader.readLine();
            for (int j = 1; j < readStr.length()+1; j++) {
                char curC = readStr.charAt(j-1);
                if (curC == 'B') {
//                    Edge edge = new Edge(i, i+j);
                    graph.adj[i].add(i+j);
                } else {
//                    Edge edge = new Edge(i+j, i);
                    graph.adj[i+j].add(i);
                }
            }
        }

        IsGraphValid validator = new IsGraphValid(graph);

        if (validator.hasCycle) System.out.println("NO");
        else System.out.println("YES");
    }

    static class IsGraphValid {

        TreeSet<Integer> graySet = new TreeSet<>();
        TreeSet<Integer> blackSet = new TreeSet<>();

        boolean hasCycle;

        public IsGraphValid(Graph g) {
            while (!g.whiteSet.isEmpty()) {
                Integer start = g.whiteSet.first();
                boolean cycle = dfs(g, start);
                if (cycle) {
                    hasCycle = true;
                    break;
                }
            }
        }

        private boolean dfs(Graph g, int v) {
            g.whiteSet.remove(v);
            graySet.add(v);
            for (Integer w:
                 g.adj[v]) {
                if (blackSet.contains(w)) {
                    continue;
                }
                if (graySet.contains(w)) {
                    return true;
                }
                if (dfs(g,w)) {
                    return true;
                }
            }
            graySet.remove(v);
            blackSet.add(v);
            return false;
        }

    }

    static class Graph
    {
        private final int V;

//        private final HashSet<Edge> addedEdge;

        private final List<Integer>[] adj;

        TreeSet<Integer> whiteSet = new TreeSet<>();

        int countEdge = 0;

        public Graph(int V)
        {
            this.V = V;
            adj =  new ArrayList[V+1];
            for (int v = 1; v < V+1; v++) {
                adj[v] = new ArrayList<Integer>(5000);
                whiteSet.add(v);
            }
        }

        public void addEdge(int v, int w)
        {
//            Edge pr = new Edge(v,w);
            adj[v].add(w);
        }

    }

}
