import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
//    private ChessboardPoint source;
//    private ChessColor chessColor;
    private String name;
    public KnightChessComponent(ChessColor chessColor,ChessboardPoint chessboardPoint){
        this.chessColor1=chessColor;
        this.source1=chessboardPoint;
        if (chessColor==ChessColor.BLACK){name="N";}
        if (chessColor==ChessColor.WHITE){name="n";}
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> MoveTo= new ArrayList<>();
        int x=source1.getX();
        int y=source1.getY();
        if (x>=2&&y>=1&&getCurrentColor(chessboard[x-2][y-1].toString().charAt(0))!=chessColor1){
            MoveTo.add(new ChessboardPoint(x-2,y-1));}
        if (x>=2&&y<=6&&getCurrentColor(chessboard[x-2][y+1].toString().charAt(0))!=chessColor1){
            MoveTo.add(new ChessboardPoint(x-2,y+1));}

        if (x>=1&&y>=2&&getCurrentColor(chessboard[x-1][y-2].toString().charAt(0))!=chessColor1){
            MoveTo.add(new ChessboardPoint(x-1,y-2));}
        if (x>=1&&y<=5&&getCurrentColor(chessboard[x-1][y+2].toString().charAt(0))!=chessColor1){
            MoveTo.add(new ChessboardPoint(x-1,y+2));}

        if (x<=6&&y>=2&&getCurrentColor(chessboard[x+1][y-2].toString().charAt(0))!=chessColor1){
            MoveTo.add(new ChessboardPoint(x+1,y-2));}
        if (x<=6&&y<=5&&getCurrentColor(chessboard[x+1][y+2].toString().charAt(0))!=chessColor1){
            MoveTo.add(new ChessboardPoint(x+1,y+2));}

        if (x<=5&&y>=1&&getCurrentColor(chessboard[x+2][y-1].toString().charAt(0))!=chessColor1){
            MoveTo.add(new ChessboardPoint(x+2,y-1));}
        if (x<=5&&y<=6&&getCurrentColor(chessboard[x+2][y+1].toString().charAt(0))!=chessColor1){
            MoveTo.add(new ChessboardPoint(x+2,y+1));}

        return MoveTo;
    }
    public ChessboardPoint getSource(){
        return source1;
    }
}