import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
        public RookChessComponent(ChessboardPoint source,ChessColor chessColor) {
            super();
            setSource(source);
            setChessColor(chessColor);
            chessNum = 2;
            if (chessColor==ChessColor.WHITE){
                name = 'r';
            }else{
                name='R';
            }
        }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointCanMoveTo = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if (hasNone(this.getSource().offset(i, 0))) {
                pointCanMoveTo.add(this.getSource().offset(i, 0));
            }
            else if (hasEnemy(this.getSource().offset(i, 0))) {
                pointCanMoveTo.add(this.getSource().offset(i, 0));
                break;
                //point1.add(new ChessboardPoint(9, 9));
            }
            else{//if (hasFriend(this.getSource().offset(i, 0))) {
//                point1.add(new ChessboardPoint(9, 9));
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            if (hasNone(this.getSource().offset(-i, 0))) {
                pointCanMoveTo.add(this.getSource().offset(-i, 0));
            }
            else if (hasEnemy(this.getSource().offset(-i, 0))) {
                pointCanMoveTo.add(this.getSource().offset(-i, 0));
                break;
                //pointCanMoveTo.add(new ChessboardPoint(9, 9));
            }
            else{//if (hasFriend(this.getSource().offset(-i, 0))) {
                break;
                //pointCanMoveTo.add(new ChessboardPoint(9, 9));
            }
        }
        for (int i = 1; i < 8; i++) {
            if (hasNone(this.getSource().offset(0, -i))) {
                pointCanMoveTo.add(this.getSource().offset(0, -i));
            }
            else if (hasEnemy(this.getSource().offset(0, -i))) {
                pointCanMoveTo.add(this.getSource().offset(0, -i));
                break;
                //pointCanMoveTo.add(new ChessboardPoint(9, 9));
            }
            else {//if (hasFriend(this.getSource().offset(0, -i))) {
                break;
                //pointCanMoveTo.add(new ChessboardPoint(9, 9));
            }
        }
        for (int i = 1; i < 8; i++) {
            if (hasNone(this.getSource().offset(0, i))) {
                pointCanMoveTo.add(this.getSource().offset(0, i));
            }
            else if (hasEnemy(this.getSource().offset(0, i))) {
                pointCanMoveTo.add(this.getSource().offset(0, i));
                break;
               // pointCanMoveTo.add(new ChessboardPoint(9, 9));
            }
            else {//if (hasFriend(this.getSource().offset(0, i))) {
                break;
                //pointCanMoveTo.add(new ChessboardPoint(9, 9));
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
