package ghost;

import java.util.*;
import processing.core.PImage;
import processing.core.PApplet;
import java.lang.Math;

/**
* Represent Ambusher type of Ghost
*/
public class Ambusher extends Ghost {

    public Ambusher( Game game, PImage ghost ,Waka target1, int ghostNumber){
        super( game,  ghost , target1,  ghostNumber);
        this.target_corner_i =447;
        this.target_corner_j =0;


    }
    /**
    * Set target location.
    * <p>If target is moving LEFT, target i coordinate - 4 units
    * <br>Else if target is moving RIGHT, target i coordinate + 4 units
    * <br>Else if target is moving UP, target j coordinate - 4 units
    * <br>Else if target is moving DOWN, target j coordinate + 4 units
    * <br> If target location is out of bound set it to maximum/minimum
    */
    public void chase(){
        if (target1.current == Direction.LEFT){
            target_location_i = target1.i_coordinate - 16*4;
            target_location_j = target1.j_coordinate;
        }
        else if (target1.current == Direction.RIGHT){
            target_location_i = target1.i_coordinate  + 16*4;
            target_location_j = target1.j_coordinate;
        }
        else if (target1.current == Direction.UP){
            target_location_i = target1.i_coordinate;
            target_location_j = target1.j_coordinate - 16*4;
        }
        else if (target1.current == Direction.DOWN){
            target_location_i = target1.i_coordinate;
            target_location_j = target1.j_coordinate + 16*4;
        }

        if (target_location_i < 0){
            target_location_i = 0;
        }
        if (target_location_j < 0){
            target_location_j = 0;
        }
        if (target_location_i > 447){
            target_location_i = 447;
        }
        if (target_location_j > 575){
            target_location_j = 575;
        }
    }

}