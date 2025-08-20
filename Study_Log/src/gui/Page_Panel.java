package gui; /*Package containing the code.*/

/*Import Java API.*/
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class Page_Panel extends JPanel { /*Class for creating the base frame.*/
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();

    /*Constructor method.*/
    public Page_Panel(String colour, int width, int height) {
        setBackground(Color.decode(colour));
        setLayout(layout);
        setSize(width, height);
        setMinimumSize(new Dimension(width, height));
    }

    /*Method for adding the widget into the panel.*/
    public void Add_Widget(JPanel widget, int x, int y, int width, int height) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        add(widget, gbc);
    }
}
