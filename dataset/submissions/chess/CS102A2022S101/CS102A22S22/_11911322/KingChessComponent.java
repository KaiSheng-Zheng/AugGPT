import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        ChessComponent[][] chessComponents = super.getConcreteChessGame().getChessComponents();

        for (int i = -1; i <= 1; i+=2) {
            if (super.getSource().offset(i,i) != null) {
                if(!chessComponents[x+i][y+i].getChessColor().equals(super.getChessColor()))
                    canMoveTo.add(super.getSource().offset(i,i));
            }
            if (super.getSource().offset(i,-1*i) != null) {
                if(!chessComponents[x+i][y-i].getChessColor().equals(super.getChessColor()))
                    canMoveTo.add(super.getSource().offset(i,-1*i));
            }
            if (super.getSource().offset(i,0) != null) {
                if(!chessComponents[x+i][y].getChessColor().equals(super.getChessColor()))
                    canMoveTo.add(super.getSource().offset(i,0));
            }
            if (super.getSource().offset(0,i) != null) {
                if(!chessComponents[x][y+i].getChessColor().equals(super.getChessColor()))
                    canMoveTo.add(super.getSource().offset(0,i));
            }
        }
        return canMoveTo;
    }
}
