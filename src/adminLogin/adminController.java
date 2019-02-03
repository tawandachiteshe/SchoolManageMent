package adminLogin;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.*;
import Admin.*;
import Student.*;

import java.net.URL;
import java.util.ResourceBundle;

public class adminController implements Initializable {
    LoginModel loginModel = new LoginModel();
    @FXML
    Label dbstatus;
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Button loginButton;
    @FXML
    ComboBox<option> combobox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    if (this.loginModel.isDataConnected()){
        this.dbstatus.setText("Connected To database");
    }else{
        this.dbstatus.setText("Check your Database COnnection");
    }
   this.combobox.setItems(FXCollections.observableArrayList(option.values()));

    }
        public void onaction(ActionEvent event){

            try {
                if(this.loginModel.isLogin(this.username.getText(),this.password.getText(),((option)this.combobox.getValue()).toString())){
                    Stage stage = (Stage)this.loginButton.getScene().getWindow();
                    stage.close();
                    switch (((option)this.combobox.getValue()).toString()){
                        case "Admin":
                            AdminData();
                            break;
                        case "Student":
                            StudentData();
                            break;


                    }

                    }else{
                    this.dbstatus.setText("login failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    public void StudentData(){
        try {
            Stage userStage = new Stage();
            FXMLLoader fxmlloader = new FXMLLoader();
            Pane pane = (Pane) fxmlloader.load(getClass().getResource("/Student/studentFXML.fxml").openStream());
            StudentController studentcontroller =(StudentController)fxmlloader.getController();

            Scene scene = new Scene(pane);

            userStage.setScene(scene);
            userStage.setTitle("Student Dashboard");
            userStage.setResizable(false);
            userStage.show();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public void AdminData(){
        try {
            Stage adminStage = new Stage();
            FXMLLoader fxmlloader = new FXMLLoader();
            Pane pane = (Pane) fxmlloader.load(getClass().getResource("/Admin/Admin.fxml").openStream());
            AdminControllerForm admincontroller =(AdminControllerForm)fxmlloader.getController();

            Scene scene = new Scene(pane);

            adminStage.setScene(scene);
           adminStage.setTitle("Variable");
            adminStage.setResizable(false);
            adminStage.show();
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
}
