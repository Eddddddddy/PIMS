package PIMS;

public class Student extends Person{
    double score;
    void Student(){}
    void Student(int ID,String name,int age,double score){
        super.Person(ID,name,age);
        this.score=score;
    }
}
