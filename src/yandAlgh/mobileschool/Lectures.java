package yandAlgh.mobileschool;

import java.io.*;
import java.util.*;

/**
 * Зависимости лекций можно представить в виде направленного графа, необходимо проверить связанный ли граф
 */
public class Lectures {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int p = Integer.parseInt(tokenizer.nextToken());

        Digraph digraph = new Digraph(n);

        boolean isCycle = false;
        for (int i = 0; i < p; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            boolean add = digraph.addEdge (Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
            if (!add) {
                isCycle = true;
                break;
            }
        }

        if (!isCycle) {
            boolean isOk = false;
            for (int i = 0; i < n; i++) {
                DirectedDFS search = new DirectedDFS(digraph, i);
                if (search.allVisited()) {
                    isOk = true;
                    break;
                }
            }

//        boolean[] visit = search.visited()
            if (isOk) System.out.println("YES");
            else System.out.println("NO");
        } else {
            System.out.println("NO");
        }

    }


    static class Digraph
    {
        private final int V;
        private final List<Integer>[] adj;

        // храним добавленные вершины, если они указывают друг на друга то пути быть не может
        private HashSet<Pair> edges;

        public Digraph(int V)
        {
            this.V = V;
            adj = new ArrayList[V];
            for (int v = 0; v < V; v++)
                adj[v] = new ArrayList<>();
            edges = new HashSet<>();
        }
        public boolean addEdge(int v, int w)
        {
            adj[v].add(w);
            Pair edge = new Pair(v,w);
            Pair opp = edge.isOpposite();
            if (edges.contains(opp)) {
                return false;
            } else {
                edges.add(edge);
                return true;
            }
        }
        public Iterable<Integer> adj(int v)
        { return adj[v]; }
    }

    static class DirectedDFS
    {
        private boolean[] marked;
        public DirectedDFS(Digraph G, int s)
        {
            marked = new boolean[G.V];
            dfs(G, s);
        }
        private void dfs(Digraph G, int v)
        {
            marked[v] = true;
            for (int w : G.adj(v))
                if (!marked[w]) dfs(G, w);
        }

        public boolean visited(int v)
        { return marked[v]; }

        public boolean allVisited() {
            boolean res = true;
            for (int i = 0; i < marked.length; i++) {
                res = res&&marked[i];
            }
            return res;
        }
    }

    static class Pair {
        int v;

        int w;

        Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }

        Pair isOpposite() {
            return new Pair(w,v);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return v == pair.v &&
                    w == pair.w;
        }

        @Override
        public int hashCode() {
            return Objects.hash(v, w);
        }
    }
}
