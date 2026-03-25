import java.util.Scanner;
import java.sql.*;

public class JdbcProject {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/Employee_Management_System";
        String user = "root";
        String password = "Burlbed58#";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected");
            System.out.println("Enter the number");
            System.out.println("1.View Records");
            System.out.println("2.Update Record");
            System.out.println("3.Delete Record");
            System.out.println("4.Exit Program");
            int choice = Input.nextInt();
            if (choice == 1) {
                Statement st = con.createStatement();
                String viewRecords = "select * from Employee";
                ResultSet rs = st.executeQuery(viewRecords);
                while (rs.next()) {
                    System.out.println(
                            "Name : " + rs.getString(2) + ", Role : " + rs.getString(3) + ", Salary : " + rs.getInt(4));
                }
            }
        } catch (Exception e) {
            System.out.println("Unable to connect to Database");
        }
    }
}
