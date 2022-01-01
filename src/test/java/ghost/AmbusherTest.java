/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ghost;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AmbusherTest {

    @Test
    public void AmbusherTest(){
        Game testGame = new Game(null, "testConf.json");
        Map mapTest = new Map(testGame);
        Waka wakaTest= new Waka(testGame);
        Ghost ambusher = new Ambusher(testGame,null,wakaTest,8);
        ambusher.target1.i_coordinate = 100;
        ambusher.target1.j_coordinate = 100;
        ambusher.mode = GhostMode.CHASE;
        ambusher.target1.current = Direction.RIGHT; // test target moving right
        ambusher.chase();
        assertEquals(164,ambusher.target_location_i);
        ambusher.target1.current = Direction.UP;
        ambusher.chase();
        assertEquals(36,ambusher.target_location_j);// test target moving up
        ambusher.target1.current = Direction.DOWN;
        ambusher.chase();
        assertEquals(164,ambusher.target_location_j); // test target moving down
        ambusher.target1.current = Direction.UNDEFINE;
        ambusher.chase();
        ambusher.target_location_i = -10;
        ambusher.chase();
        ambusher.target_location_j = -10;
        ambusher.chase();    
        ambusher.target_location_i = 500;
        ambusher.chase();
        ambusher.target_location_j = 600;
        ambusher.chase();    
        assertEquals(575,ambusher.target_location_j); // test target ount of bound
        assertEquals(447,ambusher.target_location_i); // test target ount of bound

    }
}