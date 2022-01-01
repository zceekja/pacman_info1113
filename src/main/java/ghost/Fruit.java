package ghost;
import processing.core.PImage;
/**
* Represent Fruit in Waka game.
* <p> Instance have a location, status.
*/
public class Fruit extends CollectableObject {
    /**
    * Constructor for Fruit,
    * set the location and sprite.
    * @param i_coordinate  Horizontal location of fruit on map
    * @param j_coordinate  Vertical location of fruit on map
    * @param game Refererence of game 

    */
	public Fruit(int i_coordinate, int j_coordinate, Game game) {
		super(i_coordinate,j_coordinate, game);
		sprite = game.fruit;
	}
    /**
    * Handle fruit sprite logic
    * <p> If fruit is collected, sprite is empty. 
    * <br> Otherwise sprite is fruit.
    */	
    public void tick() {
		if (isCollected()){
			sprite = game.empty;
		}
		else {
			sprite = game.fruit;
		}
	}
}