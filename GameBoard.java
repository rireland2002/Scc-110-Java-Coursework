import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class GameBoard implements ActionListener//Creates the main board and contains the action events to take all responses and edit the board
{
        public int ActionCount1 = 0;//Counter for the Action event
        public int ActionCount2 = 0;//Counter for the Action event
        public int ActionCount3 = 0;//Counter for the Action event
        public int ActionCount4 = 0;//Counter for the Action event
        public int ActionCount5 = 0;//Counter for the Action event
        public int ActionCount6 = 0;//Counter for the Action event
        public JPanel[] guessgrid = new JPanel[6];//This array is used to represent the rows of empty icons which will represent the players guesses as they input them
        public JPanel[] markgrid = new JPanel[6];//This array represents the rows of the marks on the right hand sign on the screen that appear after a user finishes a row of inputs
        public JLabel[] markbuttons0 = new JLabel[5];//These 6 arrays are used to represent each individual row filled with the right hand side mark buttons
        public JLabel[] markbuttons1 = new JLabel[5];
        public JLabel[] markbuttons2 = new JLabel[5];
        public JLabel[] markbuttons3 = new JLabel[5];
        public JLabel[] markbuttons4 = new JLabel[5];
        public JLabel[] markbuttons5 = new JLabel[5];
        public JLabel[] guessbuttons0 = new JLabel[5];//These 6 arrays are used to represent each individual guess icon where players guesses will be shown 
        public JLabel[] guessbuttons1 = new JLabel[5];
        public JLabel[] guessbuttons2 = new JLabel[5];
        public JLabel[] guessbuttons3 = new JLabel[5];
        public JLabel[] guessbuttons4 = new JLabel[5];
        public JLabel[] guessbuttons5 = new JLabel[5];
        public int[] playerguesses0 = new int[5];//the array used to represent the players guesses
        public int[] playerguesses1 = new int[5];//the array used to represent the players guesses
        public int[] playerguesses2 = new int[5];//the array used to represent the players guesses
        public int[] playerguesses3 = new int[5];//the array used to represent the players guesses
        public int[] playerguesses4 = new int[5];//the array used to represent the players guesses
        public int[] playerguesses5 = new int[5];//the array used to represent the players guesses
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
        public int incorrectcount0 = 0;//Used to count the number of half correct choices in the player guess, same for the next 5
        public int incorrectcount1 = 0;
        public int incorrectcount2 = 0;
        public int incorrectcount3 = 0;
        public int incorrectcount4 = 0;
        public int incorrectcount5 = 0;
        public int markbuttonpos0 = 0;//Used to count the position of the mark button to be altered, same for the next 5
        public int markbuttonpos1 = 0;
        public int markbuttonpos2 = 0;
        public int markbuttonpos3 = 0;
        public int markbuttonpos4 = 0;
        public int markbuttonpos5 = 0;
        public JFrame mainWindow;
        
    public GameBoard()//The method where the board is created
    {
        mainWindow = new JFrame();//The frame in which everything is stored on
        JPanel masterPanel = new JPanel(new BorderLayout());//The master panel which all other panels are placed onto, uses a border layout
        JPanel guesses = new JPanel();//The panel in which the guesses are stored on the left hand side
        JPanel options = new JPanel();//The panel in which the buttons are stored
        JPanel marks = new JPanel();//The panel in which marks are stored at the right hand side
        JPanel guessmarks = new JPanel(new BorderLayout());//The panel in which guesses,options and marks are added to, so they can be formatted properly 
        GridLayout f = new GridLayout(1,7);//The layout used for the row of buttons at the bottom of the screen
        GridLayout w = new GridLayout(1,4);//The layout used for the rows of guesses on the left hand side of the screen
        GridLayout s = new GridLayout(6,1);//The layout used for the overall panel where the guess rows are stored
        GridLayout k = new GridLayout(6,1);//The layout used for the overall panel where the mark rows are stored
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
        
        
        for(int i=0;i<6;i++)
        {
            guessgrid[i] = new JPanel();//Creates 6 panels used to represent the guess buttons
        }

        for(int i=0;i<6;i++)
        {
            markgrid[i] = new JPanel();//Creates 6 panels to represent the mark buttons
        }

        for (int i=0; i<4;i++)
        {
            guessbuttons0[i] = new JLabel(new ImageIcon("empty.png"));//The next 6 loops all create the icons used on each seperate row for guesses
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
            guessbuttons3[i] = new JLabel(new ImageIcon("empty.png"));
        }
        
        for (int i=0; i<4;i++)
        {
            guessbuttons4[i] = new JLabel(new ImageIcon("empty.png"));
        }
        
        for (int i=0; i<4;i++)
        {
            guessbuttons5[i] = new JLabel(new ImageIcon("empty.png"));
        }

        for (int i=0; i<4;i++)
        {
            markbuttons0[i] = new JLabel(new ImageIcon("empty.png"));//The next 6 loops create the icons to be used for the mark rows
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
            markbuttons3[i] = new JLabel(new ImageIcon("empty.png"));
        }
        
        for (int i=0; i<4;i++)
        {
            markbuttons4[i] = new JLabel(new ImageIcon("empty.png"));
        }
        
        for (int i=0; i<4;i++)
        {
            markbuttons5[i] = new JLabel(new ImageIcon("empty.png"));
        }
        
        for (int i=0; i<4;i++)
        {
            guessgrid[0].add(guessbuttons0[i]);//The next 6 rows adds the buttons created in the previous loops to the panels
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
            guessgrid[3].add(guessbuttons3[i]);
        }

        for (int i=0; i<4;i++)
        {
            guessgrid[4].add(guessbuttons4[i]);
        }

        for (int i=0; i<4;i++)
        {
            guessgrid[5].add(guessbuttons5[i]);
        }

        for (int i=0; i<4;i++)
        {
            markgrid[0].add(markbuttons0[i]);//The next 6 loops add all the buttons to the mark rows
        }

        for (int i=0; i<4;i++)//Loops for the number of mark buttons that can fit in the layout per row
        {
            markgrid[1].add(markbuttons1[i]);
        }

        for (int i=0; i<4;i++)
        {
            markgrid[2].add(markbuttons2[i]);
        }

        for (int i=0; i<4;i++)
        {
            markgrid[3].add(markbuttons3[i]);
        }

        for (int i=0; i<4;i++)
        {
            markgrid[4].add(markbuttons4[i]);
        }

        for (int i=0; i<4;i++)
        {
            markgrid[5].add(markbuttons5[i]);
        }

        for (int i=0; i<6;i++)
        {
            guesses.add(guessgrid[i]);//Adds all the guess rows to the guessgrid panel
        }

        for (int i=0; i<6;i++)
        {
            marks.add(markgrid[i]);//Adds all the mark rows to the markgrid panel
        }
        
        
        guessgrid[0].setLayout(w);//Sets the layout of each individual guessgrid to the correct layout
        guessgrid[1].setLayout(w);
        guessgrid[2].setLayout(w);
        guessgrid[3].setLayout(w);
        guessgrid[4].setLayout(w);
        guessgrid[5].setLayout(w);
        markgrid[0].setLayout(j);//Sets the layout of each markgrid to the correct layout
        markgrid[1].setLayout(j);
        markgrid[2].setLayout(j);
        markgrid[3].setLayout(j);
        markgrid[4].setLayout(j);
        markgrid[5].setLayout(j);
        guesses.setLayout(s);//Sets guesses to the layout s before it's added to guessmarks
        guessmarks.add(options,BorderLayout.SOUTH);//Sets the button row to the bottom of the screen
        guessmarks.add(marks,BorderLayout.EAST);//Sets the mark rows to the right hand side of the screem
        guessmarks.add(guesses,BorderLayout.WEST);//Sets the guess rows to the left hand side of the screen
        masterPanel.add(guessmarks, BorderLayout.CENTER);//Adds the guessmarks panel to the master panel and centralises it
        mainWindow.setContentPane(masterPanel);//Sets the content pane of the main window to the masterpanel
        mainWindow.setSize(510,650);//Sets the size of the main frame
        mainWindow.setVisible(true);//Sets the frame to be visible after everything is loaded
        r.addActionListener(this);//Adds the action listener to all the buttons, so the actionPerformed method activates when a button is pressed, same event for all the buttons
        o.addActionListener(this);
        y.addActionListener(this);
        g.addActionListener(this);
        b.addActionListener(this);
        p.addActionListener(this);
        v.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent e)//The action event for the buttons, everything from this point is mimicked in the hardboard class so I will only note here to save you time
    {
        if(ActionCount1<4)//Checks if the action counter is ready
        {
            if(e.getSource() == r)//Gets the source of the button, same for all the other buttons
            {
                guessbuttons0[ActionCount1].setIcon(red);//If the button is red it  will set the guess button to red etc for other buttond
                playerguesses0[ActionCount1] = 0;//Sets the int value of the player guesses array to match the button pressed, same for all other buttons
                ActionCount1++;//Iterates the action counter
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
            for (int i = 0;i<4;i++)//Loops for every integer in playerguess
            {
                if(playerguesses0[i] == guessobject.answers[i])//If the players guess is the same as correct answer
                {
                    markbuttons0[markbuttonpos0].setIcon(correct);//Changes the current mark icon to the fully correct icon
                    markbuttonpos0++;//Iterates the counter
                }
                else if((playerguesses0[i] == guessobject.answers[0])||(playerguesses0[i] == guessobject.answers[1])||(playerguesses0[i] == guessobject.answers[2])||(playerguesses0[i] == guessobject.answers[3]))
                {
                    incorrectcount0++;//If the guessed colour is correct but in the wrong place, this counter is iterated, Had issues with a colour being checked more than once or if there was more than one of the same colour, the counter would iterate even if one was in the right place and one wasnt
                }
            }
            for (int i = 0;i<incorrectcount0;i++)//Only loops to the amount of the incorrect counter so that there is no overflow
            {
                markbuttons0[markbuttonpos0].setIcon(halfcorrect);//Sets the current mark icon the half correct button
                markbuttonpos0++;//Iterates the mark icon counter
            }
            if((playerguesses0[0] == guessobject.answers[0])&&(playerguesses0[1] == guessobject.answers[1])&&(playerguesses0[2] == guessobject.answers[2])&&(playerguesses0[3] == guessobject.answers[3]))
            {
                GoodEnding goodend0 = new GoodEnding();//If every guess is correct then a GoodEnding instance game is created and the game ends
                mainWindow.setVisible(false);//Closes the main game
            }
            ActionCount1++;//Iterates the counter so that we can move onto the next row, The next rows are the same till line 761 so skip that
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
                    ActionCount3++;
                }
                else if(ActionCount3==5)
                {
                    if(ActionCount4<4)
                    {
                    if(e.getSource() == r)
                    {
                        guessbuttons3[ActionCount4].setIcon(red);
                        playerguesses3[ActionCount4] = 0;
                        ActionCount4++;
                    }
    
                    else if(e.getSource() == o)
                    {
                        guessbuttons3[ActionCount4].setIcon(orange);
                        playerguesses3[ActionCount4] = 1;
                        ActionCount4++;
                    }
    
                    else if(e.getSource() == y)
                    {
                        guessbuttons3[ActionCount4].setIcon(yellow);
                        playerguesses3[ActionCount4] = 2;
                        ActionCount4++;
                    }
    
                    else if(e.getSource() == g)
                    {
                        guessbuttons3[ActionCount4].setIcon(green);
                        playerguesses3[ActionCount4] = 3;
                        ActionCount4++;
                    }
    
                    else if(e.getSource() == b)
                    {
                        guessbuttons3[ActionCount4].setIcon(blue);
                        playerguesses3[ActionCount4] = 4;
                        ActionCount4++;
                    }
    
                    else if(e.getSource() == p)
                    {
                        guessbuttons3[ActionCount4].setIcon(purple);
                        playerguesses3[ActionCount4] = 5;
                        ActionCount4++;
                    }
    
                    else if(e.getSource() == v)
                    {
                        guessbuttons3[ActionCount4].setIcon(violet);
                        playerguesses3[ActionCount4] = 6;
                        ActionCount4++;
                    }
                }
                
    
                    if(ActionCount4 == 4)
                    {
                        for (int i = 0;i<4;i++)
                        {
                            if(playerguesses3[i] == guessobject.answers[i])
                            {
                                markbuttons3[markbuttonpos3].setIcon(correct);
                                markbuttonpos3++;
                            }
                            else if((playerguesses3[i] == guessobject.answers[0])||(playerguesses3[i] == guessobject.answers[1])||(playerguesses3[i] == guessobject.answers[2])||(playerguesses3[i] == guessobject.answers[3]))
                            {
                                incorrectcount3++;
                            }
                        }
                        for (int i = 0;i<incorrectcount3;i++)
                        {
                            markbuttons3[markbuttonpos3].setIcon(halfcorrect);
                            markbuttonpos3++;
                        }
                        if((playerguesses3[0] == guessobject.answers[0])&&(playerguesses3[1] == guessobject.answers[1])&&(playerguesses3[2] == guessobject.answers[2])&&(playerguesses3[3] == guessobject.answers[3]))
                        {
                            GoodEnding goodend3 = new GoodEnding();
                            mainWindow.setVisible(false);
                        }
                        ActionCount4++;
                    }
                    else if(ActionCount4==5)
            {
                if(ActionCount5<4)
                {
                if(e.getSource() == r)
                {
                    guessbuttons4[ActionCount5].setIcon(red);
                    playerguesses4[ActionCount5] = 0;
                    ActionCount5++;
                }

                else if(e.getSource() == o)
                {
                    guessbuttons4[ActionCount5].setIcon(orange);
                    playerguesses4[ActionCount5] = 1;
                    ActionCount5++;
                }

                else if(e.getSource() == y)
                {
                    guessbuttons4[ActionCount5].setIcon(yellow);
                    playerguesses4[ActionCount5] = 2;
                    ActionCount4++;
                }

                else if(e.getSource() == g)
                {
                    guessbuttons4[ActionCount5].setIcon(green);
                    playerguesses4[ActionCount5] = 3;
                    ActionCount5++;
                }

                else if(e.getSource() == b)
                {
                    guessbuttons4[ActionCount5].setIcon(blue);
                    playerguesses4[ActionCount5] = 4;
                    ActionCount5++;
                }

                else if(e.getSource() == p)
                {
                    guessbuttons4[ActionCount5].setIcon(purple);
                    playerguesses4[ActionCount5] = 5;
                    ActionCount5++;
                }

                else if(e.getSource() == v)
                {
                    guessbuttons4[ActionCount5].setIcon(violet);
                    playerguesses4[ActionCount5] = 6;
                    ActionCount5++;
                }
            }
            

                if(ActionCount5 == 4)
                {
                    for (int i = 0;i<4;i++)
                    {
                        if(playerguesses4[i] == guessobject.answers[i])
                        {
                            markbuttons4[markbuttonpos4].setIcon(correct);
                            markbuttonpos4++;
                        }
                        else if((playerguesses4[i] == guessobject.answers[0])||(playerguesses4[i] == guessobject.answers[1])||(playerguesses4[i] == guessobject.answers[2])||(playerguesses4[i] == guessobject.answers[3]))
                        {
                            incorrectcount4++;
                        }
                    }
                    for (int i = 0;i<incorrectcount4;i++)
                    {
                        markbuttons4[markbuttonpos4].setIcon(halfcorrect);
                        markbuttonpos4++;
                    }
                    if((playerguesses4[0] == guessobject.answers[0])&&(playerguesses4[1] == guessobject.answers[1])&&(playerguesses4[2] == guessobject.answers[2])&&(playerguesses4[3] == guessobject.answers[3]))
                    {
                        GoodEnding goodend4 = new GoodEnding();
                        mainWindow.setVisible(false);
                    }
                    ActionCount5++;
                    System.out.println(ActionCount6);
                }
            }
            if(ActionCount5==5)
            {
                if(ActionCount6<4)
                {
                    
                if(e.getSource() == r)
                {
                    guessbuttons5[ActionCount6].setIcon(red);
                    playerguesses5[ActionCount6] = 0;
                    ActionCount6++;
                }

                else if(e.getSource() == o)
                {
                    guessbuttons5[ActionCount6].setIcon(orange);
                    playerguesses5[ActionCount6] = 1;
                    ActionCount6++;
                }

                else if(e.getSource() == y)
                {
                    guessbuttons5[ActionCount6].setIcon(yellow);
                    playerguesses5[ActionCount6] = 2;
                    ActionCount6++;
                }

                else if(e.getSource() == g)
                {
                    guessbuttons5[ActionCount6].setIcon(green);
                    playerguesses5[ActionCount6] = 3;
                    ActionCount6++;
                }

                else if(e.getSource() == b)
                {
                    guessbuttons5[ActionCount6].setIcon(blue);
                    playerguesses5[ActionCount6] = 4;
                    ActionCount6++;
                }

                else if(e.getSource() == p)
                {
                    guessbuttons5[ActionCount6].setIcon(purple);
                    playerguesses5[ActionCount6] = 5;
                    ActionCount6++;
                }

                else if(e.getSource() == v)
                {
                    guessbuttons5[ActionCount6].setIcon(violet);
                    playerguesses5[ActionCount6] = 6;
                    ActionCount6++;
                }
            }
            

                if(ActionCount6 == 4)
                {
                    for (int i = 0;i<4;i++)
                    {
                        if(playerguesses5[i] == guessobject.answers[i])
                        {
                            markbuttons5[markbuttonpos5].setIcon(correct);
                            markbuttonpos5++;
                        }
                        else if((playerguesses5[i] == guessobject.answers[0])||(playerguesses5[i] == guessobject.answers[1])||(playerguesses5[i] == guessobject.answers[2])||(playerguesses5[i] == guessobject.answers[3]))
                        {
                            incorrectcount5++;
                        }
                    }
                    for (int i = 0;i<incorrectcount5;i++)
                    {
                        markbuttons5[markbuttonpos5].setIcon(halfcorrect);
                        markbuttonpos5++;
                    }
                    if((playerguesses5[0] == guessobject.answers[0])&&(playerguesses5[1] == guessobject.answers[1])&&(playerguesses5[2] == guessobject.answers[2])&&(playerguesses5[3] == guessobject.answers[3]))
                    {
                        GoodEnding goodend5 = new GoodEnding();
                        mainWindow.setVisible(false);
                    }
                    else
                    {
                        ActionCount6++;
                    }
                }
                if(ActionCount6 == 5)
                {
                    BadEnding badend = new BadEnding();//If the player runs out of guesses a bad ending instance is created
                    mainWindow.setVisible(false);//Closes the game, all mirrored in hard board
                }
            }
        
            }
            }
                
            
        }

    }
}
    
    
    
    
    
         
        
        
    





