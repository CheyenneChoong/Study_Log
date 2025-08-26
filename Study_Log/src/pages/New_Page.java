package pages; /*Package containing the class.*/

/*Import API.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import edit.*;

public class New_Page extends JPanel implements Page {
    private SpringLayout layout = new SpringLayout();
    private Base_Frame base_link;
    private Module_Panel module_link;
    private View_Page page_link;
    
    private int mode = 1;
    private Read read_file = new Read();
    private Update update_file = new Update();

    private JLabel title_label;
    private JLabel date_label;
    private JLabel type_label;
    private JTextField title_input;
    private JTextField date_input;
    private JComboBox<String> type_input;
    private JButton create_button;
    private JButton back_button; 

    public New_Page() {
        setSize(1200, 763);
        setBackground(Color.decode("#A4DFDC"));
        setLayout(layout);

        /*Title.*/
        JLabel page_title = new JLabel("NEW PAGE");
        page_title.setForeground(Color.decode("#45005A"));
        page_title.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(page_title);
        layout.putConstraint(SpringLayout.NORTH, page_title, 10, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, page_title, 0, SpringLayout.HORIZONTAL_CENTER, this);

        /*Page Name / Title  Input Label.*/
        title_label = new JLabel("Title");
        title_label.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(title_label);
        layout.putConstraint(SpringLayout.NORTH, title_label, 70, SpringLayout.NORTH, page_title);

        /*Page Name / Title input.*/
        title_input = new JTextField();
        title_input.setFont(new Font("Arial", Font.PLAIN, 15));
        title_input.setBackground(Color.decode("#FFE8FA"));
        add(title_input);
        layout.putConstraint(SpringLayout.NORTH, title_input, 100, SpringLayout.NORTH, page_title);

        /*Date Input Label*/
        date_label = new JLabel("Date");
        date_label.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(date_label);
        layout.putConstraint(SpringLayout.NORTH, date_label, 140, SpringLayout.NORTH, page_title);

        /*Date input*/
        date_input = new JTextField();
        date_input.setFont(new Font("Arial", Font.PLAIN, 15));
        date_input.setBackground(Color.decode("#FFE8FA"));
        add(date_input);
        layout.putConstraint(SpringLayout.NORTH, date_input, 170, SpringLayout.NORTH, page_title);

        /*Type input label.*/
        type_label = new JLabel("Type");
        type_label.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(type_label);
        layout.putConstraint(SpringLayout.NORTH, type_label, 207, SpringLayout.NORTH, page_title);

        /*Type input.*/
        type_input = new JComboBox<>(new String[] {"Lecture", "Tutorial / Lab", "Assignment"});
        type_input.setBackground(Color.decode("#FFE8FA"));
        type_input.setFont(new Font("Arial", Font.PLAIN, 15));
        add(type_input);
        layout.putConstraint(SpringLayout.NORTH, type_input, 236, SpringLayout.NORTH, page_title);

        /*Create button.*/
        create_button = new JButton("CREATE");
        create_button.setBackground(Color.decode("#62F473"));
        create_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (mode == 1) {
                    Create_Page();
                    base_link.Display_Page("Module Panel");
                    module_link.Display_Data("All");
                    title_input.setText("");
                    date_input.setText("");
                } else if (mode == 2) {
                    String page_title = title_input.getText().strip();
                    String date = date_input.getText().strip();
                    String type = type_input.getSelectedItem().toString();
                    if (page_title.isBlank() || date.isBlank()) {
                        return;
                    }
                    update_file.update("Study_Log/src/data/notes.txt", page_link.Page_ID(), 4, page_title);
                    update_file.update("Study_Log/src/data/notes.txt", page_link.Page_ID(), 3, type);
                    update_file.update("Study_Log/src/data/notes.txt", page_link.Page_ID(), 2, date);
                    base_link.Display_Page("View Page");
                    page_link.Display_Note(page_link.Page_ID());
                    title_input.setText("");
                    date_input.setText("");
                }
            }
        });
        add(create_button);
        layout.putConstraint(SpringLayout.NORTH, create_button, 280, SpringLayout.NORTH, page_title);

        /*Back button.*/
        back_button = new JButton("BACK");
        back_button.setBackground(Color.decode("#E96F6F"));
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (mode == 1) {
                    base_link.Display_Page("Module Panel");
                } else if (mode == 2) {
                    create_button.setText("CREATE");
                    base_link.Display_Page("View Page");
                    page_link.Display_Note(page_link.Page_ID());
                }
                mode = 1;
                title_input.setText("");
                date_input.setText("");
            }
        });
        add(back_button);
        layout.putConstraint(SpringLayout.NORTH, back_button, 280, SpringLayout.NORTH, page_title);

        Layout();
    }

    /*Method for creating connections between pages.*/
    public void Page_Connection(Object context) {
        if (context instanceof Base_Frame) {
            base_link = (Base_Frame) context;
        } else if (context instanceof Module_Panel) {
            module_link = (Module_Panel) context;
        } else if (context instanceof View_Page) {
            page_link = (View_Page) context;
        }
    }

    /*Method for updating the layout setup.*/
    public void Layout() {
        Component anchor = New_Page.this;
        int width = New_Page.this.getWidth();

        layout.putConstraint(SpringLayout.WEST, title_label, (int)((371.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.WEST, title_input, (int)((371.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, title_input, -(int)((371.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, date_label, (int)((371.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.WEST, date_input, (int)((371.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, date_input, -(int)((371.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, type_label, (int)((371.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.WEST, type_input, (int)((371.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, type_input, -(int)((371.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, create_button, (int)((396.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, create_button, -(int)((625.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, back_button, (int)((623.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, back_button, -(int)((398.0 / 1200.0) * width), SpringLayout.EAST, anchor);

        revalidate();
        repaint();
    }

    /*Method for creating a page.*/ 
    private void Create_Page() {
        File_Data file = new File_Data();
        String page_title = title_input.getText().strip();
        String date = date_input.getText().strip();
        String type = type_input.getSelectedItem().toString();
        if (page_title.isBlank() || date.isBlank()) {
            return;
        }
        String module_code = module_link.Module_Code();
        String[] module_data = read_file.one(module_code, "Study_Log/src/data/module.txt");
        String note_id = String.format("%s-%d", module_code, (Integer.parseInt(module_data[2]) + 1));
        file.Check(String.format("Study_Log/src/data/%s.txt", note_id));
        String data = String.join(";", note_id, module_code, date, type, page_title);
        update_file.add("Study_Log/src/data/notes.txt", data);
        update_file.update("Study_log/src/data/module.txt", module_code, 2, String.valueOf((Integer.parseInt(module_data[2]) + 1)));
    }

    public void Edit_Mode(String id) {
        String[] page = read_file.one(id, "Study_Log/src/data/notes.txt");
        title_input.setText(page[4]);
        switch (page[3]) {
            case "Lecture" : type_input.setSelectedIndex(0); break;
            case "Tutorial / Lab" : type_input.setSelectedIndex(1); break;
            case "Assignment" : type_input.setSelectedIndex(2); break;
        }
        date_input.setText(page[2]);
        create_button.setText("UPDATE");
        mode = 2;
    }
}
