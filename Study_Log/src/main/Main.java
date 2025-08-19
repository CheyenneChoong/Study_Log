package main; /*Package containing the code.*/

/*Import API needed for creating the interface.*/
import gui.*;

public class Main { /*Main class run.*/

    /*Main method.*/
    public static void main(String[] args){ 
        Base_Frame base = new Base_Frame("Test");
        base.setVisible(true);

        Page_Panel panel_1 = new Page_Panel("#000000");
        Page_Panel panel_2 = new Page_Panel("#678909");

        base.Add_Page(panel_1, "1");
        base.Add_Page(panel_2, "2");
        base.Display_Page("1");
    }
}
