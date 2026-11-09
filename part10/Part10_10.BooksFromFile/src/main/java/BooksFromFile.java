
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.lines;

public class BooksFromFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

    }

    public static List<Book> readBooks(String file) {
        try (var lines = Files.lines(Path.of(file))) {
            return lines
                    .map(String::trim)
                    .map(line -> line.split("\\s*,\\s*"))
                    .filter(parts -> parts.length >= 4)
                    .map(BooksFromFile::toBook)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Book toBook(String[] parts) {
        return new Book(
                parts[0],
                Integer.parseInt(parts[1]),
                Integer.parseInt(parts[2]),
                parts[3]
        );
    }

}
