package ghost;
import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import processing.core.PImage;
import processing.core.PApplet;
/**
* Represent Map in Waka game.
* <p>Instance have a movePath, remaining amount of fruit, remaining amount of berry,
* image of walls, list of fruits, list of berrys.
*/
public class Map {


	protected byte[][] map = new byte [36][28];
	protected boolean[][] movePath = new boolean[576][448];
	protected int remaining_fruit;
	protected int remaining_berry;
	protected int total_fruit;
	protected PImage[][] sprite = new PImage [36][28];
	protected Game game;
	protected List<Fruit> allFruits = new ArrayList<Fruit>();
	protected List<SuperFruit> allSuperFruits = new ArrayList<SuperFruit>();

	protected List<Berry> allBerrys= new ArrayList<Berry>(); 

	protected String mapReading = "";
	protected HashMap<Integer, Character> ghosts = new HashMap<Integer, Character>();

	/**
	* Map constructor
	*<p> Read map_file.
	*<br> Build array of map.
	*<br> Build movealbe path.
	*<br> Create fruits object.
	*<br> Create berry obeject.
	*<br> Set totalFruit.
	*@param game reference of Game.
	*/
	public Map(Game game) {
		this.game = game;

		this.readMap(game.map_file);
		this.buildMap();
		this.buildPath();
 		this.setFruits();
 		this.setSuperFruits();
		this.setBerrys();
		this.total_fruit = remaining_fruit;

	}
	/**
	* Read map file and store it.
	*<p> Read map file.
	*<br> Store the reading in mapReading.
	*@param map_file name of map file.
	*/
	public void readMap(String map_file) {
		File f = new File(map_file);
		try{
			Scanner scan = new Scanner(f);
			String line;
			while(scan.hasNextLine()) {
				line = scan.nextLine();
				mapReading += line;
			}	 
		} catch (FileNotFoundException e) {
			return;
		}
	}
	/**
	* Build 2D array of map sprite from mapReading
	*<p> If reading is 0,9,p,a,c,i,w sprite element is empty.
	*<br>Else if reading is 1 sprite element is horizontal.
	*<br>Else if reading is 2 sprite element is vertical.
	*<br>Else if reading is 3 sprite element is upLeft.
	*<br>Else if reading is 4 sprite element is upRight.
	*<br>Else if reading is 5 sprite element is downLeft.
	*<br>Else if reading is 6 sprite element is downRight.
	*<br>Else if reading is 7 sprite element is empty, increment remaining fruit by 1. 
	*<br>Else if reading is 8 sprite element is empty, increment remaining fruit by 1.
	*/

