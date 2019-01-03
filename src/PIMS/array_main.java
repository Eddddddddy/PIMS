package PIMS;

import Model.File_fun;
import Model.Student;
import Model.Worker;
import View.Screen;

import java.util.*;



public class array_main {


    public static void main(String args[]){
        int ID,score,salary,age;
        String name,work;
        String[] strArray=null;
        Student student=new Student();
        Worker worker=new Worker();
        Screen screen=new Screen();
        File_fun file=new File_fun();
        Scanner scanner = new Scanner(System.in);
        int s,k=0;
        while (k==0) {
            screen.menu();
            s=scanner.nextInt();
            switch (s) {
                case 0:{
                    student.deleteAll();
                    student.readList(file.read_file());
                }break;
                case 9:{
                    file.write_file(student,worker);
                }break;
                case 1: {
                    int j=0;
                    while (j==0) {
                        screen.student();
                        s = scanner.nextInt();
                        switch (s) {
                            case 1: {
                                strArray = convertStrToArray(screen.add_in_stu());
                                student.add(Integer.parseInt(strArray[0]), strArray[1], Integer.parseInt(strArray[2]), Integer.parseInt(strArray[3]));
                            }break;
                            case 2: {
                                screen.screenAll(student.printAll());
                            }break;
                            case 3:{
                                screen.screenAll(student.search(screen.search()));
                            }break;
                            case 4:{
                                screen.screenAll(student.delete(screen.search()));
                            }break;
                            case 5:{
                                strArray = convertStrToArray(screen.add_in_stu());
                                if(student.delete(Integer.parseInt(strArray[0]))=="已删除"){
                                    student.add(Integer.parseInt(strArray[0]), strArray[1], Integer.parseInt(strArray[2]), Integer.parseInt(strArray[3]));
                                }
                            }break;
                            case 6:{j=1;}break;
                        }
                    }
                }break;
                case 2: {
                    int j=0;
                    while (j==0) {
                        screen.worker();
                        s = scanner.nextInt();
                        switch (s) {
                            case 1: {
                                strArray = convertStrToArray(screen.add_in_wor());
                                worker.add(Integer.parseInt(strArray[0]), strArray[1], Integer.parseInt(strArray[2]), Integer.parseInt(strArray[3]),strArray[4]);
                            }break;
                            case 2: {
                                screen.screenAll(worker.printAll());
                            }break;
                            case 3:{
                                screen.screenAll(worker.search(screen.search()));
                            }break;
                            case 4:{
                                screen.screenAll(worker.delete(screen.search()));
                            }break;
                            case 5:{
                                strArray = convertStrToArray(screen.add_in_wor());
                                if(worker.delete(Integer.parseInt(strArray[0]))=="已删除"){
                                    worker.add(Integer.parseInt(strArray[0]), strArray[1], Integer.parseInt(strArray[2]), Integer.parseInt(strArray[3]),strArray[4]);
                                }
                            }break;
                            case 6:{j=1;}break;
                        }
                    }
                }break;
                case 3:{k=1;}break;
            }
        }




    }

    public static String[] convertStrToArray(String str){
        String[] strArray = null;
        strArray = str.split(",");
        return strArray;
    }

}
