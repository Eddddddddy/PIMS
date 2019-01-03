package View;

import PIMS.Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    CardLayout cardLayout = new CardLayout();

    JFrame f = new JFrame("学生管理系统");

    JPanel p_card = new JPanel(cardLayout);
    JPanel p_card_s = new JPanel();
    JPanel p_card_w = new JPanel();
    JPanel p_Search_s = new JPanel();
    JPanel p_Search_w = new JPanel();
    JPanel p_Operation_s = new JPanel();
    JPanel p_Button_s = new JPanel();
    JPanel p_Operation_w = new JPanel();
    JPanel p_Button_w = new JPanel();
    JPanel p_switch=new JPanel();
    JPanel p_L = new JPanel();

    public JTextArea t = new JTextArea(30, 10);
    public JScrollPane show_t = new JScrollPane(t);

    public JButton button_Search_s = new JButton("搜索");
    public JButton button_Search_w = new JButton("搜索");
    public JButton button_Modify_s = new JButton("修改");
    public JButton button_Delete_s = new JButton("删除");
    public JButton button_Add_s = new JButton("添加");
    public JButton button_Modify_w = new JButton("修改");
    public JButton button_Delete_w = new JButton("删除");
    public JButton button_Add_w = new JButton("添加");
    public JButton button_Stu = new JButton("学生信息");
    public JButton button_Wor = new JButton("工人信息");

    public JTextField s_ID_s = new JTextField(42);
    public JTextField s_ID_w = new JTextField(42);
    public JTextField t_ID_s = new JTextField(10);
    public JTextField t_name_s = new JTextField(10);
    public JTextField t_age_s = new JTextField(4);
    public JTextField t_ID_w = new JTextField(10);
    public JTextField t_name_w = new JTextField(10);
    public JTextField t_age_w = new JTextField(4);
    public JTextField t_score = new JTextField(4);
    public JTextField t_salary = new JTextField(4);
    public JTextField t_work = new JTextField(4);

    public JLabel l = new JLabel("欢迎使用");



    public Gui() {

        f.setLayout(null);
        f.setSize(800, 600);
        f.setLocation(300, 200);
        t.setEditable(false);

        //p_card_s.setLayout(new FlowLayout(FlowLayout.LEFT));

        show_t.setBounds(0, 0, 787, 300);
        p_card.setBounds(0, 300, 800, 200);
        p_switch.setBounds(0, 500, 800, 50);
        p_L.setBounds(0, 550, 800, 50);
        p_L.setLayout(new FlowLayout(FlowLayout.CENTER));

        p_Button_s.add(button_Add_s);
        p_Button_s.add(button_Delete_s);
        p_Button_s.add(button_Modify_s);
        p_Button_w.add(button_Add_w);
        p_Button_w.add(button_Delete_w);
        p_Button_w.add(button_Modify_w);

        p_Operation_s.add(new JLabel("ID："));
        p_Operation_s.add(t_ID_s);
        p_Operation_s.add(new JLabel("    姓名："));
        p_Operation_s.add(t_name_s);
        p_Operation_s.add(new JLabel("    年龄："));
        p_Operation_s.add(t_age_s);
        p_Operation_s.add(new JLabel("    分数："));
        p_Operation_s.add(t_score);
        p_Operation_w.add(new JLabel("ID："));
        p_Operation_w.add(t_ID_w);
        p_Operation_w.add(new JLabel("    姓名："));
        p_Operation_w.add(t_name_w);
        p_Operation_w.add(new JLabel("    年龄："));
        p_Operation_w.add(t_age_w);
        p_Operation_w.add(new JLabel("    薪水："));
        p_Operation_w.add(t_salary);
        p_Operation_w.add(new JLabel("    工种："));
        p_Operation_w.add(t_work);

        p_Search_s.add(new JLabel("学号："));
        p_Search_s.add(s_ID_s);
        p_Search_s.add(button_Search_s);
        p_Search_w.add(new JLabel("学号："));
        p_Search_w.add(s_ID_w);
        p_Search_w.add(button_Search_w);

        p_card_s.add(p_Search_s);
        p_card_s.add(p_Operation_s);
        p_card_s.add(p_Button_s);
        p_card_w.add(p_Search_w);
        p_card_w.add(p_Operation_w);
        p_card_w.add(p_Button_w);
        p_card.add(p_card_s,"s");
        p_card.add(p_card_w,"w");

        p_switch.add(button_Stu);
        p_switch.add(button_Wor);

        p_L.add(l);

        f.add(show_t);
        f.add(p_card);
        f.add(p_switch);
        f.add(p_L);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Switch();

    }

    public void Switch(){
        button_Stu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(p_card,"s");
            }
        });
        button_Wor.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(p_card,"w");
            }
        });
    }

    public void Add(){
        button_Add_s.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

}
