package ghost;

import java.util.*;
import processing.core.PImage;
import processing.core.PApplet;
import java.lang.Math;

/**
* Represent CHASER type of Ghost
*/
public class Chaser extends Ghost {

    public Chaser( Game game, PImage ghost ,Waka target1, int ghostNumber){
        super( game,  ghost , target1,  ghostNumber);
        this.target_corner_i =0;
        this.target_corner_j =0;


    }
    /**
    * Set target location.
    * Target location is player coordinate.
    */
    public void chase(){
        target_location_i = target1.i_coordinate;
        target_location_j = target1.j_coordinate;
    }

}