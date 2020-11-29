import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar
{
    private JMenu gameMenu;

    private void createMenuItem(String name, Action action)
    {
        JMenuItem item = new JMenuItem(action);
        item.setText(name);
        gameMenu.add(item);
    }

    public MenuBar(Action start6x6GameAction,Action start10x10GameAction, Action start14x14GameAction)
    {
        gameMenu = new JMenu("Game Table Menu");

        createMenuItem("Start 6x6 Game", start6x6GameAction);
        createMenuItem("Start 10x10 Game", start10x10GameAction);
        createMenuItem("Start 14x14 Game", start14x14GameAction);

        add(gameMenu);
    }
}