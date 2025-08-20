package gui; /*Package containing the code.*/

/*Import API.*/
import javax.swing.*;
import java.awt.Color;

public class Button extends JPanel {
    private JButton widget = new JButton();

    public Button(String text, int width, int height, String background) {
        add(widget);
        setBackground(Color.decode(background));
        widget.setText(text);
        widget.setSize(width, height);
    }

    public void Custom(String background, String foreground) {
        widget.setBackground(Color.decode(background));
        widget.setForeground(Color.decode(foreground));
    }
}
