import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super();
        setSource(source);
        setChessColor(chessColor);
        chessNum = 2;
        if (chessColor == ChessColor.WHITE) {
            name = 'n';
        } else {
            name = 'N';
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointCanMoveTo = new ArrayList<>();
        if (hasNone(this.getSource().offset(-1,2))){
            pointCanMoveTo.add(this.getSource().offset(-1,2));
        }
        if (hasNone(this.getSource().offset(-2,1))){
            pointCanMoveTo.add(this.getSource().offset(-2,1));
        }
        if (hasNone(this.getSource().offset(1,2))){
            pointCanMoveTo.add(this.getSource().offset(1,2));
        }
        if (hasNone(this.getSource().offset(2,1))){
            pointCanMoveTo.add(this.getSource().offset(2,1));
        }
        if (hasNone(this.getSource().offset(-1,-2))){
            pointCanMoveTo.add(this.getSource().offset(-1,-2));
        }
        if (hasNone(this.getSource().offset(-2,-1))){
            pointCanMoveTo.add(this.getSource().offset(-2,-1));
        }
        if (hasNone(this.getSource().offset(1,-2))){
            pointCanMoveTo.add(this.getSource().offset(1,-2));
        }
        if (hasNone(this.getSource().offset(2,-1))){
            pointCanMoveTo.add(this.getSource().offset(2,-1));
        }
        //
        if (hasEnemy(this.getSource().offset(-1,2))){
            pointCanMoveTo.add(this.getSource().offset(-1,2));
        }
        if (hasEnemy(this.getSource().offset(-2,1))){
            pointCanMoveTo.add(this.getSource().offset(-2,1));
        }
        if (hasEnemy(this.getSource().offset(1,2))){
            pointCanMoveTo.add(this.getSource().offset(1,2));
        }
        if (hasEnemy(this.getSource().offset(2,1))){
            pointCanMoveTo.add(this.getSource().offset(2,1));
        }
        if (hasEnemy(this.getSource().offset(-1,-2))){
            pointCanMoveTo.add(this.getSource().offset(-1,-2));
        }
        if (hasEnemy(this.getSource().offset(-2,-1))){
            pointCanMoveTo.add(this.getSource().offset(-2,-1));
        }
        if (hasEnemy(this.getSource().offset(1,-2))){
            pointCanMoveTo.add(this.getSource().offset(1,-2));
        }
        if (hasEnemy(this.getSource().offset(2,-1))){
            pointCanMoveTo.add(this.getSource().offset(2,-1));
        }
        //
        return pointCanMoveTo;
    }

    //

}
