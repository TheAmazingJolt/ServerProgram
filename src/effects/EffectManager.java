package effects;

import java.awt.Graphics;
import java.util.ArrayList;

public class EffectManager
{

    private ArrayList<Effect> effects;
	
    public EffectManager()
    {
        effects = new ArrayList<Effect>();
    }

    public void tick()
    {
    	
    }

    public void render(Graphics g)
    {
    	
    }

    public void addEffect(Effect e)
    {
        effects.add(e);
    }
    
}