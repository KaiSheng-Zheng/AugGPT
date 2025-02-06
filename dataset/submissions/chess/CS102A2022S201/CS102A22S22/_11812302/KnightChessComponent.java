import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> N = new ArrayList<>();
        N.add(getSource().offset(1,2));
        N.add(getSource().offset(1,-2));
        N.add(getSource().offset(-1,2));
        N.add(getSource().offset(-1,-2));
        N.add(getSource().offset(2,1));
        N.add(getSource().offset(2,-1));
        N.add(getSource().offset(-2,1));
        N.add(getSource().offset(-2,-1));
        for (int i=0; i<N.size(); i++) {
            if (N.get(i) == null) {
                N.remove(i);
                i = i - 1;
            }
        }
        for (int i=0; i<N.size(); i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() ==
                    ConcreteChessGame.getChessComponents0()[N.get(i).getX()][N.get(i).getY()].getChessColor()) {
                N.remove(i);
                i = i-1;
            }
        }
        return N;
    }
}