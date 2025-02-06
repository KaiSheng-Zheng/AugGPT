import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<ChessboardPoint>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        ChessComponent[][] chessComponents = super.getConcreteChessGame().getChessComponents();

        for (int i = 1; i <= 7; i++) {
            if (super.getSource().offset(0,i) == null) break;
            if (chessComponents[x][y+i] instanceof EmptySlotComponent) {
                canMoveTo.add(super.getSource().offset(0,i));
            } else if (chessComponents[x][y+i].getChessColor() != super.getChessColor()) {
                canMoveTo.add(super.getSource().offset(0,i));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (super.getSource().offset(0,-1*i) == null) break;
            if (chessComponents[x][y-i] instanceof EmptySlotComponent) {
                canMoveTo.add(super.getSource().offset(0,-1*i));
            } else if (chessComponents[x][y-i].getChessColor() != super.getChessColor()) {
                canMoveTo.add(super.getSource().offset(0,-1*i));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (super.getSource().offset(i,0) == null) break;
            if (chessComponents[x+i][y] instanceof EmptySlotComponent) {
                canMoveTo.add(super.getSource().offset(i,0));
            } else if (chessComponents[x+i][y].getChessColor() != super.getChessColor()) {
                canMoveTo.add(super.getSource().offset(i,0));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (super.getSource().offset(-1*i,0) == null) break;
            if (chessComponents[x-i][y] instanceof EmptySlotComponent) {
                canMoveTo.add(super.getSource().offset(-1*i,0));
            } else if (chessComponents[x-i][y].getChessColor() != super.getChessColor()) {
                canMoveTo.add(super.getSource().offset(-1*i,0));
                break;
            } else {
                break;
            }
        }
        return canMoveTo;
    }
}
