import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint) {
        setChessColor ( chessColor );
        setSource ( chessboardPoint );
        if ( getChessColor ().equals ( ChessColor.BLACK ) ){
            this.name='K';
        }else {
            this.name='k';
        }

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<> ();
        int x= getSource ().getX ();int y= getSource ().getY ();
        for ( int i = -1; i <2 ; i++ ) {
            for ( int j = -1; j <2 ; j++ ) {
                if ( !( x + i >= 8 | x + i < 0 | y + j >= 8 | y + j < 0 ) ) {
                    if ( getChessColor ()!=chessboard[x+i][y+j].getChessColor () && ( i!=0||j!=0 )) {
                        chessboardPoints.add ( new ChessboardPoint ( x+i,y+j ) );
                    }
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
