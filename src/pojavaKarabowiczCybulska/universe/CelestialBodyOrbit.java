package pojavaKarabowiczCybulska.universe;

public abstract class CelestialBodyOrbit extends CelestialBody
{
    protected int orbitRadius; // promień orbity
    protected double angularSpeed; // kątowa prędkość obiektu
    protected double orbitAngle = 0; // początkowy kąt
    protected double delta; // wartość wzrostu promienia
    protected double delay = 50; // przerwa pomiędzy krokami (odświeżeniami)
}
