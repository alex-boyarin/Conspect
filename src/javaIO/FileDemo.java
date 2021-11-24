package javaIO;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Важное замечание с помощью методов класса File мы не можем получить никакого доступа внутрь файла, т.е
 * не прочитать инфу не записать. Но мы можем его удалить или создать, но создан будет уже пустой файл.
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("data" + File.separator + "in.txt");
        if (file.exists() && file.isFile()) {//file.exists-проверяет существует ли файл.
            //file.isFile-проверяет является ли он файлом (может быть файлом может быть дерикторией.
            System.out.println("path " + file.getPath());//получаем (Path-путь) к файлу.
            System.out.println("AbsolutePath " + file.getAbsolutePath());// получаем (AbsolutePath-абсолютный путь) к файлу
            System.out.println("size " + file.length()); //получаем размер.
            System.out.println("dir " + file.getParent());//родительская дериктория именно конкретного файла.
            file.delete();// файл может быть удален этим методом.
            try {
                file.createNewFile();// файл может быть создан по этой файловой переменной.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File dir = new File("data");
        if (dir.exists() && dir.isDirectory()) {//dir.(exists-существует) ли дериктория.
            //dir.isDirectory-Проверяет явл. ли дериктория дерикторией
            for (File current : dir.listFiles()) {//(current-текущий, поток)
                // Получаем весь список файлов дериктории и просто их перебераем.
                long millis = current.lastModified();//возвращает текущее время в милисекундах
                LocalDateTime data = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDateTime();
                //с помощью LocalDateTime data мы преобразуем millis во время для нашей зоны,
                // и в итоге получаем дату создания файла-лов.
                System.out.println(current.getPath() + "\t" + current.length() + "\t" + data);
            }
            File root = File.listRoots()[0];//получаем доспук к корневой дериктории компьютера
            System.out.printf("\n%s %,d from %,d  bytes", root.getPath(), root.getUsableSpace(), root.getTotalSpace());
        }
        try {
            dir.createNewFile();//root.getPath()-путь. root.getUsableSpace()-используемое пространство на диске.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//root.getTotalSpace())- все пространство на диске.
}
