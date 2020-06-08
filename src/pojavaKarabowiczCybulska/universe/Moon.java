package pojavaKarabowiczCybulska.universe;

import pojavaKarabowiczCybulska.gui.GuiPanel;

import java.awt.*;

import static java.lang.Math.pow;

public class Moon extends CelestialBodyOrbit
{
    private int numOrbits = 0;
    private int planetSize;

    public Moon(CelestialBodyPosition orbitCentre,int planetSize, int orbitRadius, double orbitTime, Color colour, double mass, double planetMass, int size)
    {
        super();
        this.planetSize = planetSize;
        this.orbitCentre = new CelestialBodyPosition(orbitCentre.getX()+(this.planetSize)/4,orbitCentre.getY()+(this.planetSize)/4);

        this.colour = colour;
        this.size = size;
        this.mass = mass;
        this.orbitRadius = orbitRadius;
        this.orbitPeriod = orbitTime;
        this.position = new CelestialBodyPosition( this.orbitCentre.getX(),this.orbitCentre.getY());
        this.angularSpeed = Math.sqrt( (6.67*pow(10,-14)*planetMass*6*pow(10,24)) / pow( this.orbitRadius*150*pow(10,9) ,3) ) ;
    }
    public void setOrbitCentre(CelestialBodyPosition orbitCentre) { this.orbitCentre = orbitCentre;}

    /**
     * Obczaj ta funkcje
     * @return
     */
    @Override
    public CelestialBodyPosition getPosition() { return this.position; }

    private void updateOrbits() {
        numOrbits++;
    }

    public void updatePosition(CelestialBodyPosition planetPosittion)
    {
        this.orbitCentre.setX( planetPosittion.getX()+(this.planetSize)/4 +this.size/4 );
        this.orbitCentre.setY( planetPosittion.getY()+(this.planetSize)/4 +this.size/4 );

        this.orbitAngle += (this.angularSpeed*pow(10,11));

        if(this.orbitAngle > Math.PI * 2)
        {
            this.orbitAngle %= Math.PI * 2;
            updateOrbits();
        }
        // Nowe zmienne x, y
        this.position.setX( (int)((Math.cos(this.orbitAngle) * this.orbitRadius) + orbitCentre.getX()));
        this.position.setY( (int)((Math.sin(this.orbitAngle) * this.orbitRadius) + orbitCentre.getY()));

    }

    public void paint(Graphics g)
    {
        g.setColor(this.colour);
        g.fillOval(position.getX(), position.getY(), size(), size());
    }
    public void paintOrbit(Graphics g) //mam nadzieję, że to tak będzie
    {
        g.setColor(this.colour);
        g.drawOval(this.orbitCentre.getX() + size/4 - orbitRadius+this.size/4, this.orbitCentre.getY() +size/4 - orbitRadius +this.size/4, 2*orbitRadius, 2*orbitRadius);
    }
    public double getMass() { return this.mass; }
    public double getOrbitRadius() { return this.orbitRadius; }
    public Color getColor() { return this.colour; }
}
