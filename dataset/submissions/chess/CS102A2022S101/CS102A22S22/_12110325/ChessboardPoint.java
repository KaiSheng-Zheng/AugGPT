public class ChessboardPoint {
    private int x ;
    private int y ;
    public ChessboardPoint ( int x , int y ) {
        this . x = x ;
        this . y = y ;
    }

    public int getX() { return x ; }
    public int getY() { return y ; }

    @Override
    public String toString () {
        return String . format( "(%d,%d)" , x , y ) ;
    }
    public ChessboardPoint offset ( int dx , int dy ) {
        if ( ( x + dx >= 8 ) || ( x + dx < 0 ) ) return null ;
        if ( ( y + dy >= 8 ) || ( y + dy < 0 ) ) return null ;
        return new ChessboardPoint( x + dx , y + dy ) ;

    }

    public boolean equals ( ChessboardPoint chessboardPoint ) {
        if ( ( chessboardPoint . getX() == x ) && ( chessboardPoint . getY() == y ) ) return true ;
        else return false ;
    }
}
