import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent  {
    public PawnChessComponent (char name , ChessColor chessColor , ChessboardPoint chessboardPoint , ChessComponent chessComponents [] [] ) {
        super( name , chessColor , chessboardPoint , chessComponents ) ;
    }
    public List<ChessboardPoint> canMoveTo() {
        if ( getChessColor() == ChessColor . BLACK ) return whereBlack () ;
        else return whereWhite () ;
    }

    public  List<ChessboardPoint> whereBlack () {
        List<ChessboardPoint> black = new ArrayList<>() ;
        if ( getSource() . getX() == 7 ) return black ;

        if ( checkExist( 1 , 0 ) ) {
            if ( getSource() . getX() == 1 ) {
                if (checkExist(2, 0)) black.add(getSource().offset(2, 0));
            }
                black.add(getSource().offset(1, 0));
        }
        for ( int i = 4 ; i <= 5 ; i ++ ) {
            if ( checkExist( moveX [ i ] , moveY[ i ] ) ) black . add( getSource() . offset( moveX [ i ] , moveY[ i ] ) ) ;
        }
        return black ;
    }
    public List<ChessboardPoint> whereWhite () {
        List<ChessboardPoint> white = new ArrayList<>() ;
        if ( getSource() . getX() == 0 ) return white ;

        if ( checkExist( -1 , 0 ) ) {
            if ( getSource() . getX() == 6 ) {
                if (checkExist(-2, 0)) white.add(getSource().offset(-2, 0));
            }
            white.add(getSource().offset(-1, 0));
        }
        for ( int i = 6 ; i <= 7 ; i ++ ) {
            if ( checkExist( moveX [ i ] , moveY[ i ] ) ) white . add( getSource() . offset( moveX [ i ] , moveY[ i ] ) ) ;
        }
        return white ;
    }

    @Override
    public boolean checkExist( int dx , int dy ) {
        if ( !board( dx , dy ) ) return  false ;
        if ( dx * dy != 0 ) {
            if (  ( chessComponents [ getSource() . getX() + dx ] [ getSource() . getY() + dy ] . getChessColor() != ChessColor.NONE ) && ( !had( dx , dy ) ) )
                return true ;
            else return false ;
        }
        if ( chessComponents [ getSource() . getX() + dx ] [ getSource() . getY() + dy ] . getName()  == '_' ) return true ;
        else return false ;
    }
}
