package PIMS;

import Control.Control;
import Model.Student_SQL;
import Model.Worker_SQL;
import View.Gui;

public class PIMS_main {

    public static void main(String[] args){

        Gui gui=new Gui();
        Student_SQL student=new Student_SQL();
        Worker_SQL worker=new Worker_SQL();
        Control control=new Control(gui,student,worker);


    }

}
