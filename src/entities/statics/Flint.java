package entities.statics;

import items.Item;
import worlds.World;

// Referenced classes of package entities.statics:
//            StaticEntity

public class Flint extends StaticEntity
{
	
	private static int maxHealth = 20;
	
    public Flint(float x, float y, int id, World world)
    {
        super(x, y, 64, 64, maxHealth, id, world);
        this.id = id;
        this.health = maxHealth;
        bounds.x = 3;
        bounds.y = (int)((float)height / 2.0F);
        bounds.width = width - 6;
        bounds.height = (int)((float)height - (float)height / 2.0F);
    }

    public void tick()
    {
        if(!active)
        {
            bounds.width = 0;
            bounds.height = 0;
            return;
        }
        bounds.width = width - 6;
        bounds.height = (int)((float)height - (float)height / 2.0F);
    }

    public void die()
    {
        world.getItemManager().addItem(Item.flintItem.createNew((int)x, (int)y, false, false, false));
    }

}
