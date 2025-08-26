package pages; /*Package containing the class.*/

/*Import API needed.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import edit.*;

public class New_Module extends JPanel implements Page {
    private SpringLayout layout = new SpringLayout();
    private Base_Frame base_link;
    private Home home_link;
    private Module_Panel module_link;
    private int mode = 1;

    private JLabel title;
    private JLabel module_label;
    private JLabel code_label;
    private JTextField module_input;
    private JTextField code_input;
    private JButton create_button;
    private JButton back_button;
    private Update file = new Update();

    public New_Module() { /*Constructor method.*/
        /*Set up of the page size, background colour and layout manager.*/
        setSize(1200, 763);
        setBackground(Color.decode("#A4DFDC"));
        setLayout(layout);

        /*Title label.*/
        title = new JLabel("NEW MODULE");
        title.setForeground(Color.decode("#45005A"));
        title.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(title);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, title, 0, SpringLayout.HORIZONTAL_CENTER, this);
        layout.putConstraint(SpringLayout.NORTH, title, 10, SpringLayout.NORTH, this);

        /*Module Name Label.*/
        module_label = new JLabel("Module Name");
        module_label.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(module_label);
        layout.putConstraint(SpringLayout.NORTH, module_label, 70, SpringLayout.NORTH, title);

        /*Module Input.*/
        module_input = new JTextField();
        module_input.setBackground(Color.decode("#FFE8FA"));
        module_input.setFont(new Font("Arial", Font.PLAIN, 15));
        add(module_input);
        layout.putConstraint(SpringLayout.NORTH, module_input, 98, SpringLayout.NORTH, title);

        /*Module Code Label.*/
        code_label = new JLabel("Module Code");
        code_label.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(code_label);
        layout.putConstraint(SpringLayout.NORTH, code_label, 138, SpringLayout.NORTH, title);

        /*Module Code Input.*/
        code_input = new JTextField();
        code_input.setBackground(Color.decode("#FFE8FA"));
        code_input.setFont(new Font("Arial", Font.PLAIN, 15));
        add(code_input);
        layout.putConstraint(SpringLayout.NORTH, code_input, 167, SpringLayout.NORTH, title);

        /*Add button.*/
        create_button = new JButton("CREATE");
        create_button.setBackground(Color.decode("#62F473"));
        create_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (mode == 1) {
                    Button_Function("Add");
                } else if (mode == 2) {
                    Button_Function("Edit");
                }
            }
        });
        add(create_button);
        layout.putConstraint(SpringLayout.NORTH, create_button, 90, SpringLayout.NORTH, code_label);

        /*Back button.*/
        back_button = new JButton("BACK");
        back_button.setBackground(Color.decode("#E96F6F"));
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Button_Function("Back");
            }
        });
        add(back_button);
        layout.putConstraint(SpringLayout.NORTH, back_button, 90, SpringLayout.NORTH, code_label);

        Layout();
    }

    /*Method for creating links between pages.*/
    public void Page_Connection(Object context) {
        if (context instanceof Base_Frame) {
            base_link = (Base_Frame) context;
        } else if (context instanceof Home) {
            home_link = (Home) context;
        } else if (context instanceof Module_Panel) {
            module_link = (Module_Panel) context;
        }
    }

    /*Method for adjusting the layout.*/
    public void Layout() {
        Component anchor = New_Module.this;
        int width = New_Module.this.getWidth();
        layout.putConstraint(SpringLayout.WEST, module_label, (int)((370.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.WEST, module_input, (int)((370.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, module_input, -(int)((372.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, code_label, (int)((370.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.WEST, code_input, (int)((370.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, code_input, -(int)((372.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, create_button, (int)((396.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, create_button, -(int)((625.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, back_button, (int)((623.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, back_button, -(int)((398.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        revalidate();
        repaint();
    }

    /*Method for button functions.*/
    private void Button_Function(String action) {
        String module_name;
        String module_code;
        
        switch (action) {
            case "Add" :
                module_name = module_input.getText().strip();
                module_code = code_input.getText().strip();
                if (module_name.isBlank() || module_code.isBlank()) {
                    return;
                }
                file.add("Study_Log/src/data/module.txt", String.format("%s;%s;0", module_code, module_name));
                module_input.setText("");
                code_input.setText("");
                home_link.Display_Data("All");
                base_link.Display_Page("Home");
                break;
            case "Back" : 
                if (mode == 1) {
                    base_link.Display_Page("Home");
                } else if (mode == 2) {
                    base_link.Display_Page("Module Panel");
                    module_code = code_input.getText().strip();
                    module_link.Display_Module(module_code);
                }
                module_input.setText("");
                code_input.setText("");
                create_button.setText("CREATE");
                mode = 1;
                break;
            case "Edit" : 
                module_name = module_input.getText().strip();
                module_code = code_input.getText().strip();
                if (module_name.isBlank()) {
                    return;
                }
                file.update("Study_Log/src/data/module.txt", module_code, 1, module_name);
                module_input.setText("");
                code_input.setText("");
                code_input.setEnabled(true);
                create_button.setText("CREATE");
                mode = 1;
                base_link.Display_Page("Module Panel");
                module_link.Display_Module(module_code);
                break;

        }
    }

    /*Method for set up page when in edit mode.*/
    public void Edit_Mode(String id, String module) {
        module_input.setText(module);
        code_input.setText(id);
        code_input.setEnabled(false);
        create_button.setText("UPDATE");
        mode = 2;
    }
}
