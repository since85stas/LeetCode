package yandAlgh.sprint6;

import java.io.*;
import java.util.*;

/**
 * Задача идиентична нахождению маскимального остовного дерева для графа.
 * Добавляем вершину начиная с любой, все соседние грани добавляем в приоритетную очередь.
 * Далее пока не закончатся грани или не добавим все вершины повтаряем добавление.
 * <p>
 * сложность алгоритма O(E*log(V))
 * <p>
 * успешная посылка https://contest.yandex.ru/contest/23815/run-report/49289745/
 */
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

            // отсекаем петли
            if (u != v) {
                graph.addEdge(u-1, v-1, w);
            }
        }

        MaxST st = new MaxST(graph);

    }

    // класс для нахождения Максимального остовного дерева
    private static class MaxST {

        // отмечаем посещенные вершины
        boolean[] visited;

        EdgeWeightedGraph G;

        // приоритетная очередь для эффективного получения следующего ребра максимального веса
        PriorityQueue<Edge> queue = new PriorityQueue<>();

        // счетчик для добавленных в остов вершин
        int countV = 0;

        // сумма граней
        long sum;

        public MaxST(EdgeWeightedGraph G) {
            this.G = G;
            visited = new boolean[G.V];

            addVertex(0);

            // пока или не добавим все вершины или не останется соседних граней добавляем вершины в остов
            while (countV <= G.V && !queue.isEmpty()) {
                Edge max = queue.poll();

                if (!visited[max.w]) {
                    sum = sum + max.weight;
                    addVertex(max.w);
                }
            }

            // если добавлены все значит остов существует
            if (countV == G.V) System.out.println(sum);
            else System.out.println("Oops! I did it again");
        }

        /**
         * Добавляем вершину в остов, отмечаем что она посещена, и добавляем соседние грани в очередь
         * @param target
         */
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

    // класс для определения графа
    public static class EdgeWeightedGraph
    {
        // число вершин
        private final int V;

        // граф задаем матрицей связанности
        int[][] matr;

        public EdgeWeightedGraph(int V)
        {
            this.V = V;
            matr = new int[V][V];
        }

        /**
         * При добавлении проверяем, что такого ребра еще не было если было то сравниваем
         * и берем максимальное по весу
         * @param u - номер начала
         * @param v - номер конца
         * @param w - вес ребра
         */
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

    }

    // класс для ребра, для работы с PriorityQueue - определяем компаратор по весу
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

        @Override
        public int compareTo(Edge edge) {
            return Integer.compare(edge.weight, this.weight);
        }
    }

}