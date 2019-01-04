package PIMS;

import Control.Control;
import Model.File_fun;
import Model.Student;
import Model.Worker;
import View.Gui;

public class PIMS_main {
    public static void main(String[] args){

        Gui gui=new Gui();
        Student student=new Student();
        Worker worker=new Worker();
        File_fun file=new File_fun();
        Control control=new Control(gui,student,worker,file);

    }
}
