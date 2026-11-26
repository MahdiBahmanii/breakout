package breakout.controller;
import breakout.config.constants;
import breakout.model.*;
public class game_engine {
    private int lives;
    int score;
    bricks bricks=new bricks();
    ball ball=new ball();        
    paddle paddle=new paddle();
    public game_engine() {
        score=0;
        lives=3;
    }
    public void update(){
        if(game_over()){
            return;
        }
        ball.update_position();
        ball.hitx();
        ball.hity();
        if (paddle.paddle_hit(ball.getX(), ball.getY(), ball.getd())) {
            double offset = ball.paddle_offset(paddle.getX(), paddle.getwidth());
            ball.bounce_paddle(offset);
            ball.place_above_paddle(paddle.getY());
        }
        if(ball_out(ball.getY())){
            paddle.reset_paddle();
            ball.reset_ball();
            lives=lives-1;
            return;
        }
        boolean hit=false;
        for(int i=0;i<5&&!hit;i++){
            for(int j=0;j<8;j++){
                if(bricks.getBricks()[i][j].isactive()){
                    if(bricks.getBricks()[i][j].check(ball.getX(),ball.getY(),ball.getd())){
                        ball.sb_brick(bricks.getBricks()[i][j].getoverlapX(),bricks.getBricks()[i][j].getoverlapY());
                        bricks.getBricks()[i][j].destroy();
                        score=score+100;
                        hit=true;
                        break;
                    }
                }
            }

        }

    }
    public boolean ball_out(double by){
        if(by>=constants.WIDOW_HEIGHT){
            return true;
        }
        else{
            return false;                
        }
    }    
    public boolean game_over(){
        if(lives==0){
            return true;
        }
        else{
            return false;
        }
    }
    public paddle getPaddle(){
        return paddle;
    }
    public ball getBall(){
        return ball;
    }
    public bricks getBricks(){
        return bricks;
    }
    
}







    
