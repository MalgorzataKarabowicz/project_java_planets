package pojavaKarabowiczCybulska.gui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropDownMenu extends JMenuBar
{
    JMenu menu;
    JMenuItem menuSaveProject, menuOpenProject, menuCleanProject, menuNewProject;
    ActionListener actionMenu = new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()==menuSaveProject) { }
            if(e.getSource()==menuOpenProject) { }
            if(e.getSource()==menuCleanProject) {GuiPanel.clean(); }
            if(e.getSource()==menuNewProject)
            {
                SwingUtilities.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        PlanetarySystemSimulationMainFrame mainFrame = new PlanetarySystemSimulationMainFrame();
                        mainFrame.setVisible(true);
                    }
                });
            }

        }
    };

    DropDownMenu()  //Cybulska
    {
        menu= new JMenu("Menu");
        menuSaveProject = new JMenuItem("Save");
        menuOpenProject = new JMenuItem("Open");
        menuCleanProject = new JMenuItem("Clean");
        menuNewProject = new JMenuItem("New");
        add(menu);
        menu.add(menuSaveProject);
        menu.add(menuOpenProject);
        menu.add(menuCleanProject);
        menu.add(menuNewProject);

        menuSaveProject.addActionListener(actionMenu);
        menuOpenProject.addActionListener(actionMenu);
        menuCleanProject.addActionListener(actionMenu);
        menuNewProject.addActionListener(actionMenu);
    }
}
