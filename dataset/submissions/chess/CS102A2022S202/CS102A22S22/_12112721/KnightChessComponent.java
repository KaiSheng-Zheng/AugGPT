import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, char name, ConcreteChessGame chessGame){
        super(source,name,chessGame);
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
        int difX = destination.getX() - source.getX();
        int difY = destination.getY() - source.getY();
        if (Math.abs(difX) == 1 && Math.abs(difY) == 2){
            if (chessComponents[destination.getX()][destination.getY()].getChessColor() == getChessColor()){
                return false;
            }
        }
        else if (Math.abs(difX)==2 && Math.abs(difY) == 1){
            if (chessComponents[destination.getX()][destination.getY()].getChessColor() == getChessColor()){
                return false;
            }
        }
        else {
            return false;
        }
        return true;
    }
}
