package adminLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dbutils.DBlogin;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class LoginModel  {


    Connection connection;
    public LoginModel(){
        try {
            this.connection=  DBlogin.getMyDataBase();
        }catch (SQLException ex){


        }
        if(this.connection==null){

    System.exit(1);

        }

    }
    public Boolean isDataConnected(){
        return this.connection !=null ;
    }
    public Boolean isLogin(String user,String pass,String opt)throws Exception{
        PreparedStatement pr = null;
        ResultSet rs = null;
        String SQLQUERY = "SELECT * FROM login where username = ? and password = ? and division = ?";
        try {
            pr = this.connection.prepareStatement(SQLQUERY);
            pr.setString(1,user);
            pr.setString(2,pass);
            pr.setString(3,opt);
            rs = pr.executeQuery();

            if(rs.next()){
                return true;
            }
                return false;

        }
        catch (SQLException sqlex){
    return false;
        }
        finally {
            rs.close();
            pr.close();
        }
    }
}
