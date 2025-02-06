import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(char name,ChessboardPoint pos,ChessColor color){
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

        int move[][] = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
        for (int i = 0; i < move.length; i++) {
            int x = X + move[i][0];
            int y = Y + move[i][1];
            add(steps, chess, x, y);
        }
        return steps;
    }
}
