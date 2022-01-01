package ghost;
import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import processing.core.PImage;
import processing.core.PApplet;
import java.lang.Math;
import java.util.Random; 
/**
* Represent Ghost in Waka game.
* <p>Instance have a target location, number, image, status, mode and debugline coordinate.
*/
public class Ghost extends MoveableObject {


    Direction next = Direction.UNDEFINE;
    private int ghostNumber = 0;
    protected int target_corner_i =0;
    protected int target_corner_j =0;
    protected int target_location_i = 0;
    protected int target_location_j = 0;
    protected Waka target1;
    protected GhostMode mode = GhostMode.SCATTER;
    protected GhostMode saveMode = GhostMode.UNDEFINE;
    protected int stun_duration = 0;
    protected Direction save = Direction.UNDEFINE;
    protected PImage ghost;
    protected PImage sprite;
    protected boolean isAlive = true;
    protected int frightened_duration= 0;
    protected int [] debugLineCoordinate = new int[4];


    /**
    * Constructor for Ghost,
    * <p>set ghost number
    * <br>set target
    * <br>set ghost image
    * <br>set ghost sprite
    * @param game  reference of game
    * @param ghost  ghost image
	* @param target1 reference of waka
	* @param ghostNumber number of ghost
    */
	public Ghost( Game game, PImage ghost ,Waka target1, int ghostNumber){
		super(game.game_map.getGhostIStartLocation(ghostNumber),game.game_map.getGhostJStartLocation(ghostNumber), game);
		this.ghostNumber = ghostNumber;
		this.target1 = target1;
		this.ghost = ghost;
		sprite = ghost;
	}

