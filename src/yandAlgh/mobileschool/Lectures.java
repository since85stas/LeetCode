package yandAlgh.mobileschool;

import yandAlgh.sprint4.SumFour4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

public class Lectures {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int p = Integer.parseInt(tokenizer.nextToken());


        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            Pair pair =new Pair (Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
        }



    }


    public class Graph
    {
        private final int V;
        private final List<Integer>[] adj;
        public Graph(int V)
        {
            this.V = V;
            adj = new ArrayList<Integer>[V];
            for (int v = 0; v < V; v++)
                adj[v] = new Bag<Integer>();
        }
        public void addEdge(int v, int w)
        {
            adj[v].add(w);
            adj[w].add(v);
        }
        public Iterable<Integer> adj(int v)
        { return adj[v]; }
    }
}
