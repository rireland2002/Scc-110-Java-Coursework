import javax.swing.*;
import java.awt.*;
public class BadEnding//Executes when the player runs out of guesses, displays the correct combination and a game over screen
{
    public JFrame end = new JFrame();//The frame on which the the information is displayed, seperate frame that opens only when max guesses are reached and the main board is closed
    public JPanel endpanel = new JPanel(new BorderLayout());
    public JLabel endscreen = new JLabel(new ImageIcon("lose.jpg"));
    
    
    public BadEnding()//Method for adding content and displaying the screen when the player has lost
    {
        endpanel.add(endscreen,BorderLayout.NORTH);
        end.add(endpanel);
        end.setSize(480,270);
        end.setAlwaysOnTop(true);
        end.setVisible(true);
    }    
}
