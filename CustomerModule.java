import java.sql.*;

public class CustomerModule {
    Connection conn;

    public CustomerModule(Connection conn) {
        this.conn = conn;
    }

    public void viewBooks() throws SQLException {
        String sql = "SELECT * FROM books";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        System.out.printf("%-5s %-20s %-20s %-8s %-5s\n", "ID", "Title", "Author", "Price", "Qty");
        while (rs.next()) {
            System.out.printf("%-5d %-20s %-20s %-8.2f %-5d\n",
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getDouble("price"),
                    rs.getInt("quantity"));
        }
    }
}