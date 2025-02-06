import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent  {

    public KingChessComponent (char name , ChessColor chessColor , ChessboardPoint chessboardPoint , ChessComponent chessComponents [] [] ) {
        super( name , chessColor , chessboardPoint , chessComponents );
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>  where = new ArrayList<>() ;
        for ( int i = 0 ; i <= 7 ; i ++ ) {
            if ( checkExist( moveX [ i ] , moveY [ i ]  ) ) {
                where . add( getSource() . offset( moveX [ i ] , moveY[ i ] ) );
            }
        }
        return where ;
    }
}
