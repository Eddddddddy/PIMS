package PIMS;

public class Worker extends Person {
    int i=0;
    Wor worker[]=new Wor[10];
    Screen screen = new Screen();

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
            while (worker[i] != null) i++;
            worker[i]=new Wor();
            worker[i].salary=salary;
            worker[i].age=age;
            worker[i].ID=ID;
            worker[i].name=name;
            worker[i].work=work;
            screen.succeed_add();
        }catch(Exception e){
            screen.full();
        }
    }

    String printAll(){
        String temp="工人信息\r\n";
        for(int i=0;i<10;i++){
            if(worker[i]!=null){
                temp+=("ID:"+worker[i].ID+"name:"+worker[i].name+"age:"+worker[i].age+"score:"+worker[i].salary+"work:"+worker[i].work+"\r\n");
            }
        }
        return temp;
    }

    String search(int a){
        for(int i=0;i<10;i++){
            if(worker[i]!=null){
                if(worker[i].ID==a){
                    return ("ID:"+worker[i].ID+"name:"+worker[i].name+"age:"+worker[i].age+"score:"+worker[i].salary+"work:"+worker[i].work);
                }
            }
        }
        return "无该工人";
    }

    String delete(int a){
        for(int i=0;i<10;i++){
            if(worker[i]!=null){
                if(worker[i].ID==a){
                    worker[i]=null;
                    return "已删除";
                }
            }
        }
        return "无该工人";
    }

    String modify(int ID,String name,int age,int salary,String work){
        for(int i=0;i<10;i++){
            if(worker[i]!=null){
                if(worker[i].ID==ID){
                    worker[i].name=name;
                    worker[i].age=age;
                    worker[i].salary=salary;
                    worker[i].work=work;
                    return "已修改";
                }
            }
        }
        return "无该工人";
    }
}
