
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        List<String> lines;

        try {
            lines = Files.readAllLines(Path.of("part10/Part10_13.LiteracyComparison/literacy.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        lines.stream()
                .map(line -> line.split("\\s*,\\s*"))
                .sorted((p1, p2) -> {
                    return p1[5].compareTo(p2[5]);
                })
                .forEach(p -> {
                    System.out.println(String.format("%s (%d), %s, %.5f",
                            p[3], p[4],p[2].replace(" (%)", ""), p[5]));
                });
    }
}
