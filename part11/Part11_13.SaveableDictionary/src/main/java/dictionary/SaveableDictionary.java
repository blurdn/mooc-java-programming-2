package dictionary;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveableDictionary {
    private final Map<String, String> dictionary = new HashMap<>();
    private final Path filePath;

    private PrintWriter writer;

    public SaveableDictionary(String file) {
            filePath = Path.of(file);
    }

    public void add(String word, String translation) {
        dictionary.putIfAbsent(word, translation);
    }

    public String translate(String word) {
        return dictionary.get(word);
    }

    public void delete(String word) {
        dictionary.remove(word);
    }

    public boolean load() {
        List<String> fileLines;

        try {
            fileLines = Files.readAllLines(filePath);
        } catch (IOException e) {
            return false;
        }

        fileLines.stream()
                .map(s -> s.split(":"))
                .forEach(s -> add(s[0], s[1]));

        return true;
    }

    public boolean save() {
        writer = new PrintWriter((Writer) filePath);

    }
}
