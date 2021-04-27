package yandAlgh.sprint6;

import java.io.*;
import java.util.*;

public class RailWays {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        Graph graph = new Graph(n);

        for (int i = 1; i < m+1; i++) {
            String readStr = reader.readLine();
            for (int j = 1; j < readStr.length()+1; j++) {
                char curC = readStr.charAt(j-1);
                if (curC == 'B') {
                    Edge edge = new Edge(i, i+j, curC == 'B');
                    graph.adj[i].add(edge);
                } else {
                    Edge edge = new Edge(i, i+j, curC == 'B');
                    graph.adj[i].add(edge);
                }
            }
        }

        if (graph.V* (graph.V-1)/2 == graph.countEdge) System.out.println("YES");
        else System.out.println("NO");
    }

    static class Graph
    {
        private final int V;

//        private final HashSet<Edge> addedEdge;

        private final List<Edge>[] adj;

        int countEdge = 0;

        public Graph(int V)
        {
            this.V = V;
            adj =  new ArrayList[V+1];
            for (int v = 1; v < V+1; v++)
                adj[v] = new ArrayList<Edge>();
        }

        public void addEdge(int v, int w, boolean bType)
        {
            Edge pr = new Edge(v,w, bType);
            adj[v].add(pr);
        }

    }

    public static class Edge
    {
        private final int v, w;

        boolean bType;

        public Edge(int v, int w, boolean isBi)
        {
            this.v = v;
            this.w = w;
            this.bType = isBi;
        }
        public int from()
        { return v; }

        public int to()
        { return w; }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CompleteGraph.Edge)) return false;
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
