import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame
{
    private Model model;
    private MenuBar menuBar;
    private JLabel turnLabel;
    private JPanel mainPanel;
    public static JButton[][] grid = new JButton[14][14];
    private WindowAdapter exit = new WindowAdapter()
    {
        @Override
        public void windowClosing(WindowEvent e)
        {
            System.exit(0);
        }
    };
    private int size;

    public MainWindow()
    {
        addWindowListener(exit);

        setTitle("Triky Five");   //title of the window
        setSize(560, 560);         //size of the window

        this.mainPanel = new JPanel();

        menuBar = new MenuBar(start6x6GameAction, start10x10GameAction, start14x14GameAction);

        setJMenuBar(menuBar);
        start6x6GameAction.setEnabled(true);
        start10x10GameAction.setEnabled(true);
        start14x14GameAction.setEnabled(true);

        turnLabel = new JLabel();
        setVisible(true);
    }

    private final Action start6x6GameAction = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            mainPanel.removeAll();

            setLayout(new BorderLayout());
            add(turnLabel, BorderLayout.SOUTH);
            add(mainPanel, BorderLayout.CENTER);

            drawGrid(6);
            model=new Model(6,"X");
            size=6;

            updateLabel();
        }

    };

    private final Action start10x10GameAction = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            mainPanel.removeAll();

            setLayout(new BorderLayout());
            add(turnLabel, BorderLayout.SOUTH);
            add(mainPanel, BorderLayout.CENTER);

            drawGrid(10);
            model=new Model(10,"X");
            size=10;

            updateLabel();
        }
    };

    private final Action start14x14GameAction = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            mainPanel.removeAll();

            setLayout(new BorderLayout());
            add(turnLabel, BorderLayout.SOUTH);
            add(mainPanel, BorderLayout.CENTER);

            drawGrid(14);
            model=new Model(14,"X");
            size=14;

            updateLabel();
        }

    };

    private void drawGrid(int size)
    {
        mainPanel.setLayout(new GridLayout(size, size));    //to create grid

        for (int i = 0; i < size; ++i)
        {
            for (int j = 0; j < size; ++j)
            {
                addButton(i, j);
            }
        }
    }

    private void addButton (int i, int j)
    {
        grid[i][j] = new JButton();
        mainPanel.add(grid[i][j]);
        updateTextOfButton(i,j,"");

        grid[i][j].addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {

                model.canMark(i,j);

                if(model.isGameOver() || model.isTableFull())
                {
                    showEndGameWindow();
                }
                model.toRemoveRandomly();

                model.switchTurns();
                updateLabel();
            }
        });

    }

    public static void updateTextOfButton(int i, int j, String buttonValue)
    {
        grid[i][j].setText(String.valueOf(buttonValue));
    }

    private void updateLabel()
    {
        if(model.getPlayersTurn()=="X")
            turnLabel.setText("  Player 1's Turn!");
        else if(model.getPlayersTurn()=="O")
            turnLabel.setText("  Player 2's Turn!");

    }

    public void showEndGameWindow()
    {
        int n = JOptionPane.showConfirmDialog(this,
                model.winner +"\n"+"Click Yes to play again\nClick No to quit",
                "Approve", JOptionPane.YES_NO_OPTION);

        if (n == JOptionPane.YES_OPTION)
        {
            model.resetGrid();
            if(model.getPlayersTurn()=="X")
                model.switchTurns();
            updateLabel();
        }
        if (n == JOptionPane.NO_OPTION)
        {
            System.exit(0);
        }
    }
}