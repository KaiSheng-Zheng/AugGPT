import java.util.ArrayList;
import java . util . List ;

public abstract class ChessComponent {

    private ChessboardPoint source ;
    private ChessColor chessColor ;
    protected char name ;
    protected ChessComponent chessComponents [] [] ;
    protected final int moveX [] = { 0 , 0 , 1 , -1 , 1 , -1 , 1 , -1 } ;
    protected final int moveY [] = { 1 ,-1 , 0 , 0 , 1 , 1 , -1 , -1 } ;

    public ChessComponent () {}
    public ChessComponent( char name , ChessColor chessColor ,ChessboardPoint source , ChessComponent chessComponents [] []  ) {
        this . name = name ;
        this . chessColor = chessColor ;
        this . source = source ;
        this . chessComponents = chessComponents ;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString () {
        return String . valueOf( this . name ) ;
    }
    public ChessboardPoint getSource () { return source ; }
    public void setChessColor ( ChessColor chessColor ) {
        this . chessColor = chessColor ;
    }
    public  void  setSource ( ChessboardPoint source ) {
        this . source = source ;
    }
    public ChessColor getChessColor () { return chessColor ; }
    public char getName () { return name ;}

    public boolean checkExist ( int dx ,int dy ) {
        if ( ! board( dx , dy ) ) return false ;
        if ( chessComponents  [ source . getX() + dx ] [ source . getY() + dy ] . chessColor != this . chessColor ) return true ;
        else return false ;
    }
    public boolean had ( int dx , int dy ) {
        if ( chessComponents [  source . getX() + dx ] [ source . getY() + dy] . getChessColor() == chessColor ) return  true ;
        else return false ;
    }
    public boolean board ( int dx , int dy ) {
        if ( ( source . getX() + dx >= 8 ) || ( source . getX() + dx < 0 ) ) return false ;
        if ( ( source . getY() + dy >= 8 ) || ( source . getY() + dy < 0 ) ) return false ;
        return true ;
    }
    public List<ChessboardPoint> FindWay ( int i ) {
        List<ChessboardPoint> where = new ArrayList<>( ) ;

        for ( int j = 1 ; ; j ++ ) {
            if ( ! board(j * moveX [ i ] , j * moveY [ i ] ) ) break;
            if ( had( j * moveX [ i ] , j * moveY [ i ] ) ) break;
            if ( checkExist(j * moveX [ i ] , j * moveY [ i ]  ) ) {
                where . add( source . offset( j * moveX [ i ] , j * moveY [ i ] ) ) ;
                if ( chessComponents [ source . getX() + j * moveX [ i ] ] [ source . getY() + j * moveY [ i ] ] . getName() != '_' ) break;
            }
        }
        return where ;
    }
}
