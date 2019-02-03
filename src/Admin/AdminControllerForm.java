package Admin;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import Dbutils.*;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.sql.Connection;

public class AdminControllerForm implements Initializable {
    @FXML
    private VBox vbox;
    @FXML
    private TextField ID;
    @FXML
    private TextField Fname;
    @FXML
    private TextField Pnum;
    @FXML
    private TextField Sname;
    @FXML
    private DatePicker dob;
    @FXML
    private TableView<StudentData> studentTable;
    @FXML
    private TableColumn<StudentData,String> idcolumn;
    @FXML
    private TableColumn<StudentData,String> phonecolumn;
    @FXML
    private TableColumn<StudentData,String> fnamecolumn;
    @FXML
    private TableColumn<StudentData,String> snamecolumn;
    @FXML
    private TableColumn<StudentData,String> dobcolumn;
    private DBlogin databaseLogin ;
    private ObservableList<StudentData> SData;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            this.databaseLogin = new DBlogin();
    }
    private  String SQLQUERY= "SELECT * FROM students";
    public void refreshData(ActionEvent event){
        try{
            Connection connection = DBlogin.getMyDataBase();
            this.SData = FXCollections.observableArrayList();
            ResultSet rs = connection.createStatement().executeQuery(SQLQUERY);
            while(rs.next()){
                this.SData.add(new StudentData(rs.getString(1),rs.getString(2),rs.getString(3)
                ,rs.getString(4),rs.getString(5)));
            }
        }catch (SQLException ex){

        }
        this.idcolumn.setCellValueFactory(new PropertyValueFactory<StudentData, String>("ID"));
        this.fnamecolumn.setCellValueFactory(new PropertyValueFactory<StudentData,String>("fname"));
        this.snamecolumn.setCellValueFactory(new PropertyValueFactory<StudentData,String>("sname"));
        this.dobcolumn.setCellValueFactory(new PropertyValueFactory<StudentData,String>("DOB"));
        this.phonecolumn.setCellValueFactory(new PropertyValueFactory<StudentData,String>("phonenum"));
        this.studentTable.setItems(null);
        this.studentTable.setItems(this.SData);
    }
    @FXML
    public void insertStudent(ActionEvent event){
        String sqlinsert = "INSERT INTO students(ID,fname,sname,DOB,pnum) VALUES(?,?,?,?,?)";
       // String SQLINSERT ="INSERT INTO `students`(`ID`,`fname`,`sname`,`DOB`,`pnum`) VALUES (NULL,NULL,NULL,NULL,NULL)";

        try {
            Connection conn = DBlogin.getMyDataBase();
            PreparedStatement ps = conn.prepareStatement(sqlinsert);
            ps.setString(1,ID.getText());
            ps.setString(2,Fname.getText());
            ps.setString(3,Sname.getText());
            ps.setString(4,dob.getEditor().getText());
            ps.setString(5,Pnum.getText());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
