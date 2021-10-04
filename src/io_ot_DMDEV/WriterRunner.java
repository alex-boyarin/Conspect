package io_ot_DMDEV;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/*
 * У класса FileWriter нету метода newLine()  но он есть у класса BufferedWriter . Для этого
 * оборачиваем наш класс FileWriter классом BufferedWriter
 */
public class WriterRunner {
    public static void main(String[] args) throws IOException {
        File file = Path.of("resources", "writer.poem").toFile();
//        try (FileWriter fileWriter = new FileWriter(file, true)) {
//            fileWriter.append("Hello world!");
//            fileWriter.append("java");
//        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.append("Hello world!");
            bufferedWriter.newLine();
            bufferedWriter.append("java");
        }
    }
}
