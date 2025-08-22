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

    private JLabel title;
    private JLabel module_label;
    private JLabel code_label;
    private JTextField module_input;
    private JTextField code_input;
    private JButton create_button;
    private JButton back_button;
    private Update file = new Update();

    public New_Module(Base_Frame base, Home home_page) { /*Constructor method.*/
        /*Set up of the page size, background colour and layout manager.*/
        setSize(1200, 763);
        setBackground(Color.decode("#A4DFDC"));
        setLayout(layout);
        base_link = base;
        home_link = home_page;

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
                Button_Function("Add");
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

    private void Button_Function(String action) {
        switch (action) {
            case "Add" :
                String module_name = module_input.getText().strip();
                String module_code = code_input.getText().strip();
                if (module_name.isBlank() || module_code.isBlank()) {
                    return;
                }
                file.add("Study_Log/src/data/module.txt", String.format("%s;%s", module_code, module_name));
                module_input.setText("");
                code_input.setText("");
                home_link.Display_Data("All");
                base_link.Display_Page("Home");
                break;
            case "Back" : 
                module_input.setText("");
                code_input.setText("");
                base_link.Display_Page("Home");
        }
    }
}
