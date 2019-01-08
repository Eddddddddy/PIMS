package Model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Worker{
    ArrayList list_wor=new ArrayList();

    public class Wor extends Person{
        int salary;
        String work;
    }

    public String add(int ID, String name, int age, int salary, String work){
        try {
            Wor temp=new Wor();
            temp.salary=salary;
            temp.age=age;
            temp.ID=ID;
            temp.name=name;
            temp.work=work;
            list_wor.add(temp);
            String sql = "insert into Worker values(" + ID + ",'" + name + "'," + age + "," + salary+","+work + ");";
            Statement statement = new SQL().getStatement();
            statement.executeUpdate(sql);
            statement.close();
            return "添加成功";
        }catch(Exception e){
            return "添加失败";
        }
    }

    public String printAll(){
        try {
            String temp = "工人信息\r\n";
            Statement statement = new SQL().getStatement();
            String sql = "select ID,name,age,salary,work from Worker";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                temp += ("ID:" + rs.getString("ID") + "\t\tname:" + rs.getString("name") + "\t\tage:" + rs.getString("age") + "\t\tsalary:" + rs.getString("salary") + "\t\twork:"+rs.getString("work")+"\r\n");
            }
            statement.close();
            return temp;
        }catch (Exception e){
            ;
        }
        return "0";
    }

    public String showAll(){
        try {
            String temp = "工人信息\r\n";
            Statement statement = new SQL().getStatement();
            String sql = "select ID,name,age,salary,work from Worker";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                temp += (rs.getString("ID") + "," + rs.getString("name") + "," + rs.getString("age") + "," + rs.getString("salary") + ","+rs.getString("work")+"\r\n");
            }
            statement.close();
            return temp;
        }catch (Exception e){
            ;
        }
        return "0";
    }

    public String search(int a){
        try {
            Statement statement = new SQL().getStatement();
            String sql = "select ID,name,age,salary,work from Worker";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                if (rs.getInt("ID") == a)
                    return (rs.getString("ID") + "," + rs.getString("name") + "," + rs.getString("age") + "," + rs.getString("salary") + ","+rs.getString("work"));
            }
        } catch (Exception e) {
            ;
        }
        return "无该工人";
    }

    public String search(String a){
        try {
            Statement statement = new SQL().getStatement();
            String sql = "select ID,name,age,salary,work from Worker";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString("name").equals(a)) {
                    return (rs.getString("ID") + "," + rs.getString("name") + "," + rs.getString("age") + "," + rs.getString("salary") + ","+rs.getString("work"));
                }
            }

            int[][] same = new int[2][100];
            char[] toCharArray_a = a.toCharArray();
            int i=-1;
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                i++;
                char[] toCharArray = rs.getString("name").toCharArray();
                for (int j = 0; j < toCharArray.length; j++) {
                    for (int k = 0; k < toCharArray_a.length; k++) {
                        if (toCharArray[j] == toCharArray_a[k]) {
                            same[0][i]++;
                            same[1][i]=rs.getInt("ID");
                        }
                    }
                }
            }
            int max = 0, max_i = 0;
            for (i = 0; i < 100; i++) {
                if (same[0][i] > max) {
                    max = same[0][i];
                    max_i = i;
                }
            }
            if (max != 0) {
                sql = "select ID,name,age,salary,work from Worker where ID="+same[1][max_i]+";";
                ResultSet rst = statement.executeQuery(sql);
                rst.next();
                return (rst.getString("ID") + "," + rst.getString("name") + "," + rst.getString("age") + "," + rst.getString("salary") + ","+rst.getString("work"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("wqe");
        }
        return "无该工人";
    }

    public String delete(int a){
        try {
            Statement statement = new SQL().getStatement();
            String sql = "select ID,name,age,salary,work from Worker";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                if (rs.getInt("ID") == a) {
                    sql = "delete from  worker where  ID = "+a+";";
                    statement.executeUpdate(sql);
                    return "已删除";
                }
            }

        }catch (Exception e){}
        return "无该工人";
    }

    public String delete(String a) {
        try {

            Statement statement = new SQL().getStatement();
            String sql = "select ID,name,age,salary,work from Worker";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString("name").equals(a)) {
                    sql = "delete from  worker where name="+a+";";
                    statement.executeUpdate(sql);
                    return "已删除";
                }
            }

            int[][] same = new int[2][100];
            char[] toCharArray_a = a.toCharArray();
            int i=-1;
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                i++;
                char[] toCharArray = rs.getString("name").toCharArray();
                for (int j = 0; j < toCharArray.length; j++) {
                    for (int k = 0; k < toCharArray_a.length; k++) {
                        if (toCharArray[j] == toCharArray_a[k]) {
                            same[0][i]++;
                            same[1][i]=rs.getInt("ID");
                        }
                    }
                }
            }
            int max = 0, max_i = 0;
            for (i = 0; i < 100; i++) {
                if (same[0][i] > max) {
                    max = same[0][i];
                    max_i = i;
                }
            }
            if (max != 0) {
                sql = "delete from  worker where ID="+same[1][max_i]+";";
                statement.executeUpdate(sql);
                return "已删除";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("wqe");
        }
        return "无该工人";
    }

    public void deleteAll(){
        list_wor.clear();
    }

    public void readList(ArrayList temp){
        list_wor=temp;
    }
}
