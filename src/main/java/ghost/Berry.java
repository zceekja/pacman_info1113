package ghost;

import processing.core.PImage;

/**
* Represent Berry in Waka game.
* <p> Instance have a location, status.
*/
public class Berry  extends CollectableObject{
    /**
    * Constructor for Berry,
    * set the location and sprite.
    * @param i_coordinate  Horizontal location of berry on map
    * @param j_coordinate  Vertical location of berry on map
    * @param game Refererence of game 
    */
	public Berry(int i_coordinate, int j_coordinate,Game game) {
		super(i_coordinate,j_coordinate,  game);
		sprite = game.berry;
	}
    /**
    * Handle berry sprite logic
    * <p> If berry is collected, sprite is empty. 
    * <br> Otherwise sprite is berry.
    */
	public void tick() {
		if (isCollected()){
			sprite = game.empty;
		}
		else {
			sprite = game.berry;
		}
	}
}