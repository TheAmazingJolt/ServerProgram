package utils;

import java.awt.Color;
import java.awt.Graphics;

import gfx.Assets;
import gfx.Text;
import main.Handler;

public class Countdown {

    private long lastTimer;
    private long cooldown;
    private long timer;
    
    private boolean completed = false;
    private boolean notCompleted = false;
    
    private String text;
    
    private Handler handler;
    
    public Countdown(long l, String text, Handler handler) {
    	cooldown = l;
    	timer = cooldown;
    	this.text = text;
    	this.handler = handler;
    }
    
    public void tick() {
        timer += System.currentTimeMillis() - lastTimer;
        lastTimer = System.currentTimeMillis();
        if(timer < cooldown) {
        	notCompleted = true;
            return;
        }
        timer = 0;
        if(notCompleted) {
        	completed = true;
        }
    }
    
    public void render(Graphics g) {
    	Text.drawString(g, "Time until " + text + ":", handler.getWidth()/2, 28, true, Color.WHITE, Assets.font28);
    	Text.drawString(g, (cooldown - timer) / 1000 + " seconds", handler.getWidth()/2, 56, true, Color.WHITE, Assets.font28);
    }

	public boolean isCompleted() {
		return completed;
	}
	
}
