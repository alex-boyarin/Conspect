package io_ot_DMDEV;

import java.io.File;
import java.io.IOException;

/**
 * output stream
 * application -----> file
 * input stream
 * application <----- file
 */
public class FileRunner {
    public static void main(String[] args) throws IOException {
        File file = new File("resources/test.txt");
        System.out.println(file.exists());// проверяет есть ли такой файл или нет (если false то файла нет)
        System.out.println(file.isFile());//проверяет является ли файл файлом
        System.out.println(file.isDirectory());//проверяет является ли файл дерикторией

        System.out.println(file.createNewFile());//метод создает новый файл
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.getName());//метод для получения имени файла
        System.out.println(file.getParent());//метод получение родителя файла
        // System.out.println( file.length());//размер файла
        // file.canExecute();/*метод связан с правами доступа
        // существуют всего 3 основных операции которые мы можем делать
        // с файлом. Это выполнять его canExecute() это какие-то скрипты
        // либо exe файлы которые запускают программы.*/
        /// file.canRead();//2-я операция это считывание.
        //file.canWrite();//3-я операция можем записывать в него.
        /* для того чтобы проверить возможности файла
        мы можем воспользоваться этими 3-мя методами.*/
        // file.compareTo(); метод сравнения двух файлов
        System.out.println(file.getAbsoluteFile());//получить абсолютный файл
        // file.delete();//удаление файла
        file.getAbsolutePath();//получить абсолютный путь
        File dir = new File("resource/test/dir");/*
        если файл представляет из себя не файл а дерикторию то
        при помощи метода mkdir() мы создадим эту дирректорию
        (если у нас дериктория находится внутри нескольких
        дерикторий то будет создан весь путь к нашей папке)*/
        //dir.mkdir();
        dir.mkdirs();/*метод создает несколько дерикторий
       //  (если у нас дериктория находится внутри нескольких
       // дерикторий то будет создан весь путь к нашей папке)*/
        // dir.list();/*мы можем взять список всех файлов которые
        //лежат в нашей дериктории*/
    }
}
