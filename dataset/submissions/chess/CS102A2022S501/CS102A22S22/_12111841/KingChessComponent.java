import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        if (this.Move(1,1)){canMoveTo.add(this.getSource().offset(1, 1));}
        if (this.Move(1,-1)){canMoveTo.add(this.getSource().offset(1, -1));}
        if (this.Move(-1,1)){canMoveTo.add(this.getSource().offset(-1, 1));}
        if (this.Move(-1,-1)){canMoveTo.add(this.getSource().offset(-1, -1));}
        if (this.Move(1,0)){canMoveTo.add(this.getSource().offset(1, 0));}
        if (this.Move(-1,0)){canMoveTo.add(this.getSource().offset(-1, 0));}
        if (this.Move(0,-1)){canMoveTo.add(this.getSource().offset(0, -1));}
        if (this.Move(0,1)){canMoveTo.add(this.getSource().offset(0, 1));}
        return canMoveTo;
    }

    public boolean Move(int dx, int dy){
        if (this.getSource().offset(dx, dy) != null){
            return chessboard[this.getSource().getX() + dx][this.getSource().getY() + dy].getChessColor() != this.getChessColor();
        }
        return false;
    }
}