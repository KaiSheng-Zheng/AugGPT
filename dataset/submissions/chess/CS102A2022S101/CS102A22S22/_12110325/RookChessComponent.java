import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent (char name , ChessColor chessColor , ChessboardPoint chessboardPoint , ChessComponent chessComponents [] [] ) {
        super( name , chessColor , chessboardPoint , chessComponents );
    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>  where = new ArrayList<>() ;
        for ( int i = 0 ; i <= 3 ; i ++ ) {
            where . addAll( FindWay ( i ) ) ;
        }
        return where ;
    }
}
