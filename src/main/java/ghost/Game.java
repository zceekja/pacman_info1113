package ghost;

import processing.core.PApplet;
import processing.core.PImage;
import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import processing.event.KeyEvent;
import processing.core.PFont;

/**
* Waka game manager.
* <p> Handle all user input, manage all logic and drawing.

*/
public class Game  {
    protected String map_file = "";
    protected long lives = 0;
    protected long speed =1;	
    protected long frightenedDuration = 0;
    protected List<Long> modeLength = new ArrayList<Long>();
    protected int modeLength_index = 0;
	//All Image
    protected PFont nintendoFont;
    protected App app;
	protected PImage fruit;
	protected PImage superFruit;
	protected PImage downRight;
	protected PImage downLeft;
	protected PImage vertical;
	protected PImage horizontal;
	protected PImage upRight;
	protected PImage upLeft;
    protected PImage playerClosed;
    protected PImage playerDown;
    protected PImage playerLeft;
    protected PImage playerRight;
    protected PImage playerUp;
    protected PImage ambusher;
    protected PImage chaser;
    protected PImage ignorant;
    protected PImage whim;
    protected PImage frozen;
    protected PImage frightened;
    protected PImage berry;
    protected PImage number0;
    protected PImage number1;
    protected PImage number2;
    protected PImage number3;
    protected PImage number4;
    protected PImage number5;
    protected PImage number6; 
    protected PImage number7;
    protected PImage number8;
    protected PImage number9;
    protected PImage score1;
    protected PImage score2;
    protected PImage bigNumber1;
    protected PImage bigNumber2;
    protected PImage bigNumber3; 
    protected PImage pause;   
    protected int currentScore = 0;
    protected int highScore =0;
    protected int countdown = 180;
    protected boolean isPause = false;
    protected boolean isDebugMode = false;
    protected PImage empty;
    protected Score currentScoreDisplay;
    protected Score highScoreDisplay;
    protected PImage pauseSprite;
    protected PImage countdownSprite;
    protected Map game_map;
    protected Waka player1;
    protected List<Ghost> ghosts = new ArrayList<Ghost>();
    protected List<Ghost> chasers = new ArrayList<Ghost>();
    protected int ghostModeCounter = 0;
    protected int endingTimer = 0;
    protected boolean isWon = false;



