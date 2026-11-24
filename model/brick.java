package breakout.model;
import  breakout.config.constants;
public class brick {
    private int x;
    private int y;
    private int width;
    private int height;
    boolean active=true;
    public brick(int x,int y){
        this.x=x;
        this.y=y;
        this.width=85;
        this.height=25;
    }



    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
    public int  getwidth(){
        return width;
    }
    public int getheight(){
        return height;
    }
    public void destroy(){
        active=false;
    }
    public boolean isactive(){
        return active;
    }
    public boolean check(double bx,double by,int d){
        if(width+x>bx&&bx+d>x&&by+d>y&&y+height>by){
            return true;
        }
        else{
            return false;
        }
    }





}
