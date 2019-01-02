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
            student[i].Stu(ID, name, age, score);
//            student[i].score=score;
//            student[i].age=age;
//            student[i].ID=ID;
//            student[i].name=name;
            screen.succeed_add();
        }catch(Exception e){
            screen.full();
        }
    }
}
