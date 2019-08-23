package utils;

import com.sun.glass.events.KeyEvent;

import input.KeyManager;

public class KeyFinder
{
	KeyManager km; 
	String one;
	String two;
	String three;
	String finished;
	
    public String findKey() {
    	
    	while(finished == null) {
    		if(km.keyJustPressed(KeyEvent.VK_BACKSPACE)) {
        		one = "";
        		two = "";
        		three = "";
        	}else if(km.keyJustPressed(KeyEvent.VK_0)) {
        		if(one == null) {
        			one = "0";
        		}else if(one != null && two == null) {
        			two = "0";
        		}else if(one != null && two != null && three == null) {
        			three = "0";
        		}
        	}else if(km.keyJustPressed(KeyEvent.VK_1)) {
        		if(one == null) {
        			one = "1";
        		}else if(one != null && two == null) {
        			two = "1";
        		}else if(one != null && two != null && three == null) {
        			three = "1";
        		}
        	}else if(km.keyJustPressed(KeyEvent.VK_2)) {
        		if(one == null) {
        			one = "2";
        		}else if(one != null && two == null) {
        			two = "2";
        		}else if(one != null && two != null && three == null) {
        			three = "2";
        		}
        	}else if(km.keyJustPressed(KeyEvent.VK_3)) {
        		if(one == null) {
        			one = "3";
        		}else if(one != null && two == null) {
        			two = "3";
        		}else if(one != null && two != null && three == null) {
        			three = "3";
        		}
        	}else if(km.keyJustPressed(KeyEvent.VK_4)) {
        		if(one == null) {
        			one = "4";
        		}else if(one != null && two == null) {
        			two = "4";
        		}else if(one != null && two != null && three == null) {
        			three = "4";
        		}
        	}else if(km.keyJustPressed(KeyEvent.VK_5)) {
        		if(one == null) {
        			one = "5";
        		}else if(one != null && two == null) {
        			two = "5";
        		}else if(one != null && two != null && three == null) {
        			three = "5";
        		}
        	}else if(km.keyJustPressed(KeyEvent.VK_6)) {
        		if(one == null) {
        			one = "6";
        		}else if(one != null && two == null) {
        			two = "6";
        		}else if(one != null && two != null && three == null) {
        			three = "6";
        		}
        	}else if(km.keyJustPressed(KeyEvent.VK_7)) {
        		if(one == null) {
        			one = "7";
        		}else if(one != null && two == null) {
        			two = "7";
        		}else if(one != null && two != null && three == null) {
        			three = "7";
        		}
        	}else if(km.keyJustPressed(KeyEvent.VK_8)) {
        		if(one == null) {
        			one = "8";
        		}else if(one != null && two == null) {
        			two = "8";
        		}else if(one != null && two != null && three == null) {
        			three = "8";
        		}
        	}else if(km.keyJustPressed(KeyEvent.VK_9)) {
        		if(one == null) {
        			one = "9";
        		}else if(one != null && two == null) {
        			two = "9";
        		}else if(one != null && two != null && three == null) {
        			three = "9";
        		}
        	}else if(one != null && two != null && three != null) {
        		finished = one + two + three;
        	}
    	}
    	return finished;
    }
}