package pl.edu.pw.fizyka.pojava.karabowicz.cybulska.gui;



import javax.swing.*;


public class PlanetarySystemSimulationMainFrame extends JFrame
{
    PlanetarySystemSimulationMainFrame()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setTitle("Planetary System Simulation");
        this.setJMenuBar(new DropDownMenu());   //Rozwijane menu

        GuiPanel guiPanel = new GuiPanel();

        this.add(guiPanel);

    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PlanetarySystemSimulationMainFrame mainFrame = new PlanetarySystemSimulationMainFrame();
                mainFrame.setVisible(true);
            }
        });

    }
}
