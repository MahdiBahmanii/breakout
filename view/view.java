package breakout.view;
import java.awt.*;
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


}