package pl.edu.pw.fizyka.pojava.karabowicz.cybulska.simulation;

import pl.edu.pw.fizyka.pojava.karabowicz.cybulska.gui.GuiPanel;

import javax.swing.*;

//to chyba nie jest potrzebne -> nie potrzebujemy Appleta

public class SimulationApplet extends JApplet
{
    private GuiPanel guiPanel;
    /** Create animation GUI panel and add to applet */
    public void init() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    guiPanel = new GuiPanel();
                    add(guiPanel);
                } });
        }
        catch (Exception e) {
            System.err.println("Unable to initialize applet");
        }
    }
    /** Start animation when applet is started. */
    public void start() {guiPanel.start();}
    /** Stop animation when applet is stopped. */
    public void stop() {guiPanel.stop();}
}
