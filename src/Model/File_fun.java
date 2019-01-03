package Model;

import java.io.*;
import java.util.ArrayList;

public class File_fun {
    String[] strArray = null;
    Student tempStu=new Student();
    public ArrayList read_file() {
        Student tempStu=new Student();
        File file = new File("data.txt");
        BufferedReader reader = null;
        ArrayList tempArrayList = new ArrayList();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            reader.readLine();
            while ((tempString = reader.readLine()) != null) {
                strArray = convertStrToArray(tempString);
                tempStu.add(Integer.parseInt(strArray[0]), strArray[1], Integer.parseInt(strArray[2]), Integer.parseInt(strArray[3]));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        if (tempStu.list_stu.size()==0) {
            ;//数据库内无学生信息
        } else {
            ;
        }
        return tempStu.list_stu;
    }

    public void write_file(Student s,Worker w) {
        File file = new File("data.txt");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(s.showAll());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e1) {
                }
            }
        }
        if (tempStu.list_stu.size()==0) {
            ;//数据库内无学生信息
        } else {
            ;
        }
    }

    public static String[] convertStrToArray(String str){
        String[] strArray = null;
        strArray = str.split(",");
        return strArray;
    }
}
