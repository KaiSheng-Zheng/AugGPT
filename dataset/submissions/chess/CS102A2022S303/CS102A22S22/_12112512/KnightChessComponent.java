import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> N = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            for(int k = 0; k < 8; k++){
                if(canMoveTo1(getChessComponents(),new ChessboardPoint(i,k))){
                    N.add(new ChessboardPoint(i,k));

                }
            }
        }
        return N;
    }
    public boolean canMoveTo1(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        if(chessComponents[source.getX()][source.getY()].getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor()){
            return false;
        }
        if(Math.abs(source.getX() - destination.getX())==1&&Math.abs(source.getY() - destination.getY())==2 ){
            return true;
        }
        if(Math.abs(source.getX() - destination.getX())==2&&Math.abs(source.getY() - destination.getY())==1 ){
            return true;
        }
        else{
            return false;
        }
    }

    public KnightChessComponent( ChessboardPoint source,ChessColor chessColor,char name) {
        super(source,chessColor, name);
    }
}
