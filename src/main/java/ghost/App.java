package ghost;

import processing.core.PApplet;
import processing.event.KeyEvent;
import java.io.IOException;
/**
* App operating system.
*/
public class App extends PApplet {

    public static final int WIDTH = 448;     
    public static final int HEIGHT = 576;
    private Game pacman;

    public App() {
    }
    /**
    * App setup
    *<p> Set frame rate to 60
    *<br> create Game object.
    */
    public void setup() {
        frameRate(60);
        this.pacman = new Game(this ,"config.json");
    }
    /**
    * App setting
    *<p> Set app dimension to 448,576
    */
    public void settings() {
        size(WIDTH, HEIGHT);
    }
    /**
    * Computer graphic
    *<p> Set black background
    *<br> If game timer is 0, draw all game objects.
    *<br> Otherwiaw draw game ending screen.
    */
    public void draw() { 
        background(0, 0, 0);
        this.pacman.tick(); // all game logic
        if (pacman.endingTimer == 0) {  
            this.pacman.drawMap(this); // draw base map
            this.pacman.drawFruitsLocation(this); //draw fruits location
            this.pacman.drawSuperFruitsLocation(this); //draw fruits location
            this.pacman.drawBerrysLocation(this); //draw berry location
            this.pacman.drawWaka(this); //draw player
            this.pacman.drawLives(this); //draw current player life amount
            this.pacman.drawBerrys(this); //draw current player berry amount
            this.pacman.drawScore(this); //draw score
            this.pacman.drawGhosts(this); //draw all ghosts , debug line
            this.pacman.drawCountdowns(this);//draw countdown before game start number 3,2,1
            this.pacman.drawPause(this);  // draw pause sign 
        }
        else { 
            this.pacman.drawEnding(this); //draw ending
        }
    }
    /**
    * Main mehtod of the entire program.
    * @param args Command line argument
    */
    public static void main(String[] args) {
        PApplet.main("ghost.App");
    }
    /**
    * Key listener from user.
    * @param e key event generated when a key is press by user.
    */
    public void keyPressed(KeyEvent e) {
        pacman.keyHandler(e.getKeyCode());
    }    
}