	public void buildMap() {
		int map_row = 0;
		int map_column = 0;
		Integer ghost_counter = 0;
		for(char x: mapReading.toCharArray()){
			if( x == '0'){ 
				this.map[map_row][map_column] = 0;
				sprite[map_row][map_column] = game.empty;

			}
			else if ( x == '1') {
				this.map[map_row][map_column] = 1;
				sprite[map_row][map_column] = game.horizontal;

			}
			else if ( x == '2') {
				this.map[map_row][map_column] = 2;
				sprite[map_row][map_column] = game.vertical;


			}
			else if ( x == '3') {
				this.map[map_row][map_column] = 3;
				sprite[map_row][map_column] = game.upLeft;

			}
			else if ( x == '4') {
				this.map[map_row][map_column] = 4;
				sprite[map_row][map_column] = game.upRight;

			}
			else if ( x == '5') {
				this.map[map_row][map_column] = 5;
				sprite[map_row][map_column] = game.downLeft;

			}
			else if ( x == '6') {
				this.map[map_row][map_column] = 6;
				sprite[map_row][map_column] = game.downRight;

			}
			else if ( x == '7') {
				this.map[map_row][map_column] = 7;
				this.remaining_fruit++;
				sprite[map_row][map_column] = game.empty;

			}
			else if ( x == '8') {
				this.map[map_row][map_column] = 7;
				this.remaining_fruit++;
				sprite[map_row][map_column] = game.empty;


			}
			else if ( x == '9') {
				this.map[map_row][map_column] = 0;
				this.remaining_berry++;
				sprite[map_row][map_column] = game.empty;


			}
			else if ( x == 'p') {
				this.map[map_row][map_column] = 0;
				sprite[map_row][map_column] = game.empty;

			}
			else if ( x == 'a') {
				this.map[map_row][map_column] = 0;
				ghosts.put(ghost_counter++, 'a');
				sprite[map_row][map_column] = game.empty;

			}
			else if ( x == 'c') {
				this.map[map_row][map_column] = 0;
				ghosts.put(ghost_counter++, 'c');
				sprite[map_row][map_column] = game.empty;

			}
			else if ( x == 'i') {
				this.map[map_row][map_column] = 0;
				ghosts.put(ghost_counter++, 'i');
				sprite[map_row][map_column] = game.empty;

			}
			else if ( x == 'w') {
				this.map[map_row][map_column] = 0;
				ghosts.put(ghost_counter++, 'w');
				sprite[map_row][map_column] = game.empty;

			}
			map_column++;
			if (map_column == 28){
				map_column = 0;
				map_row++;
			}
		}
	}
	/**
	* Build boolean 2D array of path
	*<p> Parse 2D int map array to 2D boolean array of path.
	*/
	public void buildPath() {
		int start = 0;
		int end = 0;


		boolean previous = false;
		// horizontal path
		for(int i = 1; i< 36; i++){
			for(int j=1; j < 28; j++){
				if (previous == true){
					if (this.map[i][j] == 0 || this.map[i][j]== 7){
						previous = true;
					}
					else {
						end = j-1;
						for (int k = start*16-4; k < end*16-3 ; k++){
							this.movePath[i*16-5][k] = true;
						}
						previous = false;
					}

				}
				else if (this.map[i][j] == 0 || this.map[i][j]== 7){
					start = j;
					previous = true;
				}

			}
		}
		// vertical path
		for(int j = 1; j< 28; j++){
			for(int i=1; i < 36; i++){
				if (previous == true){
					if (this.map[i][j] == 0 || this.map[i][j]== 7){
						previous = true;
					}
					else {
						end = i-1;
						for (int k = start*16-5; k < end*16-4 ; k++){
							this.movePath[k][j*16-4] = true;
						}
						previous = false;
					}

				}
				else if (this.map[i][j] == 0 || this.map[i][j]== 7){
					start = i;
					previous = true;
				}

			}
		}

	}
	/**
	* Create fruit object from mapReading
	*/
	public void setFruits() {
		int map_row = 0;
		int map_column = 0;
		for(char x: mapReading.toCharArray()){
			if( x == '7'){ 
				Fruit newFruit = new Fruit(map_column, map_row, game);
				allFruits.add(newFruit);
			}
			map_column++;
			if (map_column == 28){
				map_column = 0;
				map_row++;
			}
		}
	}
	/**
	* Create Superfruit object from mapReading
	*/	
	public void setSuperFruits() {
		int map_row = 0;
		int map_column = 0;
		for(char x: mapReading.toCharArray()){
			if( x == '8'){ 
				SuperFruit newSuperFruit = new SuperFruit(map_column, map_row, game);
				allSuperFruits.add(newSuperFruit);
			}
			map_column++;
			if (map_column == 28){
				map_column = 0;
				map_row++;
			}
		}
	}
	/**
	* Create berry object from mapReading
	*/	
	public void setBerrys() {
		int map_row = 0;
		int map_column = 0;
		for(char x: mapReading.toCharArray()){
			if( x == '9'){ 
				Berry newBerry = new Berry(map_column, map_row, game);
				allBerrys.add(newBerry);
			}
			map_column++;
			if (map_column == 28){
				map_column = 0;
				map_row++;
			}
		}
	}
	/**
	* Getter method for list of berry
	* @return allBerrys
	*/	
	public List<Berry> getAllBerrys() {
		return this.allBerrys;
	}
	/**
	* Getter method for list of fruits
	* @return allFruits
	*/	
	public List<Fruit> getAllFruits() {
		return this.allFruits;
	}
	/**
	* Getter method for list of superffruit
	* @return allSuperFruits
	*/	
	public List<SuperFruit> getAllSuperFruits() {
		return this.allSuperFruits;
	}
	/**
	* Getter method player i location
	* @return player i location
	*/	
	public int  getPlayerIStartLocation() {
		int map_row = 0;
		int map_column = 0;
		for(char x: mapReading.toCharArray()){
			if( x == 'p'){ 
				return map_column;
			}
			map_column++;
			if (map_column == 28){
				map_column = 0;
				map_row++;
			}
		}
		return 0;
	}
	/**
	* Getter method player j location
	* @return player j location
	*/	
	public int getPlayerJStartLocation() {
		int map_row = 0;
		int map_column = 0;
		for(char x: mapReading.toCharArray()){
			if( x == 'p'){ 
				return map_row;
			}
			map_column++;
			if (map_column == 28){
				map_column = 0;
				map_row++;
			}
		}
		return 0;
	}
	/**
	* Getter method for total amout of ghost
	* @return ghost size
	*/	
	public int getTotalGhost(){
		return ghosts.size();
	}
	/**
	* Getter method for ghost i start location
	* @param ghostNumber number of ghost
	* @return ghost i location
	*/	
	public int getGhostIStartLocation(int ghostNumber) {
		int map_row = 0;
		int map_column = 0;
		int ghost_count = 1;
		for(char x: mapReading.toCharArray()){
			if( x == 'a' || x== 'c' || x == 'i'|| x== 'w'){ 
				if (ghost_count == ghostNumber){
					return map_column;
				}
				else {
					ghost_count++;
				}
			}
			map_column++;
			if (map_column == 28){
				map_column = 0;
				map_row++;
			}
		}
		return 0;
	}
	/**
	* Getter method for ghost j start location
	* @param ghostNumber number of ghost
	* @return ghost j location
	*/		
	public int getGhostJStartLocation(int ghostNumber) {
		int map_row = 0;
		int map_column = 0;
		int ghost_count =1;
		for(char x: mapReading.toCharArray()){
			if( x == 'a' || x== 'c' || x == 'i'|| x== 'w'){ 
				if (ghost_count == ghostNumber){
					return map_row;
				}
				else {
					ghost_count++;
				}
			}
			map_column++;
			if (map_column == 28){
				map_column = 0;
				map_row++;
			}
		}
		return 0;
	}

}