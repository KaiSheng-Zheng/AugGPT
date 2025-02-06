import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{



    public PawnChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint) {
       setChessColor ( chessColor );
        setSource ( chessboardPoint );
        if ( chessColor.equals ( ChessColor.BLACK ) ){
            this.name='P';
        }else {
            this.name='p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
         List<ChessboardPoint> chessboardPoints =  new  ArrayList<>();
        int x= getSource ().getX ();int y= getSource ().getY ();
        if ( getChessColor ()==ChessColor.BLACK ){

        if ( x + 1 <8 ) {
            if ( chessboard[x+1][y].getChessColor ()!=ChessColor.BLACK& chessboard[x+1][y].getChessColor ()!=ChessColor.WHITE ) {
                chessboardPoints.add ( new ChessboardPoint ( x+1,y ) );
                if ( x==1 ){
                    if (  chessboard[x+2][y].getChessColor ()!=ChessColor.BLACK& chessboard[x+2][y].getChessColor ()!=ChessColor.WHITE) {
                        chessboardPoints.add ( new ChessboardPoint ( x+2,y ) );
                    }
                }
            }
        }
        if ( !( x + 1 >= 8||y+1>=8 )) {
            if ( getChessColor ()!=chessboard[x+1][y+1].getChessColor ()&&(chessboard[x+1][y+1].getChessColor()==ChessColor.WHITE|chessboard[x+1][y+1].getChessColor()==ChessColor.BLACK) ) {
                chessboardPoints.add ( new ChessboardPoint ( x+1,y+1 ) );
            }
        }
        if ( !( x + 1 >= 8||y-1<=0 )) {
            if ( getChessColor ()!=chessboard[x+1][y-1].getChessColor ()&&(chessboard[x+1][y-1].getChessColor()==ChessColor.WHITE|chessboard[x+1][y+1].getChessColor()==ChessColor.BLACK) ) {
                chessboardPoints.add ( new ChessboardPoint ( x+1,y-1 ) );
            }
        }}


        if ( getChessColor ()==ChessColor.WHITE ){
            if ( x==6 ){
                if ( chessboard[x-2][y].getChessColor ()!=ChessColor.BLACK& chessboard[x-2][y].getChessColor ()!=ChessColor.WHITE) {
                    chessboardPoints.add ( new ChessboardPoint ( x-2,y ) );
                }
            }
            if ( x - 1 >=0 ) {
                if ( chessboard[x-1][y].getChessColor ()!=ChessColor.BLACK& chessboard[x-1][y].getChessColor ()!=ChessColor.WHITE ) {
                    chessboardPoints.add ( new ChessboardPoint ( x-1,y ) );
                }
            }
            if ( !( x - 1 <0||y+1>=8 )) {
                if ( getChessColor ()!=chessboard[x-1][y+1].getChessColor ()&&(chessboard[x-1][y+1].getChessColor()==ChessColor.WHITE|chessboard[x-1][y+1].getChessColor()==ChessColor.BLACK) ) {
                    chessboardPoints.add ( new ChessboardPoint ( x-1,y+1 ) );
                }
            }
            if ( !( x - 1 <0||y-1<=0 )) {
                if ( getChessColor ()!=chessboard[x-1][y-1].getChessColor ()&&(chessboard[x-1][y-1].getChessColor()==ChessColor.WHITE|chessboard[x-1][y+1].getChessColor()==ChessColor.BLACK) ) {
                    chessboardPoints.add ( new ChessboardPoint ( x-1,y-1 ) );
                }
            }}

        chessboardPoints.sort ( new Compare () );
        return  chessboardPoints ;
    }
    public String toString() {
        return String.valueOf ( name );
    }
}
