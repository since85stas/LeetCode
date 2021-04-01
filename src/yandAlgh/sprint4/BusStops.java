package yandAlgh.sprint4;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class BusStops {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());

        Exit[] exits = new Exit[n];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            Coord coord = new Coord(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()) );
            exits[i] = new Exit(i, coord);
        }

        tokenizer = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(tokenizer.nextToken());

//        BusStop[] stops = new BusStop[n];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            Coord coord = new Coord(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()) );
//            stops[i] = new BusStop(coord);
            for (Exit ex:
                 exits) {
                if (coord.getDist(ex.coord) <= 20.0) {
                    ex.busses++;
                }
            }
        }

        Arrays.sort(exits);

        System.out.println(exits[0].id+1);
    }

    static class Coord {
        int x;
        int y;

        public Coord(int x,int y) {
            this.x = x;
            this.y = y;
        }

        long getDist(Coord other) {
            long d = ((x-other.x)*(x-other.x) + (y-other.y)*(y-other.y));
            return d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coord)) return false;
            Coord coord = (Coord) o;
            return x == coord.x &&
                    y == coord.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Exit implements Comparable<Exit>{
        int id;

        int busses = 0;

        Coord coord;

        public Exit(int id, Coord coord) {
            this.id = id;
            this.coord = coord;
        }

        @Override
        public int compareTo(Exit exit) {
            if (this.equals(exit)) return 0;
            if (busses > exit.busses) return -1;
            else if (busses < exit.busses) return 1;
            else {
                if (id < exit.id) return -1;
                else if (id > exit.id) return 1;
                return 0;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Exit)) return false;
            Exit exit = (Exit) o;
            return id == exit.id &&
                    busses == exit.busses &&
                    Objects.equals(coord, exit.coord);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, busses, coord);
        }
    }

    static class BusStop {
        Coord coord;

        public BusStop(Coord coord) {
            this.coord = coord;
        }

    }

}
