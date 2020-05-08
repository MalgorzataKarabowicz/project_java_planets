package pojavaKarabowiczCybulska.universe;

import java.awt.*;

public abstract class CelestialBody
{
    protected CelestialBodyPosition position; // pozycja obiektu na planszy
    protected CelestialBodyPosition orbitCentre; // -> środek orbity -> tam gdzie znajduje się słońce
    protected double orbitPeriod; // czas obiegu orbity -> uzależniona od masy i promienia
    protected Color colour; // kolor dodawanego obiektu
    protected int size; // rozmiar obiektu na planszy -> trzeba by uzależnić od podawanej masy
    protected double mass; // masa obiektu

    protected int size(){return this.size;};
    public Color getColor(){return this.colour;};

    abstract CelestialBodyPosition getPosition(); // -> pozycja obiektu
}