    /**
    * Reset ghost location to starting locaiton,
    * <p>set i coordinate to initial coordinate
    * <br> set j coordinate to initail coordinate
    * <br> set current Direction to LEFT
    */
	public void resetLocation(){
		i_coordinate = start_i;
		j_coordinate = start_j;
		current = Direction.LEFT;
	}
    /**
    * Move the ghost location
    * <p> if current Direction is LEFT, moveLeft()
    * <br> else if current Direction is RIGHT, moveRIGHT()
    * <br> else if current Direction is UP, moveUP()
    * <br> else if current Direction is DOWN, moveDOWN()
    */
	public void move(){
		if (current == Direction.LEFT){
			this.moveLeft();
		}
		else if (current == Direction.RIGHT){
			this.moveRight();
		}
		else if (current == Direction.UP){
			this.moveUp();
		}
		else if (current == Direction.DOWN){
			this.moveDown();
		}
	}
    /**
    * Move the ghost and set Direction to opposite Direction
    * <p> if current Direction is LEFT, moveLeft() and set Direction to RIGHT
    * <br> else if current Direction is RIGHT, moveRIGHT() and set Direction to LEFT
    * <br> else if current Direction is UP, moveUP() and set Direction to DOWN
    * <br> else if current Direction is DOWN, moveDOWN() and set Direction to UP
    */
	public void vibrate(){
		if (current== Direction.LEFT){
			this.moveLeft();
			current = Direction.RIGHT;
		}
		else if (current== Direction.RIGHT){
			this.moveRight();
			current = Direction.LEFT;

		}
		else if (current== Direction.UP){
			this.moveUp();
			current = Direction.DOWN;

		}
		else if (current== Direction.DOWN){
			this.moveDown();
			current = Direction.UP;

		}
	}
    /**
    * Set new Direction for ghost depend on target location.
    *<p> 1. Calculate the difference in row and column between ghost and target location.
    *<br> 2. Compare whether difference in row or column which one is greater.
    *<br> 3. Check whether which Direction is moveable (not collide with wall)
    *<br> 4. Set new ghost Direction.
    *@param target_i i coordinate of target location.
    *@param target_j j coordinate of target locaiton.
    */
	public void ghostUseBrain(int target_i, int target_j){
		// if i diff positive mean player is on the left
		// if i diff negative mean player is on the right
		int i_diff = this.i_coordinate - target_i;
		// if j diff positive mean player is on the top
		// if j diff negative mean player is on the bottom
		int j_diff = this.j_coordinate - target_j;
		int i_diff_abs = Math.abs(i_diff);
		int j_diff_abs = Math.abs(j_diff);
		//ghost moving left
		if (current == Direction.LEFT) {
			//if horizontal more impact
			if (i_diff_abs >j_diff_abs){
				// if player is on the left
				if (i_diff > 0){
					// if go left availaible
					if (checkLeft()){
						current = Direction.LEFT;
					}
					// if player on the top
					else if (j_diff >0)
						if (checkUp()){
							current =  Direction.UP;
						}
						else {
							current = Direction.DOWN;
						}
					else {
						if (checkDown()){
							current = Direction.DOWN;
						}
						else {
							current = Direction.UP;
						}
					}
				}
				// player on the right
				else {
					//if player on the top
					if (j_diff > 0) {
						if (checkUp()){
							current = Direction.UP;
						}
						else {
							current = Direction.DOWN;
						}
					}
					else {
						if (checkDown()){
							current =  Direction.DOWN;
						}
						else {
							current = Direction.UP;
						}
					}
				}
			}
			// if vertical more impact
			else {
				//if player on the top
				if (j_diff > 0) {
					// if moving up available
					if (checkUp()){
						current = Direction.UP;
					}

					else {
						//if left available
						if (checkLeft()){
							current = Direction.LEFT;
						}
						else {
							current = Direction.DOWN;
						}
					}
				}
				// if player on the bottom
				else {
					// if bottom availabe
					if (checkDown()){
						current = Direction.DOWN;
					}
					else {
						//if left available
						if (checkLeft()){
							current = Direction.LEFT;
						}
						else {
							current = Direction.UP;
						}
					}
				}
			}
		}
		//ghost moving right
		else if (current ==  Direction.RIGHT) {

			if (i_diff_abs >j_diff_abs){
				// if player is on the right
				if (i_diff < 0){
					// if go right availaible
					if (checkRight()){
						current = Direction.RIGHT;
					}
					// if player on the top
					else if (j_diff >0) {
						if (checkUp()){
							current =  Direction.UP;
						}
						else {
							current = Direction.DOWN;
						}
					}
					else {
						if (checkDown()){
							current =  Direction.DOWN;
						}
						else {
							current =  Direction.UP;
						}
					}
				}
				// player on the left
				else  {
					//if player on the top
					if (j_diff > 0) {
						if (checkUp()){
							current = Direction.UP;
						}
						else {
							current = Direction.DOWN;
						}
					}
					else {
						if (checkDown()){
							current = Direction.DOWN;
						}
						else {
							current = Direction.UP;
						}
					}
				}
			}
			// if vertical more impact
			else {
				//if player on the top
				if (j_diff > 0) {
					// if moving up available
					if (checkUp()){
						current = Direction.UP;
					}

					else {
						//if left available
						if (checkRight()){
							current = Direction.RIGHT;
						}
						else {
							current = Direction.DOWN;
						}
					}
				}
				// if player on the bottom
				else {
					// if bottom availabe
					if (checkDown()){
						current = Direction.DOWN;
					}
					else {
						//if right available
						if (checkRight()){
							current = Direction.RIGHT;
						}
						else {
							current = Direction.UP;
						}
					}
				}
			}
		}
		// if ghost moving up
		else if (current ==  Direction.UP) {
			//if vertical more impact
			if (j_diff_abs >i_diff_abs){
				// if player is on the top
				if (j_diff > 0){
					// if go up availaible
					if (checkUp()){
						current = Direction.UP;
					}
					// if player on the left
					else if (i_diff >0) {
						if (checkLeft()){
							current = Direction.LEFT;
						}
						else {
							current = Direction.RIGHT;
						}
					}
					// if player on th eright
					else {
						if (checkRight()){
							current = Direction.RIGHT;
						}
						else {
							current = Direction.LEFT;
						}
					}
				}
				// player on the bottom
				else {
					//if player on the left
					if (i_diff > 0) {
						if (checkLeft()){
							current = Direction.LEFT;
						}
						else {
							current = Direction.RIGHT;
						}
					}
					else {
						if (checkRight()){
							current = Direction.RIGHT;
						}
						else {
							current = Direction.LEFT;
						}
					}
				}
			}
			// if horizontal more impact
			else {
				//if player on the left
				if (i_diff > 0) {
					// if moving left available
					if (checkLeft()){
						current = Direction.LEFT;
					}

					else {
						//if up available
						if (checkUp()){
							current = Direction.UP;
						}
						else {
							current = Direction.RIGHT;
						}
					}
				}
				// if player on the right
				else {
					// if right availabe
					if (checkRight()){
						current = Direction.RIGHT;
					}
					else {
						//if up available
						if (checkUp()){
							current = Direction.UP;
						}
						else {
							current = Direction.LEFT;
						}
					}
				}
			}

		}
		// ghost moving down
		else if (current == Direction.DOWN) {
			//if vertical more impact
			if (j_diff_abs >i_diff_abs){
				// if player is on the bottom
				if (j_diff < 0){
					// if go down availaible
					if (checkDown()){
						current = Direction.DOWN;
					}
					// if player on the left
					else if (i_diff >0) {
						if (checkLeft()){
							current = Direction.LEFT;
						}
						else {
							current = Direction.RIGHT;
						}
					}
					// if player on th right
					else {
						if (checkRight()){
							current = Direction.RIGHT;
						}
						else {
							current = Direction.LEFT;
						}
					}
				}
				// player on the top
				else  {
					//if player on the left
					if (i_diff > 0) {
						if (checkLeft()){
							current = Direction.LEFT;
						}
						else {
							current = Direction.RIGHT;
						}
					}
					else {
						if (checkRight()){
							current = Direction.RIGHT;
						}
						else {
							current = Direction.LEFT;
						}
					}
				}
			}
			// if horizontal more impact
			else {
				//if player on the left
				if (i_diff > 0) {
					// if moving left available
					if (checkLeft()){
						current = Direction.LEFT;
					}

					else {
						//if down available
						if (checkDown()){
							current = Direction.DOWN;
						}
						else {
							current = Direction.RIGHT;
						}
					}
				}
				// if player on the right
				else {
					// if right availabe
					if (checkRight()){
						current = Direction.RIGHT;
					}
					else {
						//if down available
						if (checkDown()){
							current = Direction.DOWN;
						}
						else {
							current = Direction.LEFT;
						}
					}
				}
			}
		}

	}
    /**
    * Check whether current location is n intersection or not.
    *@return true/false
    */
	public boolean checkIntersection(){
		if(current == Direction.UP){
			if (checkLeft() || checkRight()){
				return true;
			}
		}
		else if (current == Direction.DOWN){
			if (checkLeft() || checkRight()){
				return true;
			}

		}
		else if (current == Direction.LEFT){
			if (checkUp() || checkDown()){
				return true;
			}
		}
		else if (current == Direction.RIGHT){
			if (checkUp() || checkDown()){
				return true;
			}
		}
		return false;
	}
    /**
    * Stop the movement of the ghost
    *<p> 1. Set stun duration to 300 frame (5 seconds).
    *<br> 2. Set ghost mode to Frozen.
    */

