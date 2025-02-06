import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(char name,ChessboardPoint pos,ChessColor color){
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


            for (int i = 1; i < 8 - X; i++) {  //right
                int x = X + i;
                int y = Y;
                if (add(steps, chess, x, y)) {
                    break;
                }
            }

            for (int i = 1; i < X + 1; i++) {  //left
                int x = X - i;
                int y = Y;
                if (add(steps, chess, x, y)) {
                    break;
                }
            }

            for (int i = 1; i < Y + 1; i++) {  //up
                int x = X;
                int y = Y - i;
                if (add(steps, chess, x, y)) {
                    break;
                }
            }

            for (int i = 1; i < 8 - Y; i++) {  //down
                int x = X;
                int y = Y + i;
                if (add(steps, chess, x, y)) {
                    break;
                }
            }

        return steps;
    }
}
