import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
//        List<ChessboardPoint> canMove=new ArrayList();
//        canMoveTo().add(new ChessboardPoint(1,1));
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                getChessboard().equals(null);
//                canMove.add(new ChessboardPoint(i,j));
//            }
//        }
//        return canMove;
        return new ArrayList<>();

    }

    public EmptySlotComponent(ChessColor color) {
        setChessColor(ChessColor.NONE);
        setName("empty");
    }
}
