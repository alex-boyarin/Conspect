package io_ot_DMDEV;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Collectors;

/**
 * FileReader Им пользуется для чтения текстовых файлов
 */
public class ReaderRunner {
    public static void main(String[] args) throws IOException {
        File file = Path.of("data", "write2.txt").toFile();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String collect = bufferedReader.lines().collect(Collectors.joining("\n"));
            System.out.println(collect);
        }
    }
}
