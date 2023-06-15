package org.example.app.database;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.example.app.utils.Constants.PATH_MYSQL_CREDS;

public class PassReader {

    @SneakyThrows
    public static String readPass() {
        try {
            String fileName = "user_pass.txt";
            return Files.readString(Path.of(PATH_MYSQL_CREDS + fileName));
        } catch (Exception e) {
            System.out.println("File not found.");
            throw e;
        }
    }
}
