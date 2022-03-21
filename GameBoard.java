import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameBoard//Creates the main board and contains the action events to take all responses and edit the board
{
        public JPanel[] guessgrid = new JPanel[6];//This array is used to represent the rows of empty icons which will represent the players guesses as they input them
        public JPanel[] markgrid = new JPanel[6];//This array represents the rows of the marks on the right hand sign on the screen that appear after a user finishes a row of inputs
        public JLabel[] markbuttons0 = new JLabel[4];//These 6 arrays are used to represent each individual row filled with the right hand side mark buttons
        public JLabel[] markbuttons1 = new JLabel[4];
        public JLabel[] markbuttons2 = new JLabel[4];
        public JLabel[] markbuttons3 = new JLabel[4];
        public JLabel[] markbuttons4 = new JLabel[4];
        public JLabel[] markbuttons5 = new JLabel[4];
        public JLabel[] guessbuttons0 = new JLabel[4];//These 6 arrays are used to represent each individual guess icon where players guesses will be shown 
        public JLabel[] guessbuttons1 = new JLabel[4];
        public JLabel[] guessbuttons2 = new JLabel[4];
        public JLabel[] guessbuttons3 = new JLabel[4];
        public JLabel[] guessbuttons4 = new JLabel[4];
        public JLabel[] guessbuttons5 = new JLabel[4];
        public Picture correct = new Picture("Score_0.png");//The picture used to represent the correct icon with 2 ticks
        public Picture halfcorrect = new Picture("Score_1.png");//The picture used to represent a half correct input
        public JButton r = new JButton(new ImageIcon("Colour_0.png"));//Creates a button using the red image icon
        public JButton o = new JButton(new ImageIcon("Colour_1.png"));//Creates a button using the orange image icon
        public JButton y = new JButton(new ImageIcon("Colour_2.png"));//Creates a button using the yellow image icon
        public JButton g = new JButton(new ImageIcon("Colour_3.png"));//Creates a button using the green image icon
        public JButton b = new JButton(new ImageIcon("Colour_4.png"));//Creates a button using the blue image icon
        public JButton p = new JButton(new ImageIcon("Colour_5.png"));//Creates a button using the purple image icon
        public JButton v = new JButton(new ImageIcon("Colour_6.png"));//Creates a button using the violet image icon
        
     

    public GameBoard()//The method where the board is created
    {
        JFrame mainWindow = new JFrame();//The frame in which everything is stored on
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

        for (int i=0; i<4;i++)
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
    }


    /*public void actionPerformed(ActionEvent e)
    {
        int i = 0;
        
        if(e.getSource() == r)
        {
            empt[i] = new JLabel(new ImageIcon("Colour_0.png"));
            i = i+1;
        }
        
        if(e.getSource() == o)
        {
            empt[i] = new JLabel(new ImageIcon("Colour_1.png"));
            i = i+1;
        }
        if(e.getSource() == y)
        {
            empt[i] = new JLabel(new ImageIcon("Colour_2.png"));
            i = i+1;
        }
        
        if(e.getSource() == g)
        {
            empt[i] = new JLabel(new ImageIcon("Colour_3.png"));
            i = i+1;
        }
        
        if(e.getSource() == b)
        {
            empt[i] = new JLabel(new ImageIcon("Colour_4.png"));
            i = i+1;
        }

        if(e.getSource() == p)
        {
            empt[i] = new JLabel(new ImageIcon("Colour_5.png"));
            i = i+1;
        }

        if(e.getSource() == v)
        {
            empt[i] = new JLabel(new ImageIcon("Colour_6.png"));
            i = i+1;
        }

        if(i == 24)
        {

        }
    }*/
    
}

