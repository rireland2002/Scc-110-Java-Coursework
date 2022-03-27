import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class HardBoard implements ActionListener//Creates the main board and contains the action events to take all responses and edit the board
{
        public int ActionCount1 = 0;//Counter for the Action event
        public int ActionCount2 = 0;//Counter for the Action event
        public int ActionCount3 = 0;//Counter for the Action event
        public JPanel[] guessgrid = new JPanel[3];//This array is used to represent the rows of empty icons which will represent the players guesses as they input them
        public JPanel[] markgrid = new JPanel[3];//This array represents the rows of the marks on the right hand sign on the screen that appear after a user finishes a row of inputs
        public JLabel[] markbuttons0 = new JLabel[5];//These 6 arrays are used to represent each individual row filled with the right hand side mark buttons
        public JLabel[] markbuttons1 = new JLabel[5];
        public JLabel[] markbuttons2 = new JLabel[5];
        public JLabel[] guessbuttons0 = new JLabel[5];//These 6 arrays are used to represent each individual guess icon where players guesses will be shown 
        public JLabel[] guessbuttons1 = new JLabel[5];
        public JLabel[] guessbuttons2 = new JLabel[5];
        public int[] playerguesses0 = new int[5];//the array used to represent the players guesses
        public int[] playerguesses1 = new int[5];//the array used to represent the players guesses
        public int[] playerguesses2 = new int[5];//the array used to represent the players guesses
        public Picture correct = new Picture("Score_0.png");//The picture used to represent the correct icon with 2 ticks
        public Picture halfcorrect = new Picture("Score_1.png");//The picture used to represent a half correct input
        public Picture red = new Picture("Colour_0.png");//Creates a picture using the red png
        public Picture orange = new Picture("Colour_1.png");//Creates a picture using the orange png
        public Picture yellow = new Picture("Colour_2.png");//Creates a picture using the yellow png
        public Picture green = new Picture("Colour_3.png");//Creates a picture using the green png
        public Picture blue = new Picture("Colour_4.png");//Creates a picture using the blue png
        public Picture purple = new Picture("Colour_5.png");//Creates a picture using the purple png
        public Picture violet = new Picture("Colour_6.png");//Creates a picture using the violet png
        public JButton r = new JButton(new ImageIcon("Colour_0.png"));//Creates a button using the red image icon
        public JButton o = new JButton(new ImageIcon("Colour_1.png"));//Creates a button using the orange image icon
        public JButton y = new JButton(new ImageIcon("Colour_2.png"));//Creates a button using the yellow image icon
        public JButton g = new JButton(new ImageIcon("Colour_3.png"));//Creates a button using the green image icon
        public JButton b = new JButton(new ImageIcon("Colour_4.png"));//Creates a button using the blue image icon
        public JButton p = new JButton(new ImageIcon("Colour_5.png"));//Creates a button using the purple image icon
        public JButton v = new JButton(new ImageIcon("Colour_6.png"));//Creates a button using the violet image icon
        public GuessCode guessobject = new GuessCode();//Creates an instance of the guess code class and creates a random array for our code and a panel of the correct colours
        public int incorrectcount0 = 0;//Used to count the number of half correct choices in the player guess, same for the next 2
        public int incorrectcount1 = 0;
        public int incorrectcount2 = 0;
        public int markbuttonpos0 = 0;//Used to count the position of the mark button to be altered, same for the next 2
        public int markbuttonpos1 = 0;
        public int markbuttonpos2 = 0;
        public JFrame mainWindow;
        
        
    public HardBoard()//The method where the board is created
    {
        mainWindow = new JFrame();//The frame in which everything is stored on
        JPanel masterPanel = new JPanel(new BorderLayout());//The master panel which all other panels are placed onto, uses a border layout
        JPanel guesses = new JPanel();//The panel in which the guesses are stored on the left hand side
        JPanel options = new JPanel();//The panel in which the buttons are stored
        JPanel marks = new JPanel();//The panel in which marks are stored at the right hand side
        JPanel guessmarks = new JPanel(new BorderLayout());//The panel in which guesses,options and marks are added to, so they can be formatted properly 
        GridLayout f = new GridLayout(1,7);//The layout used for the row of buttons at the bottom of the screen
        GridLayout w = new GridLayout(1,4);//The layout used for the rows of guesses on the left hand side of the screen
        GridLayout s = new GridLayout(3,1);//The layout used for the overall panel where the guess rows are stored
        GridLayout k = new GridLayout(3,1);//The layout used for the overall panel where the mark rows are stored
        GridLayout j = new GridLayout(2,2);//The layout used for the marks at the right hand side of the screen
        options.setLayout(f);//Sets the layout of options to layout f
        marks.setLayout(k);//Sets the layout of marks to k
        options.add(r);//Adds all the individual buttons to options one by one
        options.add(o);
        options.add(y);
        options.add(g);
        options.add(b);
        options.add(p);
        options.add(v);
        r.setBorder(null);//Sets the border of all the buttons to null for the game board design
        o.setBorder(null);
        y.setBorder(null);
        g.setBorder(null);
        b.setBorder(null);
        p.setBorder(null);
        v.setBorder(null);

        for(int i=0;i<3;i++)
        {
            guessgrid[i] = new JPanel();//Creates 3 panels used to represent the guess buttons
        }

        for(int i=0;i<3;i++)
        {
            markgrid[i] = new JPanel();//Creates 3 panels to represent the mark buttons
        }

        for (int i=0; i<4;i++)
        {
            guessbuttons0[i] = new JLabel(new ImageIcon("empty.png"));//The next 3 loops all create the icons used on each seperate row for guesses
        }

        for (int i=0; i<4;i++)
        {
            guessbuttons1[i] = new JLabel(new ImageIcon("empty.png"));
        }
        
        for (int i=0; i<4;i++)
        {
            guessbuttons2[i] = new JLabel(new ImageIcon("empty.png"));
        }

        for (int i=0; i<4;i++)
        {
            markbuttons0[i] = new JLabel(new ImageIcon("empty.png"));//The next 3 loops create the icons to be used for the mark rows
        }

        for (int i=0; i<4;i++)
        {
            markbuttons1[i] = new JLabel(new ImageIcon("empty.png"));
        }
        
        for (int i=0; i<4;i++)
        {
            markbuttons2[i] = new JLabel(new ImageIcon("empty.png"));
        }

        
        for (int i=0; i<4;i++)
        {
            guessgrid[0].add(guessbuttons0[i]);//The next 3 rows adds the buttons created in the previous loops to the panels
        }

        for (int i=0; i<4;i++)
        {
            guessgrid[1].add(guessbuttons1[i]);
        }

        for (int i=0; i<4;i++)
        {
            guessgrid[2].add(guessbuttons2[i]);
        }

        for (int i=0; i<4;i++)
        {
            markgrid[0].add(markbuttons0[i]);//The next 3 loops add all the buttons to the mark rows
        }

        for (int i=0; i<4;i++)//Loops for the number of mark buttons that can fit in the layout per row
        {
            markgrid[1].add(markbuttons1[i]);
        }

        for (int i=0; i<4;i++)
        {
            markgrid[2].add(markbuttons2[i]);
        }

        for (int i=0; i<3;i++)
        {
            guesses.add(guessgrid[i]);//Adds all the guess rows to the guessgrid panel
        }

        for (int i=0; i<3;i++)
        {
            marks.add(markgrid[i]);//Adds all the mark rows to the markgrid panel
        }
        
        
        guessgrid[0].setLayout(w);//Sets the layout of each individual guessgrid to the correct layout
        guessgrid[1].setLayout(w);
        guessgrid[2].setLayout(w);
        markgrid[0].setLayout(j);//Sets the layout of each markgrid to the correct layout
        markgrid[1].setLayout(j);
        markgrid[2].setLayout(j);
        guesses.setLayout(s);//Sets guesses to the layout s before it's added to guessmarks
        guessmarks.add(options,BorderLayout.SOUTH);//Sets the button row to the bottom of the screen
        guessmarks.add(marks,BorderLayout.EAST);//Sets the mark rows to the right hand side of the screem
        guessmarks.add(guesses,BorderLayout.WEST);//Sets the guess rows to the left hand side of the screen
        masterPanel.add(guessmarks, BorderLayout.CENTER);//Adds the guessmarks panel to the master panel and centralises it
        mainWindow.setContentPane(masterPanel);//Sets the content pane of the main window to the masterpanel
        mainWindow.setSize(510,325);//Sets the size of the main frame
        mainWindow.setVisible(true);//Sets the frame to be visible after everything is loaded
        r.addActionListener(this);//Adds the action listener to all the buttons, so the actionPerformed method activates when a button is pressed, same event for all the buttons
        o.addActionListener(this);
        y.addActionListener(this);
        g.addActionListener(this);
        b.addActionListener(this);
        p.addActionListener(this);
        v.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent e)
    {
        if(ActionCount1<4)
        {
            if(e.getSource() == r)
            {
                guessbuttons0[ActionCount1].setIcon(red);
                playerguesses0[ActionCount1] = 0;
                ActionCount1++;
            }

            else if(e.getSource() == o)
            {
                guessbuttons0[ActionCount1].setIcon(orange);
                playerguesses0[ActionCount1] = 1;
                ActionCount1++;
            }

            else if(e.getSource() == y)
            {
                guessbuttons0[ActionCount1].setIcon(yellow);
                playerguesses0[ActionCount1] = 2;
                ActionCount1++;
            }

            else if(e.getSource() == g)
            {
                guessbuttons0[ActionCount1].setIcon(green);
                playerguesses0[ActionCount1] = 3;
                ActionCount1++;
            }

            else if(e.getSource() == b)
            {
                guessbuttons0[ActionCount1].setIcon(blue);
                playerguesses0[ActionCount1] = 4;
                ActionCount1++;
            }

            else if(e.getSource() == p)
            {
                guessbuttons0[ActionCount1].setIcon(purple);
                playerguesses0[ActionCount1] = 5;
                ActionCount1++;
            }

            else if(e.getSource() == v)
            {
                guessbuttons0[ActionCount1].setIcon(violet);
                playerguesses0[ActionCount1] = 6;
                ActionCount1++;
            }
        }
        

        if(ActionCount1 == 4)
        {
            for (int i = 0;i<4;i++)
            {
                if(playerguesses0[i] == guessobject.answers[i])
                {
                    markbuttons0[markbuttonpos0].setIcon(correct);
                    markbuttonpos0++;
                }
                else if((playerguesses0[i] == guessobject.answers[0])||(playerguesses0[i] == guessobject.answers[1])||(playerguesses0[i] == guessobject.answers[2])||(playerguesses0[i] == guessobject.answers[3]))
                {
                    incorrectcount0++;
                }
            }
            for (int i = 0;i<incorrectcount0;i++)
            {
                markbuttons0[markbuttonpos0].setIcon(halfcorrect);
                markbuttonpos0++;
            }
            if((playerguesses0[0] == guessobject.answers[0])&&(playerguesses0[1] == guessobject.answers[1])&&(playerguesses0[2] == guessobject.answers[2])&&(playerguesses0[3] == guessobject.answers[3]))
            {
                GoodEnding goodend0 = new GoodEnding();
                mainWindow.setVisible(false);
            }
            ActionCount1++;
        }
        

        else if(ActionCount1 == 5)
        {
                if(ActionCount2<4)
                {
                if(e.getSource() == r)
                {
                    guessbuttons1[ActionCount2].setIcon(red);
                    playerguesses1[ActionCount2] = 0;
                    ActionCount2++;
                }

                else if(e.getSource() == o)
                {
                    guessbuttons1[ActionCount2].setIcon(orange);
                    playerguesses1[ActionCount2] = 1;
                    ActionCount2++;
                }

                else if(e.getSource() == y)
                {
                    guessbuttons1[ActionCount2].setIcon(yellow);
                    playerguesses1[ActionCount2] = 2;
                    ActionCount2++;
                }

                else if(e.getSource() == g)
                {
                    guessbuttons1[ActionCount2].setIcon(green);
                    playerguesses1[ActionCount2] = 3;
                    ActionCount2++;
                }

                else if(e.getSource() == b)
                {
                    guessbuttons1[ActionCount2].setIcon(blue);
                    playerguesses1[ActionCount2] = 4;
                    ActionCount2++;
                }

                else if(e.getSource() == p)
                {
                    guessbuttons1[ActionCount2].setIcon(purple);
                    playerguesses1[ActionCount2] = 5;
                    ActionCount2++;
                }

                else if(e.getSource() == v)
                {
                    guessbuttons1[ActionCount2].setIcon(violet);
                    playerguesses1[ActionCount2] = 6;
                    ActionCount2++;
                }
            }
            

            if(ActionCount2 == 4)
            {
                for (int i = 0;i<4;i++)
                {
                    if(playerguesses1[i] == guessobject.answers[i])
                    {
                        markbuttons1[markbuttonpos1].setIcon(correct);
                        markbuttonpos1++;
                    }
                    else if((playerguesses1[i] == guessobject.answers[0])||(playerguesses1[i] == guessobject.answers[1])||(playerguesses1[i] == guessobject.answers[2])||(playerguesses1[i] == guessobject.answers[3]))
                    {
                        incorrectcount1++;
                    }
                }
                for (int i = 0;i<incorrectcount1;i++)
                {
                    markbuttons1[markbuttonpos1].setIcon(halfcorrect);
                    markbuttonpos1++;
                }
                if((playerguesses1[0] == guessobject.answers[0])&&(playerguesses1[1] == guessobject.answers[1])&&(playerguesses1[2] == guessobject.answers[2])&&(playerguesses1[3] == guessobject.answers[3]))
                {
                    GoodEnding goodend1 = new GoodEnding();
                    mainWindow.setVisible(false);
                }
                ActionCount2++;
            }
            else if(ActionCount2==5)
            {
                if(ActionCount3<4)
                {
                if(e.getSource() == r)
                {
                    guessbuttons2[ActionCount3].setIcon(red);
                    playerguesses2[ActionCount3] = 0;
                    ActionCount3++;
                }

                else if(e.getSource() == o)
                {
                    guessbuttons2[ActionCount3].setIcon(orange);
                    playerguesses2[ActionCount3] = 1;
                    ActionCount3++;
                }

                else if(e.getSource() == y)
                {
                    guessbuttons2[ActionCount3].setIcon(yellow);
                    playerguesses2[ActionCount3] = 2;
                    ActionCount3++;
                }

                else if(e.getSource() == g)
                {
                    guessbuttons2[ActionCount3].setIcon(green);
                    playerguesses2[ActionCount3] = 3;
                    ActionCount3++;
                }

                else if(e.getSource() == b)
                {
                    guessbuttons2[ActionCount3].setIcon(blue);
                    playerguesses2[ActionCount3] = 4;
                    ActionCount3++;
                }

                else if(e.getSource() == p)
                {
                    guessbuttons2[ActionCount3].setIcon(purple);
                    playerguesses2[ActionCount3] = 5;
                    ActionCount3++;
                }

                else if(e.getSource() == v)
                {
                    guessbuttons2[ActionCount3].setIcon(violet);
                    playerguesses2[ActionCount3] = 6;
                    ActionCount3++;
                }
            }
            

                if(ActionCount3 == 4)
                {
                    for (int i = 0;i<4;i++)
                    {
                        if(playerguesses2[i] == guessobject.answers[i])
                        {
                            markbuttons2[markbuttonpos2].setIcon(correct);
                            markbuttonpos2++;
                        }
                        else if((playerguesses2[i] == guessobject.answers[0])||(playerguesses2[i] == guessobject.answers[1])||(playerguesses2[i] == guessobject.answers[2])||(playerguesses2[i] == guessobject.answers[3]))
                        {
                            incorrectcount2++;
                        }
                    }
                    for (int i = 0;i<incorrectcount2;i++)
                    {
                        markbuttons2[markbuttonpos2].setIcon(halfcorrect);
                        markbuttonpos2++;
                    }
                    if((playerguesses2[0] == guessobject.answers[0])&&(playerguesses2[1] == guessobject.answers[1])&&(playerguesses2[2] == guessobject.answers[2])&&(playerguesses2[3] == guessobject.answers[3]))
                    {
                        GoodEnding goodend2 = new GoodEnding();
                        mainWindow.setVisible(false);
                    }
                    else
                    {
                        ActionCount3++;
                    }
                    if(ActionCount3==5)
                    {
                        BadEnding badend = new BadEnding();
                        mainWindow.setVisible(false);
                    }
                }
               
            }
        }
        
    }
}
                
            
        

    

    
    
    
    
    
         
        
        
    





