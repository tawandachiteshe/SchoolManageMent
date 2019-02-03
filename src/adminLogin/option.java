package adminLogin;

public enum option {
    Admin,Student;

    private option(){}
    private String value(){
        return name();
    }
    public static option fromValue(String v){

        return valueOf(v);
    }

}
