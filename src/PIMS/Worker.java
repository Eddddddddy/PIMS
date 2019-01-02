package PIMS;

public class Worker extends Person {
    double salary;
    String work;
    void Worker(){}
    void Worker(int ID,String name,int age,double salary,String work){
        super.Person(ID, name, age);
        this.salary=salary;
        this.work=work;
    }
}
