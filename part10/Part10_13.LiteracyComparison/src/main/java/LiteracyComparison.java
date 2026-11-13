
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class LiteracyComparison {

    public static void main(String[] args) {
        List<LiteracyData> literacyDataList = parseLiteracy(
                Path.of("literacy.csv")
        );

        for (LiteracyData record : literacyDataList) {
            System.out.printf(
                    "%s (%d), %s, %s%n",
                    record.country(), record.year(), record.sex(), record.literacy()
            );
        }
    }

    private static List<LiteracyData> parseLiteracy(Path path) {
        try (var lines = Files.lines(path)) {
            return lines.map(line -> line.split("\\s*,\\s*"))
                    .map(LiteracyComparison::toLiteracyData)
                    .sorted(Comparator.comparing(LiteracyData::literacy))
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
                new BigDecimal(line[5].trim())
        );
    }
}
