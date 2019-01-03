package PIMS;

import Model.File_fun;
import Model.Student;
import Model.Worker;
import View.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control {

    public Control(Gui gui, Student student, Worker worker, File_fun file){
        student.deleteAll();
        student.readList(file.read_file_stu());
        worker.deleteAll();
        worker.readList(file.read_file_wor());
        flash(gui, student);

        gui.button_Add_s.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                student.add(Integer.parseInt(gui.t_ID_s.getText()),gui.t_name_s.getText(),Integer.parseInt(gui.t_age_s.getText()),Integer.parseInt(gui.t_age_s.getText()));
                autoSave(file, student, worker);
                flash(gui,student);
            }
        });

        gui.button_Add_w.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                worker.add(Integer.parseInt(gui.t_ID_w.getText()),gui.t_name_w.getText(),Integer.parseInt(gui.t_age_w.getText()),Integer.parseInt(gui.t_age_w.getText()),gui.t_work.getText());
                autoSave(file, student, worker);
                flash(gui,worker);
            }
        });

        gui.button_Search_s.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp=student.search(Integer.parseInt(gui.s_ID_s.getText()));
                if(!temp.equals("无该学生")){
                    String[] strArray = convertStrToArray(temp);
                    gui.t_ID_s.setText(strArray[0]);
                    gui.t_name_s.setText(strArray[1]);
                    gui.t_age_s.setText(strArray[2]);
                    gui.t_score.setText(strArray[3]);
                }
            }
        });

        gui.button_Search_w.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp=worker.search(Integer.parseInt(gui.s_ID_w.getText()));
                if(!temp.equals("无该工人")){
                    String[] strArray = convertStrToArray(temp);
                    gui.t_ID_w.setText(strArray[0]);
                    gui.t_name_w.setText(strArray[1]);
                    gui.t_age_w.setText(strArray[2]);
                    gui.t_salary.setText(strArray[3]);
                    gui.t_work.setText(strArray[4]);
                }
            }
        });

        gui.button_Delete_s.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp=student.delete(Integer.parseInt(gui.s_ID_s.getText()));
                if(temp.equals("已删除")){
;
                }else if(temp.equals("无该学生")){
                    ;
                }
                autoSave(file, student, worker);
                flash(gui,student);
            }
        });

        gui.button_Delete_w.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp=worker.delete(Integer.parseInt(gui.s_ID_w.getText()));
                if(temp.equals("已删除")){
                    ;
                }else if(temp.equals("无该工人")){
                    ;
                }
                autoSave(file, student, worker);
                flash(gui,worker);
            }
        });

    }


    public void autoSave(File_fun file, Student student, Worker worker) {
        file.write_file(student, worker);
    }

    public void flash(Gui gui, Student student) {
        gui.t.setText(student.printAll());
    }

    public void flash(Gui gui, Worker worker) {
        gui.t.setText(worker.printAll());
    }

    private static String[] convertStrToArray(String str){
        String[] strArray;
        strArray = str.split(",");
        return strArray;
    }
}
