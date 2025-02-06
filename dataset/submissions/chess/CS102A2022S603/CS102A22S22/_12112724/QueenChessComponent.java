import java.util.ArrayList;
import java.util.List;
public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessboardPoint source, ChessColor chesscolor) {
        super(source, chesscolor);
        if (chesscolor == ChessColor.BLACK) {
            this.name = 'Q';
        }
        if (chesscolor == ChessColor.WHITE) {
            this.name = 'q';
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
        if (source.getX() == target.getX() && source.getY() == target.getY() || a.getChessColor() == getChessColor()) {
            return false;
        }
        if (source.getX() == target.getX()) {
            for (int i = y1 + 1; i < y2; i++) {
                if (!(getChessboard()[source.getX()][i] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
            return true;
        } else if (source.getY() == target.getY()) {
            for (int i = x1 + 1; i < x2; i++) {
                if (!(getChessboard()[i][source.getY()] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
            return true;
        }else if ((x2 - x1) == (y2 - y1)) {
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


