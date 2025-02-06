import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> K = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            for(int k = 0; k < 8; k++){
                if(canMoveTo1(getChessComponents(),new ChessboardPoint(i,k))){
                    K.add(new ChessboardPoint(i,k));

                }
            }
        }
        return K;
    }
    public boolean canMoveTo1(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        if (source.getX() - destination.getX() > 1 || source.getX() - destination.getX() < -1
                ||  source.getY() - destination.getY() > 1 || source.getY() - destination.getY() < -1) {
            return false;
        }
        else if(chessComponents[source.getX()][source.getY()].getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor()){
            return false;
        }
        else { 
            return true;
        }

    }
    public KingChessComponent( ChessboardPoint source,ChessColor chessColor,char name) {
        super(source,chessColor, name);
}
}