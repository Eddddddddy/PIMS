package PIMS;

import Control.Control;
import Model.File_fun;
import Model.SQL;
import Model.Student;
import Model.Worker;
import View.Gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PIMS_main {

    public static void main(String[] args){

        Gui gui=new Gui();
        Student student=new Student();
        Worker worker=new Worker();
        File_fun file=new File_fun();
        Control control=new Control(gui,student,worker,file);


//        {
//            String driver = "com.mysql.cj.jdbc.Driver";
//
//            String url = "jdbc:mysql://localhost:3306/pims?serverTimezone=UTC";
//
//            String user = "root";
//
//            String password = "wangdingyi110";
//
//
//            try {
//                Connection con;
//                Statement statement;
//
//                Class.forName(driver);
//
//                con = DriverManager.getConnection(url, user, password);
//
//                statement = con.createStatement();
//
//
//                int ID = 1, age = 122, score = 123;
//                String name = "abd";
//
//                String sql = "insert into Student values(" + ID + ",'" + name + "'," + age + "," + score + ");";
//
//                statement.executeUpdate(sql);
//
//
//                con.close();
//
//
//            } catch (ClassNotFoundException e) {
//
//                System.out.println("Sorry,can`t find the Driver!");
//                e.printStackTrace();
//            } catch (SQLException e) {
//
//                e.printStackTrace();
//            } catch (Exception e) {
//
//                e.printStackTrace();
//            } finally {
//
//                System.out.println("数据库数据成功获取！！");
//            }
//
//
//        }


    }

}
