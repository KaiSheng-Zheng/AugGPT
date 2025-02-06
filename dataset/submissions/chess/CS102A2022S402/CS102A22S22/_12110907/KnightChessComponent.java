import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{


    public KnightChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint) {
        setChessColor ( chessColor );
        setSource ( chessboardPoint );

        if ( chessColor.equals ( ChessColor.BLACK ) ){
            this.name='N';
        }else {
            this.name='n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<> ();
        int x= getSource ().getX ();int y= getSource ().getY ();
        if ( ! ( ( x <= 1 ) || ( y <= 0 ) || ( chessboard[ x - 2 ][ y - 1 ].getChessColor ( ) == getChessColor ( ) ) ) )
            chessboardPoints.add ( new ChessboardPoint ( x - 2 , y - 1 ) );
        
        if ( ! ( x <= 0 || y <= 1 || chessboard[ x - 1 ][ y - 2 ].getChessColor ( ) == getChessColor ( ) ) )
            chessboardPoints.add ( new ChessboardPoint ( x - 1 , y - 2 ) );
        
        if ( ! ( x <= 1 || y >= 7 || chessboard[ x - 2 ][ y + 1 ].getChessColor ( ) == getChessColor ( ) ) )
            chessboardPoints.add ( new ChessboardPoint ( x - 2 , y + 1 ) );
        
        if ( ! ( x <= 0 || y >= 6 || chessboard[ x - 1 ][ y + 2 ].getChessColor ( ) == getChessColor ( ) ) )
            chessboardPoints.add ( new ChessboardPoint ( x - 1 , y + 2 ) );
        
        if ( ! ( x >= 7 || y <= 1 || chessboard[ x + 1 ][ y - 2 ].getChessColor ( ) == getChessColor ( ) ) )
            chessboardPoints.add ( new ChessboardPoint ( x + 1 , y - 2 ) );
        
        if ( ! ( x >= 6 || y <= 0 || chessboard[ x + 2 ][ y - 1 ].getChessColor ( ) == getChessColor ( ) ) )
            chessboardPoints.add ( new ChessboardPoint ( x + 2 , y - 1 ) );
        
        if ( ! ( x >= 7 || y >= 6 || chessboard[ x + 1 ][ y + 2 ].getChessColor ( ) == getChessColor ( ) ) )
            chessboardPoints.add ( new ChessboardPoint ( x + 1 , y + 2 ) );
        
        if ( ! ( x >= 6 || y >= 7 || chessboard[ x + 2 ][ y + 1 ].getChessColor ( ) == getChessColor ( ) ) )
            chessboardPoints.add ( new ChessboardPoint ( x + 2 , y + 1 ) );
        chessboardPoints.sort ( new Compare () );

        return chessboardPoints;
    }
    public String toString() {
        return String.valueOf ( name );
    }
}
