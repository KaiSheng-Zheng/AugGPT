import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents,char name){
        super(chessboardPoint,chessComponents,name);

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points=new ArrayList<>();
  return points;  }



}
