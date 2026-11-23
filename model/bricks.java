package breakout.model;

public class bricks {
    private brick[][] bricks;
    public bricks(){
        bricks=new brick[5][8];
        for(int i=0;i<5;i++){
            for(int j=0;j<8;j++){
                int x=91*j+39;
                int y=31*i+60;
                bricks[i][j]=new brick(x,y);
            }
        }
    }

    public brick[][] getBricks() {
       return bricks;
    }
    public int nbrick(){
        int n=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<8;j++){
                if(bricks[i][j].isactive()){
                    n++;
                }
            }
        }
        return n;
    }




}
