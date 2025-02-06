
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java . util . List ;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents =  new ChessComponent [ 8 ] [ 8 ] ;
    private ChessColor currentPlayer ;
    public  ChessComponent [] [] getStatus () {
        return this . chessComponents ;
    }
    public ConcreteChessGame () {
        currentPlayer = ChessColor . WHITE ;
        for ( int i = 0  ;  i <= 7 ; i ++ ) {
            chessComponents [ 1 ] [ i ] = new PawnChessComponent( 'P' , ChessColor . BLACK ,  new ChessboardPoint( 1 ,  i ) , chessComponents ) ;
            chessComponents [ 6 ] [ i ] = new PawnChessComponent( 'p' , ChessColor . WHITE , new ChessboardPoint( 6 , i ) , chessComponents ) ;
        }
        for ( int i = 2 ; i <= 5 ; i ++ ) {
            for ( int j = 0 ; j <= 7 ; j ++ ) {
                chessComponents [ i ] [ j ] = new EmptySlotComponent( '_' , ChessColor . NONE , new ChessboardPoint( i , j ) , chessComponents  ) ;
            }
        }
        chessComponents [ 0 ] [ 4 ] = new KingChessComponent( 'K' , ChessColor . BLACK , new ChessboardPoint( 0 ,4 ) , chessComponents  ) ;
        chessComponents [ 0 ] [ 0 ] = new RookChessComponent( 'R' , ChessColor . BLACK , new ChessboardPoint( 0 , 0 ) , chessComponents ) ;
        chessComponents [ 0 ] [ 7 ] = new RookChessComponent( 'R' , ChessColor . BLACK , new ChessboardPoint( 0 , 7 ) , chessComponents ) ;
        chessComponents [ 0 ] [ 6 ] = new KnightChessComponent( 'N' , ChessColor . BLACK , new ChessboardPoint( 0 , 6 ) , chessComponents ) ;
        chessComponents [ 0 ] [ 1 ] = new KnightChessComponent( 'N' , ChessColor . BLACK , new ChessboardPoint( 0 , 1 ) , chessComponents ) ;
        chessComponents [ 0 ] [ 2 ] = new BishopChessComponent( 'B' , ChessColor . BLACK , new ChessboardPoint( 0 , 2 ) , chessComponents ) ;
        chessComponents [ 0 ] [ 5 ] = new BishopChessComponent( 'B' , ChessColor . BLACK , new ChessboardPoint( 0 , 5 ) , chessComponents ) ;
        chessComponents [ 0 ] [ 3 ] = new QueenChessComponent( 'Q' , ChessColor . BLACK , new ChessboardPoint( 0 , 3 ) , chessComponents ) ;

        chessComponents [ 7 ] [ 4 ] = new KingChessComponent( 'k' , ChessColor . WHITE , new ChessboardPoint( 7 ,4 ) , chessComponents ) ;
        chessComponents [ 7 ] [ 0 ] = new RookChessComponent( 'r' , ChessColor . WHITE , new ChessboardPoint( 7 , 0 ) , chessComponents ) ;
        chessComponents [ 7 ] [ 7 ] = new RookChessComponent( 'r' , ChessColor . WHITE , new ChessboardPoint( 7 , 7 ) , chessComponents ) ;
        chessComponents [ 7 ] [ 6 ] = new KnightChessComponent( 'n' , ChessColor . WHITE , new ChessboardPoint( 7 , 6 ) , chessComponents  ) ;
        chessComponents [ 7 ] [ 1 ] = new KnightChessComponent( 'n' , ChessColor . WHITE , new ChessboardPoint( 7 , 1 ) , chessComponents ) ;
        chessComponents [ 7 ] [ 2 ] = new BishopChessComponent( 'b' , ChessColor . WHITE , new ChessboardPoint( 7 , 2 ), chessComponents  ) ;
        chessComponents [ 7 ] [ 5 ] = new BishopChessComponent( 'b' , ChessColor . WHITE , new ChessboardPoint( 7 , 5 ) , chessComponents ) ;
        chessComponents [ 7 ] [ 3 ] = new QueenChessComponent( 'q' , ChessColor . WHITE , new ChessboardPoint( 7 , 3 ) , chessComponents ) ;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for ( int i = 0 ; i <= 7 ; i ++ ) {
            for ( int j = 0 ; j <= 7 ; j ++ ) {
                chessComponents [ i ][ j ] = fill ( chessboard . get( i ) . charAt( j ) , i , j ) ;
            }
        }
        if ( chessboard . get(8) . equals( "b" ) ) currentPlayer = ChessColor . BLACK ;
        else currentPlayer = ChessColor . WHITE ;
    }

    public ChessComponent fill ( char a , int i , int  j ) {
        ChessComponent chessComponent ;
        ChessboardPoint chessboardPoint = new ChessboardPoint( i , j ) ;
        ChessColor chessColor ;
        chessComponent =  new EmptySlotComponent ( a , ChessColor . NONE , chessboardPoint , chessComponents ) ;

        if ( a == 'R' || a == 'r' ) {
            if ( a == 'R' ) chessColor = ChessColor . BLACK ;
            else chessColor = ChessColor . WHITE ;
            chessComponent = new RookChessComponent( a , chessColor , chessboardPoint , chessComponents ) ;
        }
        if ( a == 'N' || a == 'n' ) {
            if ( a == 'N' ) chessColor = ChessColor . BLACK ;
            else chessColor = ChessColor . WHITE ;
            chessComponent = new KnightChessComponent( a , chessColor , chessboardPoint , chessComponents ) ;
        }
        if ( a == 'B' || a == 'b' ) {
            if ( a == 'B' ) chessColor = ChessColor . BLACK ;
            else chessColor = ChessColor .WHITE ;
            chessComponent = new BishopChessComponent( a , chessColor , chessboardPoint , chessComponents ) ;
        }
        if ( a == 'Q' || a == 'q' ) {
            if ( a == 'Q' ) chessColor = ChessColor . BLACK ;
            else chessColor = ChessColor . WHITE ;
            chessComponent = new QueenChessComponent( a , chessColor , chessboardPoint , chessComponents ) ;
        }
        if ( a == 'K' || a == 'k' ) {
            if ( a == 'K' ) chessColor = ChessColor . BLACK ;
            else chessColor = ChessColor . WHITE ;
            chessComponent = new KingChessComponent( a , chessColor , chessboardPoint , chessComponents ) ;
        }
        if ( a == 'P' || a == 'p' ) {
            if ( a == 'P' ) chessColor = ChessColor . BLACK ;
            else chessColor = ChessColor . WHITE ;
            chessComponent = new PawnChessComponent ( a , chessColor , chessboardPoint , chessComponents ) ;
        }
        return chessComponent ;
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this . currentPlayer;
    }

    @Override
    public String getChessboardGraph(){
        StringBuilder status = new StringBuilder() ;
        for ( int i = 0 ; i <= 7 ; i ++ ) {
            for ( int j = 0 ; j <= 7 ; j ++ ) {
                status . append( chessComponents [ i ] [ j ] . name ) ;
            }
            if ( i == 7 ) continue ;
            status . append( "\n" ) ;
        }
        return  status . toString() ;
    }
    public String getCapturedChess(ChessColor player) {
        int exist [] = new int [ 6 ] ;
        char name [] = { 'K' , 'Q' , 'R' , 'B' , 'N' , 'P' } ;
        int count = 0 ;
        StringBuilder capturedChess = new StringBuilder() ;
        if ( player == ChessColor . WHITE  )count = 32 ;

        for ( int i = 0 ; i <= 7 ; i ++ ) {
            for ( int j = 0 ; j <= 7 ; j ++ ) {
                if ( chessComponents [ i ] [ j ] . name  - count == 'K') { exist [ 0 ] ++ ; continue; }
                if ( chessComponents [ i ] [ j ] . name - count == 'Q' ) { exist [ 1 ] ++ ; continue; }
                if ( chessComponents [ i ] [ j ] . name - count == 'R' ) { exist [ 2 ] ++ ; continue; }
                if ( chessComponents [ i ] [ j ] . name - count == 'B' ) { exist [ 3 ] ++ ; continue; }
                if ( chessComponents [ i ] [ j ] . name - count == 'N' ) { exist [ 4 ] ++ ; continue; }
                if ( chessComponents [ i ] [ j ] . name - count == 'P' ) { exist [ 5 ] ++ ; continue; }
            }
        }
        exist [ 0 ] -= 1 ; exist [ 1 ] -= 1 ; exist [ 2 ] -= 2 ; exist [ 3 ] -= 2 ; exist [ 4 ] -= 2 ; exist [ 5 ] -= 8 ;
        for ( int i = 0 ; i <= 5 ; i ++ ) {
            if ( exist [ i ] != 0 ) {
                capturedChess . append( String . format ( "%c %d\n" , name [ i ] + count , -exist [ i ] ) ) ;
            }
        }
        return capturedChess . toString() ;
    }
    public ChessComponent getChess( int x , int y ) { return chessComponents[x][y] ; }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if ( sourceX < 0 || sourceX >= 8 ) return false ;
        if ( sourceY < 0 || sourceY >= 8 ) return false ;
        if ( targetX < 0 || targetX >= 8 ) return false ;
        if ( targetY < 0 || targetY >= 8 ) return false ;
        if ( ( currentPlayer != chessComponents [ sourceX ] [ sourceY ] . getChessColor())|| ( chessComponents [ sourceX ] [ sourceY ] . name == '_' ) )  return false ;
        if ( chessComponents [ targetX ] [ targetY ] . getChessColor() == chessComponents [ sourceX ] [ sourceY ] . getChessColor() ) return false ;
        else {
            List<ChessboardPoint> sourceCanMove = getCanMovePoints( new ChessboardPoint( sourceX , sourceY ) ) ;
            for ( int i = 0 ; i < sourceCanMove . size() ; i ++ ) {
                if ( sourceCanMove . get( i ) . equals( new ChessboardPoint( targetX , targetY ) )  ) {
                    if ( currentPlayer == ChessColor.WHITE ) currentPlayer = ChessColor . BLACK;
                    else currentPlayer = ChessColor . WHITE ;
                    chessComponents [ targetX ] [ targetY ] = fill( chessComponents [ sourceX ] [sourceY] . name , targetX , targetY ) ;
                    chessComponents [ sourceX ] [ sourceY ] = fill( '_' , sourceX , sourceY ) ;
                    return true ;
                }
            }
            return false ;
        }
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>() ;
        chessboardPointList = chessComponents [ source . getX() ] [ source . getY() ] . canMoveTo() ;
        Collections . sort( chessboardPointList , comparator ) ;
        return  chessboardPointList ;
    }

    Comparator <ChessboardPoint> comparator = new Comparator<ChessboardPoint>() {
        @Override
        public int compare(ChessboardPoint t1, ChessboardPoint t2) {
            if ( t1 . getX() != t2 . getX() ) {
                return t1 . getX() - t2 . getX() ;
            }
            else return t1 . getY() - t2 . getY() ;
        }
    } ;
}
