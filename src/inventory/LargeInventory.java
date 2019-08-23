package inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import com.sun.glass.events.KeyEvent;

import gfx.Assets;
import gfx.Text;
import items.LargeCraftItem;
import items.Item;
import main.Handler;

// Referenced classes of package inventory:
//            Hotbar

public class LargeInventory
{
	
    private static Handler handler;
    private boolean active = false;
    private static boolean hasItem1 = false;
    private static boolean hasItem2 = false;
    private static boolean hasItem3 = false;
    private static boolean hasItem4 = false;
    private static boolean hasAll = false;
    private static ArrayList<Item> inventoryItems;
    private static ArrayList<LargeCraftItem> craftingItems;
    private LargeCraftItem currentCraftItem;
    private Item currentItem;
    private Item currentTool;
    private static Item ingredient1;
    private static Item ingredient2;
    private static Item ingredient3;
    private static Item ingredient4;
    private static Item selected;
    private static Item toMoveTo;
    private int invX;
    private int invY;
    private int invWidth;
    private int invHeight;
    private int slotItemWidth;
    private int slotItemHeight;
    
    private int invSlot1X;
    private int invSlot1Y;
    private int invSlot2X;
    private int invSlot2Y;
    private int invSlot3X;
    private int invSlot3Y;
    private int invSlot4X;
    private int invSlot4Y;
    
    private int invSlot5X;
    private int invSlot5Y;
    private int invSlot6X;
    private int invSlot6Y;
    private int invSlot7X;
    private int invSlot7Y;
    private int invSlot8X;
    private int invSlot8Y;
    
    private int invSlot9X;
    private int invSlot9Y;
    private int invSlot10X;
    private int invSlot10Y;
    private int invSlot11X;
    private int invSlot11Y;
    private int invSlot12X;
    private int invSlot12Y;
    
    private int invSlot13X;
    private int invSlot13Y;
    private int invSlot14X;
    private int invSlot14Y;
    private int invSlot15X;
    private int invSlot15Y;
    private int invSlot16X;
    private int invSlot16Y;
    
    private int textSlot1X;
    private int textSlot1Y;
    private int textSlot2X;
    private int textSlot2Y;
    private int textSlot3X;
    private int textSlot3Y;
    private int textSlot4X;
    private int textSlot4Y;
    
    private int textSlot5X;
    private int textSlot5Y;
    private int textSlot6X;
    private int textSlot6Y;
    private int textSlot7X;
    private int textSlot7Y;
    private int textSlot8X;
    private int textSlot8Y;
    
    private int textSlot9X;
    private int textSlot9Y;
    private int textSlot10X;
    private int textSlot10Y;
    private int textSlot11X;
    private int textSlot11Y;
    private int textSlot12X;
    private int textSlot12Y;
    
    private int textSlot13X;
    private int textSlot13Y;
    private int textSlot14X;
    private int textSlot14Y;
    private int textSlot15X;
    private int textSlot15Y;
    private int textSlot16X;
    private int textSlot16Y;
    
    private int craftTextSlot1X;
    private int craftTextSlot1Y;
    private int craftTextSlot2X;
    private int craftTextSlot2Y;
    private int craftTextSlot3X;
    private int craftTextSlot3Y;
    private int craftTextSlot4X;
    private int craftTextSlot4Y;
    private int craftTextSlot5X;
    private int craftTextSlot5Y;
    
    private int emptyButtonX;
    private int emptyButtonY;
    private int emptyButtonWidth;
    private int emptyButtonHeight;
    
    private int craftSlot1X;
    private int craftSlot1Y;
    private int craftSlot2X;
    private int craftSlot2Y;
    private int craftSlot3X;
    private int craftSlot3Y;
    private int craftSlot4X;
    private int craftSlot4Y;
    private int craftSlot5X;
    private int craftSlot5Y;
    
    private int outlineWidth = 99;
    private int outlineHeight = 101;
    
    private int count = 1;
    private int amt = 0;
    
    private int selectedItem = -1;
    private int selectedSlot = -1;
    
    private int selectedPage = 1;
    private int maxPages = 1;
    private int minPages = 1;
    private int pageButtonY;
    private int pageUpX;
    private int pageDownX;
    private int pageButtonWidth;
    private int pageButtonHeight;
    private int pageTextX;
    private int pageTextY;
    
    private boolean full = false;
    private boolean reset = false;
    private boolean locationLoaded = false;
    private boolean hasItem = false;;
	
    public LargeInventory(Handler handle)
    {
        invX = 96;
        invY = 48;
        invWidth = 768;
        invHeight = 576;
        
        slotItemWidth = 96;
        slotItemHeight = 96;
        
        invSlot1X = invX + 51;
        invSlot1Y = invY + 50;
        invSlot2X = invSlot1X + 105;
        invSlot2Y = invSlot1Y;
        invSlot3X = invSlot2X + 105;
        invSlot3Y = invSlot1Y;
        invSlot4X = invSlot3X + 105;
        invSlot4Y = invSlot1Y;
        
        invSlot5X = invSlot1X;
        invSlot5Y = invSlot1Y + 105;
        invSlot6X = invSlot2X;
        invSlot6Y = invSlot5Y;
        invSlot7X = invSlot3X;
        invSlot7Y = invSlot5Y;
        invSlot8X = invSlot4X;
        invSlot8Y = invSlot5Y;
        
        invSlot9X = invSlot1X;
        invSlot9Y = invSlot5Y + 105;
        invSlot10X = invSlot2X;
        invSlot10Y = invSlot9Y;
        invSlot11X = invSlot3X;
        invSlot11Y = invSlot9Y;
        invSlot12X = invSlot4X;
        invSlot12Y = invSlot9Y;
        
        invSlot13X = invSlot1X;
        invSlot13Y = invSlot9Y + 105;
        invSlot14X = invSlot2X;
        invSlot14Y = invSlot13Y;
        invSlot15X = invSlot3X;
        invSlot15Y = invSlot13Y;
        invSlot16X = invSlot4X;
        invSlot16Y = invSlot13Y;
        
        textSlot1X = invSlot1X + (slotItemWidth / 2);
        textSlot1Y = invSlot1Y + 90;
        textSlot2X = textSlot1X + 105;
        textSlot2Y = textSlot1Y;
        textSlot3X = textSlot2X + 105;
        textSlot3Y = textSlot1Y;
        textSlot4X = textSlot3X + 105;
        textSlot4Y = textSlot1Y;
        
        textSlot5X = textSlot1X;
        textSlot5Y = textSlot1Y + 105;
        textSlot6X = textSlot2X;
        textSlot6Y = textSlot5Y;
        textSlot7X = textSlot3X;
        textSlot7Y = textSlot5Y;
        textSlot8X = textSlot4X;
        textSlot8Y = textSlot5Y;
        
        textSlot9X = textSlot1X;
        textSlot9Y = textSlot5Y + 105;
        textSlot10X = textSlot2X;
        textSlot10Y = textSlot9Y;
        textSlot11X = textSlot3X;
        textSlot11Y = textSlot9Y;
        textSlot12X = textSlot4X;
        textSlot12Y = textSlot9Y;
        
        textSlot13X = textSlot1X;
        textSlot13Y = textSlot9Y + 105;
        textSlot14X = textSlot2X;
        textSlot14Y = textSlot13Y;
        textSlot15X = textSlot3X;
        textSlot15Y = textSlot13Y;
        textSlot16X = textSlot4X;
        textSlot16Y = textSlot13Y;
        
        craftTextSlot1X = textSlot4X + 132;
        craftTextSlot1Y = textSlot1Y;
        craftTextSlot2X = craftTextSlot1X + 154;
        craftTextSlot2Y = craftTextSlot1Y;
        craftTextSlot3X = craftTextSlot1X;
        craftTextSlot3Y = craftTextSlot1Y + 105;
        craftTextSlot4X = craftTextSlot2X;
        craftTextSlot4Y = craftTextSlot3Y;
        craftTextSlot5X = craftTextSlot3X + 78;
        craftTextSlot5Y = craftTextSlot3Y + 107;
        
        craftSlot1X = invSlot4X + 132;
        craftSlot1Y = invSlot1Y;
        craftSlot2X = craftSlot1X + 154;
        craftSlot2Y = craftSlot1Y;
        craftSlot3X = craftSlot1X;
        craftSlot3Y = craftSlot1Y + 105;
        craftSlot4X = craftSlot2X;
        craftSlot4Y = craftSlot3Y;
        craftSlot5X = craftSlot3X + 78;
        craftSlot5Y = craftSlot3Y + 107;
        
        emptyButtonX = craftSlot5X + 48;
        emptyButtonY = craftSlot5Y + 117;
        emptyButtonWidth = 99;
        emptyButtonHeight = 21;
        
        pageButtonY = invY + 479;
        pageUpX = invX + 282;
        pageDownX = invX + 196;
        pageButtonWidth = 35;
        pageButtonHeight = 27;
        
        pageTextX = invX + 257;
        pageTextY = invY + 492;
        
        
        handler = handle;
        inventoryItems = new ArrayList<Item>();
        craftingItems = new ArrayList<LargeCraftItem>();
        addCraftItems();
    }

