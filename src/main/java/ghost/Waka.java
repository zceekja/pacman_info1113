package ghost;
import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import processing.core.PImage;
import processing.core.PApplet;
/**
* Represent Waka in Waka game.
* <p>Instance have a target location, number, frameCount , status,amount of berry.
*/
public class Waka extends MoveableObject{

	protected boolean alive = true;
	protected int livesLeft;
	protected int initialLives;
	protected int berryLeft = 0;
	Direction next = Direction.UNDEFINE;
	protected long frameCount =1;
	protected boolean waka_close = false;
    Direction save = Direction.UNDEFINE;

    /**
    * Waka contructor
    * <p>Set player liveLeft.
    *<br>Set player initial life.
    *<br>Set player sprite.
    */
	public Waka( Game game) {
		super(game.game_map.getPlayerIStartLocation(), game.game_map.getPlayerJStartLocation(), game);
		livesLeft = (int)game.lives;
		initialLives = livesLeft;
		sprite = game.playerLeft;

	}
    /**
    * Handle waka sprite logic
    * <p> Every 8 frame alternate waka sprite between close and open.
    *<br> If game is pause waka sprite is open-mouth.
    *<br> Otherwise set waka sprite according to Direction.
    */
	public void tick(){

    	if (frameCount%8 ==0){
    		waka_close = !waka_close;    
    	}	
    	if (game.countdown >0){
    		sprite = game.playerLeft;
    	}

    	else if(game.isPause ){

    		if (save == Direction.RIGHT){
        		sprite = game.playerRight; 
        	}
        	else if (save == Direction.LEFT){
        		sprite = game.playerLeft;
        	} 
        	else if (save == Direction.UP){
        		sprite = game.playerUp;
        	}
        	else if (save == Direction.DOWN){
        		sprite = game.playerDown;
        	}
    	}

       	else if (waka_close){
        		sprite = game.playerClosed;
    	}
    	else if (current == Direction.RIGHT){
        		sprite = game.playerRight;
        }
        else if (current == Direction.LEFT){
        		sprite = game.playerLeft;
        } 
        else if (current == Direction.UP){
        		sprite = game.playerUp;
        }
        else if (current == Direction.DOWN){
        		sprite = game.playerDown;
        }

        frameCount++;
	}
    /**
    * Reset  player location
    * <p>Set player location to initial location.
    */
	public void resetLocation(){
		this.i_coordinate = start_i;
		this.j_coordinate = start_j;
		current = Direction.LEFT;
	}
    /**
    * Collect berry 
    * <p>Increase amount of berry by 1
    */
	public void collectBerry(){
		this.berryLeft +=1;
	}
    /**
    * Set player next Direction.
    */
	public void setDirectionNext(Direction directionNext){
    	next = directionNext;
    }
    /**
    * Reset amount of player life.
    * <p>Set livesLeft to initialLives.
    */
    public void resetLives(){
    	this.livesLeft = initialLives;
    }
    /**
    * Reset amount of berry.
    * <p>Set berryLeft to 0
    */
    public void resetBerry(){
    	this.berryLeft =0;
    }
    /**
    * Use the berry.
    * <p>Reduce amount of berry by 1
    */
    public void useBerry(){
    	this.berryLeft -= 1;
    }
}


