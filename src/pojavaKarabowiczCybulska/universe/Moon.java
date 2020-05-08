package pojavaKarabowiczCybulska.universe;

import java.awt.*;

public class Moon extends CelestialBodyOrbit
{
    public Moon(CelestialBodyPosition orbitCentre,int orbitRadius, double orbitTime, Color colour, double mass, int size)
    {
        super();
        this.orbitCentre = orbitCentre;

        this.colour = colour;
        this.size = size;
        this.mass = mass;
        this.orbitRadius = orbitRadius;
        this.orbitPeriod = orbitTime;
        this.position = new CelestialBodyPosition(orbitCentre.getX(),orbitCentre.getY()+this.orbitRadius);
        this.angularSpeed = 2*Math.PI/this.orbitPeriod;
        this.delta = 2*Math.PI*this.delay/(this.orbitPeriod*1000);
    }
    public void setOrbitCentre(CelestialBodyPosition orbitCentre) { this.orbitCentre = orbitCentre;}

    /**
     * Trzeba napisać funkcje ogarniajaca polozenie
     * @return
     */
    @Override
    public CelestialBodyPosition getPosition()
    {
        //updatePosition();
        return this.position;
    }

    private void updatePosition()
    {

    }
}
