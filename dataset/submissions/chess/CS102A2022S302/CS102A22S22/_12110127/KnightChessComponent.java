import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private int x,y;
    private ChessColor chessColor;
    final ArrayList<ChessboardPoint> moveDirection = directions.Knight(); 
    final int maxSteps = 8;
    public KnightChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char a){
        super(chessboardPoint,chessColor,a);
        x=chessboardPoint.getX();y=chessboardPoint.getY();
        this.chessColor=chessColor;
        super.name=a;
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
                    break;
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