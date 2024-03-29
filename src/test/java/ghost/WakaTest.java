/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ghost;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WakaTest {
    @Test 
    public void constructorTest() {
        Game testGame = new Game(null, "testConf.json");
        assertNotNull(new Waka(testGame));    
    }
    @Test
    public void wakaTest(){
        Game testGame = new Game(null, "testConf.json");
        Waka test  = new Waka(testGame);
        assertEquals(2,test.moveSpeed);

        assertEquals(411,test.j_coordinate);
        assertEquals(204,test.i_coordinate);

        assertTrue(test.checkUp());                  //test valid checkUp method
        assertTrue(test.checkDown());                //test valid checkDown method 
        assertTrue(test.checkLeft());                //test valid checkLeft method
        assertTrue(test.checkRight());               //test valid checkRight method
        test.moveRight();                  
        assertEquals(411,test.j_coordinate);   //test moveRight method
        assertEquals(206,test.i_coordinate);   //test moveRight method
        assertEquals(411,test.start_j);        //test start location j
        assertEquals(204,test.start_i);        //test start location i
        test.moveUp();
        assertFalse(test.checkUp());                //test invalid checkUp method
        assertFalse(test.checkDown());              //test invalid checkDown method

        assertEquals(411,test.j_coordinate);   //test invalid moveUp method
        assertEquals(206,test.i_coordinate);   //test invalid moveUp method
        test.moveDown(); 
        assertEquals(411,test.j_coordinate);   //test invalid moveDown method
        assertEquals(206,test.i_coordinate);   //test invalid moveDown method

        test.moveLeft();
        assertEquals(411,test.j_coordinate);   //test moveLeft method
        assertEquals(204,test.i_coordinate);   //test moveLeft method
        test.moveUp();
        assertEquals(409,test.j_coordinate);   //test moveUp methid
        assertEquals(204,test.i_coordinate);   //test moveUp method
        test.moveLeft();
        assertFalse(test.checkLeft());         //test invalid checkLeft method
        assertFalse(test.checkRight());        //test invalid checkRight method
        assertEquals(409,test.j_coordinate);   //test invalid moveLeft method
        assertEquals(204,test.i_coordinate);   //test invalid moveLeft method 
        test.moveRight();
        assertEquals(409,test.j_coordinate);   //test invalid moveRight method
        assertEquals(204,test.i_coordinate);   //test invalid moveRight method
        test.moveDown();
        assertEquals(411,test.j_coordinate);   //test moveDown method
        assertEquals(204,test.i_coordinate);   //test moveDown method
        test.moveRight();
        test.moveRight();
        test.moveRight();
        test.current = Direction.RIGHT;
        test.resetLocation();
        assertEquals(Direction.LEFT, test.current);   //test resetLocation method
        assertEquals(411,test.j_coordinate);    //test resetLocation method
        assertEquals(204,test.i_coordinate);    //test resetLocation method
        test.collectBerry();
        test.collectBerry();
        assertEquals(2,test.berryLeft);        // test coolectBerry method
        test.useBerry();
        assertEquals(1,test.berryLeft);        // test useBerry method
        test.collectBerry();
        test.resetBerry();
        assertEquals(0,test.berryLeft);        //test resetBerry method
        test.livesLeft = 20;
        test.resetLives();
        assertEquals(10,test.livesLeft);         //test resetLife method
        test.setDirectionNext(Direction.UP);
        assertEquals(Direction.UP,test.next);  //test setDeirectionNext method
    }
    @Test
    public void tickTest(){
        Game testGame = new Game(null, "testConf.json");
        Waka test  = new Waka(testGame);
        testGame.isPause = true;
        testGame.countdown = 0;
         test.save = Direction.RIGHT;
        test.tick();
        assertEquals(testGame.playerRight,test.sprite);        //test wheter sprite change afte tick()

        test.save = Direction.LEFT;
        test.tick();
        assertEquals(testGame.playerLeft,test.sprite);        //test wheter sprite change afte tick()

         test.save = Direction.UP;
        test.tick();
        assertEquals(testGame.playerUp,test.sprite);        //test wheter sprite change afte tick()

         test.save = Direction.DOWN;
        test.tick();
        assertEquals(testGame.playerDown,test.sprite);        //test wheter sprite change afte tick()

         test.save = Direction.UNDEFINE;
        test.tick();
        assertEquals(testGame.playerDown,test.sprite);        //test wheter sprite change afte tick()

    }
}
