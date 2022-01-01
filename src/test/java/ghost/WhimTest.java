/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ghost;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WhimTest {

    @Test
    public void WhimTest(){
        Game testGame = new Game(null, "testConf.json");
        Map mapTest = new Map(testGame);
        Waka wakaTest= new Waka(testGame);
        Ghost whim = new Whim(testGame,null,wakaTest,8);
        whim.i_coordinate = 100;
        whim.j_coordinate = 100;
        whim.mode = GhostMode.CHASE;
        whim.target1.current = Direction.RIGHT;
        whim.chase();
        whim.target1.current = Direction.UP;
        whim.chase();
        whim.target1.current = Direction.DOWN;
        whim.chase();
        whim.target1.current = Direction.UNDEFINE; 
        whim.chase();
        whim.target_location_i = 500;
        whim.chase();
        assertEquals(447,whim.target_location_i); //Test target out of bound
        whim.target_location_i = -5;
        whim.chase();
        assertEquals(0,whim.target_location_i); //Test target out of bound
        whim.target_location_j = -5;
        whim.chase();
        assertEquals(0,whim.target_location_j); //Test target out of bound

        for (Ghost x: testGame.chasers){
            x.isAlive = false;
        }
        whim.chase();

    }
}
