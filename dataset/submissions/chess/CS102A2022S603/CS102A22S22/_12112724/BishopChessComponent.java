import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chesscolor) {
        super(source, chesscolor);
        if (chesscolor == ChessColor.BLACK) {
            this.name = 'B';
        }
        if (chesscolor == ChessColor.WHITE) {
            this.name = 'b';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Points = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ableToMove(getChessboard()[i][j])) {
                    Points.add(new ChessboardPoint(i, j));
                }
            }
        }
        return Points;
    }

    public boolean ableToMove(ChessComponent a) {
        ChessboardPoint source = getSource();
        ChessboardPoint target = a.getSource();
        int x1 = Math.min(source.getX(), target.getX());
        int x2 = Math.max(source.getX(), target.getX());
        int y1 = Math.min(source.getY(), target.getY());
        int y2 = Math.max(source.getY(), target.getY());
        if ((source.getX() == target.getX() && source.getY() == target.getY()) || a.getChessColor() == getChessColor()) {
            return false;
        }
        if ((x2 - x1) == (y2 - y1)) {
            if (target.getX()>source.getX()&&target.getY()>source.getY()){
                for (int i = 1; i < x2-x1; i++) {
                    if (!(getChessboard()[source.getX()+i][source.getY()+i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
                return true;
            } else if (target.getX()>source.getX()&&target.getY()<source.getY()) {
                for (int i = 1; i < x2-x1; i++) {
                    if (!(getChessboard()[source.getX() + i][source.getY() - i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
                return true;
            }else if (target.getX()<source.getX()&&target.getY()>source.getY()){
                for (int i = 1; i < x2-x1; i++) {
                    if (!(getChessboard()[source.getX() - i][source.getY() + i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
                return true;
            }else  if (target.getX()<source.getX()&&target.getY()<source.getY()){
                for (int i = 1; i < x2-x1; i++) {
                    if (!(getChessboard()[source.getX() - i][source.getY() - i] instanceof EmptySlotComponent)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
//        int x= getSource().getX();
//        int y= getSource().getY();
//        for (int i = 7; i >0 ; i--) {
//            if (getSource().offset(-i, -i) != null) {
//                if (getChessColor() != getChessboard()[x - i][y - i].getChessColor()) {
//                    Points.add(getSource().offset(-i, -i));
//                }else {
//                    break;
//                }
//            }
//            if (getSource().offset(-i, i) != null) {
//                Points.add(getSource().offset(-i, i));
//            }else {
//                break;
//            }
//        }
//        for (int i = 1; i<8 ; i++) {
//            if (getSource().offset(i, -i) != null) {
//                Points.add(getSource().offset(i, -i));
//            }
//            if (getSource().offset(i, i) != null) {
//                Points.add(getSource().offset(i, i));
//            }else {
//                break;
//            }
//        }
//
//        return Points;


