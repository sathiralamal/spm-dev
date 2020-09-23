package timetablesystem.DataBaseHandler;


import java.sql.*;

public class DBHandler {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private String url,user,pass;


    public DBHandler(){
        url="jdbc:mysql://localhost/timeTableSystem";
        user="root";
        pass="";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(url,user,pass);
            st=con.createStatement();
            System.out.println("DB Connected");

        } catch (Exception ex) {
            System.out.println("Error "+ ex);
        }
    }

    public void createTables(){
        try {

            st.executeUpdate(CreateTables.timeSolts) ;
            System.out.println("Table Created SuccessFully");
        }
        catch (Exception e) {
            System.out.println(e);

        }
    }

    public String DbInsert(String query){
        String r;
        try {
            st.executeUpdate(query) ;
            r="Success";
        }
        catch (Exception e) {
            r= e.toString();
        }
        return r;
    }


    public  ResultSet DbGet(String query){
        ResultSet r=null;

        try {
            r= st.executeQuery(query);

        } catch (Exception e) {
            System.out.println(e);
        }
        return r;
    }

}
