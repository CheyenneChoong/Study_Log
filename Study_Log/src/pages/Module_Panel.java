package pages; /*Package containing the class.*/

/*Import API.*/
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

import edit.Read;

public class Module_Panel extends JPanel implements Page { /*Module Panel Page.*/
    private SpringLayout layout = new SpringLayout();
    private Base_Frame base_link;
    private Home home_link;
    private Read file = new Read();
    private String module_id;

    private JLabel module_name;
    private JButton edit_button;
    private JButton delete_button;
    private JButton back_button;
    private JComboBox<String> filter_input;
    private JTextField search_input;
    private JButton search_button;
    private JButton add_button;
    private JTable table;
    private JScrollPane scroll;

    public Module_Panel(Base_Frame base, Home home_page) {
        /*Set up page size, background colour and layout manager.*/
        setSize(1200, 763);
        setBackground(Color.decode("#A4DFDC"));
        setLayout(layout);

        /*Connection to previous pages.*/
        base_link = base;
        home_link = home_page;
        
        /*Title label.*/
        module_name = new JLabel("Module Name");
        module_name.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(module_name);
        layout.putConstraint(SpringLayout.NORTH, module_name, 15, SpringLayout.NORTH, this);

        /*Edit button.*/
        edit_button = new JButton("Edit");
        edit_button.setBackground(Color.decode("#CF62F4"));
        add(edit_button);
        layout.putConstraint(SpringLayout.NORTH, edit_button, 15, SpringLayout.NORTH, this);

        /*Delete button.*/
        delete_button = new JButton("Delete");
        delete_button.setBackground(Color.decode("#CF62F4"));
        add(delete_button);
        layout.putConstraint(SpringLayout.NORTH, delete_button, 15, SpringLayout.NORTH, this);

        /*Back button.*/
        back_button = new JButton("x");
        back_button.setBackground(Color.decode("#E96F6F"));
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Button_Function("Back");
            }
        });
        add(back_button);
        layout.putConstraint(SpringLayout.NORTH, back_button, 15, SpringLayout.NORTH, this);

        /*Drop down filter option.*/
        filter_input = new JComboBox<>(new String[] {"Lecture", "Tutorial / Lab", "Assignment"});
        filter_input.setBackground(Color.decode("#E3D3FD"));
        add(filter_input);
        layout.putConstraint(SpringLayout.NORTH, filter_input, 50, SpringLayout.NORTH, module_name);

        /*Search bar.*/
        search_input = new JTextField();
        search_input.setBackground(Color.decode("#E3D3FD"));
        search_input.setFont(new Font("Arial", Font.PLAIN, 18));
        add(search_input);
        layout.putConstraint(SpringLayout.NORTH, search_input, 50, SpringLayout.NORTH, module_name);

        /*Search button*/
        search_button = new JButton("Search");
        search_button.setBackground(Color.decode("#9762F4"));
        search_button.setForeground(Color.WHITE);
        add(search_button);
        layout.putConstraint(SpringLayout.NORTH, search_button, 50, SpringLayout.NORTH, module_name);

        /*Add Button*/
        add_button = new JButton("+");
        add_button.setBackground(Color.decode("#9762F4"));
        add_button.setForeground(Color.WHITE);
        add_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Button_Function("New");
            }
        });
        add(add_button);
        layout.putConstraint(SpringLayout.NORTH, add_button, 50, SpringLayout.NORTH, module_name);

        /*Table displaying all the module notes.*/
        table = new JTable();
        scroll = new JScrollPane(table);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.decode("#FAD3FD"));
        header.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(scroll);
        layout.putConstraint(SpringLayout.NORTH, scroll, 95, SpringLayout.NORTH, module_name);

        Layout();
    }

    public void Layout() {
        Component anchor = Module_Panel.this;
        int width = Module_Panel.this.getWidth();
        int height = Module_Panel.this.getHeight();

        layout.putConstraint(SpringLayout.WEST, module_name, (int)((51.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.WEST, edit_button, (int)((860.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, edit_button, -(int)((231.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, delete_button, (int)((982.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, delete_button, -(int)((109.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, back_button, (int)((1104.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, back_button, -(int)((51.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, filter_input, (int)((51.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, filter_input, -(int)((960.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, search_input, (int)((254.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, search_input, -(int)((506.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, search_button, (int)((714.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, search_button, -(int)((322.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, add_button, (int)((1104.0 / 1140.0) * (width - 60)), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, add_button, -(int)((51.0 / 1140.0) * (width - 60)), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, scroll, (int)((51.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, scroll, -(int)((51.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.SOUTH, scroll, -(int)((42.0 / 763.0) * height), SpringLayout.SOUTH, anchor);
        revalidate();
        repaint();
    }

    /*Method for displaying all the data.*/
    public void Display_Data(String mode) {
        String[][] data = null;
        String[] column = null;
        int[] widths = null;

        switch (mode) {
            case "All" :
                String[][] all_data = file.multiple(module_id, 1, "Study_Log/src/data/notes.txt");
                if (all_data != null) {
                    data = new String[all_data.length][2];
                    for (int row = 0; row < all_data.length; row++) {
                        data[row][0] = all_data[row][2];
                        data[row][1] = all_data[row][4];
                    }
                }
                column = new String[] {"Date", "Title"};
                widths = new int[] {204, 500};
        }

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

    public void Display_Module(String id) {
        String[] data = file.one(id, "Study_Log/src/data/module.txt");
        module_name.setText(data[1]);
        module_id = id;
        Display_Data("All");
    }

    public String Module_Code() {
        return module_id;
    }

    private void Button_Function(String action) {
        switch (action) {
            case "Edit" : System.out.println("Edit."); break;
            case "Delete" : System.out.println("Delete."); break;
            case "Back" :
                base_link.Display_Page("Home");
                home_link.Display_Data("All");
                break;
            case "New" : 
                base_link.Display_Page("New Page");
                break;
        }
    }
}
