package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
    Connection con;
    public DBConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver"); // driver is inside package.
            String DB_URLL = "jdbc:mysql://localhost:3306/studentmanagement"; //protno,dbname
            String name = "root";
            String password = "";
            con = DriverManager.getConnection(DB_URLL,name,password);
            System.out.println("Connection Successuflly");

            //System.out.println("Connection closed");
        }
        catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();

        }

    }

    public static void main(String[] args) {

        DBConnection dbConnection = new DBConnection();
    }

    public PreparedStatement getStatement(String query){
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = con.prepareStatement(query);

        } catch(SQLException e){
            e.printStackTrace();
        }
        return preparedStatement;

    }
}
