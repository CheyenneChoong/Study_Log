package pages; /*Package containing the code.*/

/*Import API needed for creating the interface.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Base_Frame extends JFrame { /*Class for creating the base window frame.*/
    private JPanel base = new JPanel(); /*Panel created.*/
    private CardLayout layout = new CardLayout(); /*Layout manager selected.*/

    public Base_Frame(String title) { /*Constructor method.*/
        setTitle(title); /*Title of the frame.*/
        setDefaultCloseOperation(EXIT_ON_CLOSE); /*Default closing method.*/
        setSize(1200, 763); /*Initialize size.*/
        setMinimumSize(new Dimension(849, 540));
        add(base); /*Adds the base to the JFrame.*/
        base.setLayout(layout); /*Link the layout to the panel.*/

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e){
                Page panel = (Page)Current_Page();
                if (panel != null) {
                    panel.Layout();
                }
            }
        });
    }

    /*Method for adding pages to the frame.*/
    public void Add_Page(Page panel, String name) {
        base.add((JPanel) panel, name);
    }

    /*Method for displaying the selected pages.*/
    public void Display_Page(String name) {
        layout.show(base, name);
        Page current = (Page)Current_Page();
        current.Layout();
    }

    public Component Current_Page() {
        for (Component component : base.getComponents()) {
            if (component.isVisible()) {
                return component;
            }
        }
        return null;
    }
}
