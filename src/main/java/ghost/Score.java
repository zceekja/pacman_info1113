package ghost;
import processing.core.PImage;
/**
* Represent Score in Waka game.
*/
public class Score {

    protected PImage[] scoreDisplay = new PImage[6];;
    protected int score;
    protected Game game;

    boolean type;

    /**
    * Score constructor.
    *<p> Set type of score
    */
    public Score(Game game, boolean typeOfScore) {
        this.game = game;

        type = typeOfScore;

    }
    /**
    * Handle score sprite logic
    *<p> set image array of scoreDisplay according to score.
    */
    public void tick(){
        if (type){
            score = game.currentScore;
        }
        else{
            score = game.highScore;
        } 
        int digits = 0;
        while (digits < 6) {
            if (game.endingTimer > 0){
                scoreDisplay[digits] = game.empty;
            }
            else if (score == 0){
                scoreDisplay[digits] = game.empty;
            }
            else if (score%10 == 0){
                scoreDisplay[digits] = game.number0;
            }
            else if (score%10 == 1){
                scoreDisplay[digits] = game.number1;
            }
            else if (score%10 == 2){
                scoreDisplay[digits] = game.number2;
            }
            else if (score%10 == 3){
                scoreDisplay[digits] = game.number3;
            }
            else if (score%10 == 4){
                scoreDisplay[digits] = game.number4;
            }
            else if (score%10 == 5){
                scoreDisplay[digits] = game.number5;
            }
            else if (score%10 == 6){
                scoreDisplay[digits] = game.number6;
            }
            else if (score%10 == 7){
                scoreDisplay[digits] = game.number7;
            }
            else if (score%10 == 8){
                scoreDisplay[digits] = game.number8;
            }
            else {
                scoreDisplay[digits] = game.number9;
            }
            digits++;
            score = (score - score%10 )/10;
        }
    }
}