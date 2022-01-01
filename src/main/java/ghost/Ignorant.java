package ghost;

import java.util.*;
import processing.core.PImage;
import processing.core.PApplet;
import java.lang.Math;

/**
* Represent IGNORANT type of Ghost
*/
public class Ignorant extends Ghost {

    public Ignorant( Game game, PImage ghost ,Waka target1, int ghostNumber){
        super( game,  ghost , target1,  ghostNumber);
        this.target_corner_i =0;
        this.target_corner_j =575;


    }
    /**
    * Set ghost target
    * <p>If player is within 8 unit radius, target is player.
    *<br>Otherwise, target is bottom left corner.
    */
    public void chase(){
        int i_diff = target1.i_coordinate - i_coordinate;
        int j_diff = target1.j_coordinate - j_coordinate;
        double d = Math.sqrt(i_diff*i_diff + j_diff*j_diff);
        if (d > 8*16){
            target_location_i = 0;
            target_location_j = 575;
        }
        else{
            target_location_i = target1.i_coordinate;
            target_location_j = target1.j_coordinate;
        }
    }


}