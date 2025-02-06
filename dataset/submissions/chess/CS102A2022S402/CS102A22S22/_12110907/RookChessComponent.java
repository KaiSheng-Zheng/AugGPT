import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{


    public RookChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint) {
        setChessColor ( chessColor );
        setSource ( chessboardPoint );
        if ( getChessColor ().equals ( ChessColor.BLACK ) ){
            this.name='R';
        }else {
            this.name='r';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<> ();
        int x= getSource ().getX ();int y= getSource ().getY ();

        for ( int i = x+1; i <= 7; i++ ) {
            if (  chessboard[i][y].getChessColor ()!=ChessColor.BLACK&chessboard[i][y].getChessColor ()!=ChessColor.WHITE) {
                chessboardPoints.add ( new ChessboardPoint ( i,y ) );
            }else if ( getChessColor () !=chessboard[i][y].getChessColor () ){
                chessboardPoints.add ( new ChessboardPoint ( i,y ) );
                break;
            }else if ( getChessColor () ==chessboard[i][y].getChessColor () ){
                break;
            }
        }
        for ( int i = x-1; i >=0; i-- ) {
            if (  chessboard[i][y].getChessColor ()!=ChessColor.BLACK&chessboard[i][y].getChessColor ()!=ChessColor.WHITE) {
                chessboardPoints.add ( new ChessboardPoint ( i,y ) );
            }else if ( getChessColor () !=chessboard[i][y].getChessColor () ){
                break;
            }
            else if ( getChessColor () ==chessboard[i][y].getChessColor () ){
                break;
            }
        }
        for ( int i = y-1; i >=0; i-- ) {
            if ( chessboard[x][i].getChessColor ()!=ChessColor.BLACK&chessboard[x][i].getChessColor ()!=ChessColor.WHITE) {
                chessboardPoints.add ( new ChessboardPoint ( x,i ) );
            }else if ( getChessColor () !=chessboard[x][i].getChessColor () ){
                chessboardPoints.add ( new ChessboardPoint ( x,i ) );
                break;
            }else if ( getChessColor () ==chessboard[x][i].getChessColor () ){
                break;
            }
        }
        for ( int i = y+1; i <= 7; i++ ) {
            if ( chessboard[x][i].getChessColor ()!=ChessColor.BLACK&chessboard[x][i].getChessColor ()!=ChessColor.WHITE) {
                chessboardPoints.add ( new ChessboardPoint ( x,i ) );
            }else if ( getChessColor () !=chessboard[x][i].getChessColor () ){
                chessboardPoints.add ( new ChessboardPoint ( x,i ) );
                break;
            }else if ( getChessColor () ==chessboard[x][i].getChessColor () ){
                break;
            }
        }

      chessboardPoints.sort ( new Compare () );
        return chessboardPoints;
    }

    public String toString() {
        return String.valueOf ( name );
    }
}
