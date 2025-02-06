import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    final ArrayList<ChessboardPoint> moveDirection = directions.All();  
    final int maxSteps = 8;                                             



    public QueenChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name){
        super(chessboardPoint,chessColor, name);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> goodPoints = new ArrayList<>();
        for (ChessboardPoint direct : moveDirection) {
            for (int i = 1; i <= maxSteps ; i++) {
                ChessboardPoint currP = ChessboardPoint.sum(this.getSource(),ChessboardPoint.product(direct,i));
                if (currP.offset()) {
                    break;
                }
                if (this.getFatherGame().getChess(currP).getChessColor().equals(ChessColor.NONE)) {
                    goodPoints.add(currP);
                }
                else if (this.getFatherGame().getChess(currP).getChessColor().equals(this.getChessColor())) {
                    break;
                } else {
                    goodPoints.add(currP);
                    break;
                }
            }
        }
        return goodPoints;
    }
}