    /**
    * Constructor for Game,
    * read configuration file, create map, waka and ghosts obejct.
    * @param app  reference of App
    * @param conf  configuraiton file name

    */
    public Game (App app ,String conf){

		readConfiguration(conf);
		if (app != null){
   			fruit = app.loadImage("src/main/resources/fruit.png");
        	superFruit = app.loadImage("src/main/resources/bigFruit.png");
        	downRight = app.loadImage("src/main/resources/downRight.png");
        	downLeft = app.loadImage("src/main/resources/downLeft.png");
        	vertical = app.loadImage("src/main/resources/vertical.png");
        	horizontal = app.loadImage("src/main/resources/horizontal.png");
        	upRight = app.loadImage("src/main/resources/upRight.png");
        	upLeft = app.loadImage("src/main/resources/upLeft.png");
        	playerClosed = app.loadImage("src/main/resources/playerClosed.png");
        	playerDown = app.loadImage("src/main/resources/playerDown.png");
        	playerLeft = app.loadImage("src/main/resources/playerLeft.png");
        	playerRight = app.loadImage("src/main/resources/playerRight.png");
        	playerUp = app.loadImage("src/main/resources/playerUp.png");
        	ambusher = app.loadImage("src/main/resources/ambusher.png");
        	chaser = app.loadImage("src/main/resources/redGhost.png");
        	ignorant = app.loadImage("src/main/resources/ignorant.png");
        	whim = app.loadImage("src/main/resources/whim.png");
        	frozen = app.loadImage("src/main/resources/frozen.png");
        	frightened = app.loadImage("src/main/resources/frightened.png");
        	berry = app.loadImage("src/main/resources/berry.png");
        	number0 = app.loadImage("src/main/resources/number0.png");
        	number1 = app.loadImage("src/main/resources/number1.png");
        	number2 = app.loadImage("src/main/resources/number2.png");
        	number3 = app.loadImage("src/main/resources/number3.png");
        	number4 = app.loadImage("src/main/resources/number4.png");
        	number5 = app.loadImage("src/main/resources/number5.png");
        	number6 = app.loadImage("src/main/resources/number6.png");
        	number7 = app.loadImage("src/main/resources/number7.png");
        	number8 = app.loadImage("src/main/resources/number8.png");
        	number9 = app.loadImage("src/main/resources/number9.png");
        	score1 = app.loadImage("src/main/resources/score1.png");
        	score2 = app.loadImage("src/main/resources/score2.png");
        	bigNumber1 = app.loadImage("src/main/resources/bigNumber1.png");
        	bigNumber2 = app.loadImage("src/main/resources/bigNumber2.png");
        	bigNumber3 = app.loadImage("src/main/resources/bigNumber3.png");
        	pause = app.loadImage("src/main/resources/pause.png");
        	empty = app.createImage(0,0, 0);
        	nintendoFont = app.createFont("src/main/resources/PressStart2P-Regular.ttf", 30 );
        	app.stroke(200);
    	}
		this.game_map = new Map(this);
        this.player1 = new Waka( this);

        for(int i = 0; i < this.game_map.getTotalGhost(); i++){
        	if (game_map.ghosts.get(i) == 'a'){
        		Ghost ghost_tmp = new Ambusher(this , ambusher,player1,i +1);
        		ghosts.add(ghost_tmp);
        	}
        	else if (game_map.ghosts.get(i) == 'c'){
        		Ghost ghost_tmp = new Chaser(this , chaser, player1,i +1);
        		chasers.add(ghost_tmp);
        		ghosts.add(ghost_tmp);     
        	}
        	else if (game_map.ghosts.get(i) == 'i'){
        		Ghost ghost_tmp = new Ignorant(this , ignorant, player1,i +1);
        		ghosts.add(ghost_tmp);
        	}
        	else {
        		Ghost ghost_tmp = new Whim(this , whim, player1,i +1);
        		ghosts.add(ghost_tmp);
        	}


        }
        currentScoreDisplay = new Score(this, true);
        highScoreDisplay = new Score(this, false);


	}
    /**
    * Parse configuration file
    * @param file  configuration file name
	
    */
	public void readConfiguration(String file) {
		JSONParser parser = new JSONParser();
		try{


			FileReader f = new FileReader(file);
	 		Object obj = parser.parse(f);
			JSONObject jsonObject = (JSONObject) obj;
			map_file = (String) jsonObject.get("map");
			lives = (long)jsonObject.get("lives");
			speed = (long)jsonObject.get("speed");
			frightenedDuration = (long)jsonObject.get("frightenedLength")*60;
			JSONArray mode = (JSONArray) jsonObject.get("modeLengths");
			Iterator<Long> iterator = mode.iterator();
			while(iterator.hasNext())
			{

				modeLength.add(iterator.next());
			}
		} 
		catch(FileNotFoundException e){ e.printStackTrace(); }
		catch(IOException e){e.printStackTrace();}
		catch(ParseException e){e.printStackTrace();}

	}

