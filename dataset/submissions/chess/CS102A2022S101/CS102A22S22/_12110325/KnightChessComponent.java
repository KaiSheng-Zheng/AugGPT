
import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent  {
    final static int movelong [] = { 2 , 2 , -2 , -2  } ;
    final static int moveshort [] = { 1 , -1 , 1 , -1 } ;
    public KnightChessComponent (char name , ChessColor chessColor , ChessboardPoint chessboardPoint , ChessComponent chessComponents [] [] ) {
        super( name , chessColor , chessboardPoint , chessComponents );
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>  where = new ArrayList<>() ;
        for ( int i = 0 ; i <= 3 ; i ++ ) {
            if ( checkExist( movelong [ i ] , moveshort[ i ] ) ) where . add( getSource() . offset( movelong [ i ] , moveshort [ i ] ) ) ;
            if ( checkExist( moveshort [ i ] , movelong[ i ] ) ) where . add( getSource() . offset( moveshort [ i ] , movelong [ i ] ) ) ;
        }
        return where ;
    }
}
