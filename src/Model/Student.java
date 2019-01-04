package Model;

import java.util.ArrayList;

public class Student{
    ArrayList list_stu=new ArrayList();

    public class Stu extends Person{
        int score;
    }

    public String add(int ID, String name, int age, int score){
        try {
            Stu temp=new Stu();
            temp.score=score;
            temp.age=age;
            temp.ID=ID;
            temp.name=name;
            list_stu.add(temp);
            return "添加成功";
        }catch(Exception e){
            return "添加失败";
        }
    }

    public String printAll(){
        String temp="学生信息\r\n";
        Stu[] values = (Stu[])list_stu.toArray(new Stu[0]);
        for(int i=0;i<list_stu.size();i++){
                temp+=("ID:"+values[i].ID+"\t\tname:"+values[i].name+"\t\tage:"+values[i].age+"\t\tscore:"+values[i].score+"\r\n");
        }
        return temp;
    }

    public String showAll(){
        String temp="学生信息\r\n";
        Stu[] values = (Stu[])list_stu.toArray(new Stu[0]);
        for(int i=0;i<list_stu.size();i++){
            temp+=(values[i].ID+","+values[i].name+","+values[i].age+","+values[i].score+"\r\n");
        }
        return temp;
    }

    public String search(int a){
        Stu[] values = (Stu[])list_stu.toArray(new Stu[0]);
        for(int i=0;i<list_stu.size();i++){
                if(values[i].ID==a){
                    return (values[i].ID+","+values[i].name+","+values[i].age+","+values[i].score);
                }
        }
        return "无该学生";
    }

    public String search(String a){
        Stu[] values = (Stu[])list_stu.toArray(new Stu[0]);
        for(int i=0;i<list_stu.size();i++){
            if(values[i].name.equals(a)){
                return (values[i].ID+","+values[i].name+","+values[i].age+","+values[i].score);
            }
        }
        int[] same=new int[100];
        char[] toCharArray_a=a.toCharArray();
        for(int i=0;i<list_stu.size();i++){
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
            return (values[max_i].ID+","+values[max_i].name+","+values[max_i].age+","+values[max_i].score);
        }
        return "无该学生";
    }

    public String delete(int a){
        Stu[] values = (Stu[])list_stu.toArray(new Stu[0]);
        for(int i=0;i<list_stu.size();i++){

                if(values[i].ID==a){
                    list_stu.remove(i);
                    return "已删除";
                }

        }
        return "无该学生";
    }

    public void deleteAll(){
        list_stu.clear();
    }

    public void readList(ArrayList temp){
        list_stu=temp;
    }
}
