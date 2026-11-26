package breakout.model;
import breakout.config.constants;


public class paddle {
    private int x;
    private int y;
    private int width;
    private int height;
    private int speed;
    public paddle(){
        this.x=(constants.WINDOW_WIDTH-constants.PADDLE_WIDTH)/2;
        this.y=545;
        this.width=constants.PADDLE_WIDTH;
        this.height=constants.PADDLE_HEIGHT;
        this.speed=constants.PADDLE_SPEED;
    }
    public void move_left(){
        if(x-speed>=0){
            x=x-speed;
        }
    }
    public void move_right(){
        if(x+speed<=constants.WINDOW_WIDTH-constants.PADDLE_WIDTH){
            x=x+speed;
        }
    }
    public int getX(){
        return x;
    }    
    public int getY(){
        return y;
    }
    public int getwidth(){
        return width;
    }
    public int getheight(){
        return height;
    }
    public void reset_paddle(){
        x=350;
        y=545;
    }
public boolean paddle_hit(double bx, double by, int d) {
    if (x + width > bx && bx + d > x &&
        by + d > y && y + height > by) {
        return true;
    } else {
        return false;
    }
}

}
