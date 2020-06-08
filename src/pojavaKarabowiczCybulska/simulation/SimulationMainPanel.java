package pojavaKarabowiczCybulska.simulation;


import pojavaKarabowiczCybulska.gui.GuiPanel;
import pojavaKarabowiczCybulska.universe.Moon;
import pojavaKarabowiczCybulska.universe.Planet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import static pojavaKarabowiczCybulska.gui.GuiPanel.planetArrayList;
import static pojavaKarabowiczCybulska.gui.PlanetarySystemSimulationMainFrame.ogarniaczWatkow;


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
        System.out.println("timer");
        move();
    }

    protected void paintComponent(Graphics g)  //Karabowicz
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(GuiPanel.sun != null)
        {
            g2d.setColor(GuiPanel.sun.getColor());
            GuiPanel.sun.paint(g2d);
        }

        for (Planet planet: planetArrayList)
        {
            planet.updatePosition();
            g2d.setColor(planet.getColor());
            planet.paint(g2d);

            for (Moon moon: planet.moons)
            {
                g2d.setColor( moon.getColor() );
                moon.paint(g2d);
            }
        }

        if(GuiPanel.drawOrbits == true)
        {
            g2d.setColor(Color.WHITE);

            for (Planet planet: planetArrayList)
            {
                planet.paintOrbit(g2d);


                for (Moon moon: planet.moons)
                {
                    g2d.setColor( moon.getColor() );
                    moon.paintOrbit(g2d);
                }
            }
        }
    }


    public void move()
    {
        ogarniaczWatkow.scheduleAtFixedRate(new Runnable()
        {
            @Override
            public void run()
            {

                for (Planet planet : planetArrayList)
                {
                    //planet.updatePosition();
                    repaint();
                }
            }
        },5,1, TimeUnit.SECONDS);
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
