package Admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentData {
    //
    private final StringProperty ID;
    private final StringProperty fname;
    private final StringProperty sname;
    private final StringProperty phonenum;
    private final StringProperty DOB;
    public StudentData(String id,String fName,String Sname,String dob,String  phoneNum){
        this.ID = new SimpleStringProperty(id);
        this.fname = new SimpleStringProperty(fName);
        this.sname = new SimpleStringProperty(Sname);
        this.phonenum = new SimpleStringProperty(phoneNum);
        this.DOB = new SimpleStringProperty(dob);
    }
    public String getID(){
    return   ID.get();
    }
    public StringProperty IDProperty() {
        return this.ID;
    }
    public  void setID(String ID){
        this.ID.set(ID);
    }
    public  String getFname(){
        return  fname.get();
    }
    public StringProperty FnameProperty() {
        return this.fname;
    }
    public  void setFname(String fname){
        this.fname.set(fname);
    }

    public String getSname(){
        return sname.get();
    }

    public StringProperty SnameProperty() {
        return this.sname;
    }
    public void setSname(String sname){
        this.DOB.set(sname);
    }


    public String getPhonenum() {
        return phonenum.get();
    }

    public StringProperty PhoneNumProperty() {
        return this.phonenum;
    }
    public void setPhonenum(String phonenum){
        this.phonenum.set(phonenum);
    }
    public String getDOB(){
        return DOB.get();
    }
    public StringProperty DOBproperty() {
        return this.DOB;
    }
    public void setDOB(String DOB){
        this.DOB.set(DOB);
    }

}
