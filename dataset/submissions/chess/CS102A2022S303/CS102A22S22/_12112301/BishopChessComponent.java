import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(char name,ChessboardPoint pos,ChessColor color){
        this.name = name;
        this.setSource(pos);
        this.setChessColor(color);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {

        ArrayList steps = new ArrayList<>();
        int X = getSource().getX();
        int Y = getSource().getY();
        ChessComponent chess = chessboard[X][Y];

        for (int i = 1; i < 8; i++) {  //right&down
            int x = X + i;
            int y = Y + i;
            if (add(steps, chess, x, y)) {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {  //left&down
            int x = X - i;
            int y = Y + i;
            if (add(steps, chess, x, y)) {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {  //left&up
            int x = X - i;
            int y = Y - i;
            if (add(steps, chess, x, y)) {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {  //right&up
            int x = X + i;
            int y = Y - i;
            if (add(steps, chess, x, y)) {
                break;
            }
        }
        return steps;
    }
}
