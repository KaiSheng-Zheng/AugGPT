import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent  {

    public EmptySlotComponent (char name , ChessColor chessColor , ChessboardPoint chessboardPoint , ChessComponent chessComponents [] [] ) {
        super( name , chessColor , chessboardPoint , chessComponents );
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>  where = new ArrayList<>() ;
        return where ;
    }
}