    /**
    * Handle all logic of the game.
    * <p> If game ending result timer or starting countdown more than 0 , stop movement of ghost, waka.
    * <br>If player life = 0, reset stage.
    * <br>If remaining fruit in map is 0, reset stage.
    * <br>If ghost is in FRIGHTENED mode and collide with player, ghost is dead.
    * <br>If ghost not in FIGHTENED mode and collide with player, reset the game.
    * <br>If ghost mode counter is equal modeLength, change ghost mode and reset counter.
    * <br>For all ghosts, if ghost at intersection, set new target location. move ghost.
    * <br>For all fruits, if hit by player, change state to collect, increase score and decrese remaining fuit.
    * <br>For all Superfruits, if hit by player, change state to collect, increase score and decrese remaining fuit 
    * and change ghost mode to FIGHTENED.
    * <br>For all fruits, if hit by player, change state to collect, increase player berry counter. 
    * <br> If player queue Direction is LEFT, if LEFT is availiable move, set Direction to LEFT.
    * <br> If player queue Direction is RIGHT, if RIGHT is availiable move, set Direction to RIGHT.
    * <br> If player queue Direction is UP, if UP is availiable move, set Direction to UP.
    * <br> If player queue Direction is DOWN, if DOWN is availiable move, set Direction to DOWN.
    * <br> For all fruit, set fruit sprite.
    * <br> For all superFruit, set superFruit sprite.
    * <br> For all berry, set berry sprite.
    * <br> Set aka sprite.
    * <br> For all ghost, set set ghost sprite and debugline.
    * <br> Set pause sprite.
    * <br> Set countdown number sprite.
    * <br> Set ending sprite.

    */
	public void tick(){

        if (endingTimer > 0){
        	stop();
        }
		else if (countdown> 0){
			stop();
		}
		else {
			ghostModeCounter++;
		}

		if (player1.livesLeft == 0){
			stageReset(true);
		}
		if (game_map.remaining_fruit==0){
			stageReset(false);
		}

		for (Ghost x: ghosts){
			for (int i = 0; i <5 ;i++){
				if (x.i_coordinate == player1.i_coordinate+i-1)
					for (int j = 0; j< 5; j++){
						if (x.mode == GhostMode.FRIGHTENED){
							if (x.j_coordinate == player1.j_coordinate+j-1){
								x.dead();
							}
						}
						else if (x.isAlive) {		
							if (x.j_coordinate == player1.j_coordinate+j-1){
								reset(false);
							}
						}
					}
			}
		}
		if (ghostModeCounter == modeLength.get(modeLength_index)*60){
			if (modeLength_index ==  modeLength.size()-1) {
				modeLength_index = 0;
			}
			else {
                if(!isPause){
				    modeLength_index++;
                }
			}
			ghostModeCounter = 0;

		}
		if (this.ghosts.get(0).mode == GhostMode.FROZEN){
			;
		}
		else if (this.ghosts.get(0).mode == GhostMode.FRIGHTENED){
			;
		}
		else if ((modeLength_index+1)%2 ==0){
			for (Ghost x: this.ghosts) {
				x.mode = GhostMode.CHASE;
			}
		}
		else {
			for (Ghost x: this.ghosts) {

				x.mode = GhostMode.SCATTER;
			}
		}
		for (Ghost x: this.ghosts){
			if (x.checkIntersection()){
				x.chase();
			}
			x.action();
		}

		for (Fruit x: game_map.getAllFruits()){
			if ( x.j_waka_path == player1.j_coordinate){
				if (x.i_waka_path == player1.i_coordinate){
					if (!x.isCollected()){		
						this.currentScore++;
						x.collect();
					game_map.remaining_fruit--;

					}
				}
			} 
		}
		for (SuperFruit x: game_map.getAllSuperFruits()){
			if ( x.j_waka_path == player1.j_coordinate){
				if (x.i_waka_path == player1.i_coordinate){
					if (!x.isCollected()){		
						this.currentScore++;
						x.collect();
						game_map.remaining_fruit--;
						for(Ghost y: this.ghosts){
							y.frightened();
						}

					}
				}
			} 
		}
		for (Berry x: game_map.getAllBerrys()){
			if ( x.j_waka_path == player1.j_coordinate){
				if (x.i_waka_path == player1.i_coordinate){
					if (!x.isCollected()){		
						player1.berryLeft++;
						x.collect();
						game_map.remaining_berry--;

					}
				}
			} 
		}
		if(player1.next == Direction.LEFT){
			if(player1.checkLeft()){
				player1.current = player1.next;
				player1.next = Direction.UNDEFINE;
			}
		}

		if(player1.next == Direction.RIGHT){
			if(player1.checkRight()){
				player1.current = player1.next;
				player1.next = Direction.UNDEFINE;
			}
		}
		if(player1.next == Direction.UP){
			if(player1.checkUp()){
				player1.current = player1.next;
				player1.next = Direction.UNDEFINE;
			}
		}
		if(player1.next == Direction.DOWN){
			if(player1.checkDown()){
				player1.current = player1.next;
				player1.next = Direction.UNDEFINE;
			}
		}

		if(player1.current == Direction.LEFT){
			player1.moveLeft();
		}
		if(player1.current == Direction.RIGHT){
			player1.moveRight();
		}
		if(player1.current == Direction.UP){
			player1.moveUp();
		}
		if(player1.current == Direction.DOWN){
			player1.moveDown();
		}

        for (Fruit x: this.game_map.allFruits) {
            x.tick();
        }
        for (SuperFruit x: this.game_map.allSuperFruits) {
            x.tick();
        }
        for (Berry x: this.game_map.allBerrys) {
            x.tick();
        }        
        for (Ghost x: ghosts){
            x.tick();
            x.tickDebugLine();
    	}
        this.player1.tick();
        currentScoreDisplay.tick();
        highScoreDisplay.tick();
        tickPause();
        tickCountdown();
        tickEndingTimer();

	}

