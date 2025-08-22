package main; /*Package containing the code.*/

/*Import API needed for creating the interface.*/
import pages.*;

public class Main { /*Main class run.*/
    /*Main method.*/
    public static void main(String[] args){ 
        Base_Frame base = new Base_Frame("Study Log");
        base.setVisible(true);

        Page home_page = new Home(base);
        base.Add_Page(home_page, "Home");

        Page new_module_page = new New_Module(base);
        base.Add_Page(new_module_page, "New Module");

        base.pack();

        base.Display_Page("Home");
    }
}
