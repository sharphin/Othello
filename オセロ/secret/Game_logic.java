package secret;
import java.util.Arrays;

public class Game_logic {

    public Game_logic() {}
    private int game_state_flag;

    static int[][] BOARD = new int[][] {{0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0},
                                        {0,0,0,1,2,0,0,0},
                                        {0,0,0,2,1,0,0,0},
                                        {0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0},
                                        {0,0,0,0,0,0,0,0}};

    private final int[][] dire = new int[][] {{ 1, 0},
                                              { 1,-1},
                                              { 0,-1},
                                              {-1,-1},
                                              {-1, 0},
                                              {-1, 1},
                                              { 0, 1},
                                              { 1, 1}};
    private int[] BXY = new int[8];
    private int[][] XY = new int[8][2];

    public void put_stone(int x, int y) {
        int a,b,stone = 1;
        int turn_check = game_state_flag & 1;
        boolean can_change = false;
        if(turn_check == 1) {
            stone = turn_check+1;
        } else if(turn_check == 0) {
            stone = turn_check+1;
        }
        for(int i = 0; i < 8;i++) {
            a = x;    b = y;
            for(int j = 0;j < 8; j++) {
                a = a + dire[i][0];
                b = b + dire[i][1];
                if(a >=0 && a < 8 && b >=0 && b < 8) {
                    BXY[j] = BOARD[b][a];
                    XY[j][0] = a;
                    XY[j][1] = b;
                }
            }
            if(change(BXY,XY,stone,x,y)) can_change = true;
        }
        if(can_change) turn_change(turn_check);
        can_change = false;
    }
    private void turn_change(int turn_check) {
        game_state_flag = (~(game_state_flag)) & 1; 
    }
    private void arrays_init() {
        for(int temp[]: XY) {
            Arrays.fill(temp, 0);
        }
        Arrays.fill(BXY, 0);
    }
    public boolean change(int bxy[],int xy[][], int stone,int x, int y) {
        int count = 0;
        for(int i = 0; i < 8; i++) {
            if(bxy[i]==stone) {
                count = i;
                break;
            } else if(bxy[i]==0) {
                count = 0;
                break;
            }
        }
        if(count == 0) return false;
        for(int i = 0; i < count; i++) {          
            if(bxy[i]!=0 && bxy[i]!=stone) {
                BOARD[xy[i][1]][xy[i][0]] = stone;
                BOARD[y][x] = stone; 
            }
        }
        arrays_init();
        return true;
    }
}