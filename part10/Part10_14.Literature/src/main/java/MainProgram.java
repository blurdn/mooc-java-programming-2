
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();

            if (name.isEmpty()) break;

            System.out.print("Input the age recommendation: ");
            int age = Integer.parseInt(scanner.nextLine());

            books.add(new Book(name, age));

            System.out.println();
        }

        System.out.println("\n" + books.size() + " books in total.\n");

        Comparator<Book> comparator = Comparator
                .comparingInt(Book::age)
                .thenComparing(Book::name);

        System.out.println("Books:");
        books.stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }

}
