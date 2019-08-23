package entities.statics;

import java.awt.Color;
import java.awt.Graphics;

import items.Item;
import worlds.World;

// Referenced classes of package entities.statics:
//            StaticEntity

public class IcyTree extends StaticEntity
{

	private static int maxHealth = 40;
	
    public IcyTree(float x, float y, int id, World world)
    {
        super(x, y, 64, 128, maxHealth, id, world);
        this.id = id;
        this.health = maxHealth;
        bounds.x = 10;
        bounds.y = (int)((float)height / 1.5F);
        bounds.width = width - 20;
        bounds.height = (int)((float)height - (float)height / 1.5F);
    }

    public void tick()
    {
        if(!active)
        {
            bounds.width = 0;
            bounds.height = 0;
            return;
        }
        bounds.width = width - 20;
        bounds.height = (int)((float)height - (float)height / 1.5F);
        if(!attacked)
            health = 10;
    }

    public void die()
    {
        world.getItemManager().addItem(Item.woodItem.createNew((int)x + 16, (int)y + 64, false, false, false));
    }
    
}
