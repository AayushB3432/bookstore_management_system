import java.sql.*;
import java.util.Scanner;

public class
AdminModule {
    Connection conn;
    Scanner sc;

    public AdminModule(Connection conn, Scanner sc) {
        this.conn = conn;
        this.sc = sc;
    }

    public void addBook() throws SQLException {
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine(); 

        String sql = "INSERT INTO books (title, author, price, quantity) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, title);
        pst.setString(2, author);
        pst.setDouble(3, price);
        pst.setInt(4, quantity);

        pst.executeUpdate();
        System.out.println("Book added successfully.");
    }

    public void deleteBook() throws SQLException {
        System.out.print("Enter book ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        String sql = "DELETE FROM books WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, id);
        int rows = pst.executeUpdate();

        if (rows > 0)
            System.out.println("Book deleted.");
        else
            System.out.println("Book not found.");
    }
}