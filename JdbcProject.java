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
            System.out.println("4.Update Record");
            System.out.println("5.Exit Program");
            int choice = Input.nextInt();
            if (choice == 1) {
                Statement st = con.createStatement();
                String viewRecords = "select * from Employee";
                ResultSet rs = st.executeQuery(viewRecords);
                while (rs.next()) {
                    System.out.println(
                            "Id : "+rs.getInt(1) +" Name : " + rs.getString(2) + ", Role : " + rs.getString(4) + ", Salary : " + rs.getInt(3));
                }
            }
            else if(choice == 2){
                Input.nextLine();
                System.out.println("Enter Employee Id : ");
                int id = Input.nextInt();
                Input.nextLine();
                System.out.println("Enter Employee Name : ");
                String name = Input.nextLine();
                System.out.println("Enter Employee Role : ");
                String role = Input.nextLine();
                System.out.println("Enter Employee Salary : ");
                int salary = Input.nextInt();
                String addQuery = "insert into Employee values (?, ?, ?, ?)";
                PreparedStatement st = con.prepareStatement(addQuery);
                st.setInt(1, id);
                st.setString(2, name);
                st.setInt(3, salary);
                st.setString(4, role);
                st.executeUpdate();
            }
            else if(choice == 3){
                System.out.println("Enter Employee ID to delete : ");
                int id = Input.nextInt();
                String deleteQuery = "delete from Employee where id = ?";
                PreparedStatement st = con.prepareStatement(deleteQuery);
                st.setInt(1, id);
                st.executeUpdate();
            }
            else if(choice == 4){
                System.out.println("Enter the Employee Id to update : ");
                int id = Input.nextInt();
                Input.nextLine();
                System.out.println("Enter New Name : ");
                String newName = Input.nextLine();
                System.out.println("Enter New Role : ");
                String newRole = Input.nextLine();
                System.out.println("Enter New Salary : ");
                int newSalary = Input.nextInt();
                String updateQuery = "update Employee set name = ?, role = ?, salary = ? where id = ?";
                PreparedStatement st = con.prepareStatement(updateQuery);
                st.setString(1, newName);
                st.setString(2, newRole);
                st.setInt(3, newSalary);
                st.setInt(4,id);
                st.executeUpdate();
            }
            else{
                return;
            }
            Input.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Unable to connect to Database");
        }
    }
}
