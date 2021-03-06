package yandAlgh.sprint4;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
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

//        int max = Integer.MAX_VALUE;

        HashMap<ExitAndCoord, Boolean> map= new HashMap<>();

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            Coord coord = new Coord(Integer.parseInt(tokenizer.nextToken()),Integer.parseInt(tokenizer.nextToken()) );
//            stops[i] = new BusStop(coord);
            for (Exit ex:
                 exits) {
                ExitAndCoord exitAndCoord = new ExitAndCoord(ex, coord);
                if (map.containsKey(exitAndCoord)) {
                    boolean in = map.get(exitAndCoord);
                    if (in) ex.busses++;
                } else {
                    boolean in = coord.isInRadius(ex.coord);
                    map.put(exitAndCoord, in);
                    if (in) {
                        ex.busses++;
                    }
                }
            }
        }

//        Arrays.sort(exits);

        int max = Integer.MIN_VALUE;
        int idM = Integer.MIN_VALUE;
        for (Exit ex:
             exits) {
            if (ex.busses > max) {
                max = ex.busses;
                idM = ex.id + 1;
            }
        }

        System.out.println(idM);
    }

    static class Coord {
        int x;
        int y;

        public Coord(int x,int y) {
            this.x = x;
            this.y = y;
        }

        long getDist(Coord other) {
            long x2 = (x-other.x)*(x-other.x);
            long y2 = (y-other.y)*(y-other.y);
            long d = x2 + y2;
            return d;
        }

        boolean isInRadius(Coord other) {
            long dx = x-other.x;
            long dy = y-other.y;
            long x2 = dx*dx;
            long y2 = dy*dy;
            if (x2 > 400 || dy > 400) {
                return false;
            }
            else {
                long d = x2 + y2;
                if (d <= 400) {
                    return true;
                } else {
                    return false;
                }
            }
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

    static class ExitAndCoord {
        Exit exit;

        Coord coord;

        ExitAndCoord(Exit exit, Coord coord) {
            this.exit = exit;
            this.coord = coord;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ExitAndCoord)) return false;
            ExitAndCoord that = (ExitAndCoord) o;
            return Objects.equals(exit, that.exit) &&
                    Objects.equals(coord, that.coord);
        }

        @Override
        public int hashCode() {
            return Objects.hash(exit, coord);
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
