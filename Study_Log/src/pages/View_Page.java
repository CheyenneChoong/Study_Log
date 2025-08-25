package pages; /*Package containing the class.*/

/*Import API.*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class View_Page extends JPanel implements Page {
    private SpringLayout layout = new SpringLayout();
    private Base_Frame base_link;
    private Module_Panel module_link;

    private JTextField page_title;
    private JComboBox<String> note_type;
    private JTextField date_field;
    private JButton edit_button;
    private JButton delete_button;
    private JButton note_button;
    private JButton back_button;
    private JTextArea note_area;

    public View_Page() {
        /*Set up page size, background colour and layout manager.*/
        setSize(1200, 963);
        setBackground(Color.decode("#A4DFDC"));
        setLayout(layout);

        /*Page title in default not editable mode.*/
        page_title = new JTextField("Page title");
        page_title.setBackground(Color.decode("#A4DFDC"));
        page_title.setFont(new Font("Tahoma", Font.BOLD, 20));
        page_title.setEditable(false);
        page_title.setBorder(null);
        add(page_title);

        /*Note type in default not editable mode.*/
        note_type = new JComboBox<>(new String[] {"Lecture", "Tutorial / Lab", "Assignment"});
        note_type.setBackground(Color.decode("#A4DFDC"));
        note_type.setFont(new Font("Tahoma", Font.BOLD, 13));
        note_type.setBorder(null);
        note_type.setEnabled(false);
        note_type.setSelectedIndex(2);
        add(note_type);

        /*Date label in default not editable mode.*/
        date_field = new JTextField("Date");
        date_field.setBackground(Color.decode("#A4DFDC"));
        date_field.setFont(new Font("Tahoma", Font.BOLD, 13));
        date_field.setBorder(null);
        date_field.setEditable(false);
        add(date_field);

        /*Edit button.*/
        edit_button = new JButton("Edit");
        edit_button.setBackground(Color.decode("#62F473"));
        add(edit_button);

        /*Delete button.*/
        delete_button = new JButton("Delete");
        delete_button.setBackground(Color.decode("#E96F6F"));
        add(delete_button);

        /*Back button.*/
        back_button = new JButton("x");
        back_button.setBackground(Color.decode("#E96F6F"));
        add(back_button);

        /*Note taking button.*/
        note_button = new JButton("Edit Note");
        note_button.setBackground(Color.decode("#9762F4"));
        add(note_button);

        /*Note area.*/
        note_area = new JTextArea();
        note_area.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(note_area);
    }

    public void Page_Connection(Object context) {
        if (context instanceof Base_Frame) {
            base_link = (Base_Frame) context;
        } else if (context instanceof Module_Panel) {
            module_link = (Module_Panel) context;
        }
    }

    public void Layout() {
        Component anchor = View_Page.this;
        int width = View_Page.this.getWidth();
    }
}
