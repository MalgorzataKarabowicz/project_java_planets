package pojavaKarabowiczCybulska.universe;

import pojavaKarabowiczCybulska.universe.CelestialBodyOrbit;
import pojavaKarabowiczCybulska.universe.CelestialBodyPosition;

import java.awt.*;
import java.util.ArrayList;

public class Planet extends CelestialBodyOrbit
{
    private int numOrbits = 0;
    private final int g = 1;

    private ArrayList<Moon> moons;
    /*
    public void addMoon(int orbitRadius, double orbitTime, Color color, double mass, int size )
    {
        moons.add(new Moon(this.orbitCentre, orbitRadius, orbitTime,color,mass,size) );
    }
    */
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
    this.angularSpeed = Math.sqrt(g*mass/orbitRadius/orbitRadius/orbitRadius);
    this.delta = 2*Math.PI*this.delay/(this.orbitPeriod*1000);
}

    /**
     * Trzeba napisac funkcje liczaca pozycje planety
     * i w ksiezycach napisac podobna funkcje ktora jako argumenty bedzie brała położenie planety macierzystej
     * wydaje mi się że tak będzie najsensowniej.
     * @return
     */
    @Override
    public CelestialBodyPosition getPosition()
    {
        updatePosition();
        return this.position;
    }
    //Nowa pozycja -> obliczenie
    public void updatePosition()
    {

        this.orbitAngle += delta;

        if(this.orbitAngle > Math.PI * 2) {
            this.orbitAngle %= Math.PI * 2;
            updateOrbits();
        }
        // Nowe zmienne x, y
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
    public void setMass(double mass) { this.mass =mass; }
    public double getMass() { return this.mass; }

    public void paint(Graphics g)
    {
        g.getColor();
        g.fillOval(position.getX(), position.getY(), size(), size());
    }

}
