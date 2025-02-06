import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super();
        setSource(source);
        setChessColor(chessColor);
        chessNum = 2;
        if (chessColor == ChessColor.WHITE) {
            name = 'b';
        } else {
            name = 'B';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointCanMoveTo = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (hasNone(this.getSource().offset(i, i))) {
                pointCanMoveTo.add(this.getSource().offset(i, i));
            }
            if (hasEnemy(this.getSource().offset(i, i))) {
                pointCanMoveTo.add(this.getSource().offset(i, i));
                break;
                //pointCanMoveTo.add(new ChessboardPoint(9, 9));
            }
            if (hasFriend(this.getSource().offset(i, i))) {
                break;
//                pointCanMoveTo.add(new ChessboardPoint(9, 9));
            }
        }
        for (int i = 1; i < 8; i++) {
            if (hasNone(this.getSource().offset(-i, i))) {
                pointCanMoveTo.add(this.getSource().offset(-i, i));
            }
            if (hasEnemy(this.getSource().offset(-i, i))) {
                pointCanMoveTo.add(this.getSource().offset(-i, i));
                break;
//                point2.add(new ChessboardPoint(9, 9));
            }
            if (hasFriend(this.getSource().offset(-i, i))) {
                break;
//                point2.add(new ChessboardPoint(9, 9));
            }
        }
        for (int i = 1; i < 8; i++) {
            if (hasNone(this.getSource().offset(i, -i))) {
                pointCanMoveTo.add(this.getSource().offset(i, -i));
            }
            if (hasEnemy(this.getSource().offset(i, -i))) {
                pointCanMoveTo.add(this.getSource().offset(i, -i));
                break;
//                point3.add(new ChessboardPoint(9, 9));
            }
            if (hasFriend(this.getSource().offset(i, -i))) {
                break;
//                point3.add(new ChessboardPoint(9, 9));
            }
        }
        for (int i = 1; i < 8; i++) {
            if (hasNone(this.getSource().offset(-i, -i))) {
                pointCanMoveTo.add(this.getSource().offset(-i, -i));
            }
            if (hasEnemy(this.getSource().offset(-i, -i))) {
                pointCanMoveTo.add(this.getSource().offset(-i, -i));
                break;
                //pointCanMoveTo.add(new ChessboardPoint(9, 9));
            }
            if (hasFriend(this.getSource().offset(-i, -i))) {
                break;
//                pointCanMoveTo.add(new ChessboardPoint(9, 9));
            }
        }
//        int j = 0;
//        while (pointCanMoveTo.get(j).getX() != 9 && j<pointCanMoveTo.size()) {
//            pointCanMoveTo.add(pointCanMoveTo.get(j));
//            j++;
//        }
//        j = 0;
//        while (pointCanMoveTo.get(j).getX() != 9 && j<pointCanMoveTo.size()) {
//            pointCanMoveTo.add(pointCanMoveTo.get(j));
//            j++;
//        }
//        j = 0;
//        while (pointCanMoveTo.get(j).getX() != 9 && j<pointCanMoveTo.size()) {
//            pointCanMoveTo.add(pointCanMoveTo.get(j));
//            j++;
//        }
//        j = 0;
//        while (pointCanMoveTo.get(j).getX() != 9 && j<pointCanMoveTo.size()) {
//            pointCanMoveTo.add(pointCanMoveTo.get(j));
//            j++;
//        }
    return pointCanMoveTo;
    }
}
