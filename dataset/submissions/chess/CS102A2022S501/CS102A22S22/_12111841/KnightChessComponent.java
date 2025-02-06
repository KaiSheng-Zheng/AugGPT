import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent  extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        if (this.Move(2,1)){canMoveTo.add(this.getSource().offset(2, 1));}
        if (this.Move(2,-1)){canMoveTo.add(this.getSource().offset(2, -1));}
        if (this.Move(-2,1)){canMoveTo.add(this.getSource().offset(-2, 1));}
        if (this.Move(-2,-1)){canMoveTo.add(this.getSource().offset(-2, -1));}
        if (this.Move(1,2)){canMoveTo.add(this.getSource().offset(1, 2));}
        if (this.Move(-1,2)){canMoveTo.add(this.getSource().offset(-1, 2));}
        if (this.Move(1,-2)){canMoveTo.add(this.getSource().offset(1, -2));}
        if (this.Move(-1,-2)){canMoveTo.add(this.getSource().offset(-1, -2));}
        return canMoveTo;
    }

    public boolean Move(int dx, int dy){
        if (this.getSource().offset(dx, dy) != null){
            return chessboard[this.getSource().getX() + dx][this.getSource().getY() + dy].getChessColor() != this.getChessColor();
        }
        return false;
    }
}