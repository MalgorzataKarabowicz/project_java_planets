package pl.edu.pw.fizyka.pojava.karabowicz.cybulska;

import java.awt.*;

public class Sunn implements CelestialBody
{
    Color color = Color.YELLOW;
    Double mass = 10000.00;
    
    public void paintCelestialBody()
    {

    };
    Sunn(Color newColor, Double newMass)
    {
        color = newColor;
        mass= newMass;
    }
}
