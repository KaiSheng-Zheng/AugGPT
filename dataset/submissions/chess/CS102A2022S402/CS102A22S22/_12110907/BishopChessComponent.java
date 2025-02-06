import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{


    public BishopChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint) {
        setChessColor ( chessColor );
        setSource ( chessboardPoint );

        if ( chessColor.equals ( ChessColor.BLACK ) ){
            this.name='B';
        }else {
            this.name='b';
        }

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<> ();
        int x= getSource ().getX ();int y= getSource ().getY ();

        for ( int i = 1; i < 8; i++ ) {
            if ( !( x + i >= 8 | x + i < 0 | y + i >= 8 | y + i < 0 ) ) {
                if ( chessboard[x+i][y+i].getChessColor ()!=ChessColor.BLACK&chessboard[x+i][y+i].getChessColor ()!=ChessColor.WHITE ) {
                    chessboardPoints.add ( new ChessboardPoint ( x+i,y+i ) );
                }else if ( getChessColor ()!=chessboard[i+1][y+1].getChessColor () ){
                    chessboardPoints.add ( new ChessboardPoint ( x+i,y+i ) );
                    break;
                }else if ( getChessColor ()==chessboard[x+i][y+i].getChessColor () ){
                    break;
                }
            }
        }
        for ( int i = -1; i >-8; i-- ) {
            if ( !( x + i >= 8 | x + i < 0 | y + i >= 8 | y + i < 0 ) ) {
                if ( chessboard[x+i][y+i].getChessColor ()!=ChessColor.BLACK&chessboard[x+i][y+i].getChessColor ()!=ChessColor.WHITE ) {
                    chessboardPoints.add ( new ChessboardPoint ( x+i,y+i ) );
                }else if ( getChessColor ()!=chessboard[x+i][y+i].getChessColor () ){
                    chessboardPoints.add ( new ChessboardPoint ( x+i,y+i ) );
                    break;
                }else if ( getChessColor ()==chessboard[x+i][y+i].getChessColor () ){
                    break;
                }
            }
        }
        for ( int i = 1; i < 8; i++ ) {
            if ( !( x + i >= 8 | x + i < 0 | y - i >= 8 | y - i < 0 ) ) {
                if (chessboard[x+i][y-i].getChessColor ()!=ChessColor.BLACK&chessboard[x+i][y-i].getChessColor ()!=ChessColor.WHITE) {
                    chessboardPoints.add ( new ChessboardPoint ( x+i,y-i ) );
                }else if ( getChessColor ()!=chessboard[x+i][y-i].getChessColor () ){
                    chessboardPoints.add ( new ChessboardPoint ( x+i,y-i ) );
                    break;
                }else if ( getChessColor ()==chessboard[x+i][y-i].getChessColor () ){
                    break;
                }
            }
        }
        for ( int i = -1; i >-8; i-- ) {
            if ( !( x + i >= 8 | x + i < 0 | y - i >= 8 | y - i < 0 ) ) {
                if ( chessboard[x+i][y-i].getChessColor ()!=ChessColor.BLACK&chessboard[x+i][y-i].getChessColor ()!=ChessColor.WHITE) {
                    chessboardPoints.add ( new ChessboardPoint ( x+i,y-i ) );
                }else if ( getChessColor ()!=chessboard[x+i][y-i].getChessColor () ){
                    chessboardPoints.add ( new ChessboardPoint ( x+i,y-i ) );
                    break;
                }else if ( getChessColor ()==chessboard[x+i][y-i].getChessColor () ){
                    break;
                }
            }
        }
        chessboardPoints.sort ( new Compare () );
        return chessboardPoints;
    }
    public String toString() {
        return String.valueOf ( name );
    }
}
