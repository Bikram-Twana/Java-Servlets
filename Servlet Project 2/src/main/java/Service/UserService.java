package Service;

import Connection.DBConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    //insert
    public void insertUser(User user){

        String insertSql = "insert into user(userName, fullName, password)" + "Values(?,?,?);";
//        INSERT INTO `user`(`id`, `userName`, `fullName`, `password`) VALUES ('[value-1]','[value-2]','[value-3]','[value-4]')
        PreparedStatement preparedStatement = new DBConnection().getStatement(insertSql);
        try{
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getFullName());
            preparedStatement.setString(3, user.getPassword());

            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //delete user
    public void deleteUser(int id) {
        String deleteSql = "delete from user where id=?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(deleteSql);

        try {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //edit user
    public void editUser(int id, User user) throws SQLException {

        String editQuery = "update user set userName=?, fullName=?, password=?" + "where id=?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(editQuery);

        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getFullName());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setInt(4, id);
        preparedStatement.execute();
    }

    //LOGIN // getUser
    public User getUser(String userName, String password){
        User user = null;

        String query = "select * from user where userName = ? AND password=?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(query);
        try{
            preparedStatement.setString(1, userName);

            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("userName"));
                user.setFullName((resultSet.getString("fullName")));
                user.setPassword((resultSet.getString("password")));

                System.out.println("UserName is " + userName + " Password is: " + password );

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    //get all list
    public List<User> getUserList(){
        String userList = "select * from user";
        List<User> arrayList = new ArrayList<>();
        PreparedStatement preparedStatement = new DBConnection().getStatement(userList);
        try{
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("userName"));
                user.setFullName(resultSet.getString("fullName"));
                user.setPassword(resultSet.getString("password"));
                arrayList.add(user);
            }

        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return arrayList;
    }

    public User getUserRow(int id){
        String rowQuery = "select * from user where id = ?";
        PreparedStatement preparedStatement = new DBConnection().getStatement(rowQuery);
        User user = new User();
        try{
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){

                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("userName"));
                user.setFullName(resultSet.getString("fullName"));
                user.setPassword(resultSet.getString("password"));

            }

        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return user;

    }

}
