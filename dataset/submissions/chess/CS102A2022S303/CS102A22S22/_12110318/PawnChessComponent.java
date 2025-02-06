import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super();
        setSource(source);
        setChessColor(chessColor);
        chessNum = 8;
        if (chessColor == ChessColor.WHITE) {
            name = 'p';
        } else {
            name = 'P';
        }
    }
    //has not defined neverMove!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> point = new ArrayList<>();
        if ((this.getChessColor()==ChessColor.WHITE&&this.getSource().getX()==6)||
                (this.getChessColor()==ChessColor.BLACK&&this.getSource().getX()==1)){
            if (this.getChessColor()==ChessColor.BLACK) {
                if (hasNone(this.getSource().offset(2, 0))) {
                    point.add(this.getSource().offset(2, 0));
                }
            }else {
                if (hasNone(this.getSource().offset(-2, 0))) {
                    point.add(this.getSource().offset(-2, 0));
                }
            }
        }
        if (this.getChessColor()==ChessColor.BLACK) {
            if (hasNone(this.getSource().offset(1, 0))) {
                point.add(this.getSource().offset(1, 0));
            }
            if (hasEnemy(this.getSource().offset(1, 1))) {
                point.add(this.getSource().offset(1, 1));
            }
            if (hasEnemy(this.getSource().offset(1, -1))) {
                point.add(this.getSource().offset(1, -1));
            }
        }else {
            if (hasNone(this.getSource().offset(-1, 0))) {
                point.add(this.getSource().offset(-1, 0));
            }
            if (hasEnemy(this.getSource().offset(-1, 1))) {
                point.add(this.getSource().offset(-1, 1));
            }
            if (hasEnemy(this.getSource().offset(-1, -1))) {
                point.add(this.getSource().offset(-1, -1));
            }
        }
        return point;
    }
}