    /**
    * Handle coundown sprite logic.
    * <p> If game state is end do nothing.
    * <br>If countdown is more than 120 frame, set sprite to number 3.
    * <br>If countdown is more than 60 frame, set sprite to number 2.
    * <br>If countdown is more than 0 frame, set sprite to number 1.
    * <br>Otherwise do not display countdown sprite.   
    */
    public void tickCountdown(){
    	if (endingTimer > 0){
    		;
    	}
        else if (countdown > 120){
            countdownSprite = bigNumber3;
            this.countdown--;
        }
        else if (countdown > 60){
            countdownSprite = bigNumber2;
            this.countdown--;
        }
        else if (countdown > 0) {
            countdownSprite = bigNumber1;
            this.countdown--;
        }
        else{
            countdownSprite = empty;
        }

    }

    /**
    * Handle pause sprite logic.
    * <p> If game state is pasuse, set sprite to pause. 
    * <br> Otherwise, do not display pause sprite. 
    */
    public void tickPause(){
        if (isPause){
            pauseSprite = pause;
        }
        else {
            pauseSprite = empty;
        }
    }
    /**
    * Reset stage of the game whene player is defeated or clear the stage.
    * <p> Reset all fruit, berry and super fruit.
    * <br> Reset player life.
    * <br> Reset player berry amount.
    * <br> Set ending Timer to 600 frame (10 seconds)
    * <br> If current score more than high score, set new high score.
    * <br> If gameOver is true, player lose.(isWon = false)
    * <br> If gameOver is false, player win.(isWon = true)
    * <br> Call reset(true)
    * @param gameOver playerLife = 0?
    */	
    public void stageReset(boolean gameOver){

		game_map.remaining_fruit = game_map.total_fruit;
		for(Fruit x: this.game_map.allFruits){
			x.reset();
		}
		for(Berry x: this.game_map.allBerrys){
			x.reset();
		}
		for(SuperFruit x: this.game_map.allSuperFruits){
			x.reset();
		}
		player1.resetLives();
		player1.resetBerry();
		endingTimer = 600;
		if (currentScore > highScore){
			highScore = currentScore;
		}
		this.currentScore = 0;
		if(gameOver){
			isWon = false;
		}
		else{
			isWon = true;
		}	
		reset(true);
	}
    /**
    * Reset the game when player hit by ghost.
    * <p> If player life more than 0 , reduce by 1.
    * <br> Reset player location to starting location
    * <br> Reset all ghosts location to starting location
    * <br> set all ghosts to SCATTER mode
    * <br> change status of all ghost to alive.
    * <br> set modeLenth_index to 0.
    * <br> set ghostModeCounter to 0.
    * <br> set countdown to 180 frame (3 seconds)

    * @param isOver isPlayerLife = 0?
    */
	public void reset(boolean isOver){
		if (!isOver){
			player1.livesLeft -= 1;
		}

		this.player1.resetLocation();
		for(Ghost x: this.ghosts){
			x.resetLocation();
            x.mode = GhostMode.SCATTER;
            x.isAlive = true;
		}
		modeLength_index =0;
		ghostModeCounter =0;
		countdown = 180;
	}

