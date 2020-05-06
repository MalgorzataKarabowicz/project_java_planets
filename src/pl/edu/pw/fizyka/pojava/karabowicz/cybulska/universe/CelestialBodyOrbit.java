package pl.edu.pw.fizyka.pojava.karabowicz.cybulska.universe;

public abstract class CelestialBodyOrbit extends CelestialBody
{
    protected int orbitRadius; // orbit radius of object
    protected double angularSpeed; // angular speed of object
    protected double orbitAngle = 0; // starting orbit angle
    protected double delta; // angle increments
    protected double delay = 50; // Delay in ms between steps
}
