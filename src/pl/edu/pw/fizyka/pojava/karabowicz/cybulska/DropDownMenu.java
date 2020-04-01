package pl.edu.pw.fizyka.pojava.karabowicz.cybulska;
import javax.swing.*;

public class DropDownMenu extends JMenuBar
{
    JMenu menu;
    JMenuItem menuSaveProject, menuOpenProject, menuCleanProject, menuNewProject;

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

        // menuSaveProject.addActionListener(actionMenu);
        // menuOpenProject.addActionListener(actionMenu);
        // menuCleanProject.addActionListener(actionMenu);
        // menuNewProject.addActionListener(actionMenu);
    }
}