    /**
    * Stop the movement of movable object.
    * <p>  if countdown more than 0 , set player and all ghost Direction to UNDEFINE
    * <br> if countdown = 1, set player and all ghost Direction to LEFT.
    */
    public void stop(){
        if (countdown >0) {
            this.player1.current = Direction.UNDEFINE;
            for(Ghost x: this.ghosts) {
            	x.current = Direction.UNDEFINE;
            }
        }
        if (countdown == 1){
            this.player1.current = Direction.LEFT;
        
            for(Ghost x: this.ghosts) {
                x.current = Direction.LEFT;
            }
        }
    }
    /**
    * Pause the game.
    * <p>  Save player current Direction.
    * <br> Set player current Direction to UNDEFINE.
    * <br> For all ghost save ghost current Direction and set current Direction to UNDEFINE.
    * <br> Set isPasuse to true.
    */

    public void toPause(){
        this.player1.save = this.player1.current;
        this.player1.current = Direction.UNDEFINE;
        for (Ghost x: this.ghosts){
            x.save = x.current;
            x.current = Direction.UNDEFINE;
        }
        this.isPause = true;
    }
    /**
    * Continue the game.
    * <p>  Set player current Direction to save Direction
    * <br> For all ghost set ghost current Direction to save Direction.
    * <br> Set isPasuse to false.
    */
    public void toContinue(){
        this.player1.current =  this.player1.save;
        for( Ghost x: this.ghosts){
            x.current = x.save;
        }
        this.isPause =false;
    }
    /**
    * Draw map.
    * <p>  Iterate through all element in game_map.sprite and draw sprite.
    * @param app reference of App
    */
    public void drawMap(PApplet app) {
        int width = 0;
        int height = 0;
        for (int i = 0; i < 36; i++) {
            for(int j = 0; j < 28; j++) {
                app.image(this.game_map.sprite[i][j], width, height);
                width += 16;
            }
            width = 0;
            height += 16;
        }
    }
    /**
    * Draw Player.
    * <p>  Draw player base on current location and current sprite.
    * @param app reference of App
    */
    public void drawWaka(PApplet app) {
    	app.image(this.player1.sprite, player1.i_coordinate, player1.j_coordinate);
    }

    /**
    * Draw amount of player remaining life.
    * <p>  Draw player remaining left at the bottom left.
    * @param app reference of App
    */
    public void drawLives(PApplet app) {
        int n = 0;
        for (int i = 1; i < this.player1.livesLeft; i++) {
            app.image(this.playerRight, 8 + n, 544);
            n+= 30;
        }
    }

    /**
    * Draw amount of player remaining berry.
    * <p>  Draw player remaining berry at the bottom right.
    * @param app reference of App
    */
    public void drawBerrys(PApplet app) {
        int n = 0;
        for (int i = 0; i < this.player1.berryLeft; i++) {
            app.image(this.berry, 420 - n, 546);
            n+= 20;
        }
    }

    /**
    * Draw player current score and high score.
    * <p>  Draw player score at top of the game screen.
    * @param app reference of App
    */
 	public void drawScore(PApplet app) {
 		app.image(score1, 20,10);
 		app.image(score2, 240,10);
        for (int i = 0; i < 6; i++){
            app.image(currentScoreDisplay.scoreDisplay[i], 410-i*20, 10);
        }
        for (int i = 0; i < 6; i++){
            app.image(highScoreDisplay.scoreDisplay[i], 410-200-i*20, 10);
        }

 	}

    /**
    * Draw all fruits.
    * <p>  Iterate through allFruits and draw fruit.
    * @param app reference of App
    */
    public void drawFruitsLocation(PApplet app) {
        for (Fruit x: this.game_map.allFruits) {
            app.image(x.sprite, x.i_coordinate*16, x.j_coordinate*16);
        }
    }

