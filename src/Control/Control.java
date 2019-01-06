package Control;

import Model.File_fun;
import Model.Student;
import Model.Worker;
import View.Gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control {

    public Control(Gui gui, Student student, Worker worker, File_fun file) {
        student.deleteAll();
        student.readList(file.read_file_stu());
        worker.deleteAll();
        worker.readList(file.read_file_wor());
        flash(gui, student);

        gui.button_Stu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.cardLayout.show(gui.p_card, "s");
                flash(gui, student);
                gui.l.setText("学生面板");
            }
        });

        gui.button_Wor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.cardLayout.show(gui.p_card, "w");
                flash(gui, worker);
                gui.l.setText("工人面板");
            }
        });

        gui.button_Add_s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gui.t_age_s.getText() != null && !gui.t_age_s.getText().trim().equals("") && gui.t_ID_s.getText() != null && !gui.t_ID_s.getText().trim().equals("") && gui.t_name_s.getText() != null && !gui.t_name_s.getText().trim().equals("") && gui.t_score.getText() != null && !gui.t_score.getText().trim().equals("")) {
                    if (student.search(Integer.parseInt(gui.t_ID_s.getText())).equals("无该学生")) {
                        student.add(Integer.parseInt(gui.t_ID_s.getText()), gui.t_name_s.getText(), Integer.parseInt(gui.t_age_s.getText()), Integer.parseInt(gui.t_score.getText()));
                        autoSave(file, student, worker);
                        flash(gui, student);
                        gui.l.setText("添加成功信息");
                    } else {
                        gui.l.setText("已有该生信息");
                    }
                } else {
                    gui.l.setText("请填入必要信息");
                }
            }
        });

        gui.button_Add_w.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gui.t_age_w.getText() != null && !gui.t_age_w.getText().trim().equals("") && gui.t_ID_w.getText() != null && !gui.t_ID_w.getText().trim().equals("") && gui.t_name_w.getText() != null && !gui.t_name_w.getText().trim().equals("") && gui.t_salary.getText() != null && !gui.t_salary.getText().trim().equals("") && gui.t_work.getText() != null && !gui.t_work.getText().trim().equals("")) {
                    if (worker.search(Integer.parseInt(gui.t_ID_w.getText())).equals("无该工人")) {
                        worker.add(Integer.parseInt(gui.t_ID_w.getText()), gui.t_name_w.getText(), Integer.parseInt(gui.t_age_w.getText()), Integer.parseInt(gui.t_salary.getText()), gui.t_work.getText());
                        autoSave(file, student, worker);
                        flash(gui, worker);
                        gui.l.setText("添加成功");
                    } else {
                        gui.l.setText("已有该人员信息");
                    }
                } else {
                    gui.l.setText("请填入必要信息");
                }
            }
        });

        gui.button_Search_s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (gui.s_ID_s.getText() != null && !gui.s_ID_s.getText().trim().equals("")) {
                        String temp = student.search(Integer.parseInt(gui.s_ID_s.getText()));
                        if (!temp.equals("无该学生")) {
                            String[] strArray = convertStrToArray(temp);
                            gui.t_ID_s.setText(strArray[0]);
                            gui.t_name_s.setText(strArray[1]);
                            gui.t_age_s.setText(strArray[2]);
                            gui.t_score.setText(strArray[3]);
                        } else {
                            gui.l.setText("未找到该生信息");
                        }
                    } else {
                        gui.l.setText("请填入必要信息");
                    }
                }catch (Exception e2){
                    String temp_n = student.search(gui.s_ID_s.getText());
                    if(!temp_n.equals("无该学生")) {
                        String[] strArray = convertStrToArray(temp_n);
                        gui.t_ID_s.setText(strArray[0]);
                        gui.t_name_s.setText(strArray[1]);
                        gui.t_age_s.setText(strArray[2]);
                        gui.t_score.setText(strArray[3]);
                    }
                }
            }
        });

        gui.button_Search_w.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (gui.s_ID_w.getText() != null && !gui.s_ID_w.getText().trim().equals("")) {
                        String temp = worker.search(Integer.parseInt(gui.s_ID_w.getText()));
                        if (!temp.equals("无该工人")) {
                            String[] strArray = convertStrToArray(temp);
                            gui.t_ID_w.setText(strArray[0]);
                            gui.t_name_w.setText(strArray[1]);
                            gui.t_age_w.setText(strArray[2]);
                            gui.t_salary.setText(strArray[3]);
                            gui.t_work.setText(strArray[4]);
                        } else {
                            gui.l.setText("未找到该人员信息");
                        }
                    } else {
                        gui.l.setText("请填入必要信息");
                    }
                }catch (Exception e2){
                    String temp_n = worker.search(gui.s_ID_w.getText());
                    if(!temp_n.equals("无该工人")) {
                        String[] strArray = convertStrToArray(temp_n);
                        gui.t_ID_w.setText(strArray[0]);
                        gui.t_name_w.setText(strArray[1]);
                        gui.t_age_w.setText(strArray[2]);
                        gui.t_salary.setText(strArray[3]);
                        gui.t_work.setText(strArray[4]);
                    }
                }
            }
        });

        gui.button_Delete_s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gui.s_ID_s.getText() != null && !gui.s_ID_s.getText().trim().equals("")) {
                    String temp = student.delete(Integer.parseInt(gui.s_ID_s.getText()));
                    if (temp.equals("已删除")) {
                        gui.l.setText("已删除");
                    } else if (temp.equals("无该学生")) {
                        gui.l.setText("未找到该生信息");
                    }
                    autoSave(file, student, worker);
                    flash(gui, student);
                } else {
                    gui.l.setText("请填入必要信息");
                }
            }
        });

        gui.button_Delete_w.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gui.s_ID_w.getText() != null && !gui.s_ID_w.getText().trim().equals("")) {
                    String temp = worker.delete(Integer.parseInt(gui.s_ID_w.getText()));
                    if (temp.equals("已删除")) {
                        gui.l.setText("已删除");
                    } else if (temp.equals("无该工人")) {
                        gui.l.setText("未找到该人员信息");
                    }
                    autoSave(file, student, worker);
                    flash(gui, worker);
                } else {
                    gui.l.setText("请填入必要信息");
                }
            }
        });

        gui.button_Modify_s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gui.t_age_s.getText() != null && !gui.t_age_s.getText().trim().equals("") && gui.t_ID_s.getText() != null && !gui.t_ID_s.getText().trim().equals("") && gui.t_name_s.getText() != null && !gui.t_name_s.getText().trim().equals("") && gui.t_score.getText() != null && !gui.t_score.getText().trim().equals("")) {
                    String temp = student.delete(Integer.parseInt(gui.t_ID_s.getText()));
                    if (temp.equals("已删除")) {
                        student.add(Integer.parseInt(gui.t_ID_s.getText()), gui.t_name_s.getText(), Integer.parseInt(gui.t_age_s.getText()), Integer.parseInt(gui.t_score.getText()));
                        gui.l.setText("已修改");
                    } else if (temp.equals("无该学生")) {
                        gui.l.setText("修改失败");
                    }
                    autoSave(file, student, worker);
                    flash(gui, student);
                } else {
                    gui.l.setText("请填入必要信息");
                }
            }
        });

        gui.button_Modify_w.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gui.t_age_w.getText() != null && !gui.t_age_w.getText().trim().equals("") && gui.t_ID_w.getText() != null && !gui.t_ID_w.getText().trim().equals("") && gui.t_name_w.getText() != null && !gui.t_name_w.getText().trim().equals("") && gui.t_salary.getText() != null && !gui.t_salary.getText().trim().equals("") && gui.t_work.getText() != null && !gui.t_work.getText().trim().equals("")) {

                    String temp = worker.delete(Integer.parseInt(gui.t_ID_w.getText()));
                    if (temp.equals("已删除")) {
                        worker.add(Integer.parseInt(gui.t_ID_w.getText()), gui.t_name_w.getText(), Integer.parseInt(gui.t_age_w.getText()), Integer.parseInt(gui.t_salary.getText()), gui.t_work.getText());
                        gui.l.setText("已修改");
                    } else if (temp.equals("无该工人")) {
                        gui.l.setText("修改失败");
                    }
                    autoSave(file, student, worker);
                    flash(gui, worker);
                } else {
                    gui.l.setText("请填入必要信息");
                }
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

    private static String[] convertStrToArray(String str) {
        String[] strArray;
        strArray = str.split(",");
        return strArray;
    }
}
