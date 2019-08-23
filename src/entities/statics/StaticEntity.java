package entities.statics;

import entities.Entity;
import worlds.World;

public abstract class StaticEntity extends Entity
{

    public StaticEntity(float x, float y, int width, int height, int health, int id, World world)
    {
        super(x, y, width, height, health, id, world);
    }
}
