package yandAlgh.sprint2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Идея простая, храним ссылки на последний и первый элемент. Дальше либо убираем либо добавляем с нужного конца
 *
 * сложность всех операций O(1)
 *
 * успешная посылка https://contest.yandex.ru/contest/22781/run-report/48725816/
 */
public class Deck {
    // ссылка на первый элемент в деке
    private static Node first;

    // ссылка на последний элемент в деке
    private static Node last;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        short n = Short.parseShort(tokenizerStr.nextToken());
        tokenizerStr = new StringTokenizer(reader.readLine());

        // максимальный размер дека
        short sizeMax = Short.parseShort(tokenizerStr.nextToken());

        // переменая хранящая текущий размер дека
        short size = 0;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            tokenizerStr = new StringTokenizer(reader.readLine());
            String command = tokenizerStr.nextToken();
            if (command.equals("push_back")) {
                short val = Short.parseShort(tokenizerStr.nextToken());
                // если еще не заполнен то добавляем, иначе ошибка
                if (size < sizeMax) {
                    // если дек пустой то при добавлении первый и послед элемент будут одинаковыми
                    if (isEmpty()) {
                        Node node = new Node(val, null, null);
                        first = node;
                        last = node;

                        // размер увеличиваем на 1
                        size++;
                    } else {
                        // если не пустой то добавляем с конца элемент
                        Node node = new Node(val, last, null);
                        last.prev = node;
                        last = node;

                        // размер увеличиваем на 1
                        size++;
                    }
                } else {
                    builder.append("error\n");
                }
            } else if (command.equals("push_front")) {
                short val = Short.parseShort(tokenizerStr.nextToken());
                // если еще не заполнен то добавляем, иначе ошибка
                if (size < sizeMax) {
                    // если дек пустой то при добавлении первый и послед элемент будут одинаковыми
                    if (isEmpty()) {
                        Node node = new Node(val, null, null);
                        first = node;
                        last = node;

                        // размер увеличиваем на 1
                        size++;
                    } else {
                        // если не пустой то добавляем элемент с начала
                        Node node = new Node(val, null, first);
                        first.next = node;
                        first = node;

                        // размер увеличиваем на 1
                        size++;
                    }
                } else {
                    builder.append("error\n");
                }
            } else if (command.equals("pop_back")) {
                // если не пустой то убираем, иначе ошибка
                if (size > 0) {
                    // если убираем последний элемент то обнуляем обе ссылки - дек пуст
                    if (size == 1) {
                        builder.append(last.val + "\n");
                        first = null;
                        last = null;

                        // размер уиеньшаем на 1
                        size--;
                    } else if (size == 2) {
                        // если убираем предпоследний элемент конец и начало должны показывать на последний элемент
                        builder.append(last.val + "\n");
                        last = last.next;
                        first = last;

                        // размер уиеньшаем на 1
                        size--;
                    } else {
                        // в противном случае просто убираем элемент с конца
                        builder.append(last.val + "\n");
                        last = last.next;

                        // размер уиеньшаем на 1
                        size--;
                    }
                } else {
                    builder.append("error\n");
                }
            } else if (command.equals("pop_front")) {
                if (size > 0) {
                    // если убираем последний элемент то обнуляем обе ссылки - дек пуст
                    if (size == 1) {
                        builder.append(first.val + "\n");
                        first = null;
                        last = null;

                        // размер уиеньшаем на 1
                        size--;
                    } else if (size == 2) {
                        // если убираем предпоследний элемент конец и начало должны показывать на последний элемент
                        builder.append(first.val + "\n");
                        first = first.prev;
                        last = first;

                        // размер уиеньшаем на 1
                        size--;
                    } else {
                        // в противном случае просто убираем элемент с начала
                        builder.append(first.val + "\n");
                        first = first.prev;

                        // размер уиеньшаем на 1
                        size--;
                    }
                } else {
                    builder.append("error\n");
                }
            }
        }
        System.out.println(builder.toString().trim());
    }

    /**
     * вспомогательная функция, если обе ссылки null значит что дек пуст
     */
    private static boolean isEmpty() {
        return first==null && last == null;
    }

    /**
     * вспомогательный класс, каждый элемент хранит ссылку на предыдущий, следующий и свое значение
     */
    private static class Node {

        private short val;

        private Node next;

        private Node prev;

        public Node(short val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

    }

}
