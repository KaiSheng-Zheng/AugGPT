import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, char name, ConcreteChessGame chessGame) {
        super(source, name, chessGame);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> cbp = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (canMoveTo(getChessGame().getChessComponents(),new ChessboardPoint(i,j))) {
                    cbp.add(new ChessboardPoint(i,j));
                }
            }
        }
        return cbp;
    }

    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getSource();
        int sumS = source.getX()+source.getY();
        int difS = source.getX()-source.getY();
        int sumD = destination.getX()+destination.getY();
        int difD = destination.getX()-destination.getY();
        if (sumS == sumD) {
            int sum = sumS;
            for (int dif = Math.min(difS, difD) + 2;
                 dif < Math.max(difS, difD); dif+=2) {
                if (!(chessComponents[(sum+dif)/2][(sum-dif)/2] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (difS == difD) {
            int dif = difD;
            for (int sum = Math.min(sumS, sumD) + 2;
                 sum < Math.max(sumS, sumD); sum+=2) {
                if (!(chessComponents[(sum+dif)/2][(sum-dif)/2] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        if (chessComponents[source.getX()][source.getY()].getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor()) {
            return false;
        }
        return true;
    }



}