package pojavaKarabowiczCybulska.universe;

import java.awt.*;


public class Sun extends CelestialBodyOrbit //Cybulska
{
    public Sun (CelestialBodyPosition position, Color colour, double mass, int size)
    {
        super();
        this.colour = colour;
        this.size = size;
        this.mass = mass;
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
        if(mass < 1)
        {

        }
    }


    public void paint(Graphics g)
    {
        g.getColor();
        g.fillOval(position.getX(), position.getY(), size(), size());
    }
}
