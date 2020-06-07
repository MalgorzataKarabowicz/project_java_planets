package pojavaKarabowiczCybulska.universe;

import java.awt.*;

import static java.lang.Math.pow;

public class Moon extends CelestialBodyOrbit
{
    private int numOrbits = 0;

    public Moon(CelestialBodyPosition orbitCentre,int orbitRadius, double orbitTime, Color colour, double mass, double planetMass, int size)
    {
        super();
        this.orbitCentre = orbitCentre;

        this.colour = colour;
        this.size = size;
        this.mass = mass;
        this.orbitRadius = orbitRadius;
        this.orbitPeriod = orbitTime;
        this.position = new CelestialBodyPosition(orbitCentre.getX(),orbitCentre.getY()+this.orbitRadius);
        this.angularSpeed = Math.sqrt( (6.67*pow(10,-14)*planetMass) / pow(this.orbitRadius,3) ) ;
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

        this.orbitAngle += this.angularSpeed;

        if(this.orbitAngle > Math.PI * 2) {
            this.orbitAngle %= Math.PI * 2;
            updateOrbits();
        }
        // Nowe zmienne x, y
        this.position.setX( (int)((Math.cos(this.orbitAngle) * this.orbitRadius) + planetPosittion.getX()) );
        this.position.setY( (int)((Math.sin(this.orbitAngle) * this.orbitRadius) + planetPosittion.getY()) );

    }

    public void paint(Graphics g)
    {
        g.setColor(this.colour);
        g.fillOval(position.getX(), position.getY(), size(), size());
    }
    public double getMass() { return this.mass; }
    public double getOrbitRadius() { return this.orbitRadius; }
    public Color getColor() { return this.colour; }
}
