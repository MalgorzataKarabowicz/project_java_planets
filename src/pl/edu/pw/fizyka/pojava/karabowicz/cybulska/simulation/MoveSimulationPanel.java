package pl.edu.pw.fizyka.pojava.karabowicz.cybulska.simulation;

import java.util.logging.Handler;
import pl.edu.pw.fizyka.pojava.karabowicz.cybulska.input.KeyMenager;
public class MoveSimulationPanel
{
    private Handler handler;
    private float x, y; //actual position in space
    private float dispX, dispY; //where its drawn at on screen

    public MoveSimulationPanel(Handler handler)
    {
        this.handler = handler;
        this.x = 0;
        this.y = 0;
        this.dispX = 0;
        this.dispY = 0;
    }
    private void getInput()
    {
        getKeyboardInput();
    }
    private void getKeyboardInput();
    {
        //WASD KEYS
        if(handler.getKeyManager().up && !handler.getKeyManager().down)
            handler.getCamera().move(0,-10);
        if(handler.getKeyManager().down && !handler.getKeyManager().up)
            handler.getCamera().move(0,10);
        if(handler.getKeyManager().left && !handler.getKeyManager().right)
            handler.getCamera().move(-10,0);
        if(handler.getKeyManager().right && !handler.getKeyManager().left)
            handler.getCamera().move(10,0);
    }
}
