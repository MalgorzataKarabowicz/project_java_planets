package pl.edu.pw.fizyka.pojava.karabowicz.cybulska.simulation;

import pl.edu.pw.fizyka.pojava.karabowicz.cybulska.input.KeyMenager;

import javax.swing.*;
import java.awt.*;


public class SimulationMainPanel extends JPanel
{
    Color simulationMainPanelColor = Color.DARK_GRAY;
    public SimulationMainPanel()
    {
        this.setBackground(simulationMainPanelColor);
    }


    //pomocnicze
    public void paintComponent(Graphics g)
    {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,1000,1000);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(200,200,10,10);
    }


}
