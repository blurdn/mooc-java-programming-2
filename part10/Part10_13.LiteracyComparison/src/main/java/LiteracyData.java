import java.math.BigDecimal;

public record LiteracyData(
        String country,
        int year,
        String sex,
        BigDecimal literacy
) {}
