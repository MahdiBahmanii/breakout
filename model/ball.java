package breakout.model;
import breakout.config.constants;
import java.util.Random;
import java.lang.Math;
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




}
