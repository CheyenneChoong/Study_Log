package main; /*Package containing the code.*/

/*Import API needed for creating the interface.*/
import gui.*;

public class Main { /*Main class run.*/

    /*Main method.*/
    public static void main(String[] args){ 
        Base_Frame base = new Base_Frame("Test", 500, 200);
        base.setVisible(true);

        Button btn_1 = new Button("BTN 1", 100, 20, "#000000");
        Button btn_2 = new Button("BTN 2", 100, 20, "#000000");
        Button btn_3 = new Button("BTN 3", 100, 20, "#000000");

        Page_Panel panel_1 = new Page_Panel("#000000", 500, 200);
        panel_1.Add_Widget(btn_1, 0, 1, 100, 20);
        panel_1.Add_Widget(btn_2, 1, 1, 100, 20);
        panel_1.Add_Widget(btn_3, 2, 1, 100, 20);
        
        base.Add_Page(panel_1, "1");
        base.Display_Page("1");
    }
}
