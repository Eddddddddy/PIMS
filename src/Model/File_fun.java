package Model;

import java.io.*;
import java.util.ArrayList;

public class File_fun {
    String[] strArray = null;
    Student_SQL tempStu=new Student_SQL();
    Worker_SQL tempWor=new Worker_SQL();
    public ArrayList read_file_stu() {
        Student_SQL tempStu=new Student_SQL();
        File file = new File("data_stu.txt");
        BufferedReader reader = null;
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

    public ArrayList read_file_wor() {
        Worker_SQL tempWor=new Worker_SQL();
        File file = new File("data_wor.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            reader.readLine();
            while ((tempString = reader.readLine()) != null) {
                strArray = convertStrToArray(tempString);
                tempWor.add(Integer.parseInt(strArray[0]), strArray[1], Integer.parseInt(strArray[2]), Integer.parseInt(strArray[3]),strArray[4]);
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
        if (tempWor.list_wor.size()==0) {
            ;//数据库内无学生信息
        } else {
            ;
        }
        return tempWor.list_wor;
    }

    public void write_file(Student_SQL s, Worker_SQL w) {
        File file_stu = new File("data_stu.txt");
        File file_wor = new File("data_wor.txt");
        BufferedWriter writer_stu = null;
        BufferedWriter writer_wor=null;
        try {
            writer_stu = new BufferedWriter(new FileWriter(file_stu));
            writer_stu.write(s.showAll());
            writer_stu.close();
            writer_wor = new BufferedWriter(new FileWriter(file_wor));
            writer_wor.write(w.showAll());
            writer_wor.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer_stu != null||writer_wor!=null) {
                try {
                    writer_stu.close();
                    writer_wor.close();
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
