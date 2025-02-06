import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{



    public QueenChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint) {
        setChessColor ( chessColor );
        setSource ( chessboardPoint );
        if ( getChessColor ().equals ( ChessColor.BLACK ) ){
            this.name='Q';
        }else {
            this.name='q';
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

        //
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
