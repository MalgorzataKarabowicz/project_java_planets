package pl.edu.pw.fizyka.pojava.karabowicz.cybulska.simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    //Rozpoczęcie animacji
    public void start() {animationTimer.start();}
    //zatrzymanie animacji
    public void stop() {animationTimer.stop();}


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
