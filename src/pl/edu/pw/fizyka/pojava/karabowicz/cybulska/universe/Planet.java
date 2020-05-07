package pl.edu.pw.fizyka.pojava.karabowicz.cybulska.universe;

import java.awt.*;

public class Planet extends CelestialBodyOrbit
{
    private int numOrbits = 0;

    Planet(CelestialBodyPosition orbitCentre, int orbitRadius, double orbitTime, Color colour, int size) {
        super();
        this.colour = colour;
        this.size = size;
        this.orbitCentre = orbitCentre;
        this.orbitRadius = orbitRadius;
        this.orbitPeriod = orbitTime;
        this.position = new CelestialBodyPosition(orbitCentre.getX(),orbitCentre.getY()+this.orbitRadius);
        this.angularSpeed = 2*Math.PI/this.orbitPeriod;
        this.delta = 2*Math.PI*this.delay/(this.orbitPeriod*1000);
    }

    @Override
    public CelestialBodyPosition getPosition() {
        updatePosition();
        return this.position;
    }
    /* Calculate new position */
    private void updatePosition() {

        this.orbitAngle += delta;
        // Check if lap completed
        if(this.orbitAngle > Math.PI * 2) {
            this.orbitAngle %= Math.PI * 2;
            /* Increment orbit every lap */
            updateOrbits();
        }
        /* Set new x,y coordinates */
        this.position.setX((int)((Math.cos(this.orbitAngle) * this.orbitRadius) + this.orbitCentre.getX()));
        this.position.setY((int)((Math.sin(this.orbitAngle) * this.orbitRadius) + this.orbitCentre.getY()));
    }

    public int getOrbitRadius(){
        return this.orbitRadius;
    }

    public int getOrbits() {
        return this.numOrbits;
    }
    private void updateOrbits() {
        numOrbits++;
    }

}
