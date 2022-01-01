package ghost;
import processing.core.PImage;
/**
* Represent SuperFruit in Waka game.
* <p> Instance have a location, status.
*/
public class SuperFruit extends CollectableObject {
    /**
    * Constructor for SuperFruit,
    * set the location and sprite.
    * @param i_coordinate  Horizontal location of fruit on map
    * @param j_coordinate  Vertical location of fruit on map
    * @param game Refererence of game 

    */
	public SuperFruit(int i_coordinate, int j_coordinate, Game game) {
		super(i_coordinate,j_coordinate, game);
		sprite = game.superFruit;
	}
    /**
    * Handle super fruit sprite logic
    * <p> If super fruit is collected, sprite is empty. 
    * <br> Otherwise sprite is superFruit.
    */
	public void tick() {
		if (isCollected()){
			sprite = game.empty;
		}
		else {
			sprite = game.superFruit;
		}
	}
}