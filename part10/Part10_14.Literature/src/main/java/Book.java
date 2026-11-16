public record Book(String name, int age) {
    @Override
    public String toString() {
        return name + " (recommended for " + age + " year-olds or older)";
    }
}
