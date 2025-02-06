import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canPoint = new ArrayList<>();
        for(int i = 0 ; i < 8 ; i ++){
            for(int t = 0 ; t < 8 ; t++) {
                ChessboardPoint destination = new ChessboardPoint(i, t);
                ChessboardPoint source = getChessboardPoint();
                if((Math.abs(source.getY()-destination.getY())<=1)
                        &&(Math.abs(source.getX()-destination.getX())<=1)&&
                        ((chessComponents[i][t].getChessColor()!=getChessColor()))){
                    canPoint.add(destination);
                }
            }
        }
        return canPoint;
    }
}