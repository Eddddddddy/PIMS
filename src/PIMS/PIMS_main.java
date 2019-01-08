package PIMS;

import Control.Control;
import Model.Student;
import Model.Worker;
import View.Gui;

public class PIMS_main {

    public static void main(String[] args){

        Gui gui=new Gui();
        Student student=new Student();
        Worker worker=new Worker();
        Control control=new Control(gui,student,worker);


    }

}
