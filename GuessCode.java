import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.AsyncBoxView;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;


public class GuessCode//Creates a random array of numbers to represent what the player needs to guess and creates a panel to display this combination to be used in the ending classes
{


    public JPanel correctpanel = new JPanel();//the panel on which the correct combination will be displayed
    public JLabel correctlabel[] = new JLabel[4];//the labels that will be used to show each colour in the combination
    public int[] answers = new int[4];// the array that makes up the combination players must guess, using numbers from 0-6 representing one of the colours
    public int[] playerguesses = new int[4];//the array used to represent the players guesses
    
    
    public void ColourCode()
    {
        int[] answeropt = {0,1,2,3,4,5,6};//red,orange,yellow,green,blue,purple,violet
        for(int i = 0;i<4;i++)
        {
            Random randomiser = new Random();//creates a randomiser to use on the array of numbers that could make up the final combo
            int indexrand = randomiser.nextInt(answeropt.length);//takes all the numbers inside the answeropt array and picks a random one 
            answers[i] = indexrand;//sets the current index to the randomly picked number
            System.out.println(answers[i]);//test remove in final version

            if (answers[i] == 0)//if the number at the index is 0 execute this code
            {
                correctlabel[i] = new JLabel(new ImageIcon("Colour_0.png"));//takes the label at the current index and turns it into the colour correlated with the number in the answers array     }
            }
            else if (answers[i] == 1)//All the below code is the same as above for each of the different colours, using an else if statement
            {
                correctlabel[i] = new JLabel(new ImageIcon("Colour_1.png"));
            }
            
            else if (answers[i] == 2)
            {
                correctlabel[i] = new JLabel(new ImageIcon("Colour_2.png"));
            }

            else if (answers[i] == 3)
            {
                correctlabel[i] = new JLabel(new ImageIcon("Colour_3.png"));
            }

            else if (answers[i] == 4)
            {
                correctlabel[i] = new JLabel(new ImageIcon("Colour_4.png"));
            }

            else if (answers[i] == 5)
            {
                correctlabel[i] = new JLabel(new ImageIcon("Colour_5.png"));
            }
        }
    }
}