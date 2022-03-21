import javax.swing.*;
import java.awt.*;
public class BadEnding//Executes when the player runs out of guesses, displays the correct combination and a game over screen
{
    public JFrame end = new JFrame();//The frame on which the the information is displayed, seperate frame that opens only when max guesses are reached and the main board is closed
    public JLabel endscreen = new JLabel(new ImageIcon("lose.jpg"));//may or may not keep comment later
    
    
    public BadEnding()//Method for adding content and displaying the screen when the player has lost
    {
        end.add(endscreen);
        end.setVisible(true);
        end.setSize(480,270);
    }    
}
