package breakout.model;
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
        if(width+x>bx && bx+d>x && by+d>y && y+height>by){
            double lrba=(double)bx+d;
            double lrbr=(double)x+width;
            double llba=(double)bx;
            double llbr=(double)x;
            double overlapX=Math.min(lrba, lrbr)-Math.max(llba, llbr);
            
            double lbba=(double)by;
            double lbbr=(double)y;
            double lpba=(double)by+d;
            double lpbr=(double)y+height;
            double overlapY=Math.min(lpba, lpbr)-Math.max(lbba,lbbr);
            
            
            
            return true;

                }
        else{
            return false;
        }
    }





}
