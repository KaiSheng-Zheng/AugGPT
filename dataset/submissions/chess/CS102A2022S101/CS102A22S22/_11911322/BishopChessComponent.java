import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        ChessComponent[][] chessComponents = super.getConcreteChessGame().getChessComponents();

        for (int i = 1; i <= 7; i++) {
            if (super.getSource().offset(i,i) == null) break;
            if (chessComponents[x+i][y+i] instanceof EmptySlotComponent) {
                canMoveTo.add(super.getSource().offset(i,i));
            } else if (chessComponents[x+i][y+i].getChessColor() != super.getChessColor()) {
                canMoveTo.add(super.getSource().offset(i,i));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (super.getSource().offset(-1*i,-1*i) == null) break;
            if (chessComponents[x-i][y-i] instanceof EmptySlotComponent) {
                canMoveTo.add(super.getSource().offset(-1*i,-1*i));
            } else if (chessComponents[x-i][y-i].getChessColor() != super.getChessColor()) {
                canMoveTo.add(super.getSource().offset(-1*i,-1*i));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (super.getSource().offset(i,-1*i) == null) break;
            if (chessComponents[x+i][y-i] instanceof EmptySlotComponent) {
                canMoveTo.add(super.getSource().offset(i,-1*i));
            } else if (chessComponents[x+i][y-i].getChessColor() != super.getChessColor()) {
                canMoveTo.add(super.getSource().offset(i,-1*i));
                break;
            } else {
                break;
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (super.getSource().offset(-1*i,i) == null) break;
            if (chessComponents[x-i][y+i] instanceof EmptySlotComponent) {
                canMoveTo.add(super.getSource().offset(-1*i,i));
            } else if (chessComponents[x-i][y+i].getChessColor() != super.getChessColor()) {
                canMoveTo.add(super.getSource().offset(-1*i,i));
                break;
            } else {
                break;
            }
        }
        return canMoveTo;
    }
}
