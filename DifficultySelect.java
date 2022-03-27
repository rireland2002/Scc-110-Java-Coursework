import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DifficultySelect implements ActionListener
{
    public JFrame masterframe;//Creates public variables to be used in GameBoard and Hardboard 
    public JPanel masterpanel;
    public JButton easy;
    public JButton hard; 


    public DifficultySelect()
    {
        masterframe = new JFrame();//Creates the main frame for the panel to be stored
        masterpanel = new JPanel();//Creates the panel for the buttons
        GridLayout duobuttons = new GridLayout(1,2);//Creates a layout for the panel
        masterpanel.setLayout(duobuttons);//Sets the layout of the panel
        easy = new JButton("Easy");//Adds the button easy with the text Easy
        hard = new JButton("Hard");//Adds the button hard with the text Hard
        masterpanel.add(easy);//Adds the button to the panel
        masterpanel.add(hard);//Adds the button to the panel
        masterframe.add(masterpanel);//Adds the panel to the frame
        masterframe.setVisible(true);//Sets the frame to visible when called
        masterframe.setSize(250,250);//Sets frame size
        easy.addActionListener(this);//Adds action listener below to the easy button
        hard.addActionListener(this);//Adds action listener below to the hard button
    }

    public void actionPerformed(ActionEvent d)
    {
        if(d.getSource() == easy)//If the easy button is clicked
        {
            GameBoard easyBoard = new GameBoard();//Creates an instance of the GameBoard class with 6 guess rows
            masterframe.setVisible(false);//Closes the frame when the game is opened
        }
        if(d.getSource() == hard)//if the hard button is clicked
        {
            HardBoard hardBoard = new HardBoard();//Creates an instance of the HardBoard class with 3 rows
            masterframe.setVisible(false);//Closes the frame when the game is opened
        }
    }


}
