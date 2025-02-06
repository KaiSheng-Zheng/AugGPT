import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessboardPoint source, char name, ChessComponent[][] chessboard) {
        super(source, name, chessboard);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();

        for(int i = x - 1; i<x+2; i++){
            for(int f = y - 1; f<=y+1; f++){
                ChessboardPoint pt = new ChessboardPoint(i,f);
                if(!pt.getOnBoard()){
                    continue;
                }
                if(this.chessboard[i][f].getColor() != this.chessColor){
                    canMovePoints.add(pt);
                }
            }
        }
        return canMovePoints;
    }
}
