import javax.swing.*;
import secret.Game_view;

public class Othello extends JFrame{
    private final int MASU = 8;
    private final int M_S = 60;
    private final int WIDTH = M_S * MASU;
    private final int HEIGHT = WIDTH;

    public static void main(String[] args) {
        new Othello();
    } 
    public Othello() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH+17, HEIGHT+40);
        setTitle("Othello");
        setVisible(true);
        Game_view gv = new Game_view();
        super.add(gv);
    }
}