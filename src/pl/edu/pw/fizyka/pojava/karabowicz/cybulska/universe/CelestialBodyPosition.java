package pl.edu.pw.fizyka.pojava.karabowicz.cybulska.universe;

/*
Pozycja danego obiektu
 */

/**
 * ta klasa jest już OK
 */

public class CelestialBodyPosition //Karabowicz
{
    private int x;
    private int y;

    CelestialBodyPosition()
    {
        this.x = 0;
        this.y = 0;
    }

   public CelestialBodyPosition(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}

    public int getX(){return this.x;}
    public int getY(){return this.y;}
}