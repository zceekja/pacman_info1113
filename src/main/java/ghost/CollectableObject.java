package ghost;
import processing.core.PImage;

abstract class CollectableObject {

    protected boolean collected = false;
    protected int i_coordinate = 0;
    protected int j_coordinate = 0;
    protected int i_waka_path = 0;
    protected int j_waka_path = 0;
    protected Game game;
    protected PImage sprite;

    public CollectableObject(int i, int j, Game game) {
        this.game = game;
        this.i_coordinate = i;
        this.j_coordinate = j;
        this.i_waka_path = i*16-4;
        this.j_waka_path = j*16-5;

    }
   /**
    * Set collected to true.
    */
    public void collect() {
        this.collected = true;
    }
   /**
    * Check wether object is collected or not.
    * @return true/false
    */
    public boolean isCollected(){
        return collected;
    }
   /**
    * Set object collected to false.
    */
    public void reset(){
        this.collected = false;
    }


}