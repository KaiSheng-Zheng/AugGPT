import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
//    private ChessboardPoint source;
//    private ChessColor chessColor;
    private String name;
    public QueenChessComponent(ChessColor chessColor,ChessboardPoint chessboardPoint){
        this.chessColor1=chessColor;
        this.source1=chessboardPoint;
        if (chessColor==ChessColor.BLACK){name="Q";}
        if (chessColor==ChessColor.WHITE){name="q";}
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
        for (int i=x+1;i<=7;i++){
            if (getCurrentColor(chessboard[i][y].toString().charAt(0))!=chessColor1 ) {
                MoveTo.add(new ChessboardPoint(i, y));}
            if ((getCurrentColor(chessboard[i][y].toString().charAt(0))==ChessColor.WHITE
                    ||getCurrentColor(chessboard[i][y].toString().charAt(0))==ChessColor.BLACK) ){
                break;
            }
        }
        for (int i=x-1;i>=0;i--){
            if (getCurrentColor(chessboard[i][y].toString().charAt(0))!=chessColor1 ) {
                MoveTo.add(new ChessboardPoint(i, y));}
            if ((getCurrentColor(chessboard[i][y].toString().charAt(0))==ChessColor.WHITE
                    ||getCurrentColor(chessboard[i][y].toString().charAt(0))==ChessColor.BLACK) ){
                break;
            }
        }
        for (int j=y+1;j<=7;j++){
            if (getCurrentColor(chessboard[x][j].toString().charAt(0))!=chessColor1 ) {
                MoveTo.add(new ChessboardPoint(x,j));}
            if ((getCurrentColor(chessboard[x][j].toString().charAt(0))==ChessColor.WHITE
                    ||getCurrentColor(chessboard[x][j].toString().charAt(0))==ChessColor.BLACK) ){
                break;
            }
        }
        for (int j=y-1;j>=0;j--){
            if (getCurrentColor(chessboard[x][j].toString().charAt(0))!=chessColor1 ) {
                MoveTo.add(new ChessboardPoint(x,j));}
            if ((getCurrentColor(chessboard[x][j].toString().charAt(0))==ChessColor.WHITE
                    ||getCurrentColor(chessboard[x][j].toString().charAt(0))==ChessColor.BLACK) ){
                break;
            }
        }



        for (int d=1;d<=Math.min(7-source1.getX(),7-source1.getY());d++){
            if (getCurrentColor(chessboard[x+d][y+d].toString().charAt(0))!=chessColor1){
                MoveTo.add(new ChessboardPoint(x+d,y+d));}
            if ((getCurrentColor(chessboard[x+d][y+d].toString().charAt(0))==ChessColor.WHITE
                    ||getCurrentColor(chessboard[x+d][y+d].toString().charAt(0))==ChessColor.BLACK) ){
                break;
            }
        }
        for (int d=1;d<=Math.min(source1.getX(),source1.getY());d++){
            if (getCurrentColor(chessboard[x-d][y-d].toString().charAt(0))!=chessColor1){
                MoveTo.add(new ChessboardPoint(x-d,y-d));}
            if ((getCurrentColor(chessboard[x-d][y-d].toString().charAt(0))==ChessColor.WHITE
                    ||getCurrentColor(chessboard[x-d][y-d].toString().charAt(0))==ChessColor.BLACK) ){
                break;
            }
        }


        for (int d=1;d<=Math.min(source1.getX(),7-source1.getY());d++){
            if (getCurrentColor(chessboard[x-d][y+d].toString().charAt(0))!=chessColor1){
                MoveTo.add(new ChessboardPoint(x-d,y+d));}
            if ((getCurrentColor(chessboard[x-d][y+d].toString().charAt(0))==ChessColor.WHITE
                    ||getCurrentColor(chessboard[x-d][y+d].toString().charAt(0))==ChessColor.BLACK) ){
                break;
            }
        }
        for (int d=1;d<=Math.min(7-source1.getX(),source1.getY());d++){
            if (getCurrentColor(chessboard[x+d][y-d].toString().charAt(0))!=chessColor1){
                MoveTo.add(new ChessboardPoint(x+d,y-d));}
            if ((getCurrentColor(chessboard[x+d][y-d].toString().charAt(0))==ChessColor.WHITE
                    ||getCurrentColor(chessboard[x+d][y-d].toString().charAt(0))==ChessColor.BLACK) ){
                break;
            }
        }

        return MoveTo;
    }
    public ChessboardPoint getSource(){
        return source1;
    }
}