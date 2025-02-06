import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent (char name , ChessColor chessColor , ChessboardPoint chessboardPoint , ChessComponent chessComponents [] [] ) {
        super( name , chessColor , chessboardPoint , chessComponents );
    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>  where = new ArrayList<>() ;
        for ( int i = 0 ; i <= 7 ; i ++ ) {
            where . addAll( FindWay ( i ) ) ;
        }
        return where ;
    }
}
