import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    final int maxSteps=8;final ArrayList<ChessboardPoint> moveDirection = directions.Normal();
    public RookChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char a){
        super(chessboardPoint,chessColor,a);
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