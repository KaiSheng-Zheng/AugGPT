import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super();
        setSource(source);
        setChessColor(chessColor);
        chessNum = 1;
        if (chessColor == ChessColor.WHITE) {
            name = 'k';
        } else {
            name = 'K';
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> point = new ArrayList<>();
        if (hasNone(this.getSource().offset(-1, 1) )) {
            point.add(this.getSource().offset(-1, 1));
        }
        if (hasNone(this.getSource().offset(0, 1) )) {
            point.add(this.getSource().offset(0, 1));
        }
        if (hasNone(this.getSource().offset(1, 1) )) {
            point.add(this.getSource().offset(1, 1));
        }
        if (hasNone(this.getSource().offset(-1, 0) )) {
            point.add(this.getSource().offset(-1, 0));
        }
        if (hasNone(this.getSource().offset(1, 0) )) {
            point.add(this.getSource().offset(1, 0));
        }
        if (hasNone(this.getSource().offset(-1, -1) )) {
            point.add(this.getSource().offset(-1, -1));
        }
        if (hasNone(this.getSource().offset(0, -1) )) {
            point.add(this.getSource().offset(0, -1));
        }
        if (hasNone(this.getSource().offset(1, -1) )) {
            point.add(this.getSource().offset(1, -1));
        }
        //
        if (hasEnemy(this.getSource().offset(-1, 1) )) {
            point.add(this.getSource().offset(-1, 1));
        }
        if (hasEnemy(this.getSource().offset(0, 1) )) {
            point.add(this.getSource().offset(0, 1));
        }
        if (hasEnemy(this.getSource().offset(1, 1) )) {
            point.add(this.getSource().offset(1, 1));
        }
        if (hasEnemy(this.getSource().offset(-1, 0) )) {
            point.add(this.getSource().offset(-1, 0));
        }
        if (hasEnemy(this.getSource().offset(-1, 0) )) {
            point.add(this.getSource().offset(1, 0));
        }
        if (hasEnemy(this.getSource().offset(-1, -1) )) {
            point.add(this.getSource().offset(-1, -1));
        }
        if (hasEnemy(this.getSource().offset(0, -1) )) {
            point.add(this.getSource().offset(0, -1));
        }
        if (hasEnemy(this.getSource().offset(1, -1) )) {
            point.add(this.getSource().offset(1, -1));
        }
        return point;
    }
}
