package PIMS;

public class Screen {
    void menu(){
        System.out.println("1.学生信息管理\r\n2.工人信息管理\r\n3.退出系统");
    }
    void student(){
        System.out.println("1.增加学生信息\r\n2.列出全部学生信息\r\n3.查询学生信息\n4.删除学生信息\n5.修改学生信息\n6.返回上一级菜单");
    }
    void worker(){
        System.out.println("1.增加工人信息\r\n2.列出全部工人信息\r\n3.查询工人信息\n4.删除工人信息\n5.修改工人信息\n6.返回上一级菜单");
    }
    void full(){
        System.out.println("满了");
    }
    void succeed_add(){
        System.out.println("添加成功");
    }
}
