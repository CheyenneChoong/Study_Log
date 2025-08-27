package pages; /*Package containing the home page. */

/*Import API and module needed.*/
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import edit.Read;

public class Home extends JPanel implements Page { /*Class for the home page.*/
    private SpringLayout layout = new SpringLayout(); /*Layout manager.*/
    private Read file = new Read(); /*Read object for reading files.*/

    /*Establishing the widgets.*/
    private JLabel title;
    private JButton add_button;
    private JTable table;
    private JScrollPane scroll;
    private Base_Frame base_link;

    public Home() { /*Constructor method.*/
        /*Set up of the page size, background colour and layout manager.*/
        setSize(1200, 763);
        setBackground(Color.decode("#A4DFDC"));
        setLayout(layout);
        
        /*Title label.*/
        title = new JLabel("STUDY LOG");
        title.setForeground(Color.decode("#45005A"));
        title.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(title);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);

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
        table.getSelectionModel().addListSelectionListener(e -> {
            if(!e.getValueIsAdjusting()) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    base_link.Display_Page("Module Panel");
                    Module_Panel current = (Module_Panel) base_link.Current_Page();
                    current.Display_Module(String.valueOf(table.getValueAt(row, 0)));
                }
            }
        });
        /*Header colour and design.*/
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.decode("#FAD3FD"));
        header.setFont(new Font("Tahoma", Font.BOLD, 12));
        /*Scroll bar.*/
        scroll = new JScrollPane(table);
        add(scroll);
        layout.putConstraint(SpringLayout.NORTH, scroll, 40, SpringLayout.NORTH, add_button);

        /*Default display.*/
        Layout();
        Display_Data("All");
    }

    /*Method for creating connections to other pages.*/
    public void Page_Connection(Object context) {
        base_link = (Base_Frame) context;
    }

    /*Method for adjusting the layout.*/
    public void Layout() {
        Component anchor = Home.this;
        int width = Home.this.getWidth();
        int height = Home.this.getHeight();
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
        String[][] data = file.all("Study_Log/src/data/module.txt");
        String[] column = {"Module Code", "Module Name"};
        int[] widths = {204, 500};

        DefaultTableModel model = new DefaultTableModel(data, column) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(model);
        for (int index = 0; index < widths.length; index++) {
            table.getColumnModel().getColumn(index).setMinWidth(widths[index]);
        }
    }
}
