package yandAlgh.sprint6;

import java.io.*;
import java.util.*;

public class MaxOstov2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        EdgeWeightedGraph graph = new EdgeWeightedGraph(n);

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());

            if (u != v) {
                graph.addEdge(u-1, v-1, w);
            }
        }

        MaxST st = new MaxST(graph);

    }

    private static class MaxST {

        boolean[] visited;

        EdgeWeightedGraph G;

        PriorityQueue<Edge> queue = new PriorityQueue<>();

        int countV = 0;

        long sum;

        public MaxST(EdgeWeightedGraph G) {
            this.G = G;
            visited = new boolean[G.V];

            addVertex(0);

            while (countV <= G.V && !queue.isEmpty()) {
                Edge max = queue.poll();

                if (!visited[max.w]) {
                    sum = sum + max.weight;
                    addVertex(max.w);
                }
            }

            if (countV == G.V) System.out.println(sum);
            else System.out.println("Oops! I did it again");
        }

        public void addVertex(int target) {

            countV ++;

            visited[target] = true;

            for (int i = 0; i < G.matr[target].length; i++) {
                if (G.matr[target][i] > 0 && !visited[i] ) {
                    Edge edge = new Edge(target, i, G.matr[target][i]);
                    queue.add(edge);
                    G.matr[target][i] = 0;
                    G.matr[i][target] = 0;
                }
            }
        }
    }

    public static class EdgeWeightedGraph
    {
        private final int V;

        int[][] matr;

        public EdgeWeightedGraph(int V)
        {
            this.V = V;
            matr = new int[V][V];
        }

        public void addEdge(int u, int v, int w) {
            if (matr[u][v] == 0) {
                matr[u][v] = w;
                matr[v][u] = w;
            } else {
                if (matr[u][v] < w) {
                    matr[u][v] = w;
                    matr[v][u] = w;
                }
            }
        }


        public Iterable<Integer> adj(int v)
        { return null; }
    }

    public static class Edge implements Comparable<Edge>
    {
        private final int v, w;
        int weight;
        public Edge(int v, int w, int weight)
        {
            this.v = v;
            this.w = w;
            this.weight = weight;
        }

        public int from()
        { return v; }

        public int to()
        { return w; }

        public int weight()
        { return weight; }

        Edge reverse() {
            return new Edge(w,v,weight);
        }

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

        @Override
        public int compareTo(Edge edge) {
            return Integer.compare(edge.weight, this.weight);
        }
    }

}
