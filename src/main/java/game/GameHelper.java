package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class GameHelper {
    private static final String alphabet = "abcdefg";
    private int gridLength = 7;
    private int gridSize = 49;
    private int[] grid = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) {
                return null;
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase(Locale.ROOT);
    }

    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<String>();
        String[] alphacoords = new String[comSize];// Хранит координаты типа f6
        String temp = null;                     // Временная строка для конкатенации
        int[] coords = new int[comSize];       // Координаты текущего "сайта"
        int attempts = 0;                       // Счетчик текущих попыток
        boolean success = false;                // Нашли подходящее местоположение?
        int location = 0;                       // Текущее начальное местоположение
        comCount++;                             // Энный "сайт" для размещения
        int incr = 1;                           // Устанавливаем горизонтальный инкремент
        if ((comCount % 2) == 1) {              // Если нечетный (размещаем вертикально)
            incr = gridLength;                  // Устанавливаем вертикальный инкремент
        }

        while (!success & attempts++ < 200) {               // Главный поисковый цикл (32)
            location = (int) (Math.random() * gridSize);    // Получаем случайную стартовую точку
            System.out.println("лре-буем " + location);
            int x = 0;                          // Энная позиция в "сайте", который нужно разместить
            success = true;                     // Предполагаем успешный исход
            while (success && x < comSize) {    // Ищем соседнюю неиспользован ячейку
                if (grid[location] == 0) {      // Если еще не используется
                    coords[x++] = location;     // Сохраняем местоположение
                    location += incr;           // Пробуем "следующую" соседнюю ячейку
                    if (location >= gridSize) { // Вышли за рамки - низ
                        success = false;        // Неудача
                    }
                    if (x > 0 && (location % gridLength == 0)) {    // Вышли за рамки - правый край
                        success = false;                            // Неудача
                    }
                } else {                                            // Нашли уже использующееся местоположение
                    // System.out.print("используется"+ location)
                    success = false;                                // Неудача
                }
            }
        }                                                           // Конец while
        int x = 0;                  // Переводим местоположение в символьные координаты
        int row = 0;
        int column = 0;
//        System.out.println("\n") ;
        while (x < comSize) {
            grid[coords[x]] = 1;                    // Помечаем ячейки на главной сетке как "использованные"
            row = (int) (coords[x] / gridLength);   // Получаем значение строки
            column = coords[x] % gridLength;        // Получаем числовое значение столбца
            temp = String.valueOf(alphabet.charAt(column)); // Преобразуем его в строковый символ
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            System.out.println(Arrays.toString(coords) + "+" + alphaCells.get(x - 1));
        }
        System.out.println();
        return alphaCells;
    }
}

