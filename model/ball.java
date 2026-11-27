package breakout.model;
import breakout.config.constants;
import java.util.Random;
import java.lang.Math;
import breakout.model.paddle;
public class ball {
    private double x;
    private double y;
    private double vx;
    private double vy;
    private int d;
    public ball(){
        this.x=392;
        this.y=529;
        this.vx=0;
        this.vy=0;
        this.d=constants.BALL_D;
    }
    public void reset_ball(){
        vx=0;
        vy=0;
        x=392;
        y=529;
    }
    public void update_position(){
        x=x+vx;
        y=y+vy;
    }
    public void launch(){
        Random r=new Random();
        double teta=r.nextDouble(-20,20);
        teta=Math.toRadians(teta);
        vx=6*Math.sin(teta);
        vy=-6*Math.cos(teta);
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    } 
    public double getvx(){
        return vx;
    }
    public double getvy(){
        return vy;
    }
    public int getd(){
        return d;
    }
    public void hitx(){
        if (x<=0||x>=784) {
            vx=-vx;
        }
    }
    public void hity(){
        if(y<=0){
            vy=-vy;
        }
    }
    public void sb_brick(double overlapX,double overlapY){
        if(overlapX<overlapY){
            vx=-vx;
        }
        if(overlapX>overlapY){
            vy=-vy;
        }
    }
    public double paddle_offset(double paddleX, double paddleWidth) {
        double ballCenter= x+d/2.0;
        double paddleCenter= paddleX+paddleWidth/2.0;
        double offset=(ballCenter-paddleCenter)/(paddleWidth/2.0);
        offset=Math.max(-1.0,Math.min(1.0,offset));
        return offset;
    }
    public void bounce_paddle(double offset) {
        double theta= Math.toRadians(offset * 60.0);
        vx = constants.BALL_SPEED*Math.sin(theta);
        vy= -constants.BALL_SPEED * Math.cos(theta);
    }
    public void place_above_paddle(double paddleY) {
        y = paddleY - d;
    }
    public void place_on_paddle(int paddleX, int paddleY, int paddleWidth) {
        x= paddleX+(paddleWidth-d)/2.0;
        y= paddleY-d;
    }



}