    public void stun(){
    	this.stun_duration =300;
    	mode = GhostMode.FROZEN;
    }
    /**
    * Set ghost to frightend mode.
    *<p> Save current ghost mode.
    *<br> Set ghost frigtened duration to frightenedDuration.
    *<br> Set ghost mode to FRIGHTENED.
    */    
    public void frightened(){
    	saveMode = mode;
    	this.frightened_duration = (int) game.frightenedDuration;
    	mode = GhostMode.FRIGHTENED;
    }
    /**
    * Handle ghost sprite logic
    *<p> If ghost isAlive is false, ghost sprite is empty.
    *<br> Else if ghost is in FROZEN mode, ghost sprite is frozen.
    *<br> Otherwise ghost sprite is ghost
    */    
    public void tick(){
    	if (!isAlive){
    		sprite = game.empty;
    	}
    	else if (mode== GhostMode.FROZEN){
    		sprite = game.frozen;
    	}
    	else if (mode == GhostMode.FRIGHTENED){
    		sprite = game.frightened;
    	}
    	else {
    		sprite = ghost;
    	}

    }
    /**
    * Move the ghost according to the mode
    *<p> If ghost is in SCATTER mode, check whether curent location is an intersection,
    * if true, decide new Direction and move, if false just move.
    *<br>Else if ghost is in FRIGHTENED mode,reducae duration by 1 check whether curent location is an intersection,
    * if true, decide new Direction and move, if false just move.
    *<br> Else if ghost is in CHASE mode, check whether curent location is an intersection,
    * if true, decide new Direction and move, if false just move.
    *<br>Else if ghost is in FROZEN mode, reduce stun duration by 1, call vibrate() method. 
	* If stun duration is 0, change ghost mode to CHASE mode.
    */  
    public void action(){
        if (mode == GhostMode.SCATTER ){
            if(checkIntersection()){
            	ghostUseBrain(target_corner_i, target_corner_j);
            	move();
            }
            else {
                move();
            }       
        }
        else if (mode == GhostMode.FRIGHTENED){
        	Random rand = new Random();
        	frightened_duration -= 1;
            if(checkIntersection()){
                ghostUseBrain(rand.nextInt(575), rand.nextInt(447));
            	move();
            }
            else {
                move();
            } 
            if (frightened_duration == 0) {
            	mode = saveMode;
            }

        }             
        else if (mode == GhostMode.CHASE){
            if(checkIntersection()){
                ghostUseBrain(target_location_i, target_location_j);
                move();
            }
            else {
                move();
            }
        }
        else if (mode== GhostMode.FROZEN){
            stun_duration -= 1;
            vibrate();
            if(stun_duration == 0){
                mode = GhostMode.CHASE;
            }
        }
    }
    /**
    * Set target location depend on ghost type
    */ 
    void chase(){
    	;
    }
    /**
    * Set ghost status to dead.
    */ 
    public void dead(){
    	this.isAlive =false;
    }
    /**
    * Handle debug line logic.
    *<p> If game is end or in countdown state, all debug line coordiante = 0
    *<br> If ghost is alive and in SCATTER mode, target coordinate is corner.
    *<br> Else if ghost in CHASE mode, target location i on ghost targer location.
    */ 
    public void tickDebugLine(){
        
        debugLineCoordinate[0] = 0;
        debugLineCoordinate[1] = 0;
        debugLineCoordinate[2] = 0;
        debugLineCoordinate[3] = 0;    
        if (game.isDebugMode && game.endingTimer == 0){        
            if (isAlive){
                if (mode == GhostMode.SCATTER){
                debugLineCoordinate[0] = i_coordinate+14;
                    debugLineCoordinate[1] = j_coordinate+14;
                    debugLineCoordinate[2] = target_corner_i;
                    debugLineCoordinate[3] = target_corner_j;
                }
                else if (mode == GhostMode.CHASE){
                    debugLineCoordinate[0] = i_coordinate+14;
                    debugLineCoordinate[1] = j_coordinate+14;
                    debugLineCoordinate[2] = target_location_i+12;
                    debugLineCoordinate[3] = target_location_j+13;
                }
            }
        }
    }
}


