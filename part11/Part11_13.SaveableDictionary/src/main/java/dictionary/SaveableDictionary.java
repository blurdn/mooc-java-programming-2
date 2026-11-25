package dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class SaveableDictionary {
    private final Map<String, String> dictionary = new HashMap<>();
    private final Map<String, String> dictionaryReversed = new HashMap<>();
    private final Path filePath;

    public SaveableDictionary() {
        this.filePath = null;
    }

    public SaveableDictionary(String file) {
        filePath = Path.of(file);
    }

    public void add(String word, String translation) {
        dictionary.putIfAbsent(word, translation);
        dictionaryReversed.putIfAbsent(translation, word);
    }

    public String translate(String word) {
        var translation = dictionary.get(word);

        if (translation != null) {
            return translation;
        }

        return dictionaryReversed.get(word);
    }

    public void delete(String word) {
        var translation = translate(word);
        if (translation == null) {
            return;
        }

        dictionary.remove(word);
        dictionaryReversed.remove(word);
        dictionary.remove(translation);
        dictionaryReversed.remove(translation);
    }

    public boolean load() {
        if (filePath == null) {
            return false;
        }

        List<String> fileLines;

        try {
            fileLines = Files.readAllLines(filePath);
        } catch (IOException e) {
            return false;
        }

        fileLines.stream()
                .filter(s -> s.contains(":"))
                .map(s -> s.split(":", 2))
                .forEach(s -> add(s[0], s[1]));

        return true;
    }

    public boolean save() {
        if (filePath == null) {
            return false;
        }

        StringJoiner sj = new StringJoiner("\n");

        dictionary.forEach((key, value) -> sj.add(key + ":" + value));

        try {
            Files.writeString(filePath, sj.toString());
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
