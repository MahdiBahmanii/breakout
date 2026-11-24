package breakout.controller;
import breakout.model.*;
public class game_engine {
    int score;
    bricks bricks=new bricks();
    ball ball=new ball();        
    paddle paddle=new paddle();
    public game_engine() {
        score=0;
    }
    public void update(){
        ball.update_position();
        ball.hitx();
        ball.hity();
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

    
    
}







    
