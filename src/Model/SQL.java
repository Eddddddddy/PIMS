package Model;



import java.sql.*;

public class SQL {
    Connection con;
    Statement statement;
    public  SQL(){

        String driver = "com.mysql.cj.jdbc.Driver";

        String url = "jdbc:mysql://localhost:3306/pims?serverTimezone=UTC";

        String user = "root";

        String password = "wangdingyi110";


        try {

               Class.forName(driver);

               con = DriverManager.getConnection(url,user,password);

               statement = con.createStatement();

            con.close();



           } catch(ClassNotFoundException e) {

               System.out.println("Sorry,can`t find the Driver!");
               e.printStackTrace();
               } catch(SQLException e) {

               e.printStackTrace();
               }catch (Exception e) {

               e.printStackTrace();
           }finally{

               System.out.println("数据库数据成功获取！！");
           }

    }
    public Statement getStatement(){

        return statement;
    }
}
