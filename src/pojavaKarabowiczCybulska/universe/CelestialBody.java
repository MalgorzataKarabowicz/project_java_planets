package pojavaKarabowiczCybulska.universe;

import java.awt.*;

public abstract class CelestialBody
{
    protected CelestialBodyPosition position; // x,y coordinates of object on animation panel
    protected CelestialBodyPosition orbitCentre; // x,y coordinates of orbit centre on animation panel
    protected double orbitPeriod; // orbit period of object
    protected Color colour; // colour of object on animation panel
    protected int size; // size of object on animation panel
    protected double mass; //mass of object

    protected int size(){return this.size;};
    protected Color colour(){return this.colour;};
    /* Methods to implement in subclasses */
    abstract CelestialBodyPosition getPosition(); // position of object
}
