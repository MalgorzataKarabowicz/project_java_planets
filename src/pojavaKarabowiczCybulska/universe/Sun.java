package pojavaKarabowiczCybulska.universe;

import java.awt.*;


public class Sun extends CelestialBodyOrbit //Cybulska
{
    public Sun (CelestialBodyPosition position, Color colour, double mass)
    {
        super();
        this.colour = colour;
        this.mass = mass;
        setSize();
        this.position = position;
        this.angularSpeed = 0;
    }

    @Override
    CelestialBodyPosition getPosition()
    {
        return null;
    }
    public double getMass() { return this.mass; }
    public void setMass(double mass) { this.mass = mass; }

    private void setSize() //Karabowicz
    {
        if(mass <= 1)
        {
            size = 10;
        }
        else if(1 < mass && mass <= 100)
        {
            size = 15;
        }
        else if(100 < mass && mass <= 1000)
        {
            size = 20;
        }
        else if(1000 < mass && mass <= 10000)
        {
            size = 25;
        }
        else if(10000 < mass)
        {
            size = 30;
        }
    }


    public void paint(Graphics g)
    {
        g.getColor();
        g.fillOval(position.getX() - size/4, position.getY() - size/4, size(), size());
    }
}
