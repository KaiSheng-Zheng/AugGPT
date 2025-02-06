import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
        public QueenChessComponent(ChessboardPoint source,ChessColor chessColor) {
            super();
            setSource(source);
            setChessColor(chessColor);
            chessNum = 1;
            if (chessColor==ChessColor.WHITE){
                name = 'q';
            }else{
                name='Q';
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
        return pointCanMoveTo;
    }
}
