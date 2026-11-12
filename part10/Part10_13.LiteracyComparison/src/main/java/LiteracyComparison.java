
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class LiteracyComparison {

    public static void main(String[] args) {
        List<LiteracyData> literacyDataList = parseLiteracy(
                Path.of("part10/Part10_13.LiteracyComparison/literacy.csv")
        );

        for (LiteracyData record : literacyDataList) {
            System.out.printf(
                    Locale.ENGLISH,
                    "%s (%d), %s, %.5f%n",
                    record.country(), record.year(), record.sex(), record.literacy()
            );
        }
    }

    private static List<LiteracyData> parseLiteracy(Path path) {
        try (var lines = Files.lines(path)) {
            return lines.map(line -> line.split("\\s*,\\s*"))
                    .map(LiteracyComparison::toLiteracyData)
                    .sorted(Comparator.comparingDouble(LiteracyData::literacy))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static LiteracyData toLiteracyData(String[] line) {
        return new LiteracyData(
                line[3],
                Integer.parseInt(line[4]),
                line[2].replace(" (%)", ""),
                Double.parseDouble(line[5])
        );
    }
}
