package pl.edu.pw.fizyka.pojava.karabowicz.cybulska;

import javax.swing.*;
import java.awt.*;

public class PlanetarySystemSimulatiomMainFrame extends JFrame
{
    PlanetarySystemSimulatiomMainFrame()
    {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1000,800);
        this.setJMenuBar(new DropDownMenu());   //Rozwijane menu

        JPanel planetarySystemSimulationMainPanel = new JPanel(new BorderLayout());
        planetarySystemSimulationMainPanel.add(new ChangeOptionsPanel(), BorderLayout.LINE_END);
        this.add(planetarySystemSimulationMainPanel);
    }

    public static void main(String[] args)
    {
        PlanetarySystemSimulatiomMainFrame mainFrame = new PlanetarySystemSimulatiomMainFrame();
        mainFrame.setVisible(true);
    }
}
