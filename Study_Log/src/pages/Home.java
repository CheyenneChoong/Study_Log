package pages; /*Package containing the home page. */

/*Import API and module needed.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JPanel implements Page {
    private SpringLayout layout = new SpringLayout();
    private JLabel title;
    private JTextField search_input;
    private JButton search_button;
    private JButton add_button;
    private JTable table;
    private JScrollPane scroll;
    private Base_Frame base_link;

    public Home(Base_Frame base) { /*Constructor method.*/
        /*Set up of the page size, background colour and layout manager.*/
        setSize(1200, 763);
        setBackground(Color.decode("#A4DFDC"));
        setLayout(layout);
        base_link = base;
        
        /*Title label.*/
        title = new JLabel("STUDY LOG");
        title.setForeground(Color.decode("#45005A"));
        title.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(title);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);

        /*Search bar input.*/
        search_input = new JTextField();
        search_input.setBackground(Color.decode("#E3D3FD"));
        search_input.setFont(new Font("Arial", Font.PLAIN, 18));
        add(search_input);
        layout.putConstraint(SpringLayout.NORTH, search_input, 60, SpringLayout.NORTH, title);

        /*Search button.*/
        search_button = new JButton("Search");
        search_button.setBackground(Color.decode("#9762F4"));
        search_button.setForeground(Color.WHITE);
        add(search_button);
        layout.putConstraint(SpringLayout.NORTH, search_button, 60, SpringLayout.NORTH, title);

        /*Add button.*/
        add_button = new JButton("+");
        add_button.setBackground(Color.decode("#9762F4"));
        add_button.setForeground(Color.WHITE);
        add_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                base_link.Display_Page("New Module");
            }
        });
        add(add_button);
        layout.putConstraint(SpringLayout.NORTH, add_button, 60, SpringLayout.NORTH, title);

        /*Table containing the list of modules.*/
        table = new JTable();
        scroll = new JScrollPane(table);
        add(scroll);
        layout.putConstraint(SpringLayout.NORTH, scroll, 40, SpringLayout.NORTH, search_input);

        Layout();
    }

    /*Method for adjusting the layout.*/
    public void Layout() {
        Component anchor = Home.this;
        int width = Home.this.getWidth();
        int height = Home.this.getHeight();
        layout.putConstraint(SpringLayout.WEST, search_input, (int)((51.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, search_input, -(int)((709.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, search_button, (int)((522.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, search_button, -(int)((525.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, add_button, (int)((1089.0 / 1140.0) * (width - 60)), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, add_button, -(int)((51.0 / 1140.0) * (width - 60)), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, scroll, (int)((51.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, scroll, -(int)((51.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.SOUTH, scroll, -(int)((60.0 / 763.0) * height), SpringLayout.SOUTH, anchor);
        revalidate();
        repaint();
    }

    /*Method for displaying all the data.*/
    public void Display_Data(String mode) {
        switch (mode) {
            case "All" : System.out.println("Work in progress"); break;
        }
    }
}
