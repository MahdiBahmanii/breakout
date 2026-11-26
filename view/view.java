package breakout.view;
import java.awt.*;
import breakout.*;
import breakout.model.ball;
import breakout.model.brick;
import breakout.model.bricks;
import breakout.model.paddle;

import javax.swing.JFrame;
import javax.swing.JPanel;

import breakout.controller.game_engine;
public class view extends JPanel {
    game_engine g = new game_engine();
    JFrame frame = new JFrame("breakout");
    public void w(){
    setBackground(Color.DARK_GRAY); 
    setPreferredSize(new Dimension(800, 600));
    }
    public void v(){
        this.w();
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics gg) {
        super.paintComponent(gg);

        paddle p = g.getPaddle();
        gg.setColor(Color.WHITE);
        gg.fillRect(p.getX(), p.getY(), p.getwidth(), p.getheight());

        ball b = g.getBall();
        gg.setColor(Color.WHITE);
        gg.fillOval((int)b.getX(), (int)b.getY(), b.getd(), b.getd());
    
        bricks bs = g.getBricks();
        brick[][] arr = bs.getBricks();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                brick br = arr[i][j];

                if (br.isactive()) {
                    gg.setColor(Color.RED);
                    gg.fillRect(br.getx(), br.gety(), br.getwidth(), br.getheight());
                }
            }
        }
    }


}