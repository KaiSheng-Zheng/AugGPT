import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source,chessColor,name);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canPoint = new ArrayList<>();
        for(int i = 0 ; i < 8 ; i ++){
            for(int t = 0 ; t < 8 ; t++) {
                ChessboardPoint destination = new ChessboardPoint(i, t);
                ChessboardPoint source = getChessboardPoint();
                if(chessComponents[destination.getX()][destination.getY()].getChessColor()==getChessColor()){
                    continue;
                }
                if((source.getY()!=destination.getY())&&(source.getX()!=destination.getX())){
                    if(Math.abs(source.getY()-destination.getY())+Math.abs(source.getX()-destination.getX())==3){
                        canPoint.add(destination);
                    }
                    else{
                        //
                    }
                }
                else { // Not on the same row or the same column.
                    //
                }
            }
        }
        return canPoint;
    }
}