    /**
    * Draw all superFruit.
    * <p>  Iterate through allSuperFruits and draw SuperFruit.
    * @param app reference of App
    */
    public void drawSuperFruitsLocation(PApplet app) {
        for (SuperFruit x: this.game_map.allSuperFruits) {
            app.image(x.sprite, x.i_coordinate*16, x.j_coordinate*16);
        }
    }
    /**
    * Draw all berry.
    * <p>  Iterate through allBerry and draw berry.
    * @param app reference of App
    */
    protected void drawBerrysLocation(PApplet app) {
        for (Berry x: this.game_map.allBerrys) {
            app.image(x.sprite, x.i_coordinate*16, x.j_coordinate*16);
        }
    }
    /**
    * Draw all ghost and debug line.
    * <p>  Iterate through all ghost, then draw ghost and debug line.
    * @param app reference of App
    */
    public void drawGhosts(PApplet app) {
    	for (Ghost x: ghosts){
    		app.image(x.sprite, x.i_coordinate, x.j_coordinate);
       		app.line(x.debugLineCoordinate[0],
       			x.debugLineCoordinate[1],
       			x.debugLineCoordinate[2],
       			x.debugLineCoordinate[3]);
    	}
    }
    /**
    * Draw countdown number before game start.
    * <p>  Draw countdown number at the middle of the screen.
    * @param app reference of App
    */
    public void drawCountdowns(PApplet app) {
    	app.image(countdownSprite,160,200);

    	
    }
    /**
    * Draw pause sign.
    * <p>  Draw pause sign at the middle of the screen.
    * @param app reference of App
    */
    public void drawPause(PApplet app){
        app.image(pauseSprite,135,210);
    }
    /**
    * Draw end game result.
    * <p>  Draw end game result at the middle of the screen.
    * @param app reference of App
    */
    public void drawEnding(PApplet app){
        app.textFont(nintendoFont,24); 
        app.fill(200); 
        if (!isWon){
            app.text("GAME OVER",120,250);
        }
        else{
            app.text("YOU WIN",120,250);

        }
    }
    /**
    * Decrement ending screen timer
    * <p>  decrease endinTimer by 1 until it reach 0
    */
    public void tickEndingTimer(){
    	if (endingTimer > 0){
    		endingTimer--;
    	}
    }
    /**
    * Handle user input
    * <p>  If keyCode is 38 or 87 (ARROW_UP or W), set player next Direction to UP
    * <p>  If keyCode is 40 or 83 (ARROW_DOWN or S), set player next Direction to DOWN
    * <p>  If keyCode is 37 or 65 (ARROW_LEFT or A), set player next Direction to LEFT
    * <p>  If keyCode is 39 or 68 (ARROW_RIGHT or D), set player next Direction to RIGHT
    * <p>  If keyCode is 32 (SPACE_BAR), Set isDebugMode to !isDebugMode (turn on/off debug mode)
    * <p>  If keyCode is 70 (F), if player have berry, use berry and stun all ghost.
    * <p>  If keyCode is 80 (P), if coundown == 0, set isPause to !isPause (pasue the game)
    * @param keyCode key code of user input.
    */
    public void keyHandler(int keyCode) {
        if(keyCode == 38 || keyCode ==87){
            if (!isPause && countdown == 0){
                player1.setDirectionNext(Direction.UP);
                System.out.println("up");
            }
        }
        else if(keyCode == 40 || keyCode ==83){
            if (!isPause  && countdown == 0){
                player1.setDirectionNext(Direction.DOWN);
                System.out.println("down");
            }
        }
        else if(keyCode == 37  || keyCode == 65 ){
            if (!isPause && countdown == 0){
                player1.setDirectionNext(Direction.LEFT);
                System.out.println("left");
            }
        }
        else if(keyCode == 39 || keyCode == 68){
            if (!isPause && countdown == 0){
                player1.setDirectionNext(Direction.RIGHT);
                System.out.println("right");
            }
        }
        else if(keyCode == 32){
            isDebugMode = !isDebugMode; 
            
        }
        else if(keyCode == 70){
            if (player1.berryLeft >0){
                if (!isPause && countdown == 0){
                    player1.useBerry();
                    for (Ghost x: ghosts){
                        x.stun();
                    }
                }
            }
            else{
            	;
            }

        }

        else if(keyCode == 80){
            if(countdown==0){
                if(!isPause){
                    toPause();
                }
                else {
                    toContinue();
                }
            }
        }
    }
}
