import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BookRepository bookRepository = new BookRepository();
        UserRepository userRepository = new UserRepository();

        int choice;
        do {
            displayMenu();
            choice = Integer.parseInt(input.nextLine());
//            input.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("You choose to exit");
                    break;
                case 1:
                    getBookFromUser(input, bookRepository);
                    break;

                case 2:
                    getUser(input, userRepository);
                    break;


                case 3:
                    borrowBook(input);
                    break;


                case 5:
                    System.out.println(bookRepository.showBooks());
                    break;

                case 6:
                    System.out.println(userRepository.showUsers());
                    break;



                default:
                    System.out.println("ENTER BETWEEN 0 TO 6.");
            }
        }

        // Checking condition at last where we are
        // checking case entered value is not zero
        while (choice != 0);
    }

    private static void borrowBook(Scanner input) {
        System.out.println("Enter User's ID to Borrow Book:");
        String userIdStr = input.nextLine();

        System.out.println("\r\nEnter Book ID to Borrow:");
        String bookIdStr = input.nextLine();

        BookRepository.borrowBook(Long.parseLong(userIdStr),Long.parseLong(bookIdStr));
    }

    private static void getUser(Scanner input, UserRepository userRepository) {
        System.out.println("Enter User's Name:");
        String name = input.nextLine();

        System.out.println("\r\nEnter User's Lastname:");
        String lastName = input.nextLine();

        User user = new User(name,lastName);
        userRepository.save(user);
    }

    private static void getBookFromUser(Scanner input, BookRepository bookRepository) {
        System.out.println("Enter Book Name:");
        String bookName = input.nextLine();

        System.out.println("\r\nEnter Author Name:");
        String authorName = input.nextLine();

        Book book = new Book(bookName,authorName,BookStatus.AVAILABLE);
        bookRepository.save(book);
    }


    public static void displayMenu() {


        System.out.println(
                "----------------------------------------------------------------------------------------------------------");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 2 to Add new User.");
        System.out.println("Press 3 to Borrow Book.");
        System.out.println("Press 4 to Return Book.");
        System.out.println("Press 5 to Show Available Books.");
        System.out.println("Press 6 to Show All Users.");
        System.out.println("Press 0 to Exit Application.");

        System.out.println(
                "-------------------------------------------------------------------------------------------------------");
    }

}