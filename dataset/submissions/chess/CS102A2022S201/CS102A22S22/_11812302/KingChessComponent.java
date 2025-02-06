import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> K = new ArrayList<>();
        K.add(getSource().offset(1,0));
        K.add(getSource().offset(-1,0));
        K.add(getSource().offset(0,1));
        K.add(getSource().offset(0,-1));
        K.add(getSource().offset(1,1));
        K.add(getSource().offset(1,-1));
        K.add(getSource().offset(-1,1));
        K.add(getSource().offset(-1,-1));
        for (int i=0; i<K.size(); i++) {
            if (K.get(i) == null) {
                K.remove(i);
                i = i - 1;
            }
        }
        for (int i=0; i<K.size(); i++) {
            if (ConcreteChessGame.getChessComponents0()[getSource().getX()][getSource().getY()].getChessColor() ==
                    ConcreteChessGame.getChessComponents0()[K.get(i).getX()][K.get(i).getY()].getChessColor()) {
                K.remove(i);
                i = i-1;
            }
        }
        return K;
    }
}