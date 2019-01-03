package PIMS;

import java.util.ArrayList;

public class Worker{
    int i=0;
    //Wor worker[]=new Wor[10];
    Screen screen = new Screen();

    ArrayList list_wor=new ArrayList();

    public class Wor extends Person{
        int salary;
        String work;
        void Wor(){}
        void Wor(int ID,String name,int age,int salary,String work){
            super.Person(ID,name,age);
            this.salary=salary;
            this.work=work;
        }
    }

    void add(int ID,String name,int age,int salary,String work){
        try {
            Wor temp=new Wor();
            temp.salary=salary;
            temp.age=age;
            temp.ID=ID;
            temp.name=name;
            temp.work=work;
            list_wor.add(temp);
            screen.succeed_add();
        }catch(Exception e){
            screen.full();
        }
    }

    String printAll(){
        String temp="工人信息\r\n";
        Wor[] values = (Wor[])list_wor.toArray(new Wor[0]);
        for(int i=0;i<list_wor.size();i++){
                temp+=("ID:"+values[i].ID+"name:"+values[i].name+"age:"+values[i].age+"score:"+values[i].salary+"work:"+values[i].work+"\r\n");
        }
        return temp;
    }

    String search(int a){
        Wor[] values = (Wor[])list_wor.toArray(new Wor[0]);
        for(int i=0;i<list_wor.size();i++){
                if(values[i].ID==a){
                    return ("ID:"+values[i].ID+"name:"+values[i].name+"age:"+values[i].age+"score:"+values[i].salary+"work:"+values[i].work);
                }
        }
        return "无该工人";
    }

    String delete(int a){
        Wor[] values = (Wor[])list_wor.toArray(new Wor[0]);
        for(int i=0;i<list_wor.size();i++){

                if(values[i].ID==a){
                    list_wor.remove(i);
                    return "已删除";
                }

        }
        return "无该工人";
    }
}
