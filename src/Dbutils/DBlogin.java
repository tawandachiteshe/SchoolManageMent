package Dbutils;

import adminLogin.LoginModel;

import java.sql.*;

public class DBlogin  {
    public static  final String USERNAME = "lateruse";
    public static final String PASSWORD ="*******";
    public static final String CONNECTION ="jdbc:mysql://localhost/login";
    public static final String SQLITECONNECTION="jdbc:sqlite:students.sqlite";
    public static  final String DBCLASS= "org.sqlite.JDBC";
    public static final String SQLQUERY = "SELECT * FROM login where username = ? and password = ? and division =?";


    public static Connection getMyDataBase()throws SQLException {

        try {
            Class.forName(DBCLASS);
            return DriverManager.getConnection(SQLITECONNECTION);
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return null;
    }

}
