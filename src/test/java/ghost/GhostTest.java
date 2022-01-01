/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ghost;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GhostTest {
    @Test 
    public void constructorTest() {
        Game testGame = new Game(null, "testConf.json");
        assertNotNull(new Ghost(testGame,null,null,0));    
    }
    @Test
    public void GhostTest(){
        Game testGame = new Game(null, "testConf.json");
        Map mapTest = new Map(testGame);
        Waka wakaTest= new Waka(testGame);
        Ghost test = new Ghost(testGame,null,wakaTest,9);
        Ghost test1 = new Ghost(testGame,null,wakaTest,1);
        Ghost test2 = new Ghost(testGame,null,wakaTest,2);
        Ghost test3 = new Ghost(testGame,null,wakaTest,3);
        Ghost test4 = new Ghost(testGame,null,wakaTest,4);
        Ghost test5 = new Ghost(testGame,null,wakaTest,11);
        Ghost test6 = new Ghost(testGame,null,wakaTest,12);
        Ghost test7 = new Ghost(testGame,null,wakaTest,13);
        Ghost test8 = new Ghost(testGame,null,wakaTest,14);

        assertEquals(411,test.j_coordinate);   //test start location
        assertEquals(380,test.i_coordinate);   //test start location
        test.move();  
        assertEquals(411,test.j_coordinate);    //test move method in left current;
        assertEquals(378,test.i_coordinate);    //test move method in left current;
        test.current = Direction.RIGHT;
        test.move();
        assertEquals(411,test.j_coordinate);    //test move method in right current;
        assertEquals(380,test.i_coordinate);    //test move method in right direciton;
        test.current = Direction.UP;
        test.move();
        assertEquals(409,test.j_coordinate);    //test move method in up current;
        assertEquals(380,test.i_coordinate);    //test move method in up current;
        test.current = Direction.DOWN;
        test.move();
        assertEquals(411,test.j_coordinate);    //test move method in down current;
        assertEquals(380,test.i_coordinate);    //test move method in down current;
        test.current = Direction.UNDEFINE;
        test.move();
        assertEquals(411,test.j_coordinate);    //test move method empty current;
        assertEquals(380,test.i_coordinate);    //test move method empty current;


        /*

        Test ghost decision in 4 way intersection, ghost coordinate 380,411
        
        */
        assertEquals(411,test.j_coordinate);
        assertEquals(380,test.i_coordinate);

        test.current = Direction.RIGHT;
        test.ghostUseBrain(382,408);
        assertEquals(Direction.UP,test.current);

        test.current = Direction.RIGHT;
        test.ghostUseBrain(382,410);
        assertEquals(Direction.RIGHT,test.current);

        test.current = Direction.RIGHT;
        test.ghostUseBrain(382,412);
        assertEquals(Direction.RIGHT,test.current);


        test.current = Direction.RIGHT;
        test.ghostUseBrain(382,414);
        assertEquals(Direction.DOWN,test.current);


        test.current = Direction.RIGHT;
        test.ghostUseBrain(378,408);
        assertEquals(Direction.UP,test.current);

        test.current = Direction.RIGHT;
        test.ghostUseBrain(378,410);
        assertEquals(Direction.UP,test.current);

        test.current = Direction.RIGHT;
        test.ghostUseBrain(378,412);
        assertEquals(Direction.DOWN,test.current);

        test.current = Direction.RIGHT;
        test.ghostUseBrain(378,414);
        assertEquals(Direction.DOWN,test.current);
        /*

        Test ghost decision in 3 way intersection(1), ghost coordinate 44,43

        */
        assertEquals(43,test1.j_coordinate);
        assertEquals(44,test1.i_coordinate);

        test1.current = Direction.RIGHT;
        test1.ghostUseBrain(46,40);
        assertEquals(Direction.RIGHT,test1.current);

        test1.current = Direction.RIGHT;
        test1.ghostUseBrain(46,42);
        assertEquals(Direction.RIGHT,test1.current);

        test1.current = Direction.RIGHT;
        test1.ghostUseBrain(46,44);
        assertEquals(Direction.RIGHT,test1.current);


        test1.current = Direction.RIGHT;
        test1.ghostUseBrain(46,46);
        assertEquals(Direction.DOWN,test1.current);


        test1.current = Direction.RIGHT;
        test1.ghostUseBrain(42,40);
        assertEquals(Direction.RIGHT,test1.current);

        test1.current = Direction.RIGHT;
        test1.ghostUseBrain(42,42);
        assertEquals(Direction.DOWN,test1.current);

        test1.current = Direction.RIGHT;
        test1.ghostUseBrain(42,44);
        assertEquals(Direction.DOWN,test1.current);

        test1.current = Direction.RIGHT;
        test1.ghostUseBrain(42,46);
        assertEquals(Direction.DOWN,test1.current);


        test1.current = Direction.UP;
        test1.ghostUseBrain(46,40);
        assertEquals(Direction.RIGHT,test1.current);

        test1.current = Direction.UP;
        test1.ghostUseBrain(46,42);
        assertEquals(Direction.RIGHT,test1.current);

        test1.current = Direction.UP;
        test1.ghostUseBrain(46,44);
        assertEquals(Direction.RIGHT,test1.current);


        test1.current = Direction.UP;
        test1.ghostUseBrain(46,46);
        assertEquals(Direction.RIGHT,test1.current);


        test1.current = Direction.UP;
        test1.ghostUseBrain(42,40);
        assertEquals(Direction.LEFT,test1.current);

        test1.current = Direction.UP;
        test1.ghostUseBrain(42,42);
        assertEquals(Direction.LEFT,test1.current);

        test1.current = Direction.UP;
        test1.ghostUseBrain(42,44);
        assertEquals(Direction.LEFT,test1.current);

        test1.current = Direction.UP;
        test1.ghostUseBrain(42,46);
        assertEquals(Direction.LEFT,test1.current);



        test1.current = Direction.LEFT;
        test1.ghostUseBrain(46,40);
        assertEquals(Direction.LEFT,test1.current);

        test1.current = Direction.LEFT;
        test1.ghostUseBrain(46,42);
        assertEquals(Direction.DOWN,test1.current);

        test1.current = Direction.LEFT;
        test1.ghostUseBrain(46,44);
        assertEquals(Direction.DOWN,test1.current);


        test1.current = Direction.LEFT;
        test1.ghostUseBrain(46,46);
        assertEquals(Direction.DOWN,test1.current);


        test1.current = Direction.LEFT;
        test1.ghostUseBrain(42,40);
        assertEquals(Direction.LEFT,test1.current);

        test1.current = Direction.LEFT;
        test1.ghostUseBrain(42,42);
        assertEquals(Direction.LEFT,test1.current);

        test1.current = Direction.LEFT;
        test1.ghostUseBrain(42,44);
        assertEquals(Direction.LEFT,test1.current);

        test1.current = Direction.LEFT;
        test1.ghostUseBrain(42,46);
        assertEquals(Direction.DOWN,test1.current);
        /*

        Test ghost decision in 3 way intersection(2), ghost coordinate 108,43

        */
        assertEquals(43,test2.j_coordinate);
        assertEquals(108,test2.i_coordinate);

        test2.current = Direction.RIGHT;
        test2.ghostUseBrain(110,40);
        assertEquals(Direction.UP,test2.current);

        test2.current = Direction.RIGHT;
        test2.ghostUseBrain(110,42);
        assertEquals(Direction.UP,test2.current);

        test2.current = Direction.RIGHT;
        test2.ghostUseBrain(110,44);
        assertEquals(Direction.DOWN,test2.current);


        test2.current = Direction.RIGHT;
        test2.ghostUseBrain(110,46);
        assertEquals(Direction.DOWN,test2.current);


        test2.current = Direction.RIGHT;
        test2.ghostUseBrain(106,40);
        assertEquals(Direction.UP,test2.current);

        test2.current = Direction.RIGHT;
        test2.ghostUseBrain(106,42);
        assertEquals(Direction.UP,test2.current);

        test2.current = Direction.RIGHT;
        test2.ghostUseBrain(106,44);
        assertEquals(Direction.DOWN,test2.current);

        test2.current = Direction.RIGHT;
        test2.ghostUseBrain(106,46);
        assertEquals(Direction.DOWN,test2.current);


        test2.current = Direction.DOWN;
        test2.ghostUseBrain(110,40);
        assertEquals(Direction.LEFT,test2.current);

        test2.current = Direction.DOWN;
        test2.ghostUseBrain(110,42);
        assertEquals(Direction.DOWN,test2.current);

        test2.current = Direction.DOWN;
        test2.ghostUseBrain(110,44);
        assertEquals(Direction.DOWN,test2.current);


        test2.current = Direction.DOWN;
        test2.ghostUseBrain(110,46);
        assertEquals(Direction.DOWN,test2.current);


        test2.current = Direction.DOWN;
        test2.ghostUseBrain(106,40);
        assertEquals(Direction.LEFT,test2.current);

        test2.current = Direction.DOWN;
        test2.ghostUseBrain(106,42);
        assertEquals(Direction.LEFT,test2.current);

        test2.current = Direction.DOWN;
        test2.ghostUseBrain(106,44);
        assertEquals(Direction.LEFT,test2.current);

        test2.current = Direction.DOWN;
        test2.ghostUseBrain(106,46);
        assertEquals(Direction.DOWN,test2.current);



        test2.current = Direction.UP;
        test2.ghostUseBrain(110,40);
        assertEquals(Direction.UP,test2.current);

        test2.current = Direction.UP;
        test2.ghostUseBrain(110,42);
        assertEquals(Direction.UP,test2.current);

        test2.current = Direction.UP;
        test2.ghostUseBrain(110,44);
        assertEquals(Direction.UP,test2.current);


        test2.current = Direction.UP;
        test2.ghostUseBrain(110,46);
        assertEquals(Direction.LEFT,test2.current);


        test2.current = Direction.UP;
        test2.ghostUseBrain(106,40);
        assertEquals(Direction.UP,test2.current);

        test2.current = Direction.UP;
        test2.ghostUseBrain(106,42);
        assertEquals(Direction.LEFT,test2.current);

        test2.current = Direction.UP;
        test2.ghostUseBrain(106,44);
        assertEquals(Direction.LEFT,test2.current);

        test2.current = Direction.UP;
        test2.ghostUseBrain(106,46);
        assertEquals(Direction.LEFT,test2.current);
        /*

        Test ghost decision in 3 way intersection(3), ghost coordinate 156,43

        */
        assertEquals(43,test3.j_coordinate);
        assertEquals(156,test3.i_coordinate);

        test3.current = Direction.RIGHT;
        test3.ghostUseBrain(158,40);
        assertEquals(Direction.UP,test3.current);

        test3.current = Direction.RIGHT;
        test3.ghostUseBrain(158,42);
        assertEquals(Direction.RIGHT,test3.current);

        test3.current = Direction.RIGHT;
        test3.ghostUseBrain(158,44);
        assertEquals(Direction.RIGHT,test3.current);


        test3.current = Direction.RIGHT;
        test3.ghostUseBrain(158,46);
        assertEquals(Direction.RIGHT,test3.current);


        test3.current = Direction.RIGHT;
        test3.ghostUseBrain(154,40);
        assertEquals(Direction.UP,test3.current);

        test3.current = Direction.RIGHT;
        test3.ghostUseBrain(154,42);
        assertEquals(Direction.UP,test3.current);

        test3.current = Direction.RIGHT;
        test3.ghostUseBrain(154,44);
        assertEquals(Direction.UP,test3.current);

        test3.current = Direction.RIGHT;
        test3.ghostUseBrain(154,46);
        assertEquals(Direction.RIGHT,test3.current);



        test3.current = Direction.LEFT;
        test3.ghostUseBrain(158,40);
        assertEquals(Direction.UP,test3.current);

        test3.current = Direction.LEFT;
        test3.ghostUseBrain(158,42);
        assertEquals(Direction.UP,test3.current);

        test3.current = Direction.LEFT;
        test3.ghostUseBrain(158,44);
        assertEquals(Direction.UP,test3.current);


        test3.current = Direction.LEFT;
        test3.ghostUseBrain(158,46);
        assertEquals(Direction.LEFT,test3.current);


        test3.current = Direction.LEFT;
        test3.ghostUseBrain(154,40);
        assertEquals(Direction.UP,test3.current);

        test3.current = Direction.LEFT;
        test3.ghostUseBrain(154,42);
        assertEquals(Direction.LEFT,test3.current);

        test3.current = Direction.LEFT;
        test3.ghostUseBrain(154,44);
        assertEquals(Direction.LEFT,test3.current);

        test3.current = Direction.LEFT;
        test3.ghostUseBrain(154,46);
        assertEquals(Direction.LEFT,test3.current);



        test3.current = Direction.DOWN;
        test3.ghostUseBrain(158,40);
        assertEquals(Direction.RIGHT,test3.current);

        test3.current = Direction.DOWN;
        test3.ghostUseBrain(158,42);
        assertEquals(Direction.RIGHT,test3.current);

        test3.current = Direction.DOWN;
        test3.ghostUseBrain(158,44);
        assertEquals(Direction.RIGHT,test3.current);


        test3.current = Direction.DOWN;
        test3.ghostUseBrain(158,46);
        assertEquals(Direction.RIGHT,test3.current);


        test3.current = Direction.DOWN;
        test3.ghostUseBrain(154,40);
        assertEquals(Direction.LEFT,test3.current);

        test3.current = Direction.DOWN;
        test3.ghostUseBrain(154,42);
        assertEquals(Direction.LEFT,test3.current);

        test3.current = Direction.DOWN;
        test3.ghostUseBrain(154,44);
        assertEquals(Direction.LEFT,test3.current);

        test3.current = Direction.DOWN;
        test3.ghostUseBrain(154,46);
        assertEquals(Direction.LEFT,test3.current);
        /*

        Test ghost decision in 3 way intersection(4), ghost coordinate 204,43

        */
        assertEquals(43,test4.j_coordinate);
        assertEquals(204,test4.i_coordinate);

        test4.current = Direction.UP;
        test4.ghostUseBrain(206,40);
        assertEquals(Direction.UP,test4.current);

        test4.current = Direction.UP;
        test4.ghostUseBrain(206,42);
        assertEquals(Direction.RIGHT,test4.current);

        test4.current = Direction.UP;
        test4.ghostUseBrain(206,44);
        assertEquals(Direction.RIGHT,test4.current);


        test4.current = Direction.UP;
        test4.ghostUseBrain(206,46);
        assertEquals(Direction.RIGHT,test4.current);


        test4.current = Direction.UP;
        test4.ghostUseBrain(202,40);
        assertEquals(Direction.UP,test4.current);

        test4.current = Direction.UP;
        test4.ghostUseBrain(202,42);
        assertEquals(Direction.UP,test4.current);

        test4.current = Direction.UP;
        test4.ghostUseBrain(202,44);
        assertEquals(Direction.UP,test4.current);

        test4.current = Direction.UP;
        test4.ghostUseBrain(202,46);
        assertEquals(Direction.RIGHT,test4.current);


        test4.current = Direction.LEFT;
        test4.ghostUseBrain(206,40);
        assertEquals(Direction.UP,test4.current);

        test4.current = Direction.LEFT;
        test4.ghostUseBrain(206,42);
        assertEquals(Direction.UP,test4.current);

        test4.current = Direction.LEFT;
        test4.ghostUseBrain(206,44);
        assertEquals(Direction.DOWN,test4.current);


        test4.current = Direction.LEFT;
        test4.ghostUseBrain(206,46);
        assertEquals(Direction.DOWN,test4.current);


        test4.current = Direction.LEFT;
        test4.ghostUseBrain(202,40);
        assertEquals(Direction.UP,test4.current);

        test4.current = Direction.LEFT;
        test4.ghostUseBrain(202,42);
        assertEquals(Direction.UP,test4.current);

        test4.current = Direction.LEFT;
        test4.ghostUseBrain(202,44);
        assertEquals(Direction.DOWN,test4.current);

        test4.current = Direction.LEFT;
        test4.ghostUseBrain(202,46);
        assertEquals(Direction.DOWN,test4.current);


        test4.current = Direction.DOWN;
        test4.ghostUseBrain(206,40);
        assertEquals(Direction.RIGHT,test4.current);

        test4.current = Direction.DOWN;
        test4.ghostUseBrain(206,42);
        assertEquals(Direction.RIGHT,test4.current);

        test4.current = Direction.DOWN;
        test4.ghostUseBrain(206,44);
        assertEquals(Direction.RIGHT,test4.current);


        test4.current = Direction.DOWN;
        test4.ghostUseBrain(206,46);
        assertEquals(Direction.DOWN,test4.current);


        test4.current = Direction.DOWN;
        test4.ghostUseBrain(202,40);
        assertEquals(Direction.RIGHT,test4.current);

        test4.current = Direction.DOWN;
        test4.ghostUseBrain(202,42);
        assertEquals(Direction.DOWN,test4.current);

        test4.current = Direction.DOWN;
        test4.ghostUseBrain(202,44);
        assertEquals(Direction.DOWN,test4.current);

        test4.current = Direction.DOWN;
        test4.ghostUseBrain(202,46);
        assertEquals(Direction.DOWN,test4.current);
        /*

        Test ghost decision in 2 way intersection(1), ghost coordinate 44,507

        */
        assertEquals(507,test5.j_coordinate);
        assertEquals(44,test5.i_coordinate);

        test5.current = Direction.RIGHT;
        test5.ghostUseBrain(46,504);
        assertEquals(Direction.DOWN,test5.current);

        test5.current = Direction.RIGHT;
        test5.ghostUseBrain(46,506);
        assertEquals(Direction.DOWN,test5.current);

        test5.current = Direction.RIGHT;
        test5.ghostUseBrain(46,508);
        assertEquals(Direction.DOWN,test5.current);


        test5.current = Direction.RIGHT;
        test5.ghostUseBrain(46,510);
        assertEquals(Direction.DOWN,test5.current);


        test5.current = Direction.RIGHT;
        test5.ghostUseBrain(42,504);
        assertEquals(Direction.DOWN,test5.current);

        test5.current = Direction.RIGHT;
        test5.ghostUseBrain(42,506);
        assertEquals(Direction.DOWN,test5.current);

        test5.current = Direction.RIGHT;
        test5.ghostUseBrain(42,508);
        assertEquals(Direction.DOWN,test5.current);

        test5.current = Direction.RIGHT;
        test5.ghostUseBrain(42,510);
        assertEquals(Direction.DOWN,test5.current);


        test5.current = Direction.UP;
        test5.ghostUseBrain(46,504);
        assertEquals(Direction.LEFT,test5.current);

        test5.current = Direction.UP;
        test5.ghostUseBrain(46,506);
        assertEquals(Direction.LEFT,test5.current);

        test5.current = Direction.UP;
        test5.ghostUseBrain(46,508);
        assertEquals(Direction.LEFT,test5.current);


        test5.current = Direction.UP;
        test5.ghostUseBrain(46,510);
        assertEquals(Direction.LEFT,test5.current);


        test5.current = Direction.UP;
        test5.ghostUseBrain(42,504);
        assertEquals(Direction.LEFT,test5.current);

        test5.current = Direction.UP;
        test5.ghostUseBrain(42,506);
        assertEquals(Direction.LEFT,test5.current);

        test5.current = Direction.UP;
        test5.ghostUseBrain(42,508);
        assertEquals(Direction.LEFT,test5.current);

        test5.current = Direction.UP;
        test5.ghostUseBrain(42,510);
        assertEquals(Direction.LEFT,test5.current);
        /*

        Test ghost decision in 2 way intersection(2), ghost coordinate 108,507

        */
        assertEquals(507,test6.j_coordinate);
        assertEquals(108,test6.i_coordinate);

        test6.current = Direction.RIGHT;
        test6.ghostUseBrain(110,504);
        assertEquals(Direction.UP,test6.current);

        test6.current = Direction.RIGHT;
        test6.ghostUseBrain(110,506);
        assertEquals(Direction.UP,test6.current);

        test6.current = Direction.RIGHT;
        test6.ghostUseBrain(110,508);
        assertEquals(Direction.UP,test6.current);


        test6.current = Direction.RIGHT;
        test6.ghostUseBrain(106,510);
        assertEquals(Direction.UP,test6.current);


        test6.current = Direction.RIGHT;
        test6.ghostUseBrain(106,504);
        assertEquals(Direction.UP,test6.current);

        test6.current = Direction.RIGHT;
        test6.ghostUseBrain(106,506);
        assertEquals(Direction.UP,test6.current);

        test6.current = Direction.RIGHT;
        test6.ghostUseBrain(106,508);
        assertEquals(Direction.UP,test6.current);

        test6.current = Direction.RIGHT;
        test6.ghostUseBrain(106,510);
        assertEquals(Direction.UP,test6.current);


        test6.current = Direction.DOWN;
        test6.ghostUseBrain(110,504);
        assertEquals(Direction.LEFT,test6.current);

        test6.current = Direction.DOWN;
        test6.ghostUseBrain(110,506);
        assertEquals(Direction.LEFT,test6.current);

        test6.current = Direction.DOWN;
        test6.ghostUseBrain(110,508);
        assertEquals(Direction.LEFT,test6.current);


        test6.current = Direction.DOWN;
        test6.ghostUseBrain(110,510);
        assertEquals(Direction.LEFT,test6.current);


        test6.current = Direction.DOWN;
        test6.ghostUseBrain(106,504);
        assertEquals(Direction.LEFT,test6.current);

        test6.current = Direction.DOWN;
        test6.ghostUseBrain(106,506);
        assertEquals(Direction.LEFT,test6.current);

        test6.current = Direction.DOWN;
        test6.ghostUseBrain(106,508);
        assertEquals(Direction.LEFT,test6.current);

        test6.current = Direction.DOWN;
        test6.ghostUseBrain(106,510);
        assertEquals(Direction.LEFT,test6.current);
        /*

        Test ghost decision in 2 way intersection(3), ghost coordinate 156,507

        */
        assertEquals(507,test7.j_coordinate);
        assertEquals(156,test7.i_coordinate);

        test7.current = Direction.DOWN;
        test7.ghostUseBrain(158,504);
        assertEquals(Direction.RIGHT,test7.current);

        test7.current = Direction.DOWN;
        test7.ghostUseBrain(158,506);
        assertEquals(Direction.RIGHT,test7.current);

        test7.current = Direction.DOWN;
        test7.ghostUseBrain(158,508);
        assertEquals(Direction.RIGHT,test7.current);


        test7.current = Direction.DOWN;
        test7.ghostUseBrain(158,510);
        assertEquals(Direction.RIGHT,test7.current);


        test7.current = Direction.DOWN;
        test7.ghostUseBrain(154,504);
        assertEquals(Direction.RIGHT,test7.current);

        test7.current = Direction.DOWN;
        test7.ghostUseBrain(154,506);
        assertEquals(Direction.RIGHT,test7.current);

        test7.current = Direction.DOWN;
        test7.ghostUseBrain(154,508);
        assertEquals(Direction.RIGHT,test7.current);

        test7.current = Direction.DOWN;
        test7.ghostUseBrain(154,510);
        assertEquals(Direction.RIGHT,test7.current);

        test7.current = Direction.LEFT;
        test7.ghostUseBrain(158,504);
        assertEquals(Direction.UP,test7.current);

        test7.current = Direction.LEFT;
        test7.ghostUseBrain(158,506);
        assertEquals(Direction.UP,test7.current);

        test7.current = Direction.LEFT;
        test7.ghostUseBrain(158,508);
        assertEquals(Direction.UP,test7.current);


        test7.current = Direction.LEFT;
        test7.ghostUseBrain(158,510);
        assertEquals(Direction.UP,test7.current);


        test7.current = Direction.LEFT;
        test7.ghostUseBrain(154,504);
        assertEquals(Direction.UP,test7.current);

        test7.current = Direction.LEFT;
        test7.ghostUseBrain(154,506);
        assertEquals(Direction.UP,test7.current);

        test7.current = Direction.LEFT;
        test7.ghostUseBrain(154,508);
        assertEquals(Direction.UP,test7.current);

        test7.current = Direction.LEFT;
        test7.ghostUseBrain(154,510);
        assertEquals(Direction.UP,test7.current);
        /*

        Test ghost decision in 2 way intersection(4), ghost coordinate 204,507

        */
        assertEquals(507,test8.j_coordinate);
        assertEquals(204,test8.i_coordinate);

        test8.current = Direction.UP;
        test8.ghostUseBrain(206,504);
        assertEquals(Direction.RIGHT,test8.current);

        test8.current = Direction.UP;
        test8.ghostUseBrain(206,506);
        assertEquals(Direction.RIGHT,test8.current);

        test8.current = Direction.UP;
        test8.ghostUseBrain(206,508);
        assertEquals(Direction.RIGHT,test8.current);


        test8.current = Direction.UP;
        test8.ghostUseBrain(206,510);
        assertEquals(Direction.RIGHT,test8.current);

        test8.current = Direction.UP;
        test8.ghostUseBrain(202,504);
        assertEquals(Direction.RIGHT,test8.current);

        test8.current = Direction.UP;
        test8.ghostUseBrain(202,506);
        assertEquals(Direction.RIGHT,test8.current);

        test8.current = Direction.UP;
        test8.ghostUseBrain(202,508);
        assertEquals(Direction.RIGHT,test8.current);

        test8.current = Direction.UP;
        test8.ghostUseBrain(202,510);
        assertEquals(Direction.RIGHT,test8.current);


        test8.current = Direction.LEFT;
        test8.ghostUseBrain(206,504);
        assertEquals(Direction.DOWN,test8.current);

        test8.current = Direction.LEFT;
        test8.ghostUseBrain(206,506);
        assertEquals(Direction.DOWN,test8.current);

        test8.current = Direction.LEFT;
        test8.ghostUseBrain(206,508);
        assertEquals(Direction.DOWN,test8.current);


        test8.current = Direction.LEFT;
        test8.ghostUseBrain(206,510);
        assertEquals(Direction.DOWN,test8.current);

        test8.current = Direction.LEFT;
        test8.ghostUseBrain(202,504);
        assertEquals(Direction.DOWN,test8.current);

        test8.current = Direction.LEFT;
        test8.ghostUseBrain(202,506);
        assertEquals(Direction.DOWN,test8.current);

        test8.current = Direction.LEFT;
        test8.ghostUseBrain(202,508);
        assertEquals(Direction.DOWN,test8.current);

        test8.current = Direction.LEFT;
        test8.ghostUseBrain(202,510);
        assertEquals(Direction.DOWN,test8.current);

        test8.current = Direction.UNDEFINE;
        test8.ghostUseBrain(202,510);
        assertEquals(Direction.UNDEFINE,test8.current);

    }
    /*

        Test ghost current target corner for scatter mode

    */
    //@Test
   /* public void GhostTargetCornerTest(){
        Game testGame = new Game(null, "testMap.txt");
        Map mapTest = new Map(testGame);
        Waka wakaTest= new Waka(testGame);
        Ghost test = new Ghost(testGame,null,wakaTest,5);

        test.i_coordinate = 40;          // set new ghoost location   
        test.j_coordinate = 40;       
        assertEquals(0,test.target_corner_i);   //check new target corner
        assertEquals(0,test.target_corner_j);

        test.i_coordinate = 300;        // set new ghoost location
        test.j_coordinate = 40;
        assertEquals(447, test.target_corner_i);
        assertEquals(0, test.target_corner_j);
        test.i_coordinate = 40;         // set new ghoost location
        test.j_coordinate = 300;
        assertEquals(0,test.target_corner_i);
        assertEquals(575,test.target_corner_j);  //check new target corner
        test.i_coordinate = 300;        // set new ghoost location
        test.j_coordinate = 300;
        assertEquals(447,test.target_corner_i); //check new target corner
        assertEquals(575,test.target_corner_j);
    }*/
        /*

        Test intersection check

        */ 
   @Test
    public void checkIntersectionTest(){
        Game testGame = new Game(null, "testConf.json");
        Map mapTest = new Map(testGame);
        Waka wakaTest= new Waka(testGame);
        Ghost test = new Ghost(testGame,null,wakaTest,9);
        Ghost test1 = new Ghost(testGame,null,wakaTest,11);
        Ghost test2 = new Ghost(testGame,null,wakaTest,12);
        Ghost test3 = new Ghost(testGame,null,wakaTest,13);
        Ghost test4 = new Ghost(testGame,null,wakaTest,14);

        test.current = Direction.RIGHT;
        assertTrue(test.checkIntersection());
        test.i_coordinate++;
        assertFalse(test.checkIntersection());
        test.i_coordinate--;
        test.current = Direction.LEFT;
        assertTrue(test.checkIntersection());
        test.i_coordinate++;
        assertFalse(test.checkIntersection());
        test.i_coordinate--;
        test.current = Direction.UP;
        assertTrue(test.checkIntersection());
        test.j_coordinate++;
        assertFalse(test.checkIntersection());
        test.j_coordinate--;
        test.current = Direction.DOWN;
        assertTrue(test.checkIntersection());
        test.j_coordinate++;
        assertFalse(test.checkIntersection());
        test.j_coordinate--;

        test1.current =Direction.RIGHT;
        assertTrue(test1.checkIntersection());
        test2.current =Direction.DOWN;
        assertTrue(test2.checkIntersection());
        test3.current =Direction.LEFT;
        assertTrue(test3.checkIntersection());
        test4.current =Direction.UP;
        assertTrue(test4.checkIntersection());

        test1.current =Direction.UP;
        assertTrue(test1.checkIntersection());
        test2.current =Direction.RIGHT;
        assertTrue(test2.checkIntersection());
        test3.current =Direction.DOWN;
        assertTrue(test3.checkIntersection());
        test4.current =Direction.LEFT;
        assertTrue(test4.checkIntersection());

        test4.current = Direction.UNDEFINE;
        assertFalse(test4.checkIntersection());  //invalid current, otherwise return false
    }
   @Test
    public void stunTest(){
        Game testGame = new Game(null, "testConf.json");
        Map mapTest = new Map(testGame);
        Waka wakaTest= new Waka(testGame);
        Ghost test = new Ghost(testGame,null,wakaTest,9);
        test.stun();
        assertEquals(300, test.stun_duration);  
    }
   @Test
    public void setTargetTest(){
        Game testGame = new Game(null, "testConf.json");
        Map mapTest = new Map(testGame);
        Waka wakaTest= new Waka(testGame);
        Ghost test = new Ghost(testGame,null,wakaTest,9); 
        test.current = Direction.DOWN;
        assertEquals(411,test.j_coordinate);
        assertEquals(380,test.i_coordinate);
        test.mode =GhostMode.CHASE;
        test.action();
        assertEquals(411,test.j_coordinate);
        assertEquals(378,test.i_coordinate); 
        test.action();
        assertEquals(411,test.j_coordinate);
        assertEquals(376,test.i_coordinate); 
        test.i_coordinate =380;
        test.current = Direction.DOWN;
        test.mode =GhostMode.SCATTER;
        test.action();
        assertEquals(411,test.j_coordinate);
        assertEquals(378,test.i_coordinate); 
        test.action();
        assertEquals(411,test.j_coordinate);
        assertEquals(376,test.i_coordinate); 
        test.mode = GhostMode.UNDEFINE;
        test.action();
        assertEquals(411,test.j_coordinate);
        assertEquals(376,test.i_coordinate); 

        test.j_coordinate =411;
        test.i_coordinate =380;
        test.stun_duration =10;
        test.current = Direction.DOWN;
        test.mode =GhostMode.FRIGHTENED;
        test.action();
        test.frightened_duration = 1;
        test.action();
        test.mode =GhostMode.FRIGHTENED;

        //assertEquals(411,test.j_coordinate);
        test.stun_duration =1;
        test.action();
        assertEquals(GhostMode.FRIGHTENED,test.mode);  
        test.mode =GhostMode.FROZEN;
        test.action();
        test.mode =GhostMode.FROZEN;

        test.tick();


    }
        /*

        Test ghost vibrate method

        */
    @Test
    public void vibrateTest(){
        Game testGame = new Game(null, "testConf.json");
        Map mapTest = new Map(testGame);
        Waka wakaTest= new Waka(testGame);
        Ghost test = new Ghost(testGame,null,wakaTest,9);     
        test.current = Direction.LEFT;
        test.vibrate();
        assertEquals(411,test.j_coordinate);
        assertEquals(378,test.i_coordinate); 
        test.current = Direction.RIGHT;
        test.vibrate();
        assertEquals(411,test.j_coordinate);
        assertEquals(380,test.i_coordinate); 
        test.current = Direction.UP;
        test.vibrate();
        assertEquals(409,test.j_coordinate);
        assertEquals(380,test.i_coordinate); 
        test.current = Direction.DOWN;
        test.vibrate();
        assertEquals(411,test.j_coordinate);
        assertEquals(380,test.i_coordinate); 
        test.current = Direction.UNDEFINE;
        test.vibrate();
        assertEquals(411,test.j_coordinate); 
        assertEquals(380,test.i_coordinate); 
    }
        /*

        Test reset method

        */
    @Test
    public void resetTest(){
        Game testGame = new Game(null, "testConf.json");
        Map mapTest = new Map(testGame);
        Waka wakaTest= new Waka(testGame);
        Ghost test = new Ghost(testGame,null,wakaTest,9);     
        test.current = Direction.LEFT;
        test.i_coordinate = 0;  // change coordinate
        test.j_coordinate = 0;  // change coordinate
        test.resetLocation();   //  reset coordinate
        assertEquals(411,test.j_coordinate);  // check whether coordiante is reset
        assertEquals(380,test.i_coordinate);  // check whether coordiante is reset
    }
    @Test
    public void tickTest(){
        Game testGame = new Game(null, "testConf.json");
        Map mapTest = new Map(testGame);
        Waka wakaTest= new Waka(testGame);
        Ghost test = new Ghost(testGame,null,wakaTest,9);
        testGame.countdown =0;
        test.tick();
        assertEquals(test.ghost,test.sprite);  // check whether sprite is correct
        test.mode = GhostMode.FRIGHTENED;
        test.tick();
        assertEquals(testGame.frightened,test.sprite);  // check whether sprite is correct
    }

    @Test
    public void tickDebugLineTest(){
        Game testGame = new Game(null, "testConf.json");
        Map mapTest = new Map(testGame);
        Waka wakaTest= new Waka(testGame);
        Ghost test = new Ghost(testGame,null,wakaTest,9); 
        testGame.isDebugMode = true;
        testGame.countdown = 0;
        test.mode = GhostMode.SCATTER;
        test.tickDebugLine();
        test.mode = GhostMode.CHASE;
        test.tickDebugLine();
        test.mode = GhostMode.UNDEFINE;
        test.tickDebugLine();
        test.isAlive = false;
        test.tickDebugLine();
        testGame.endingTimer = 100;
        test.tickDebugLine();
    }

}
