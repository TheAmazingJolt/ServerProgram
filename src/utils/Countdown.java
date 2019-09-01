package utils;

public class Countdown {

    private long lastTimer;
    private long cooldown;
    private long timer;
    
    private boolean completed = false;
    private boolean notCompleted = false;
    
    public Countdown(long l) {
    	cooldown = l;
    	timer = cooldown;
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

	public boolean isCompleted() {
		return completed;
	}
	
}
