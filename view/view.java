package breakout.view;
import java.awt.*;
import breakout.*;
import breakout.model.ball;
import breakout.model.brick;
import breakout.model.bricks;
import breakout.model.paddle;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import breakout.controller.game_engine;

public class view extends JPanel {
    Timer timer;
    game_engine g = new game_engine();
    JFrame frame = new JFrame("breakout");
    public void w(){
    setBackground(new Color(15,18,35)); 
    setPreferredSize(new Dimension(800, 600));
    }
    public void v(){
        this.w();
        frame.add(this);

        getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "left");
        getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "right");

        getActionMap().put("left", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                g.getPaddle().move_left();
                repaint();
            }
        });

        getActionMap().put("right", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                g.getPaddle().move_right();
                repaint();
            }
        });
        getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "launch");

        getActionMap().put("launch", new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                g.launch_ball();
            }
        });
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        timer = new Timer(16, e -> {
            g.update();
            repaint();
            });
        timer.start();
        frame.setVisible(true);
    }

@Override
protected void paintComponent(Graphics gg) {
    super.paintComponent(gg);

    Graphics2D g2 = (Graphics2D) gg;
    g2.setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON
    );

    // Paddle
    paddle p = g.getPaddle();
    g2.setColor(new Color(70, 170, 255));
    g2.fillRoundRect(
        p.getX(), p.getY(),
        p.getwidth(), p.getheight(),
        12, 12
    );

    // Ball
    ball b = g.getBall();
    g2.setColor(new Color(240, 245, 255));
    g2.fillOval(
        (int) b.getX(), (int) b.getY(),
        b.getd(), b.getd()
    );

    // Bricks
    bricks bs = g.getBricks();
    brick[][] arr = bs.getBricks();

    Color[] brickColors = {
        new Color(255, 90, 95),
        new Color(255, 160, 70),
        new Color(255, 215, 80),
        new Color(80, 220, 160),
        new Color(90, 160, 255)
    };

    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 8; j++) {
            brick br = arr[i][j];

            if (br.isactive()) {
                g2.setColor(brickColors[i]);

                g2.fillRoundRect(
                    br.getx(), br.gety(),
                    br.getwidth(), br.getheight(),
                    8, 8
                );

                // Highlight on top
                g2.setColor(new Color(255, 255, 255, 55));
                g2.drawRoundRect(
                    br.getx() + 1, br.gety() + 1,
                    br.getwidth() - 2, br.getheight() - 2,
                    8, 8
                );
            }
        }
    }
}


}