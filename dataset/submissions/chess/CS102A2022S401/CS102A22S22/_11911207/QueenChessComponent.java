import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMovePoints = new ArrayList<>();
        for (int i=0;i<8;i++) {
            for (int j = 0; j < 8; j++) {
                if (i==super.getSource().getX()&&j==super.getSource().getY()){
                    continue;
                }
                if (Checkers.allCheck(chessComponents[super.getSource().getX()][super.getSource().getY()],chessComponents, String.valueOf(chessComponents[super.getSource().getX()][super.getSource().getY()].name),i,j,super.getChessColor())){
                    canMovePoints.add(new ChessboardPoint(i,j));
                }
            }
        }
        return canMovePoints;
    }


}