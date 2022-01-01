package ghost;
import processing.core.PImage;

abstract class MoveableObject {

    protected int start_i = 0;
    protected int start_j = 0;
    protected int i_coordinate = 0;
    protected int j_coordinate = 0;
    protected int moveSpeed;
    protected Map game_map;
    protected Direction current = Direction.LEFT;
    protected PImage sprite;
    protected Game game;

    public MoveableObject(int i, int j, Game game) {
        this.game = game;
        i_coordinate = i * 16 -4; 
        j_coordinate = j * 16 -5;
        start_i = i_coordinate;
        start_j = j_coordinate; 
        this.game_map = game.game_map;
        this.moveSpeed = (int)game.speed;

    }
   /**
    * Move Left(decrement i coordinate)
    */
    public void moveLeft() {
        if (game_map.movePath[j_coordinate][i_coordinate-moveSpeed]) {
            this.i_coordinate -= moveSpeed;
        }
        
    }
    /**
    * Move right(increment i coordinate)
    */
    public void moveRight() {
        if (game_map.movePath[j_coordinate][i_coordinate+moveSpeed]) {
            this.i_coordinate += moveSpeed;
        }
    }
    /**
    * Move Up(decrement j coordinate)
    */
    public void moveUp() {
        if (game_map.movePath[j_coordinate-moveSpeed][i_coordinate]) {
            this.j_coordinate -=  moveSpeed;
        }
    }
    /**
    * Move Down(increment j coordinate)
    */
    public void moveDown() {
        if (game_map.movePath[j_coordinate+moveSpeed][i_coordinate]) {
            this.j_coordinate += moveSpeed;
        }
    }
    /**
    * Check whether coordinate on the left is moveable or not.
    *@return true/false
    */
    public boolean checkLeft() {
        return game_map.movePath[j_coordinate][i_coordinate-moveSpeed];

    }
    /**
    * Check whether coordinate on the right is moveable or not.
    *@return true/false
    */
    public boolean checkRight() {
        return game_map.movePath[j_coordinate][i_coordinate+moveSpeed];

    }
    /**
    * Check whether coordinate ablove is moveable or not.
    *@return true/false
    */
    public boolean checkUp() {
        return game_map.movePath[j_coordinate-moveSpeed][i_coordinate];

    }
    /**
    * Check whether coordinate below is moveable or not.
    *@return true/false
    */
    public boolean checkDown() {
        return game_map.movePath[j_coordinate+moveSpeed][i_coordinate];

    }
}

