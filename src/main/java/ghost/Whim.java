package ghost;

import java.util.*;
import processing.core.PImage;
import processing.core.PApplet;
import java.lang.Math;

/**
* Represent WHIM type of Ghost
*/
public class Whim extends Ghost {

    protected int whimTarget_i;
    protected int whimTarget_j;

    public Whim( Game game, PImage ghost ,Waka target1, int ghostNumber){
        super( game,  ghost , target1,  ghostNumber);
        this.target_corner_i =447;
        this.target_corner_j =575;

    }
    /**
    * Set target location.
    * <p>Target location is double vector between Chaser and player + 2 unit 
    * depend on the Direction on player.
    *<br> If chaser is dead, set the target to bottom left corner.
    */
    public void chase(){
        if (setChaserTarget()){
            int i_diff = target1.i_coordinate - whimTarget_i;
            int j_diff = target1.j_coordinate - whimTarget_j;
            if (target1.current == Direction.LEFT){
                i_diff = i_diff - 16*2;
                target_location_i = whimTarget_i + i_diff*2;
                target_location_j = whimTarget_j + j_diff*2;
            }
            else if (target1.current == Direction.RIGHT){
                i_diff = i_diff + 16*2;
    
                    target_location_i = whimTarget_i + i_diff*2;
                    target_location_j = whimTarget_j + j_diff*2;
                }
                else if (target1.current == Direction.UP){
                    j_diff = j_diff - 16*2;
    
                     target_location_i = whimTarget_i + i_diff*2;
                    target_location_j = whimTarget_j + j_diff*2;
                }
                else if (target1.current == Direction.DOWN){
                    j_diff = j_diff + 16*2;
                    target_location_i = whimTarget_i + i_diff*2;
                    target_location_j = whimTarget_j + j_diff*2;
                }      
                if (target_location_i > 447){
                    target_location_i = 447;
                }
                if (target_location_j > 575){
                    target_location_j = 575;
                }        
                if (target_location_i < 0){
                    target_location_i = 0;
                }
                if (target_location_j < 0){
                    target_location_j = 0;
                }
            }
        else{
            target_location_i = 447;
            target_location_j =575;
        }
    }
    /**
    * Choose the chaser target, and check wheter chaser is exist.
    *@return true/false
    */
    public boolean setChaserTarget(){
        for (Ghost x : game.chasers){
            if (x.isAlive == true){
                whimTarget_i = x.i_coordinate;
                whimTarget_j = x.j_coordinate;

                return true;
            }

        }
        return false;

    }


}