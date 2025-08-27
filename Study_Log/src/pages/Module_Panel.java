package pages; /*Package containing the class.*/

/*Import API.*/
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import edit.*;

public class Module_Panel extends JPanel implements Page { /*Module Panel Page.*/
    /*Layout manager, connection to other frames and variable / arrays needed.*/
    private SpringLayout layout = new SpringLayout();
    private Base_Frame base_link;
    private Home home_link;
    private New_Module new_module_link;
    private View_Page page_link;
    private Read file = new Read();
    private String module_id;
    private String[][] all_data;

    /*Widgets in the frame.*/
    private JLabel module_name;
    private JButton edit_button;
    private JButton delete_button;
    private JButton back_button;
    private JComboBox<String> filter_input;
    private JButton add_button;
    private JTable table;
    private JScrollPane scroll;

    public Module_Panel() {
        /*Set up page size, background colour and layout manager.*/
        setSize(1200, 763);
        setBackground(Color.decode("#A4DFDC"));
        setLayout(layout);
        
        /*Title label.*/
        module_name = new JLabel("Module Name");
        module_name.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(module_name);
        layout.putConstraint(SpringLayout.NORTH, module_name, 15, SpringLayout.NORTH, this);

        /*Edit button.*/
        edit_button = new JButton("Edit");
        edit_button.setBackground(Color.decode("#CF62F4"));
        edit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Button_Function("Edit");
            }
        });
        add(edit_button);
        layout.putConstraint(SpringLayout.NORTH, edit_button, 15, SpringLayout.NORTH, this);

        /*Delete button.*/
        delete_button = new JButton("Delete");
        delete_button.setBackground(Color.decode("#CF62F4"));
        delete_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Button_Function("Delete");
            }
        });
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
        filter_input.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Display_Data("Filter");
            }
        });
        add(filter_input);
        layout.putConstraint(SpringLayout.NORTH, filter_input, 50, SpringLayout.NORTH, module_name);

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
        table.getSelectionModel().addListSelectionListener(e -> {
            if(!e.getValueIsAdjusting()) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    base_link.Display_Page("View Page");
                    page_link.Display_Note(all_data[row][0]);
                }
            }
        });
        /*Scroll and header display.*/
        scroll = new JScrollPane(table);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.decode("#FAD3FD"));
        header.setFont(new Font("Tahoma", Font.BOLD, 12));
        add(scroll);
        layout.putConstraint(SpringLayout.NORTH, scroll, 95, SpringLayout.NORTH, module_name);

        /*Default display.*/
        Layout();
    }

    /*Method for creating link between pages.*/
    public void Page_Connection(Object context) {
        if (context instanceof Base_Frame) {
            base_link = (Base_Frame) context;
        } else if (context instanceof Home) {
            home_link = (Home) context;
        } else if (context instanceof New_Module) {
            new_module_link = (New_Module) context;
        } else if (context instanceof View_Page) {
            page_link = (View_Page) context;
        }
    }

    /*Method for adjusting the layout.*/
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
        layout.putConstraint(SpringLayout.WEST, add_button, (int)((1104.0 / 1140.0) * (width - 60)), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, add_button, -(int)((51.0 / 1140.0) * (width - 60)), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, scroll, (int)((51.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, scroll, -(int)((51.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.SOUTH, scroll, -(int)((42.0 / 763.0) * height), SpringLayout.SOUTH, anchor);
        revalidate();
        repaint();
    }
    
    /*Method for button functions.*/
    private void Button_Function(String action) {
        switch (action) {
            case "Edit" :
                base_link.Display_Page("New Module");
                new_module_link.Edit_Mode(module_id, module_name.getText());
                break;
            case "Delete" : 
                Update update = new Update();
                File_Data file_data = new File_Data();
                update.delete("Study_Log/src/data/module.txt", module_id);
                String[][] pages = file.multiple(module_id, 1, "Study_Log/src/data/notes.txt");
                if (pages != null) {
                    for (String[] row : pages) {
                        file_data.Delete_File(String.format("Study_Log/src/data/%s.txt", row[0]));
                        update.delete("Study_Log/src/data/notes.txt", row[0]);
                    }
                }
                base_link.Display_Page("Home");
                home_link.Display_Data("All");
                break;
            case "Back" :
                base_link.Display_Page("Home");
                home_link.Display_Data("All");
                break;
            case "New" : 
                base_link.Display_Page("New Page");
                break;
        }
    }

    /*Method for displaying all the data.*/
    public void Display_Data(String mode) {
        String[][] data = null;
        String[] column = {"Date", "Title"};
        int[] widths = {204, 500};

        switch (mode) {
            case "All" :
                all_data = file.multiple(module_id, 1, "Study_Log/src/data/notes.txt");
                if (all_data != null) {
                    data = new String[all_data.length][2];
                    for (int row = 0; row < all_data.length; row++) {
                        data[row][0] = all_data[row][2];
                        data[row][1] = all_data[row][4];
                    }
                }
                break;
            case "Filter" : 
                all_data = file.multiple(module_id, 1, "Study_Log/src/data/notes.txt");
                ArrayList<String> temp_list = new ArrayList<>();
                if (all_data != null) {
                    for (String[] row : all_data) {
                        if (row[3].equals(filter_input.getSelectedItem().toString())) {
                            temp_list.add(String.join(";", row));
                        }
                    }
                    String[] temp_array = temp_list.toArray(new String[0]);
                    data = new String[temp_array.length][2];
                    all_data = new String[temp_array.length][5];
                    for (int row = 0; row < temp_array.length; row++) {
                        all_data[row] = temp_array[row].split(";");
                        data[row][0] = temp_array[row].split(";")[2];
                        data[row][1] = temp_array[row].split(";")[4];
                    }
                }
                break;
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

    /* Method for displaying the selected module information.*/
    public void Display_Module(String id) {
        String[] data = file.one(id, "Study_Log/src/data/module.txt");
        module_name.setText(data[1]);
        module_id = id;
        Display_Data("All");
    }

    /*Method for retrieving the module code of the module being displayed.*/
    public String Module_Code() {
        return module_id;
    }
}