    public void tick()
    {
    	if(handler.getWorld().getEntityManager().getPlayer().getInventory().isActive()) {
    		this.active = false;
    	}
        if(active && handler.getKeyManager().keyJustPressed(27) || handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT) && active) {
        	if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_LEFT)) {
        		handler.getWorld().getEntityManager().getPlayer().getInventory().setActive(true);
        	}
        	if(!active) {
        		for(Item i : inventoryItems) {
        			i.setSlot(i.getStartSlot());
        		}
        	}
            active = !active;
        }
        if(!active)
            return;
        int mouseX = handler.getMouseManager().getMouseX();
        int mouseY = handler.getMouseManager().getMouseY();
        inventoryItems = handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems();
        
        if(!locationLoaded) {
            reloadLocation();
            locationLoaded = true;
        }
        
        for(Item i : inventoryItems) {
        	if(i.getCount() <= 0) {
        		i.setCount(1);
        	}
        }
        
        hasItem = false;
        
        if(inventoryItems.size() > 16) {
        	maxPages = 2;
        }else {
        	maxPages = 1;
        }
        
        if(handler.getMouseManager().isRightPressed())
        {
        	if(inventoryItems.size() <= 0)
                return;
        	if(mouseX >= invSlot1X && mouseX <= invSlot1X + slotItemWidth) {
        		if(mouseY >= invSlot1Y && mouseY <= invSlot1Y + slotItemHeight) {
        			if(selectedPage == 1) {
            			selectedSlot = 0;
        			}else if(selectedPage == 2) {
        				selectedSlot = 16;
        			}
        		}
        	}else if(mouseX >= invSlot2X && mouseX <= invSlot2X + slotItemWidth) {
        		if(mouseY >= invSlot2Y && mouseY <= invSlot2Y + slotItemHeight) {
        			if(selectedPage == 1) {
            			selectedSlot = 1;
        			}else if(selectedPage == 2) {
        				selectedSlot = 17;
        			}
        		}
        	}else if(mouseX >= invSlot3X && mouseX <= invSlot3X + slotItemWidth) {
        		if(mouseY >= invSlot3Y && mouseY <= invSlot3Y + slotItemHeight) {
        			if(selectedPage == 1) {
            			selectedSlot = 2;
        			}else if(selectedPage == 2) {
        				selectedSlot = 18;
        			}
        		}
        	}else if(mouseX >= invSlot4X && mouseX <= invSlot4X + slotItemWidth) {
        		if(mouseY >= invSlot4Y && mouseY <= invSlot4Y + slotItemHeight) {
        			if(selectedPage == 1) {
            			selectedSlot = 3;
        			}else if(selectedPage == 2) {
        				selectedSlot = 19;
        			}
        		}
        	}
        }
        
        if(handler.getMouseManager().isRightPressed())
        {
        	if(inventoryItems.size() <= 0)
                return;
        	else if(mouseX >= invSlot5X && mouseX <= invSlot5X + slotItemWidth) {
        		if(mouseY >= invSlot5Y && mouseY <= invSlot5Y + slotItemHeight) {
        			if(selectedPage == 1) {
            			selectedSlot = 4;
        			}else if(selectedPage == 2) {
        				selectedSlot = 20;
        			}
        		}
        	}else if(mouseX >= invSlot6X && mouseX <= invSlot6X + slotItemWidth) {
        		if(mouseY >= invSlot6Y && mouseY <= invSlot6Y + slotItemHeight) {
        			if(selectedPage == 1) {
            			selectedSlot = 5;
        			}else if(selectedPage == 2) {
        				selectedSlot = 21;
        			}
        		}
        	}else if(mouseX >= invSlot7X && mouseX <= invSlot7X + slotItemWidth) {
        		if(mouseY >= invSlot7Y && mouseY <= invSlot7Y + slotItemHeight) {
        			if(selectedPage == 1) {
            			selectedSlot = 6;
        			}else if(selectedPage == 2) {
        				selectedSlot = 22;
        			}
        		}
        	}else if(mouseX >= invSlot8X && mouseX <= invSlot8X + slotItemWidth) {
        		if(mouseY >= invSlot8Y && mouseY <= invSlot8Y + slotItemHeight) {
        			if(selectedPage == 1) {
            			selectedSlot = 7;
        			}else if(selectedPage == 2) {
        				selectedSlot = 23;
        			}
        		}
        	}
        }
        
        if(handler.getMouseManager().isRightPressed())
        {
        	if(inventoryItems.size() <= 0)
                return;
        	else if(mouseX >= invSlot9X && mouseX <= invSlot9X + slotItemWidth) {
        		if(mouseY >= invSlot9Y && mouseY <= invSlot9Y + slotItemHeight) {
        			if(selectedPage == 1) {
            			selectedSlot = 8;
        			}else if(selectedPage == 2) {
        				selectedSlot = 24;
        			}
        		}
        	}else if(mouseX >= invSlot10X && mouseX <= invSlot10X + slotItemWidth) {
        		if(mouseY >= invSlot10Y && mouseY <= invSlot10Y + slotItemHeight) {
        			if(selectedPage == 1) {
            			selectedSlot = 9;
        			}else if(selectedPage == 2) {
        				selectedSlot = 25;
        			}
        		}
        	}else if(mouseX >= invSlot11X && mouseX <= invSlot11X + slotItemWidth) {
        		if(mouseY >= invSlot11Y && mouseY <= invSlot11Y + slotItemHeight) {
        			if(selectedPage == 1) {
            			selectedSlot = 10;
        			}else if(selectedPage == 2) {
        				selectedSlot = 26;
        			}
        		}
        	}else if(mouseX >= invSlot12X && mouseX <= invSlot12X + slotItemWidth) {
        		if(mouseY >= invSlot12Y && mouseY <= invSlot12Y + slotItemHeight) {
        			if(selectedPage == 1) {
            			selectedSlot = 11;
        			}else if(selectedPage == 2) {
        				selectedSlot = 27;
        			}
        		}
        	}
        }
        	
        if(handler.getMouseManager().isRightPressed())
        {
        	if(inventoryItems.size() <= 0)
                return;
        	else if(mouseX >= invSlot13X && mouseX <= invSlot13X + slotItemWidth) {
        		if(mouseY >= invSlot13Y && mouseY <= invSlot13Y + slotItemHeight) {
        			if(selectedPage == 1) {
            			selectedSlot = 12;
        			}else if(selectedPage == 2) {
        				selectedSlot = 28;
        			}
        		}
        	}else if(mouseX >= invSlot14X && mouseX <= invSlot14X + slotItemWidth) {
        		if(mouseY >= invSlot14Y && mouseY <= invSlot14Y + slotItemHeight) {
        			if(selectedPage == 1) {
            			selectedSlot = 13;
        			}else if(selectedPage == 2) {
        				selectedSlot = 29;
        			}
        		}
        	}else if(mouseX >= invSlot15X && mouseX <= invSlot15X + slotItemWidth) {
        		if(mouseY >= invSlot15Y && mouseY <= invSlot15Y + slotItemHeight) {
        			if(selectedPage == 1) {
            			selectedSlot = 14;
        			}else if(selectedPage == 2) {
        				selectedSlot = 30;
        			}
        		}
        	}else if(mouseX >= invSlot16X && mouseX <= invSlot16X + slotItemWidth) {
        		if(mouseY >= invSlot16Y && mouseY <= invSlot16Y + slotItemHeight) {
        			if(selectedPage == 1) {
            			selectedSlot = 15;
        			}else if(selectedPage == 2) {
        				selectedSlot = 31;
        			}
        		}
        	}   
        }
        
       if(handler.getMouseManager().isRightPressed()) {
    	   if(inventoryItems.size() <= 0)
    		   return;
    	   if(mouseX >= craftSlot3X && mouseX <= craftSlot3X + slotItemWidth) {
    		   if(mouseY >= craftSlot3Y && mouseY <= craftSlot3Y + slotItemHeight) {
    			   selectedSlot = 34;
    		   }
    	   }else if(mouseX >= craftSlot4X && mouseX <= craftSlot4X + slotItemWidth) {
    		   if(mouseY >= craftSlot4Y && mouseY <= craftSlot4Y + slotItemHeight) {
    			   selectedSlot = 35;
    		   }
    	   }
       	}
        
        if(handler.getMouseManager().isRightPressed())
        {
        	if(inventoryItems.size() <= 0)
                return;
        	else if(mouseX >= craftSlot1X && mouseX <= craftSlot1X + slotItemWidth) {
        		if(mouseY >= craftSlot1Y && mouseY <= craftSlot1Y + slotItemHeight) {
        			selectedSlot = 32;
        		}
        	}else if(mouseX >= craftSlot2X && mouseX <= craftSlot2X + slotItemWidth) {
        		if(mouseY >= craftSlot2Y && mouseY <= craftSlot2Y + slotItemHeight) {
        			selectedSlot = 33;
        		}
        	}else if(mouseX >= craftSlot5X && mouseX <= (craftSlot5X + slotItemWidth)) {
            	if(mouseY >= craftSlot5Y && mouseY <= (craftSlot5Y + slotItemHeight)) {
            		if(ingredient1 != null && ingredient2 != null && ingredient3 != null && ingredient4 != null) {
            			if(currentCraftItem != null && currentCraftItem.isTool())
                        {
                            if(ingredient1 == currentTool)
                            {
                                if(!checkIfContains(currentItem.getId()))
                                {
                                	for(int ii = 0; ii < count; ii++) {
                                		if(ingredient1 == null || ingredient2 == null || ingredient3 == null || ingredient4 == null) {
                                			currentCraftItem = null;
                                			currentItem = null;
                                			currentTool = null;
                                			full = false;
                                			reset = true;
                                			break;
                                		}
                                		for(Item i : inventoryItems) {
                                			if(i == currentItem) {
                                				removeItem2(ingredient2, 1);
                                				removeItem3(ingredient3, 1);
                                				removeItem4(ingredient4, 1);
                                        		addItem(currentItem, amt);
                                        		hasItem = true;
                                        		break;
                                			}
                                		}
                                		if(!hasItem) {
                            				removeItem2(ingredient2, 1);
                            				removeItem3(ingredient3, 1);
                            				removeItem4(ingredient4, 1);
                                    		addItem(currentItem, amt);
                                    		for(Item i : inventoryItems) {
                                    			if(i == currentItem) {
                                    				i.setSlot(37);
                                    				i.setStartSlot(setStartSlot());
                                    				selectedSlot = 36;
                                    			}
                                    		}
                                		}
                                	}
                                    full = false;
                                	currentCraftItem = null;
                        			currentItem = null;
                        			currentTool = null;
                                } else
                                if(checkIfContains(currentItem.getId()))
                                    System.out.println((new StringBuilder("Already have a(n) ")).append(currentCraftItem.getName()).toString());
                            }else if(ingredient2 == currentTool)
                            {
                                if(!checkIfContains(currentItem.getId()))
                                {
                                	for(int ii = 0; ii < count; ii++) {
                                		if(ingredient1 == null || ingredient2 == null || ingredient3 == null || ingredient4 == null) {
                                			currentCraftItem = null;
                                			currentItem = null;
                                			currentTool = null;
                                			full = false;
                                			reset = true;
                                			break;
                                		}
                                		for(Item i : inventoryItems) {
                                			if(i == currentItem) {
                                				removeItem2(ingredient1, 1);
                                				removeItem3(ingredient3, 1);
                                				removeItem4(ingredient4, 1);
                                        		addItem(currentItem, amt);
                                        		hasItem = true;
                                        		break;
                                			}
                                		}
                                		if(!hasItem) {
                            				removeItem2(ingredient1, 1);
                            				removeItem3(ingredient3, 1);
                            				removeItem4(ingredient4, 1);
                                    		addItem(currentItem, amt);
                                    		for(Item i : inventoryItems) {
                                    			if(i == currentItem) {
                                    				i.setSlot(37);
                                    				i.setStartSlot(setStartSlot());
                                    				selectedSlot = 36;
                                    			}
                                    		}
                                		}
                                	}
                                    full = false;
                                	currentCraftItem = null;
                        			currentItem = null;
                        			currentTool = null;
                                } else
                                if(checkIfContains(currentItem.getId()))
                                    System.out.println((new StringBuilder("Already have a(n) ")).append(currentCraftItem.getName()).toString());
                            }else if(ingredient3 == currentTool)
                            {
                                if(!checkIfContains(currentItem.getId()))
                                {
                                	for(int ii = 0; ii < count; ii++) {
                                		if(ingredient1 == null || ingredient2 == null || ingredient3 == null || ingredient4 == null) {
                                			currentCraftItem = null;
                                			currentItem = null;
                                			currentTool = null;
                                			full = false;
                                			reset = true;
                                			break;
                                		}
                                		for(Item i : inventoryItems) {
                                			if(i == currentItem) {
                                				removeItem2(ingredient1, 1);
                                				removeItem3(ingredient2, 1);
                                				removeItem4(ingredient4, 1);
                                        		addItem(currentItem, amt);
                                        		hasItem = true;
                                        		break;
                                			}
                                		}
                                		if(!hasItem) {
                            				removeItem2(ingredient1, 1);
                            				removeItem3(ingredient2, 1);
                            				removeItem4(ingredient4, 1);
                                    		addItem(currentItem, amt);
                                    		for(Item i : inventoryItems) {
                                    			if(i == currentItem) {
                                    				i.setSlot(37);
                                    				i.setStartSlot(setStartSlot());
                                    				selectedSlot = 36;
                                    			}
                                    		}
                                		}
                                	}
                                    full = false;
                                	currentCraftItem = null;
                        			currentItem = null;
                        			currentTool = null;
                                } else
                                if(checkIfContains(currentItem.getId()))
                                    System.out.println((new StringBuilder("Already have a(n) ")).append(currentCraftItem.getName()).toString());
                            }else  if(ingredient4 == currentTool)
                            {
                                if(!checkIfContains(currentItem.getId()))
                                {
                                	for(int ii = 0; ii < count; ii++) {
                                		if(ingredient1 == null || ingredient2 == null || ingredient3 == null || ingredient4 == null) {
                                			currentCraftItem = null;
                                			currentItem = null;
                                			currentTool = null;
                                			full = false;
                                			reset = true;
                                			break;
                                		}
                                		for(Item i : inventoryItems) {
                                			if(i == currentItem) {
                                				removeItem2(ingredient1, 1);
                                				removeItem3(ingredient2, 1);
                                				removeItem4(ingredient3, 1);
                                        		addItem(currentItem, amt);
                                        		hasItem = true;
                                        		break;
                                			}
                                		}
                                		if(!hasItem) {
                            				removeItem2(ingredient1, 1);
                            				removeItem3(ingredient2, 1);
                            				removeItem4(ingredient3, 1);
                                    		addItem(currentItem, amt);
                                    		for(Item i : inventoryItems) {
                                    			if(i == currentItem) {
                                    				i.setSlot(37);
                                    				i.setStartSlot(setStartSlot());
                                    				selectedSlot = 36;
                                    			}
                                    		}
                                		}
                                	}
                                    full = false;
                                	currentCraftItem = null;
                        			currentItem = null;
                        			currentTool = null;
                                } else
                                if(checkIfContains(currentItem.getId()))
                                    System.out.println((new StringBuilder("Already have a(n) ")).append(currentCraftItem.getName()).toString());
                            }else if(!checkIfContains(currentItem.getId()))
                            {
                            	for(int ii = 0; ii < count; ii++) {
                            		if(ingredient1 == null || ingredient2 == null || ingredient3 == null | ingredient4 == null) {
                            			currentCraftItem = null;
                            			currentItem = null;
                            			currentTool = null;
                            			full = false;
                            			reset = true;
                            			break;
                            		}
                            		for(Item i : inventoryItems) {
                            			if(i == currentItem) {
                                    		removeItems(ingredient1, ingredient2, ingredient3, ingredient4, 1, 1, 1, 1);
                                            addItem(currentItem, amt);
                                    		hasItem = true;
                                    		break;
                            			}
                            		}
                            		if(!hasItem) {
                                		removeItems(ingredient1, ingredient2, ingredient3, ingredient4, 1, 1, 1, 1);
                                        addItem(currentItem, amt);
                                		for(Item i : inventoryItems) {
                                			if(i == currentItem) {
                                				i.setSlot(37);
                                				i.setStartSlot(setStartSlot());
                                				selectedSlot = 36;
                                			}
                                		}
                            		}
                            	}
                                
                                full = false;
                            	currentCraftItem = null;
                    			currentItem = null;
                    			currentTool = null;
                				
                            } else
                            if(checkIfContains(currentItem.getId()))
                                System.out.println((new StringBuilder("Already have a(n) ")).append(currentCraftItem.getName()).toString());
                        } else
                        if(currentCraftItem != null && !currentCraftItem.isTool())
                            if(ingredient1 == currentTool){
                            	for(int ii = 0; ii < count; ii++) {
                                	if(ingredient1 == null || ingredient2 == null || ingredient3 == null || ingredient4 == null) {
                                		currentCraftItem = null;
                               			currentItem = null;
                               			currentTool = null;
                               			full = false;
                               			reset = true;
                               			break;
                               		}
                               		for(Item i : inventoryItems) {
                               			if(i == currentItem) {
                               				removeItem2(ingredient2, 1);
                               				removeItem3(ingredient3, 1);
                               				removeItem4(ingredient4, 1);
                                       		addItem(currentItem, amt);
                                       		hasItem = true;
                                       		break;
                               			}
                               		}
                               		if(!hasItem) {
                           				removeItem2(ingredient2, 1);
                           				removeItem3(ingredient3, 1);
                           				removeItem4(ingredient4, 1);
                                   		addItem(currentItem, amt);
                                   		for(Item i : inventoryItems) {
                                   			if(i == currentItem) {
                                   				i.setSlot(37);
                                   				i.setStartSlot(setStartSlot());
                                   				selectedSlot = 36;
                                   			}
                                   		}
                               		}
                               	}
                                full = false;
                                currentCraftItem = null;
                        		currentItem = null;
                        		currentTool = null;
                				
                            	try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
                            }else if(ingredient2 == currentTool){
                            	for(int ii = 0; ii < count; ii++) {
                                	if(ingredient1 == null || ingredient2 == null || ingredient3 == null || ingredient4 == null) {
                                		currentCraftItem = null;
                               			currentItem = null;
                               			currentTool = null;
                               			full = false;
                               			reset = true;
                               			break;
                               		}
                               		for(Item i : inventoryItems) {
                               			if(i == currentItem) {
                               				removeItem2(ingredient1, 1);
                               				removeItem3(ingredient3, 1);
                               				removeItem4(ingredient4, 1);
                                       		addItem(currentItem, amt);
                                       		hasItem = true;
                                       		break;
                               			}
                               		}
                               		if(!hasItem) {
                           				removeItem2(ingredient1, 1);
                           				removeItem3(ingredient3, 1);
                           				removeItem4(ingredient4, 1);
                                   		addItem(currentItem, amt);
                                   		for(Item i : inventoryItems) {
                                   			if(i == currentItem) {
                                   				i.setSlot(37);
                                   				i.setStartSlot(setStartSlot());
                                   				selectedSlot = 36;
                                   			}
                                   		}
                               		}
                               	}
                                full = false;
                                currentCraftItem = null;
                        		currentItem = null;
                        		currentTool = null;
                				
                            	try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
                            }else if(ingredient3 == currentTool){
                            	for(int ii = 0; ii < count; ii++) {
                                	if(ingredient1 == null || ingredient2 == null || ingredient3 == null || ingredient4 == null) {
                                		currentCraftItem = null;
                               			currentItem = null;
                               			currentTool = null;
                               			full = false;
                               			reset = true;
                               			break;
                               		}
                               		for(Item i : inventoryItems) {
                               			if(i == currentItem) {
                               				removeItem2(ingredient1, 1);
                               				removeItem3(ingredient2, 1);
                               				removeItem4(ingredient4, 1);
                                       		addItem(currentItem, amt);
                                       		hasItem = true;
                                       		break;
                               			}
                               		}
                               		if(!hasItem) {
                           				removeItem2(ingredient1, 1);
                           				removeItem3(ingredient2, 1);
                           				removeItem4(ingredient4, 1);
                                   		addItem(currentItem, amt);
                                   		for(Item i : inventoryItems) {
                                   			if(i == currentItem) {
                                   				i.setSlot(37);
                                   				i.setStartSlot(setStartSlot());
                                   				selectedSlot = 36;
                                   			}
                                   		}
                               		}
                               	}
                                full = false;
                                currentCraftItem = null;
                        		currentItem = null;
                        		currentTool = null;
                				
                            	try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
                            }else if(ingredient4 == currentTool){
                            	for(int ii = 0; ii < count; ii++) {
                                	if(ingredient1 == null || ingredient2 == null || ingredient3 == null || ingredient4 == null) {
                                		currentCraftItem = null;
                               			currentItem = null;
                               			currentTool = null;
                               			full = false;
                               			reset = true;
                               			break;
                               		}
                               		for(Item i : inventoryItems) {
                               			if(i == currentItem) {
                               				removeItem2(ingredient1, 1);
                               				removeItem3(ingredient2, 1);
                               				removeItem4(ingredient3, 1);
                                       		addItem(currentItem, amt);
                                       		hasItem = true;
                                       		break;
                               			}
                               		}
                               		if(!hasItem) {
                           				removeItem2(ingredient1, 1);
                           				removeItem3(ingredient2, 1);
                           				removeItem4(ingredient3, 1);
                                   		addItem(currentItem, amt);
                                   		for(Item i : inventoryItems) {
                                   			if(i == currentItem) {
                                   				i.setSlot(37);
                                   				i.setStartSlot(setStartSlot());
                                   				selectedSlot = 36;
                                   			}
                                   		}
                               		}
                               	}
                                full = false;
                                currentCraftItem = null;
                        		currentItem = null;
                        		currentTool = null;
                				
                            	try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
                            }else{
                                for(int ii = 0; ii < count; ii++) {
                            		if(ingredient1 == null || ingredient2 == null || ingredient3 == null || ingredient4 == null) {
                            			currentCraftItem = null;
                            			currentItem = null;
                            			currentTool = null;
                            			full = false;
                            			reset = true;
                            			break;
                            		}
                            		for(Item i : inventoryItems) {
                            			if(i == currentItem) {
                            				removeItems(ingredient1, ingredient2, ingredient3, ingredient4, 1, 1, 1, 1);
                                            addItem(currentItem, amt);
                                    		hasItem = true;
                                    		break;
                            			}
                            		}
                            		if(!hasItem) {
                        				removeItems(ingredient1, ingredient2, ingredient3, ingredient4, 1, 1, 1, 1);
                                        addItem(currentItem, amt);
                                		for(Item i : inventoryItems) {
                                			if(i == currentItem) {
                                				i.setSlot(37);
                                				i.setStartSlot(setStartSlot());
                                				selectedSlot = 36;
                                			}
                                		}
                            		}
                            		
                            	}
                        		full = false;
                            	currentCraftItem = null;
                    			currentItem = null;
                    			currentTool = null;
                				
                            	
                                try {
									Thread.sleep(100);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
                            }
                	}
            	}	
            } 
        }
        
        if(handler.getMouseManager().isLeftPressed()) {
        	if(!full) {
        		if(mouseX >= invSlot1X && mouseX <= (invSlot1X + slotItemWidth)) {
                	if(mouseY >= invSlot1Y && mouseY <= (invSlot1Y + slotItemHeight)) {
                		if(selectedPage == 1) {
                    		selectedItem = 0;
                		}else if(selectedPage == 2) {
                    		selectedItem = 16;
                		}
            			moveOnClick();
            			selectedSlot = -1;
                		selectedItem = -1;
                	}
                }else if(mouseX >= invSlot2X && mouseX <= (invSlot2X + slotItemWidth)) {
                	if(mouseY >= invSlot2Y && mouseY <= (invSlot2Y + slotItemHeight)) {
                		if(selectedPage == 1) {
                    		selectedItem = 1;
                		}else if(selectedPage == 2) {
                    		selectedItem = 17;
                		}
            			moveOnClick();
            			selectedSlot = -1;
                		selectedItem = -1;
                	}
                }else if(mouseX >= invSlot3X && mouseX <= (invSlot3X + slotItemWidth)) {
                	if(mouseY >= invSlot3Y && mouseY <= (invSlot3Y + slotItemHeight)) {
                		if(selectedPage == 1) {
                    		selectedItem = 2;
                		}else if(selectedPage == 2) {
                    		selectedItem = 18;
                		}
            			moveOnClick();
            			selectedSlot = -1;
                		selectedItem = -1;
                	}
                }else if(mouseX >= invSlot4X && mouseX <= (invSlot4X + slotItemWidth)) {
                	if(mouseY >= invSlot4Y && mouseY <= (invSlot4Y + slotItemHeight)) {
                		if(selectedPage == 1) {
                    		selectedItem = 3;
                		}else if(selectedPage == 2) {
                    		selectedItem = 19;
                		}
            			moveOnClick();
            			selectedSlot = -1;
                		selectedItem = -1;
                	}
                }
        	}
        	
        }
        if(handler.getMouseManager().isLeftPressed()) {
        	if(!full) {
        		if(mouseX >= invSlot5X && mouseX <= (invSlot5X + slotItemWidth)) {
                	if(mouseY >= invSlot5Y && mouseY <= (invSlot5Y + slotItemHeight)) {
                		if(selectedPage == 1) {
                    		selectedItem = 4;
                		}else if(selectedPage == 2) {
                    		selectedItem = 20;
                		}
            			moveOnClick();
            			selectedSlot = -1;
                		selectedItem = -1;
                	}
                }else if(mouseX >= invSlot6X && mouseX <= (invSlot6X + slotItemWidth)) {
                	if(mouseY >= invSlot6Y && mouseY <= (invSlot6Y + slotItemHeight)) {
                		if(selectedPage == 1) {
                    		selectedItem = 5;
                		}else if(selectedPage == 2) {
                    		selectedItem = 21;
                		}
            			moveOnClick();
            			selectedSlot = -1;
                		selectedItem = -1;
                	}
                }else if(mouseX >= invSlot7X && mouseX <= (invSlot7X + slotItemWidth)) {
                	if(mouseY >= invSlot7Y && mouseY <= (invSlot7Y + slotItemHeight)) {
                		if(selectedPage == 1) {
                    		selectedItem = 6;
                		}else if(selectedPage == 2) {
                    		selectedItem = 22;
                		}
            			moveOnClick();
            			selectedSlot = -1;
                		selectedItem = -1;
                	}
                }else if(mouseX >= invSlot8X && mouseX <= (invSlot8X + slotItemWidth)) {
                	if(mouseY >= invSlot8Y && mouseY <= (invSlot8Y + slotItemHeight)) {
                		if(selectedPage == 1) {
                    		selectedItem = 7;
                		}else if(selectedPage == 2) {
                    		selectedItem = 23;
                		}
            			moveOnClick();
            			selectedSlot = -1;
                		selectedItem = -1;
                	}
                }
        	}
        }
        if(handler.getMouseManager().isLeftPressed()) {
        	if(!full) {
        		if(mouseX >= invSlot9X && mouseX <= (invSlot9X + slotItemWidth)) {
                	if(mouseY >= invSlot9Y && mouseY <= (invSlot9Y + slotItemHeight)) {
                		if(selectedPage == 1) {
                    		selectedItem = 8;
                		}else if(selectedPage == 2) {
                    		selectedItem = 24;
                		}
            			moveOnClick();
            			selectedSlot = -1;
                		selectedItem = -1;
                	}
                }else if(mouseX >= invSlot10X && mouseX <= (invSlot10X + slotItemWidth)) {
                	if(mouseY >= invSlot10Y && mouseY <= (invSlot10Y + slotItemHeight)) {
                		if(selectedPage == 1) {
                    		selectedItem = 9;
                		}else if(selectedPage == 2) {
                    		selectedItem = 25;
                		}
            			moveOnClick();
            			selectedSlot = -1;
                		selectedItem = -1;
                	}
                }else if(mouseX >= invSlot11X && mouseX <= (invSlot11X + slotItemWidth)) {
                	if(mouseY >= invSlot11Y && mouseY <= (invSlot11Y + slotItemHeight)) {
                		if(selectedPage == 1) {
                    		selectedItem = 10;
                		}else if(selectedPage == 2) {
                    		selectedItem = 26;
                		}
            			moveOnClick();
            			selectedSlot = -1;
                		selectedItem = -1;
                	}
                }else if(mouseX >= invSlot12X && mouseX <= (invSlot12X + slotItemWidth)) {
                	if(mouseY >= invSlot12Y && mouseY <= (invSlot12Y + slotItemHeight)) {
                		if(selectedPage == 1) {
                    		selectedItem = 11;
                		}else if(selectedPage == 2) {
                    		selectedItem = 27;
                		}
            			moveOnClick();
            			selectedSlot = -1;
                		selectedItem = -1;
                	}
                }
        	}
        	
        }
        if(handler.getMouseManager().isLeftPressed()) {
        	if(!full) {
        		if(mouseX >= invSlot13X && mouseX <= (invSlot13X + slotItemWidth)) {
                	if(mouseY >= invSlot13Y && mouseY <= (invSlot13Y + slotItemHeight)) {
                		if(selectedPage == 1) {
                    		selectedItem = 12;
                		}else if(selectedPage == 2) {
                    		selectedItem = 28;
                		}
            			moveOnClick();
            			selectedSlot = -1;
                		selectedItem = -1;
                	}
                }else if(mouseX >= invSlot14X && mouseX <= (invSlot14X + slotItemWidth)) {
                	if(mouseY >= invSlot14Y && mouseY <= (invSlot14Y + slotItemHeight)) {
                		if(selectedPage == 1) {
                    		selectedItem = 13;
                		}else if(selectedPage == 2) {
                    		selectedItem = 29;
                		}
            			moveOnClick();
            			selectedSlot = -1;
                		selectedItem = -1;
                	}
                }else if(mouseX >= invSlot15X && mouseX <= (invSlot15X + slotItemWidth)) {
                	if(mouseY >= invSlot15Y && mouseY <= (invSlot15Y + slotItemHeight)) {
                		if(selectedPage == 1) {
                    		selectedItem = 14;
                		}else if(selectedPage == 2) {
                    		selectedItem = 30;
                		}
            			moveOnClick();
            			selectedSlot = -1;
                		selectedItem = -1;
                	}
                }else if(mouseX >= invSlot16X && mouseX <= (invSlot16X + slotItemWidth)) {
                	if(mouseY >= invSlot16Y && mouseY <= (invSlot16Y + slotItemHeight)) {
                		if(selectedPage == 1) {
                    		selectedItem = 15;
                		}else if(selectedPage == 2) {
                    		selectedItem = 31;
                		}
            			moveOnClick();
            			selectedSlot = -1;
                		selectedItem = -1;
                	}
                }
        	}
        }
        
        if(handler.getMouseManager().isLeftPressed()) {
        	if(mouseX >= craftSlot1X && mouseX <= (craftSlot1X + slotItemWidth)) {
            	if(mouseY >= craftSlot1Y && mouseY <= (craftSlot1Y + slotItemHeight)) {
            		selectedItem = 32;
        			moveOnClick();
        			selectedSlot = -1;
            		selectedItem = -1;
            	}
            }else if(mouseX >= craftSlot2X && mouseX <= (craftSlot2X + slotItemWidth)) {
            	if(mouseY >= craftSlot2Y && mouseY <= (craftSlot2Y + slotItemHeight)) {
            		selectedItem = 33;
        			moveOnClick();
        			selectedSlot = -1;
            		selectedItem = -1;
            	}
            }
        }
        
        if(handler.getMouseManager().isLeftPressed()) {
        	if(mouseX >= craftSlot3X && mouseX <= (craftSlot3X + slotItemWidth)) {
            	if(mouseY >= craftSlot3Y && mouseY <= (craftSlot3Y + slotItemHeight)) {
            		selectedItem = 34;
        			moveOnClick();
        			selectedSlot = -1;
            		selectedItem = -1;
            	}
            }else if(mouseX >= craftSlot4X && mouseX <= (craftSlot4X + slotItemWidth)) {
            	if(mouseY >= craftSlot4Y && mouseY <= (craftSlot4Y + slotItemHeight)) {
            		selectedItem = 35;
        			moveOnClick();
        			selectedSlot = -1;
            		selectedItem = -1;
            	}
            }else if(mouseX >= craftSlot5X && mouseX <= (craftSlot5X + slotItemWidth)) {
            	if(mouseY >= craftSlot5Y && mouseY <= (craftSlot5Y + slotItemHeight)) {
            		if(selectedSlot != 36) {
            			return;
            		}
            		selectedItem = 36;
        			moveOnClick();
        			selectedSlot = -1;
            		selectedItem = -1;
            	}
            }
        }
        
        if(handler.getMouseManager().isLeftPressed()) {
        	if(mouseX >= emptyButtonX - (emptyButtonWidth/2) && mouseX <= (emptyButtonX + (emptyButtonWidth/2))) {
                if(mouseY >= emptyButtonY - (emptyButtonHeight/2) && mouseY <= (emptyButtonY + (emptyButtonHeight/2))) {
               		for(Item i : inventoryItems) {
               			if(i.getSlot() == 33 || i.getSlot() == 34 || i.getSlot() == 35 || i.getSlot() == 36) {
               				for(Item ii : inventoryItems) {
               					if(ii.getSlot() == i.getStartSlot()) {
               						i.setSlot(i.getStartSlot() + 1);
               						i.setStartSlot(i.getSlot());
               						break;
               					}
               				}
               				i.setSlot(i.getStartSlot());
               			}
               		}
               	}
            }
        }
        
        if(handler.getMouseManager().isLeftPressed()) {
        	if(mouseY >= pageButtonY && mouseY <= pageButtonY + pageButtonHeight) {
            	if(mouseX >= pageUpX && mouseX <= pageUpX + pageButtonWidth) {
            		selectedPage++;
            		if(selectedPage > maxPages) {
            			selectedPage = maxPages;
            		}
            	}
            	if(mouseX >= pageDownX && mouseX <= pageDownX + pageButtonWidth) {
            		selectedPage--;
            		if(selectedPage < minPages) {
            			selectedPage = minPages;
            		}
            	}
            }
        }
        
        for(Item i : inventoryItems) {
        	Item i1 = null;
        	Item i2 = null;
        	Item i3 = null;
        	Item i4 = null;
        	if(i.getSlot() == 33) {
        		i1 = i;
        	}else if(i.getSlot() == 34) {
        		i2 = i;
        	}else if(i.getSlot() == 35) {
        		i3 = i;
        	}else if(i.getSlot() == 36) {
        		i4 = i;
        	}
        	ingredient1 = i1;
        	ingredient2 = i2;
        	ingredient3 = i3;
        	ingredient4 = i4;
        	for(Item ii : inventoryItems) {
        		if(i != ii) {
        			if(i.getSlot() == ii.getSlot()) {
        				i.setSlot(i.getSlot()+1);
        				i.setStartSlot(i.getSlot());
        			}
        		}
        	}
        }
    }
        
    public int setStartSlot() {
    	int toReturn = 0;
    	for(int i = 0; i<inventoryItems.size(); i++) {
    		if(inventoryItems.get(i).getStartSlot() == i + 1) {
    			continue;
    		}else {
    			toReturn = i+1;
    			break;
    		}
    	}
    	return toReturn;
    }
    
    public void moveOnClick() {
    	for(Item i : inventoryItems) {
        	if(i.getSlot() - 1 == selectedSlot) {
        		selected = i;
        	}
        }
        
        if(selected != null) {
        	if(selectedItem != selected.getSlot() - 1) {
        		for(Item i : inventoryItems) {
        			if(selectedItem == i.getSlot() - 1) {
        				toMoveTo = i;
        			}
        		}
        		if(selectedSlot == 32 && (selectedItem != 32 || selectedItem != 33 || selectedItem != 34 || selectedItem != 35)) {
        			ingredient1 = null;
        			currentCraftItem = null;
        			currentItem = null;
        			currentTool = null;
        		}else if(selectedSlot == 33 && (selectedItem != 32 || selectedItem != 33 || selectedItem != 34 || selectedItem != 35)) {
        			ingredient2 = null;
        			currentCraftItem = null;
        			currentItem = null;
        			currentTool = null;
        		}else if(selectedSlot == 34 && (selectedItem != 32 || selectedItem != 33 || selectedItem != 34 || selectedItem != 35)) {
        			ingredient3 = null;
        			currentCraftItem = null;
        			currentItem = null;
        			currentTool = null;
        		}else if(selectedSlot == 35 && (selectedItem != 32 || selectedItem != 33 || selectedItem != 34 || selectedItem != 35)) {
        			ingredient4 = null;
        			currentCraftItem = null;
        			currentItem = null;
        			currentTool = null;
        		}
        		if(toMoveTo == null) {
        			if(selectedItem != -1) {
        				selected.setSlot(selectedItem + 1);
            			selectedSlot = -1;
                		selectedItem = -1;
                		selected = null;
                		toMoveTo = null;
                		return;
        			}
        		}
        		if(selectedItem != -1) {
        			toMoveTo.setStartSlot(selected.getSlot());
        			selected.setStartSlot(toMoveTo.getSlot());
            		toMoveTo.setSlot(selected.getSlot());
            		selected.setSlot(selectedItem + 1);
            		selectedSlot = -1;
            		selectedItem = -1;
            		selected = null;
            		toMoveTo = null;
        			
        		}
        	}
        }
    }
   
    public void reloadLocation() {
    	for(int i = 0; i < inventoryItems.size(); i++) {
        	Item item = inventoryItems.get(i);
        	item.setSlot(i+1);
			item.setStartSlot(i+1);
        }
    }
    
    public void reloadLocation(Item item) {
    	for(int i = 0; i<inventoryItems.size(); i++) {
    		if(inventoryItems.get(i) == item) {
    			item.setStartSlot(i+1);
    		}
    	}
    }
    
    public void addCraftItems() {
    	craftingItems.add(LargeCraftItem.pistol);
    	craftingItems.add(LargeCraftItem.pistolBullet);
    	craftingItems.add(LargeCraftItem.SMG);
    	craftingItems.add(LargeCraftItem.smgBullet);
    }
    
    public void render(Graphics g)
    {
        if(!active)
            return;
        if(reset) {
        	for(Item i : inventoryItems) {
    			i.setSlot(i.getStartSlot());
    		}
        	reset = false;
        }
        g.drawImage(Assets.weaponScreen, invX, invY, invWidth, invHeight, null);
        Text.drawString(g, "Inventory", invX + invWidth / 2, invY + invHeight / 25, true, Color.WHITE, Assets.font40);
        int len = inventoryItems.size();
        
        if(len != 0) {
        	for(Item item:inventoryItems) {
        		if(selectedPage == 1) {
        			if(item.getSlot() == 1) {
                		g.drawImage(item.getTexture(), invSlot1X, invSlot1Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot1X, textSlot1Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 2) {
                		g.drawImage(item.getTexture(), invSlot2X, invSlot2Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot2X, textSlot2Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 3) {
                		g.drawImage(item.getTexture(), invSlot3X, invSlot3Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot3X, textSlot3Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 4) {
                		g.drawImage(item.getTexture(), invSlot4X, invSlot4Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot4X, textSlot4Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 5) {
                		g.drawImage(item.getTexture(), invSlot5X, invSlot5Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot5X, textSlot5Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 6) {
                		g.drawImage(item.getTexture(), invSlot6X, invSlot6Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot6X, textSlot6Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 7) {
                		g.drawImage(item.getTexture(), invSlot7X, invSlot7Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot7X, textSlot7Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 8) {
                		g.drawImage(item.getTexture(), invSlot8X, invSlot8Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot8X, textSlot8Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 9) {
                		g.drawImage(item.getTexture(), invSlot9X, invSlot9Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot9X, textSlot9Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 10) {
                		g.drawImage(item.getTexture(), invSlot10X, invSlot10Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot10X, textSlot10Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 11) {
                		g.drawImage(item.getTexture(), invSlot11X, invSlot11Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot11X, textSlot11Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 12) {
                		g.drawImage(item.getTexture(), invSlot12X, invSlot12Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot12X, textSlot12Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 13) {
                		g.drawImage(item.getTexture(), invSlot13X, invSlot13Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot13X, textSlot13Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 14) {
                		g.drawImage(item.getTexture(), invSlot14X, invSlot14Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot14X, textSlot14Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 15) {
                		g.drawImage(item.getTexture(), invSlot15X, invSlot15Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot15X, textSlot15Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 16) {
                		g.drawImage(item.getTexture(), invSlot16X, invSlot16Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot16X, textSlot16Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 33) {
                		ingredient1 = item;
                		g.drawImage(item.getTexture(), craftSlot1X, craftSlot1Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), craftTextSlot1X, craftTextSlot1Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 34) {
                		ingredient2 = item;
                		g.drawImage(item.getTexture(), craftSlot2X, craftSlot2Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), craftTextSlot2X, craftTextSlot2Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 35) {
                		ingredient3 = item;
                		g.drawImage(item.getTexture(), craftSlot3X, craftSlot3Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), craftTextSlot3X, craftTextSlot3Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 36) {
                		ingredient4 = item;
                		g.drawImage(item.getTexture(), craftSlot4X, craftSlot4Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), craftTextSlot4X, craftTextSlot4Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 37) {
                		g.drawImage(item.getTexture(), craftSlot5X, craftSlot5Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), craftTextSlot5X, craftTextSlot5Y - 2, true, Color.WHITE, Assets.font32);
                	}
        		}else if(selectedPage == 2) {
        			if(item.getSlot() == 17) {
                		g.drawImage(item.getTexture(), invSlot1X, invSlot1Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot1X, textSlot1Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 18) {
                		g.drawImage(item.getTexture(), invSlot2X, invSlot2Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot2X, textSlot2Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 19) {
                		g.drawImage(item.getTexture(), invSlot3X, invSlot3Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot3X, textSlot3Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 20) {
                		g.drawImage(item.getTexture(), invSlot4X, invSlot4Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot4X, textSlot4Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 21) {
                		g.drawImage(item.getTexture(), invSlot5X, invSlot5Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot5X, textSlot5Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 22) {
                		g.drawImage(item.getTexture(), invSlot6X, invSlot6Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot6X, textSlot6Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 23) {
                		g.drawImage(item.getTexture(), invSlot7X, invSlot7Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot7X, textSlot7Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 24) {
                		g.drawImage(item.getTexture(), invSlot8X, invSlot8Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot8X, textSlot8Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 25) {
                		g.drawImage(item.getTexture(), invSlot9X, invSlot9Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot9X, textSlot9Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 26) {
                		g.drawImage(item.getTexture(), invSlot10X, invSlot10Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot10X, textSlot10Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 27) {
                		g.drawImage(item.getTexture(), invSlot11X, invSlot11Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot11X, textSlot11Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 28) {
                		g.drawImage(item.getTexture(), invSlot12X, invSlot12Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot12X, textSlot12Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 29) {
                		g.drawImage(item.getTexture(), invSlot13X, invSlot13Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot13X, textSlot13Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 30) {
                		g.drawImage(item.getTexture(), invSlot14X, invSlot14Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot14X, textSlot14Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 31) {
                		g.drawImage(item.getTexture(), invSlot15X, invSlot15Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot15X, textSlot15Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 32) {
                		g.drawImage(item.getTexture(), invSlot16X, invSlot16Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), textSlot16X, textSlot16Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 33) {
                		ingredient1 = item;
                		g.drawImage(item.getTexture(), craftSlot1X, craftSlot1Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), craftTextSlot1X, craftTextSlot1Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 34) {
                		ingredient2 = item;
                		g.drawImage(item.getTexture(), craftSlot2X, craftSlot2Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), craftTextSlot2X, craftTextSlot2Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 35) {
                		ingredient3 = item;
                		g.drawImage(item.getTexture(), craftSlot3X, craftSlot3Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), craftTextSlot3X, craftTextSlot3Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 36) {
                		ingredient4 = item;
                		g.drawImage(item.getTexture(), craftSlot4X, craftSlot4Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), craftTextSlot4X, craftTextSlot4Y - 2, true, Color.WHITE, Assets.font32);
                	}else if(item.getSlot() == 37) {
                		g.drawImage(item.getTexture(), craftSlot5X, craftSlot5Y, slotItemWidth, slotItemHeight, null);
                		Text.drawString(g, Integer.toString(item.getCount()), craftTextSlot5X, craftTextSlot5Y - 2, true, Color.WHITE, Assets.font32);
                	}
        		}
            }
        }
        
        if(selectedPage == 1) {
        	 if(selectedItem == 0) {
         		g.drawImage(Assets.outline, invSlot1X - 1, invSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 1) {
         		g.drawImage(Assets.outline, invSlot2X - 1, invSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 2) {
         		g.drawImage(Assets.outline, invSlot3X - 1, invSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 3) {
         		g.drawImage(Assets.outline, invSlot4X - 1, invSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 4) {
         		g.drawImage(Assets.outline, invSlot1X - 1, invSlot5Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 5) {
         		g.drawImage(Assets.outline, invSlot2X - 1, invSlot5Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 6) {
         		g.drawImage(Assets.outline, invSlot3X - 1, invSlot5Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 7) {
         		g.drawImage(Assets.outline, invSlot4X - 1, invSlot5Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 8) {
         		g.drawImage(Assets.outline, invSlot1X - 1, invSlot9Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 9) {
         		g.drawImage(Assets.outline, invSlot2X - 1, invSlot9Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 10) {
         		g.drawImage(Assets.outline, invSlot3X - 1, invSlot9Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 11) {
         		g.drawImage(Assets.outline, invSlot4X - 1, invSlot9Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 12) {
         		g.drawImage(Assets.outline, invSlot1X - 1, invSlot13Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 13) {
         		g.drawImage(Assets.outline, invSlot2X - 1, invSlot13Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 14) {
         		g.drawImage(Assets.outline, invSlot3X - 1, invSlot13Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 15) {
         		g.drawImage(Assets.outline, invSlot4X - 1, invSlot13Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 32) {
         		g.drawImage(Assets.outline, craftSlot1X - 1, craftSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 33) {
         		g.drawImage(Assets.outline, craftSlot2X - 1, craftSlot2Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 34) {
         		g.drawImage(Assets.outline, craftSlot3X - 1, craftSlot3Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 35) {
         		g.drawImage(Assets.outline, craftSlot4X - 1, craftSlot4Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 36) {
         		g.drawImage(Assets.outline, craftSlot5X - 1, craftSlot5Y, outlineWidth, outlineHeight, null);
         	}
         	
         	if(selectedSlot == 0) {
         		g.drawImage(Assets.redOutline, invSlot1X - 1, invSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 1) {
         		g.drawImage(Assets.redOutline, invSlot2X - 1, invSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 2) {
         		g.drawImage(Assets.redOutline, invSlot3X - 1, invSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 3) {
         		g.drawImage(Assets.redOutline, invSlot4X - 1, invSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 4) {
         		g.drawImage(Assets.redOutline, invSlot1X - 1, invSlot5Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 5) {
         		g.drawImage(Assets.redOutline, invSlot2X - 1, invSlot5Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 6) {
         		g.drawImage(Assets.redOutline, invSlot3X - 1, invSlot5Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 7) {
         		g.drawImage(Assets.redOutline, invSlot4X - 1, invSlot5Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 8) {
         		g.drawImage(Assets.redOutline, invSlot1X - 1, invSlot9Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 9) {
         		g.drawImage(Assets.redOutline, invSlot2X - 1, invSlot9Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 10) {
         		g.drawImage(Assets.redOutline, invSlot3X - 1, invSlot9Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 11) {
         		g.drawImage(Assets.redOutline, invSlot4X - 1, invSlot9Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 12) {
         		g.drawImage(Assets.redOutline, invSlot1X - 1, invSlot13Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 13) {
         		g.drawImage(Assets.redOutline, invSlot2X - 1, invSlot13Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 14) {
         		g.drawImage(Assets.redOutline, invSlot3X - 1, invSlot13Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 15) {
         		g.drawImage(Assets.redOutline, invSlot4X - 1, invSlot13Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 32) {
         		g.drawImage(Assets.redOutline, craftSlot1X - 1, craftSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 33) {
         		g.drawImage(Assets.redOutline, craftSlot2X - 1, craftSlot2Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 34) {
         		g.drawImage(Assets.redOutline, craftSlot3X - 1, craftSlot3Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 35) {
         		g.drawImage(Assets.redOutline, craftSlot4X - 1, craftSlot4Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 36) {
         		g.drawImage(Assets.redOutline, craftSlot5X - 1, craftSlot5Y, outlineWidth, outlineHeight, null);
         	}
        }else if(selectedPage == 2) {
        	 if(selectedItem == 16) {
         		g.drawImage(Assets.outline, invSlot1X - 1, invSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 17) {
         		g.drawImage(Assets.outline, invSlot2X - 1, invSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 18) {
         		g.drawImage(Assets.outline, invSlot3X - 1, invSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 19) {
         		g.drawImage(Assets.outline, invSlot4X - 1, invSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 20) {
         		g.drawImage(Assets.outline, invSlot1X - 1, invSlot5Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 21) {
         		g.drawImage(Assets.outline, invSlot2X - 1, invSlot5Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 22) {
         		g.drawImage(Assets.outline, invSlot3X - 1, invSlot5Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 23) {
         		g.drawImage(Assets.outline, invSlot4X - 1, invSlot5Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 24) {
         		g.drawImage(Assets.outline, invSlot1X - 1, invSlot9Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 25) {
         		g.drawImage(Assets.outline, invSlot2X - 1, invSlot9Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 26) {
         		g.drawImage(Assets.outline, invSlot3X - 1, invSlot9Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 27) {
         		g.drawImage(Assets.outline, invSlot4X - 1, invSlot9Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 28) {
         		g.drawImage(Assets.outline, invSlot1X - 1, invSlot13Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 29) {
         		g.drawImage(Assets.outline, invSlot2X - 1, invSlot13Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 30) {
         		g.drawImage(Assets.outline, invSlot3X - 1, invSlot13Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 31) {
         		g.drawImage(Assets.outline, invSlot4X - 1, invSlot13Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 32) {
         		g.drawImage(Assets.outline, craftSlot1X - 1, craftSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 33) {
         		g.drawImage(Assets.outline, craftSlot2X - 1, craftSlot2Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 34) {
         		g.drawImage(Assets.outline, craftSlot3X - 1, craftSlot3Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 35) {
         		g.drawImage(Assets.outline, craftSlot4X - 1, craftSlot4Y, outlineWidth, outlineHeight, null);
         	}else if(selectedItem == 36) {
         		g.drawImage(Assets.outline, craftSlot5X - 1, craftSlot5Y, outlineWidth, outlineHeight, null);
         	}
         	
         	if(selectedSlot == 16) {
         		g.drawImage(Assets.redOutline, invSlot1X - 1, invSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 17) {
         		g.drawImage(Assets.redOutline, invSlot2X - 1, invSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 18) {
         		g.drawImage(Assets.redOutline, invSlot3X - 1, invSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 19) {
         		g.drawImage(Assets.redOutline, invSlot4X - 1, invSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 20) {
         		g.drawImage(Assets.redOutline, invSlot1X - 1, invSlot5Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 21) {
         		g.drawImage(Assets.redOutline, invSlot2X - 1, invSlot5Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 22) {
         		g.drawImage(Assets.redOutline, invSlot3X - 1, invSlot5Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 23) {
         		g.drawImage(Assets.redOutline, invSlot4X - 1, invSlot5Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 24) {
         		g.drawImage(Assets.redOutline, invSlot1X - 1, invSlot9Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 25) {
         		g.drawImage(Assets.redOutline, invSlot2X - 1, invSlot9Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 26) {
         		g.drawImage(Assets.redOutline, invSlot3X - 1, invSlot9Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 27) {
         		g.drawImage(Assets.redOutline, invSlot4X - 1, invSlot9Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 28) {
         		g.drawImage(Assets.redOutline, invSlot1X - 1, invSlot13Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 29) {
         		g.drawImage(Assets.redOutline, invSlot2X - 1, invSlot13Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 30) {
         		g.drawImage(Assets.redOutline, invSlot3X - 1, invSlot13Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 31) {
         		g.drawImage(Assets.redOutline, invSlot4X - 1, invSlot13Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 32) {
         		g.drawImage(Assets.redOutline, craftSlot1X - 1, craftSlot1Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 33) {
         		g.drawImage(Assets.redOutline, craftSlot2X - 1, craftSlot2Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 34) {
         		g.drawImage(Assets.redOutline, craftSlot3X - 1, craftSlot3Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 35) {
         		g.drawImage(Assets.redOutline, craftSlot4X - 1, craftSlot4Y, outlineWidth, outlineHeight, null);
         	}else if(selectedSlot == 36) {
         		g.drawImage(Assets.redOutline, craftSlot5X - 1, craftSlot5Y, outlineWidth, outlineHeight, null);
         	}
        }
       
    	
    	if(currentCraftItem == null) {
    		setCraftItem();
    	}else if(currentCraftItem != null) {
    		if(ingredient1 != null && ingredient2 != null && ingredient3 != null && ingredient4 != null) {
    			g.drawImage(currentCraftItem.getTexture(), craftSlot5X, craftSlot5Y, slotItemWidth, slotItemHeight, null);
    		}
    	}
    	
    	Text.drawString(g, "Empty" , emptyButtonX, emptyButtonY, true, Color.WHITE, Assets.font20);
    	
    	Text.drawString(g, Integer.toString(selectedPage), pageTextX, pageTextY, true, Color.WHITE, Assets.font28);
        
    }
    
    public void craft() {
    	
    }
    
    public void setCraftItem() {
    	if(ingredient1 != null && ingredient2 != null && ingredient3 != null && ingredient4 != null) {
    		for(LargeCraftItem craftItem : craftingItems) {
    			if(craftItem.getI1id() == ingredient1.getId()) {
    				if(craftItem.getI2id() == ingredient2.getId()) {
        				if(craftItem.getI3id() == ingredient3.getId()) {
            				if(craftItem.getI4id() == ingredient4.getId()) {
        						currentCraftItem = craftItem;
            					if(craftItem.getId() == 0) {
            						currentItem = Item.pistolItem;
            						currentTool = Item.steelHammer;
            						this.amt = 1;
            					}else if(craftItem.getId() == 1) {
            						currentItem = Item.pistolBulletItem;
            						currentTool = Item.steelAxeItem;
            						this.amt = 10;
            					}else if(craftItem.getId() == 2) {
            						currentItem = Item.smg;
            						currentTool = null;
            						this.amt = 1;
            					}else if(craftItem.getId() == 3) {
            						currentItem = Item.smgBullet;
            						currentTool = Item.steelAxeItem;
            						this.amt = 3;
            					}
            				}
        				}
    				}else {
    					continue;
    				}
    			}else {
    				continue;
    			}
    		}
    	}
	} 

    public static void addItem(Item item, int amt)
    {
    	item.setCount(amt);
        for(Item i:inventoryItems)
        {
            if(i.getId() == item.getId())
            {
                i.setCount(i.getCount() + amt);
                if(i.getCount() <= 0) {
                    i.setCount(1);
                }
                return;
            }
        }
        inventoryItems.add(item);
    }

    public static void loadItem(Item item, int amt)
    {
        for(Item i:inventoryItems)
        {
            if(i.getId() == item.getId())
            {
                i.setCount(amt);
                if(i.getCount() <= 0)
                    i.setCount(1);
                return;
            }
        }

        inventoryItems.add(item);
    }
    
    public static void addItem(int id, int amt)
    {
        for(Iterator<Item> iterator = Item.getItems().iterator(); iterator.hasNext();)
        {
            Item i = (Item)iterator.next();
            if(i.getId() == id)
                inventoryItems.add(i);
        }

    }

    public static void removeItem(Item item, int amt)
    {
        for(Item i : inventoryItems) {
        	if(i.getId() == item.getId()) {
        		i.setCount(i.getCount() - amt);
        		if(i.getCount() <= 0) {
        			inventoryItems.remove(i);
        			ingredient1 = null;
        		}
        		break;
        	}else {
        		continue;
        	}
        }

    }
    
    public static void removeItem2(Item item, int amt)
    {
        for(Item i : inventoryItems) {
        	if(i.getId() == item.getId()) {
        		i.setCount(i.getCount() - amt);
        		if(i.getCount() <= 0) {
        			inventoryItems.remove(i);
        			ingredient2 = null;
        		}
        		break;
        	}else {
        		continue;
        	}
        }

    }
    public static void removeItem3(Item item, int amt)
    {
        for(Item i : inventoryItems) {
        	if(i.getId() == item.getId()) {
        		i.setCount(i.getCount() - amt);
        		if(i.getCount() <= 0) {
        			inventoryItems.remove(i);
        			ingredient3 = null;
        		}
        		break;
        	}else {
        		continue;
        	}
        }

    }
    public static void removeItem4(Item item, int amt)
    {
        for(Item i : inventoryItems) {
        	if(i.getId() == item.getId()) {
        		i.setCount(i.getCount() - amt);
        		if(i.getCount() <= 0) {
        			inventoryItems.remove(i);
        			ingredient4 = null;
        		}
        		break;
        	}else {
        		continue;
        	}
        }

    }

    public static void removeItems(Item item, Item item2, Item item3, Item item4, int amt1, int amt2, int amt3, int amt4)
    {
    	for(Item i : inventoryItems) {
        	if(i.getId() == item.getId()) {
        		i.setCount(i.getCount() - amt1);
        		if(i.getCount() <= 0) {
        			inventoryItems.remove(i);
        			ingredient1 = null;
        		}
        		break;
        	}else {
        		continue;
        	}
        }

    	for(Item ii : inventoryItems) {
        	if(ii.getId() == item2.getId()) {
        		ii.setCount(ii.getCount() - amt2);
        		if(ii.getCount() <= 0) {
        			inventoryItems.remove(ii);
        			ingredient2 = null;
        		}
        		break;
        	}else {
        		continue;
        	}
        }
    	for(Item i2 : inventoryItems) {
        	if(i2.getId() == item3.getId()) {
        		i2.setCount(i2.getCount() - amt3);
        		if(i2.getCount() <= 0) {
        			inventoryItems.remove(i2);
        			ingredient3 = null;
        		}
        		break;
        	}else {
        		continue;
        	}
        }

    	for(Item ii2 : inventoryItems) {
        	if(ii2.getId() == item4.getId()) {
        		ii2.setCount(ii2.getCount() - amt4);
        		if(ii2.getCount() <= 0) {
        			inventoryItems.remove(ii2);
        			ingredient4 = null;
        		}
        		break;
        	}else {
        		continue;
        	}
        }

    }

    public boolean checkIfContains(int id)
    {
        hasItem1 = false;
        for(Iterator<Item> iterator = inventoryItems.iterator(); iterator.hasNext(); hasItem1 = false)
        {
            Item i = (Item)iterator.next();
            if(i.getId() != id)
                continue;
            hasItem1 = true;
            break;
        }

        return hasItem1;
    }

    public static boolean checkIfContains(int id, int id2, int id3, int id4)
    {
        hasItem1 = false;
        hasItem2 = false;
        hasItem3 = false;
        hasItem4 = false;
        hasAll = false;
        for(Iterator<Item> iterator = inventoryItems.iterator(); iterator.hasNext(); hasItem1 = false)
        {
            Item i = (Item)iterator.next();
            if(i.getId() != id)
                continue;
            hasItem1 = true;
            break;
        }

        for(Iterator<Item> iterator1 = inventoryItems.iterator(); iterator1.hasNext(); hasItem2 = false)
        {
            Item i = (Item)iterator1.next();
            if(i.getId() != id2)
                continue;
            hasItem2 = true;
            break;
        }
        for(Iterator<Item> iterator = inventoryItems.iterator(); iterator.hasNext(); hasItem3 = false)
        {
            Item i = (Item)iterator.next();
            if(i.getId() != id3)
                continue;
            hasItem3 = true;
            break;
        }

        for(Iterator<Item> iterator1 = inventoryItems.iterator(); iterator1.hasNext(); hasItem4 = false)
        {
            Item i = (Item)iterator1.next();
            if(i.getId() != id4)
                continue;
            hasItem4 = true;
            break;
        }

        if(hasItem1 && hasItem2 && hasItem3 && hasItem4)
            hasAll = true;
        return hasAll;
    }

    public Handler getHandler()
    {
        return handler;
    }

    public void setHandler(Handler handle)
    {
        handler = handle;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean activ)
    {
        active = activ;
    }

    public ArrayList<Item> getInventoryItems()
    {
        return inventoryItems;
    }

	public int getcraftSlot5X() {
		return craftSlot5X;
	}

	public int getcraftSlot5Y() {
		return craftSlot5Y;
	}

	public int getSlotItemWidth() {
		return slotItemWidth;
	}

	public int getSlotItemHeight() {
		return slotItemHeight;
	}

	public int getInvSlot1X() {
		return invSlot1X;
	}

	public int getInvSlot1Y() {
		return invSlot1Y;
	}

	public int getInvSlot2X() {
		return invSlot2X;
	}

	public int getInvSlot2Y() {
		return invSlot2Y;
	}

	public int getInvSlot3X() {
		return invSlot3X;
	}

	public int getInvSlot3Y() {
		return invSlot3Y;
	}

	public int getInvSlot4X() {
		return invSlot4X;
	}

	public int getInvSlot4Y() {
		return invSlot4Y;
	}

	public int getInvSlot5X() {
		return invSlot5X;
	}

	public int getInvSlot5Y() {
		return invSlot5Y;
	}

    

}
