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

        Page new_module_page = new New_Module(base, (Home)home_page);
        base.Add_Page(new_module_page, "New Module");

        Page module_panel_page = new Module_Panel(base, (Home)home_page);
        base.Add_Page(module_panel_page, "Module Panel");

        Page new_page = new New_Page(base, (Module_Panel)module_panel_page);
        base.Add_Page(new_page, "New Page");

        base.pack();

        base.Display_Page("Home Page");
    }
}
