package PIMS;

public class Student{
    int i=0;
    Stu student[]=new Stu[10];
    Screen screen = new Screen();

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
            while (student[i] != null) i++;
            student[i]=new Stu();
            student[i].score=score;
            student[i].age=age;
            student[i].ID=ID;
            student[i].name=name;
            screen.succeed_add();
        }catch(Exception e){
            screen.full();
        }
    }

    String printAll(){
        String temp="学生信息\r\n";
        for(int i=0;i<10;i++){
            if(student[i]!=null){
                temp+=("ID:"+student[i].ID+"name:"+student[i].name+"age:"+student[i].age+"score:"+student[i].score+"\r\n");
            }
        }
        return temp;
    }

    String search(int a){
        for(int i=0;i<10;i++){
            if(student[i]!=null){
                if(student[i].ID==a){
                    return ("ID:"+student[i].ID+"name:"+student[i].name+"age:"+student[i].age+"score:"+student[i].score);
                }
            }
        }
        return "无该学生";
    }

    String delete(int a){
        for(int i=0;i<10;i++){
            if(student[i]!=null){
                if(student[i].ID==a){
                    student[i]=null;
                    return "已删除";
                }
            }
        }
        return "无该学生";
    }

    String modify(int ID,String name,int age,int score){
        for(int i=0;i<10;i++){
            if(student[i]!=null){
                if(student[i].ID==ID){
                    student[i].name=name;
                    student[i].age=age;
                    student[i].score=score;
                    return "已修改";
                }
            }
        }
        return "无该学生";
    }
}
