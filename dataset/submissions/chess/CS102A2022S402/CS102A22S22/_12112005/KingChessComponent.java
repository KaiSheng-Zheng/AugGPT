import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    ChessComponent[][] chessComponents;

    public KingChessComponent(ChessComponent[][] chessComponents,int i,int j) {
        this.chessComponents = chessComponents;
        setSource(new ChessboardPoint(i,j));
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointslist = new ArrayList<>();
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(canmoveto(chessComponents,new ChessboardPoint(i,j))){
                    pointslist.add(new ChessboardPoint(i,j));
                }
            }
        }
        return pointslist;
    }

    public boolean canmoveto(ChessComponent[][] chessboard, ChessboardPoint destination) {
        ChessboardPoint source = getSource();
        if (Math.abs(destination.getX()-source.getX())<=1 && Math.abs(destination.getY()-source.getY())<=1){
            if(chessboard[source.getX()][source.getY()].getChessColor()!=chessboard[destination.getX()][destination.getY()].getChessColor()) {
                return true;
            }else return false;
        }else return false;
    }

}
