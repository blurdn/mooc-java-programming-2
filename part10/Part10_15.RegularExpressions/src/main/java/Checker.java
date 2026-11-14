

public class Checker {
    private static final String WEEK_DAYS_RE = "(mon|tue|wed|thu|fri|sat|sun)";
    private static final String ALL_VOWELS_RE = "[aeiou]*";

    private static final String HOURS_RE = "([01][0-9]|2[0-3])";
    private static final String MINUTES_OR_SECONDS_RE = "[0-5][0-9]";
    private static final String TIME_OF_DAY_RE = HOURS_RE + ":" + MINUTES_OR_SECONDS_RE + ":" + MINUTES_OR_SECONDS_RE;

    public boolean isDayOfWeek(String string) {
         return string.matches(WEEK_DAYS_RE);
    }

    public boolean allVowels(String string) {
        return string.matches(ALL_VOWELS_RE);
    }

    public boolean timeOfDay(String string) {
        return string.matches(TIME_OF_DAY_RE);
    }
}
