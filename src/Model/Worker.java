package Model;

import java.util.ArrayList;

public class Worker{
    ArrayList list_wor=new ArrayList();

    public class Wor extends Person{
        int salary;
        String work;
    }

    public String add(int ID, String name, int age, int salary, String work){
        try {
            Wor temp=new Wor();
            temp.salary=salary;
            temp.age=age;
            temp.ID=ID;
            temp.name=name;
            temp.work=work;
            list_wor.add(temp);
            return "添加成功";
        }catch(Exception e){
            return "添加失败";
        }
    }

    public String printAll(){
        String temp="工人信息\r\n";
        Wor[] values = (Wor[])list_wor.toArray(new Wor[0]);
        for(int i=0;i<list_wor.size();i++){
                temp+=("ID:"+values[i].ID+"\t\tname:"+values[i].name+"\t\tage:"+values[i].age+"\t\tsalary:"+values[i].salary+"\t\twork:"+values[i].work+"\r\n");
        }
        return temp;
    }

    public String showAll(){
        String temp="工人信息\r\n";
        Wor[] values = (Wor[])list_wor.toArray(new Wor[0]);
        for(int i=0;i<list_wor.size();i++){
            temp+=(values[i].ID+","+values[i].name+","+values[i].age+","+values[i].salary+","+values[i].work+"\r\n");
        }
        return temp;
    }

    public String search(int a){
        Wor[] values = (Wor[])list_wor.toArray(new Wor[0]);
        for(int i=0;i<list_wor.size();i++){
                if(values[i].ID==a){
                    return (values[i].ID+","+values[i].name+","+values[i].age+","+values[i].salary+","+values[i].work);
                }
        }
        return "无该工人";
    }

    public String delete(int a){
        Wor[] values = (Wor[])list_wor.toArray(new Wor[0]);
        for(int i=0;i<list_wor.size();i++){

                if(values[i].ID==a){
                    list_wor.remove(i);
                    return "已删除";
                }

        }
        return "无该工人";
    }

    public void deleteAll(){
        list_wor.clear();
    }

    public void readList(ArrayList temp){
        list_wor=temp;
    }
}
