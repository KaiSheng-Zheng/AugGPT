import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(char name,ChessboardPoint pos,ChessColor color){
        this.name = name;
        this.setSource(pos);
        this.setChessColor(color);
    }
    public boolean peat(List<ChessboardPoint> steps, ChessComponent chess, int x, int y) {
        if (x < 0 || y < 0 || x >= 8 || y >= 8)
            return true;
        boolean stop = false;
        ChessComponent c = chessboard[x][y];
        if (c.getChessColor() != chess.getChessColor() && c.name != '_') {
            steps.add(c.getSource());
            stop = true;
        }
        return stop;
    }

    public boolean pmove(List<ChessboardPoint> steps, ChessComponent chess, int x, int y) {
        if (x < 0 || y < 0 || x >= 8 || y >= 8)
            return true;
        boolean stop = false;
        ChessComponent c = chessboard[x][y];
        if (c.name == '_') {
            steps.add(c.getSource());
        }
        return stop;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList steps = new ArrayList<>();
        int X = getSource().getX();
        int Y = getSource().getY();
        ChessComponent chess = chessboard[X][Y];

        if(chess.getChessColor() == ChessColor.WHITE){
            if (chess.getSource().getX() == 6) {
                int x = 4;
                int y = Y;
                pmove(steps, chess, x, y);
            }
            int x = X - 1;
            int y = Y;
            pmove(steps, chess, x, y);

            x = X - 1;
            y = Y - 1;
            peat(steps,chess,x,y);
            x = X - 1;
            y = Y + 1;
            peat(steps,chess,x,y);
        }
        if(chess.getChessColor() == ChessColor.BLACK){
            if (chess.getSource().getX() == 1) {
                int x = 3;
                int y = Y;
                pmove(steps, chess, x, y);
            }
            int x = X + 1;
            int y = Y;
            pmove(steps, chess, x, y);

            x = X + 1;
            y = Y + 1;
            peat(steps,chess,x,y);
            x = X + 1;
            y = Y - 1;
            peat(steps,chess,x,y);
        }
        return steps;
    }
}
