import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent  {
    public BishopChessComponent (char name , ChessColor chessColor , ChessboardPoint chessboardPoint , ChessComponent chessComponents [] [] ) {
        super( name , chessColor , chessboardPoint , chessComponents );
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List < ChessboardPoint > where = new ArrayList<>() ;
        for ( int i = 4 ; i <= 7 ; i ++ ) {
            where . addAll( FindWay ( i ) ) ;
        }
        return where ;
    }
}
