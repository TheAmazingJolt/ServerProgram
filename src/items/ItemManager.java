package items;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package items:
//            Item

public class ItemManager
{

    private ArrayList<Item> items;
	
    public ItemManager()
    {
        items = new ArrayList<Item>();
    }

    public void tick()
    {
        for(Iterator<Item> it = items.iterator(); it.hasNext();)
        {
            Item i = (Item)it.next();
            i.tick();
            if(i.isPickedUp())
                it.remove();
        }

    }

    public void addItem(Item i)
    {
        items.add(i);
    }

}
