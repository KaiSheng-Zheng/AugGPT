import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        ChessComponent[][] chessComponents = super.getConcreteChessGame().getChessComponents();

        for (int i = -1; i <= 1; i+=2) {
            if (super.getSource().offset(2*i,i) != null) {
                if(!chessComponents[x+2*i][y+i].getChessColor().equals(super.getChessColor()))
                    canMoveTo.add(super.getSource().offset(2*i,i));
            }
            if (super.getSource().offset(i,2*i) != null) {
                if(!chessComponents[x+i][y+2*i].getChessColor().equals(super.getChessColor()))
                    canMoveTo.add(super.getSource().offset(i,2*i));
            }
            if (super.getSource().offset(2*i,-1*i) != null) {
                if(!chessComponents[x+2*i][y-i].getChessColor().equals(super.getChessColor()))
                    canMoveTo.add(super.getSource().offset(2*i,-1*i));
            }
            if (super.getSource().offset(i,-2*i) != null) {
                if(!chessComponents[x+i][y-2*i].getChessColor().equals(super.getChessColor()))
                    canMoveTo.add(super.getSource().offset(i,-2*i));
            }
        }
        return canMoveTo;
    }
}
