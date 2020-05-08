package pojavaKarabowiczCybulska.universe;

import pojavaKarabowiczCybulska.universe.CelestialBodyOrbit;
import pojavaKarabowiczCybulska.universe.CelestialBodyPosition;

import java.awt.*;
import java.util.ArrayList;

public class Planet extends CelestialBodyOrbit
{
    private int numOrbits = 0;

    private ArrayList<Moon> moons;

    public Planet(CelestialBodyPosition orbitCentre, int orbitRadius, double orbitTime, Color colour, double mass, int size)
    {
        super();
        this.colour = colour;
        this.size = size;
        this.mass = mass;
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
    //Nowa pozycja -> obliczenie
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