import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
//    private ChessboardPoint source;
//    private ChessColor chessColor;
    private String name;

    public BishopChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint) {
        this.chessColor1 = chessColor;
        this.source1 = chessboardPoint;
        if (chessColor == ChessColor.BLACK) {
            name = "B";
        }
        if (chessColor == ChessColor.WHITE) {
            name = "b";
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> MoveTo= new ArrayList<>();
        int x=source1.getX();
        int y=source1.getY();
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

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public ChessboardPoint getSource(){
        return source1;
    }
}