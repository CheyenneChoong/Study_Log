package gui; /*Package containing the code.*/

/*Import Java API.*/
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;

public class Page_Panel extends JPanel { /*Class for creating the base frame.*/
    private GridLayout layout = new GridLayout();
    
    /*Constructor method.*/
    public Page_Panel(String colour) {
        setLayout(layout);
        setBackground(Color.decode(colour));
        setSize(100, 100);
    }
}
