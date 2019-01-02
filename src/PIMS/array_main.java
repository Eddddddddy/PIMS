package PIMS;

import java.util.*;

public class array_main {
    public static void main(String args[]){
        Student student=new Student();
        Worker worker[]=new Worker[10];
        Screen screen=new Screen();
        screen.menu();
        Scanner scanner = new Scanner(System.in);
        int s;
        s=scanner.nextInt();
        while (true) {
            switch (s) {
                case 1: {
                    screen.student();
                    s=scanner.nextInt();
                    switch (s){
                        case 1:student.add(Integer.parseInt(scanner.nextLine()),scanner.nextLine(),Integer.parseInt(scanner.nextLine()),Integer.parseInt(scanner.nextLine()));
                    }
                }
                case 2: {
                    screen.worker();
                }
                case 3://退出
            }
        }
    }
}
