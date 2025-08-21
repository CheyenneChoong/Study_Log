package pages; /*Package containing the home page. */

/*Import API and module needed.*/
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Home extends JPanel {
    private SpringLayout layout = new SpringLayout();

    public Home() {
        /*Set up of the page size, background colour and layout manager.*/
        setSize(1200, 763);
        setMinimumSize(new Dimension(1200, 763));
        setBackground(Color.decode("#A4DFDC"));
        setLayout(layout);
        
        /*Title label.*/
        JLabel title = new JLabel("STUDY LOG");
        title.setForeground(Color.decode("#45005A"));
        title.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(title);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);

        /*Search bar input.*/
        JTextField search_input = new JTextField();
        search_input.setBackground(Color.decode("#E3D3FD"));
        search_input.setFont(new Font("Arial", Font.PLAIN, 20));
        add(search_input);
        layout.putConstraint(SpringLayout.NORTH, search_input, 50, SpringLayout.NORTH, title);
        layout.putConstraint(SpringLayout.WEST, search_input, (int)((51.0 / 1200.0) * this.getWidth()), SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, search_input, -(int)((709.0 / 1200.0) * this.getWidth()), SpringLayout.EAST, this);

        /*Search button.*/
        JButton search_button = new JButton("Search");
        search_button.setBackground(Color.decode("#9762F4"));
        search_button.setForeground(Color.WHITE);
        add(search_button);
        layout.putConstraint(SpringLayout.NORTH, search_button, 50, SpringLayout.NORTH, title);
        layout.putConstraint(SpringLayout.WEST, search_button, (int)((522.0 / 1200.0) * this.getWidth()), SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.EAST, search_button, -(int)((525.0 / 1200.0) * this.getWidth()), SpringLayout.EAST, this);

        /*Add button.*/
        JButton add_button = new JButton("+");
        add_button.setBackground(Color.decode("#9762F4"));
        add_button.setForeground(Color.WHITE);
        add(add_button);
        layout.putConstraint(SpringLayout.NORTH, add_button, 50, SpringLayout.NORTH, title);
        // layout.putConstraint(SpringLayout.WEST, add_button, );
    }


}
