import javax.swing.*;
import java.awt.*;
public class GoodEnding//Executes when the player guesses correctly, a congratulations screen
{
    public JFrame end = new JFrame();//The frame on which the the information is displayed
    public JPanel endpanel = new JPanel(new BorderLayout());
    public JLabel endscreen = new JLabel(new ImageIcon("win.png"));
    
    
    public GoodEnding()//Method for adding content and displaying the screen when the player has lost
    {
        endpanel.add(endscreen,BorderLayout.NORTH);
        end.add(endpanel);
        end.setSize(300,300);
        end.setAlwaysOnTop(true);
        end.setVisible(true);
    }    
}
