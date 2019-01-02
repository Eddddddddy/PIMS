package PIMS;

import java.util.ArrayList;

public class Student{
    int i=0;
    //Stu student[]=new Stu[10];
    Screen screen = new Screen();

    ArrayList list_stu=new ArrayList();

    public class Stu extends Person{
        int score;
        void Stu(){}
        void Stu(int ID,String name,int age,int score){
            super.Person(ID,name,age);
            this.score=score;
        }
    }

    void add(int ID,String name,int age,int score){
        try {
            Stu temp=new Stu();
            temp.score=score;
            temp.age=age;
            temp.ID=ID;
            temp.name=name;
            list_stu.add(temp);
            screen.succeed_add();
        }catch(Exception e){
            screen.full();
        }
    }

    String printAll(){
        String temp="学生信息\r\n";
        Stu[] values = (Stu[])list_stu.toArray(new Stu[0]);
        for(int i=0;i<list_stu.size();i++){
                temp+=("ID:"+values[i].ID+"name:"+values[i].name+"age:"+values[i].age+"score:"+values[i].score+"\r\n");
        }
        return temp;
    }

    String search(int a){
        Stu[] values = (Stu[])list_stu.toArray(new Stu[0]);
        for(int i=0;i<list_stu.size();i++){
                if(values[i].ID==a){
                    return ("ID:"+values[i].ID+"name:"+values[i].name+"age:"+values[i].age+"score:"+values[i].score);
                }
        }
        return "无该学生";
    }

    String delete(int a){
        Stu[] values = (Stu[])list_stu.toArray(new Stu[0]);
        for(int i=0;i<list_stu.size();i++){

                if(values[i].ID==a){
                    list_stu.remove(i);
                    return "已删除";
                }

        }
        return "无该学生";
    }
}
