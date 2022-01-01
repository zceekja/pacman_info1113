/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ghost;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IgnorantTest {

    @Test
    public void IgnorantTest(){
        Game testGame = new Game(null, "testConf.json");
        Map mapTest = new Map(testGame);
        Waka wakaTest= new Waka(testGame);
        Ghost ignorant = new Ignorant(testGame,null,wakaTest,8);
        ignorant.i_coordinate = 100;
        ignorant.j_coordinate = 100;
        ignorant.mode = GhostMode.CHASE;
        ignorant.chase();
        assertEquals(0, ignorant.target_location_i);  // test target more than 8 unit
        assertEquals(575,ignorant.target_location_j);  // test target more than 8 unit
        ignorant.target1.i_coordinate =110;
        ignorant.target1.j_coordinate = 110;
        ignorant.chase();
        assertEquals(110, ignorant.target_location_i);  // test target less than 8 unit
        assertEquals(110,ignorant.target_location_j); // test target less than 8 unit
    }
}