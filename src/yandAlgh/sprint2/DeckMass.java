package yandAlgh.sprint2;

import java.io.*;
import java.util.StringTokenizer;

public class DeckMass {

    /**
     * Идея простая, храним номера последнего и первого элемента. Дальше либо убираем либо добавляем с нужного конца
     * <p>
     * сложность всех операций O(1)
     * <p>
     * успешная посылка https://contest.yandex.ru/contest/22781/run-report/48893580/
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        StringTokenizer tokenizerStr = new StringTokenizer(reader.readLine());
        short n = Short.parseShort(tokenizerStr.nextToken());
        tokenizerStr = new StringTokenizer(reader.readLine());

        // максимальный размер дека
        short sizeMax = Short.parseShort(tokenizerStr.nextToken());

        // переменая хранящая текущий размер дека
        short size = 0;

        // номер головы
        short head = 0;

        // номер хвоста
        short tail = 0;

        short[] massive = new short[sizeMax];

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            tokenizerStr = new StringTokenizer(reader.readLine());
            String command = tokenizerStr.nextToken();
            if (command.equals("push_back")) {
                short val = Short.parseShort(tokenizerStr.nextToken());
                // если еще не заполнен то добавляем, иначе ошибка
                if (size < sizeMax) {
                    // если хвост указывает на 0 то зацикливаемся иначе просто уменьшаем на 1
                    if (tail == 0) {
                        tail = (short) (sizeMax-1);
                    } else {
                        tail = (short) (tail-1);
                    }

                    massive[tail] = val;

                    // увеличиваепм размер и если это первый элемент то голова будет на нем же
                    size++;
                    if (size == 1) {
                        head = tail;
                    }
                } else {
                    builder.append("error\n");
                }
            } else if (command.equals("push_front")) {
                short val = Short.parseShort(tokenizerStr.nextToken());
                // если еще не заполнен то добавляем, иначе ошибка
                if (size < sizeMax) {
                    // если голова указывает на последний, то зацикливаемся иначе просто увеличиваем на 1
                    if (head == sizeMax-1) {
                        head = 0;
                    } else {
                        head = (short) (head+1);
                    }

                    massive[head] = val;

                    // увеличиваепм размер и если это первый элемент то хвост будет на нем же
                    size++;
                    if (size == 1) {
                        tail = head;
                    }

                } else {
                    builder.append("error\n");
                }
            } else if (command.equals("pop_back")) {
                // если не пустой то убираем, иначе ошибка
                if (size > 0) {
                    // берем элемент с хвоста
                    short val = massive[tail];
                    builder.append(val + "\n");

                    // если хвост указывает на последний, то зацикливаемся иначе просто увеличиваем на 1
                    if (tail == sizeMax-1) {
                        tail = 0;
                    } else {
                        tail++;
                    }
                    size--;
                } else {
                    builder.append("error\n");
                }
            } else if (command.equals("pop_front")) {
                // если не пустой то убираем, иначе ошибка
                if (size > 0) {
                    // берем элемент с головы
                    short val = massive[head];
                    builder.append(val + "\n");

                    // если голова указывает на 0 то зацикливаемся иначе просто уменьшаем на 1
                    if (head == 0) {
                        head = (short) (sizeMax-1);
                    } else {
                        head--;
                    }
                    size--;
                } else {
                    builder.append("error\n");
                }
            }
        }
        System.out.println(builder.toString().trim());
    }
}

