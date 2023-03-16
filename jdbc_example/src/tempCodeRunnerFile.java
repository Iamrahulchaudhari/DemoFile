import java.sql.*;
public class App {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/mydatabase"; // Replace "mydatabase" with your database name
        String username = "root"; // Replace "yourusername" with your MySQL username
        String password = " "; // Replace "yourpassword" with your MySQL password

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Execute a SQL query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable"); // Replace "mytable" with your table name

            // Iterate over the result set and print the data
            while (resultSet.next()) {
                String column1Data = resultSet.getString("column1"); // Replace "column1" with your column name
                String column2Data = resultSet.getString("column2"); // Replace "column2" with your column name
                System.out.println("Column 1: " + column1Data + ", Column 2: " + column2Data);
            }

            // Close the result set, statement, and connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
