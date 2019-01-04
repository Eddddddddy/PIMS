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

    public String search(String a){
        Wor[] values = (Wor[]) list_wor.toArray(new Wor[0]);
        for(int i=0;i<list_wor.size();i++){
            if(values[i].name.equals(a)){
                return (values[i].ID+","+values[i].name+","+values[i].age+","+values[i].salary+","+values[i].work);
            }
        }
        int[] same=new int[100];
        char[] toCharArray_a=a.toCharArray();
        for(int i=0;i<list_wor.size();i++){
            char[] toCharArray = values[i].name.toCharArray();
            for(int j=0;j<toCharArray.length;j++){
                for(int k=0;k<toCharArray_a.length;k++){
                    if(toCharArray[j]==toCharArray_a[k]){
                        same[i]++;
                    }
                }
            }
        }
        int max=0,max_i=0;
        for(int i=0;i<100;i++){
            if(same[i]>max){
                max=same[i];
                max_i=i;
            }
        }
        if(max!=0){
            return (values[max_i].ID+","+values[max_i].name+","+values[max_i].age+","+values[max_i].salary+","+values[max_i].work);
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
