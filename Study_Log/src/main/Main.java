package main; /*Package containing the code.*/

/*Import API needed for creating the interface.*/
import pages.*;

public class Main { /*Main class run.*/
    /*Main method.*/
    public static void main(String[] args){ 
        /*Establishing the frames.*/
        Base_Frame base = new Base_Frame("Study Log");
        Page home_page = new Home();
        Page new_module_page = new New_Module();
        Page module_panel_page = new Module_Panel();
        Page new_page = new New_Page();
        Page view_page = new View_Page();
        
        /*Establishing connections between the pages.*/
        home_page.Page_Connection(base);
        new_module_page.Page_Connection(base);
        new_module_page.Page_Connection((Home) home_page);
        new_module_page.Page_Connection((Module_Panel) module_panel_page);
        module_panel_page.Page_Connection(base);
        module_panel_page.Page_Connection((Home) home_page);
        module_panel_page.Page_Connection((New_Module) new_module_page);
        module_panel_page.Page_Connection((View_Page) view_page);
        new_page.Page_Connection(base);
        new_page.Page_Connection((Module_Panel) module_panel_page);
        new_page.Page_Connection((View_Page) view_page);
        view_page.Page_Connection(base);
        view_page.Page_Connection((Module_Panel)module_panel_page);
        view_page.Page_Connection((New_Page) new_page);

        /*Adds the pages to the base frame.*/
        base.Add_Page(home_page, "Home");
        base.Add_Page(module_panel_page, "Module Panel");
        base.Add_Page(new_module_page, "New Module");
        base.Add_Page(new_page, "New Page");
        base.Add_Page(view_page, "View Page");

        /*Set up and display the frame with the intended page.*/
        base.pack();
        base.setVisible(true);
        base.Display_Page("Home");
    }
}
