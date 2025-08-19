package gui; /*Package containing the code.*/

/*Import API needed for creating the interface.*/
import javax.swing.*;
import java.awt.*;

public class Base_Frame extends JFrame { /*Class for creating the base window frame.*/
    private JPanel base = new JPanel(); /*Panel created.*/
    private CardLayout layout = new CardLayout(); /*Layout manager selected.*/

    public Base_Frame(String title) { /*Constructor method.*/
        setTitle(title); /*Title of the frame.*/
        setDefaultCloseOperation(EXIT_ON_CLOSE); /*Default closing method.*/
        setSize(100, 100); /*Initialize size.*/
        add(base); /*Adds the base to the JFrame.*/
        base.setLayout(layout); /*Link the layout to the panel.*/
    }

    /*Method for adding pages to the frame.*/
    public void Add_Page(JPanel panel, String name) {
        base.add(panel, name);
    }

    /*Method for displaying the selected pages.*/
    public void Display_Page(String name) {
        layout.show(base, name);
    }
}
