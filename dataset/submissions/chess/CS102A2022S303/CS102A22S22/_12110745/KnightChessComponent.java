import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        super(source,chessColor);
        this.name = name;
    }

    public void addMove(int dx, int dy,ArrayList<ChessboardPoint> move){
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        if (chessboard[x][y].getSource().isInChessboard(dx,dy)){
            if (isEnemy(chessboard[x+dx][y+dy])){
                move.add(this.getSource().offset(dx,dy));
            }
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        addMove(1,2,move);
        addMove(1,-2,move);
        addMove(-1,2,move);
        addMove(-1,-2,move);
        addMove(2,1,move);
        addMove(2,-1,move);
        addMove(-2,1,move);
        addMove(-2,-1,move);
        return move;
    }
}
