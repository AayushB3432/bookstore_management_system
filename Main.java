import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bookstore";
        String user = "root";
        String password = "ab123"; 

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Scanner sc = new Scanner(System.in)) {

            AdminModule admin = new AdminModule(conn, sc);
            CustomerModule customer = new CustomerModule(conn);

            while (true) {
                System.out.println("\n1. Add Book (Admin)");
                System.out.println("2. Delete Book (Admin)");
                System.out.println("3. View Books (Customer)");
                System.out.println("4. Exit");
                System.out.print("Choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        admin.addBook();
                        break;
                    case 2:
                        admin.deleteBook();
                        break;
                    case 3:
                        customer.viewBooks();
                        break;
                    case 4:
                        System.out.println("Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}