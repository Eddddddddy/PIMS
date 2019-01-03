package PIMS;

import java.io.*;
import java.util.ArrayList;

public class File_fun {
String read_file(ArrayList a) {
    File file = new File("data.txt");
    BufferedReader reader = null;
    try {
        System.out.println("以行为单位读取文件内容，一次读一整行：");
        reader = new BufferedReader(new FileReader(file));
        String tempString = null;
        int line = 1, j = 0;
        int number = 0, ranking = 0;
        double Score_Math = 0, Score_English = 0, Score_Java = 0, Score_System = 0, Score_PE = 0, Score_Average = 0;
        String name = "0";
        // 一次读入一行，直到读入null为文件结束
        while ((tempString = reader.readLine()) != null) {
            switch (j) {
                case 0: {
                    number = Integer.parseInt(tempString);
                }
                break;
                case 1: {
                    name = tempString;
                }
                break;
                case 2: {
                    Score_Math = (Double.parseDouble(tempString) / 10);
                }
                break;
                case 3: {
                    Score_English = (Double.parseDouble(tempString) / 10);
                }
                break;
                case 4: {
                    Score_Java = (Double.parseDouble(tempString) / 10);
                }
                break;
                case 5: {
                    Score_System = (Double.parseDouble(tempString) / 10);
                }
                break;
                case 6: {
                    Score_PE = (Double.parseDouble(tempString) / 10);
                    student.addHead(name, number, Score_Math, Score_English, Score_Java, Score_System, Score_PE);
                    j = -1;
                }
                break;
            }
            j++;
            line++;
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
    if (student.isEmpty()) {
        l.setText("数据库内无学生信息");
    } else {
        student.sort();
        t.setText(student.display());
        l.setText("读取完成");
    }
}
}
