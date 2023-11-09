package secret;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Game_view extends JPanel implements MouseListener{

    public static final int MASU = 8;
    public static final int M_S = 60;
    private static final int WIDTH = M_S * MASU;
    private static final int HEIGHT= M_S * MASU;

    Game_logic gl = new Game_logic();
    public Game_view() {
        setSize(WIDTH, HEIGHT);
        addMouseListener(this);
    }
    public void paint(Graphics g) {
        g.setColor(new Color(34,139,34));
        g.fillRect(1,1,WIDTH-1, HEIGHT-1);
        for(int i = 0; i < MASU; i++) {
            for(int j = 0; j < MASU; j++) {
                g.setColor(Color.BLACK);
                g.drawRect((i*M_S),(j*M_S),M_S,M_S);
                switch (Game_logic.BOARD[i][j]){
                    case 1:  g.setColor(Color.BLACK);      break;
                    case 2:  g.setColor(Color.WHITE);      break;
                    default: continue;
                } 
                g.fillOval((j*M_S+3),(i*M_S+3),M_S-6,M_S-6);
            }
        }
    }
    public void mouseClicked(MouseEvent e) {
        int x = (e.getX()/M_S);
        int y = (e.getY()/M_S);
        gl.put_stone(x, y);
        repaint();
    }
    public void mousePressed(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
}