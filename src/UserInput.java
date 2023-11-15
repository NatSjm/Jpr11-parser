import java.util.Scanner;

public class UserInput implements AutoCloseable {

    final private Scanner scanner;

    public UserInput() {
        this.scanner = new Scanner(System.in);
    }

    public String getBookName() {
        System.out.println("Enter the book name:");
        return scanner.nextLine();
    }

    @Override
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}