package pages; /*Package containing the class.*/

/*Import API.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import edit.*;

public class View_Page extends JPanel implements Page {
    private SpringLayout layout = new SpringLayout();
    private Base_Frame base_link;
    private Module_Panel module_link;
    private New_Page new_page_link;

    private String note_id;

    private JLabel page_title;
    private JLabel type_date;
    private JButton edit_button;
    private JButton delete_button;
    private JButton note_button;
    private JButton back_button;
    private JTextArea note_area;
    private JScrollPane scroll;

    public View_Page() {
        /*Set up page size, background colour and layout manager.*/
        setSize(1200, 963);
        setBackground(Color.decode("#A4DFDC"));
        setLayout(layout);

        /*Page title in default not editable mode.*/
        page_title = new JLabel("Page title");
        page_title.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(page_title);
        layout.putConstraint(SpringLayout.NORTH, page_title, 15, SpringLayout.NORTH, this);

        /*Note type in default not editable mode.*/
        type_date = new JLabel("Type, Date");
        type_date.setFont(new Font("Tahoma", Font.BOLD, 13));
        add(type_date);
        layout.putConstraint(SpringLayout.NORTH, type_date, 30, SpringLayout.NORTH, page_title);

        /*Edit button.*/
        edit_button = new JButton("Edit");
        edit_button.setBackground(Color.decode("#9762F4"));
        edit_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                base_link.Display_Page("New Page");
                new_page_link.Edit_Mode(note_id);
            }
        });
        add(edit_button);
        layout.putConstraint(SpringLayout.NORTH, edit_button, 15, SpringLayout.NORTH, this);

        /*Delete button.*/
        delete_button = new JButton("Delete");
        delete_button.setBackground(Color.decode("#9762F4"));
        add(delete_button);
        layout.putConstraint(SpringLayout.NORTH, delete_button, 15, SpringLayout.NORTH, this);

        /*Back button.*/
        back_button = new JButton("x");
        back_button.setBackground(Color.decode("#E96F6F"));
        back_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                base_link.Display_Page("Module Panel");
                module_link.Display_Data("All");
            }
        });
        add(back_button);
        layout.putConstraint(SpringLayout.NORTH, back_button, 15, SpringLayout.NORTH, this);

        /*Note taking button.*/
        note_button = new JButton("Edit Note");
        note_button.setBackground(Color.decode("#9762F4"));
        note_button.setForeground(Color.WHITE);
        add(note_button);
        layout.putConstraint(SpringLayout.NORTH, note_button, 50, SpringLayout.NORTH, page_title);

        /*Note area.*/
        note_area = new JTextArea();
        note_area.setFont(new Font("Tahoma", Font.PLAIN, 15));
        note_area.setLineWrap(true);
        note_area.setWrapStyleWord(true);
        note_area.setEditable(false);
        scroll = new JScrollPane(note_area);
        add(scroll);
        layout.putConstraint(SpringLayout.NORTH, scroll, 50, SpringLayout.NORTH, type_date);

        Layout();
    }

    public void Page_Connection(Object context) {
        if (context instanceof Base_Frame) {
            base_link = (Base_Frame) context;
        } else if (context instanceof Module_Panel) {
            module_link = (Module_Panel) context;
        } else if (context instanceof New_Page) {
            new_page_link = (New_Page) context;
        }
    }

    public void Layout() {
        Component anchor = View_Page.this;
        int width = View_Page.this.getWidth();
        int height = View_Page.this.getHeight();

        layout.putConstraint(SpringLayout.WEST, page_title, (int)((51.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.WEST, type_date, (int)((51.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.WEST, edit_button, (int)((860.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, edit_button, -(int)((231.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, delete_button, (int)((982.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, delete_button, -(int)((109.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, back_button, (int)((1104.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, back_button, -(int)((51.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, note_button, (int)((989.0 / 1040.0) * (width-160)), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, note_button, -(int)((51.0 / 1040.0) * (width-160)), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.WEST, scroll, (int)((51.0 / 1200.0) * width), SpringLayout.WEST, anchor);
        layout.putConstraint(SpringLayout.EAST, scroll, -(int)((51.0 / 1200.0) * width), SpringLayout.EAST, anchor);
        layout.putConstraint(SpringLayout.SOUTH, scroll, -(int)((34.0 / 963.0) * height), SpringLayout.SOUTH, anchor);

        revalidate();
        repaint();
    }

    public void Display_Note(String id) {
        Read read_file = new Read();
        note_id = id;
        String[] details = read_file.one(note_id, "Study_Log/src/data/notes.txt");
        page_title.setText(details[4]);
        type_date.setText(String.format("%s, %s", details[3], details[2]));
        String text = read_file.read(String.format("Study_Log/src/data/%s.txt", note_id));
        note_area.setText(text);
    }

    public String Page_ID() {
        return note_id;
    }
}
