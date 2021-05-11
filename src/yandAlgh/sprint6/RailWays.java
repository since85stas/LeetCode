package yandAlgh.sprint6;

import java.io.*;
import java.util.*;

/**
 * Решение задачи идиентично проверке существует ли в графе цикл или нет. Ребра типа B- считаем прямыми
 * ребра типа R - обратные. Если цикла нет то сеть оптимальна.
 * Для нахождения цикла проходимся вглубину по всем вершинам и окрашиваем цвета. Если при проходе
 * встречается серая вершина, значит мы еще не закончили проход и следовательно существует цикл.
 * <p>
 * сложность алгоритма такая же как и прохода в глубину O(V*V) - квадрат числа вершин
 * <p>
 * успешная посылка https://contest.yandex.ru/contest/25070/run-report/51247319/
 */
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
                // при считывании считаем что ребра типа B прямые, а типа R - обратные
                if (curC == 'B') {
                    graph.adj[i].add(i+j);
                } else {
                    graph.adj[i+j].add(i);
                }
            }
        }

        IsGraphValid validator = new IsGraphValid(graph);

        if (validator.hasCycle) System.out.println("NO");
        else System.out.println("YES");
    }

    static class IsGraphValid {

        // массив хранения цветов
        byte[] colors;

        // хранит результат прохода
        boolean hasCycle;


        public IsGraphValid(Graph g) {

            colors = new byte[g.V+1];

            // проходим в глубину по всем вершинам начиная с первой, если находим цикл в графе, то можно прерывать проход
            while (!g.whiteSet.isEmpty()) {
                Integer start = g.whiteSet.first();
                boolean cycle = dfs(g, start);
                if (cycle) {
                    hasCycle = true;
                    break;
                }
            }
        }

        /**
         * Обычный рекурсивный проход в глубину с разметкой цветов. Если вершина белая красим в серый,
         * идем на соседнюю, если вдруг встретили серую значит есть цикл, по выходу красим в черный.
         * @param g - исследуемый граф
         * @param v - начальная вершина
         */
        private boolean dfs(Graph g, int v) {
            g.whiteSet.remove(v);
            colors[v] = 1;
            for (Integer w:
                 g.adj[v]) {
                if (colors[w] == 2) {
                    continue;
                }
                if (colors[w] == 1) {
                    return true;
                }
                if (dfs(g,w)) {
                    return true;
                }
            }
            colors[v] = 2;
            return false;
        }

    }

    // класс для опеределния графа
    static class Graph
    {
        // число вершин
        private final int V;

        // масиив со списком смежных ваершин
        private final List<Integer>[] adj;

        // набор вершин в графе, сразу объявляем для удобства заполнения
        TreeSet<Integer> whiteSet = new TreeSet<>();

        public Graph(int V)
        {
            this.V = V;
            adj =  new ArrayList[V+1];
            for (int v = 1; v < V+1; v++) {
                // так как скорее всего будет много граней сразу задаю начальное значение побольше
                adj[v] = new ArrayList<Integer>(5000);
                whiteSet.add(v);
            }
        }

        // добавляем грань
        public void addEdge(int v, int w)
        {
            adj[v].add(w);
        }

    }

}
