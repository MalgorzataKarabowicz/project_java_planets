package pojavaKarabowiczCybulska.simulation;

import pojavaKarabowiczCybulska.universe.Planet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static pojavaKarabowiczCybulska.gui.GuiPanel.planetArrayList;

/*
plansza do rysowania
 */

public class SimulationMainPanel extends JPanel implements ActionListener
{
    private Timer animationTimer;
    public static final int delay = 10; //ms



    public SimulationMainPanel()
    {
        super();


        animationTimer = new Timer(delay,this);
        animationTimer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillOval(300, 300, 20, 20);

        /**
         * Nie wiem jeszcze jak to rysować :(
         */

    }


    //Rozpoczęcie animacji
    public void start() {animationTimer.start();}
    //zatrzymanie animacji
    public void stop() {animationTimer.stop();}


    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
    }
}
