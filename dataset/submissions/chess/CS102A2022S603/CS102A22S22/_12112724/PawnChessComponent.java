
import java.util.ArrayList;
import java.util.List;
public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chesscolor) {
        super(source, chesscolor);
        if (chesscolor == ChessColor.BLACK) {
            this.name = 'P';
        }
        if (chesscolor == ChessColor.WHITE) {
            this.name = 'p';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Points = new ArrayList<>();
        return Points;
    }
    public boolean ableToMove(ChessComponent a) {
        return false;
    }
}

//    @Override
//    public List<ChessboardPoint> canMoveTo() {
//        List<ChessboardPoint> Points=new ArrayList<>();
//        for (int i =1; i <8; i++) {
//            if (getSource().offset(0,i)!=null){
//                Points.add(getSource().offset(0,i));
//            }else {
//                break;
//            }
//        }
//
//        return Points;
//    }
//}
