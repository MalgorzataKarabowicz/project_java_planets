package pl.edu.pw.fizyka.pojava.karabowicz.cybulska.gui;

import pl.edu.pw.fizyka.pojava.karabowicz.cybulska.simulation.SimulationMainPanel;

import javax.swing.*;
import java.awt.*;

public class PlanetarySystemSimulationMainFrame extends JFrame
{
    PlanetarySystemSimulationMainFrame()
    {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(900,600);
        this.setTitle("Planetary System Simulation");
        this.setJMenuBar(new DropDownMenu());   //Rozwijane menu

        JPanel planetarySystemSimulationMainPanel = new JPanel(new BorderLayout());
        planetarySystemSimulationMainPanel.add(new ChangeOptionsPanel(), BorderLayout.LINE_END);
        planetarySystemSimulationMainPanel.add(new SimulationMainPanel(), BorderLayout.CENTER);
        this.add(planetarySystemSimulationMainPanel);

    }

    public static void main(String[] args)
    {
        PlanetarySystemSimulationMainFrame mainFrame = new PlanetarySystemSimulationMainFrame();
        mainFrame.setVisible(true);
    }
}
