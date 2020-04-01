package pl.edu.pw.fizyka.pojava.karabowicz.cybulska;

import javax.swing.*;

public class PlanetarySystemSimulatiomMainFrame extends JFrame
{
    PlanetarySystemSimulatiomMainFrame()
    {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(800,600);
        this.setJMenuBar(new DropDownMenu());   //Rozwijane menu
    }

    public static void main(String[] args)
    {
        PlanetarySystemSimulatiomMainFrame mainFrame = new PlanetarySystemSimulatiomMainFrame();
        mainFrame.setVisible(true);
    }
}
