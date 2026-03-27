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
            System.out.println("2.Add Record");
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
            else if(choice == 2){
                Input.nextLine();
                System.out.println("Enter Employee Name : ");
                String name = Input.nextLine();
                System.out.println("Enter Employee Role : ");
                String role = Input.nextLine();
                System.out.println("Enter Employee Salary : ");
                int salary = Input.nextInt();
                String addQuery = "insert into Employee (name, role, salary) values (?,?,?)";
                PreparedStatement st = con.prepareStatement(addQuery);
                st.setString(1, name);
                st.setString(2, role);
                st.setInt(3, salary);
                st.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println("Unable to connect to Database");
        }
    }
}
