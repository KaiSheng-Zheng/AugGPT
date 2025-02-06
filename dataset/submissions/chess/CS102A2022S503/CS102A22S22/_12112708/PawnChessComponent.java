
import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
//    private ChessboardPoint source;
//    private ChessColor chessColor;
    private String name;
    public PawnChessComponent(ChessColor chessColor,ChessboardPoint chessboardPoint){
        this.chessColor1=chessColor;
        this.source1=chessboardPoint;
        if (chessColor==ChessColor.BLACK){name="P";}
        if (chessColor==ChessColor.WHITE){name="p";}
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> MoveTo=new ArrayList<>();
        int x=source1.getX();
        int y=source1.getY();
        if(chessColor1==ChessColor.WHITE){
            if(x!=0 && getCurrentColor(chessboard[x-1][y].toString().charAt(0))==ChessColor.NONE){
                MoveTo.add(new ChessboardPoint(x-1,y));
                if(x==6&&getCurrentColor(chessboard[x-2][y].toString().charAt(0))==ChessColor.NONE){
                    MoveTo.add(new ChessboardPoint(x-2,y));
                }
            }
            if(x!=0 &&y!=0&&getCurrentColor(chessboard[x-1][y-1].toString().charAt(0))==ChessColor.BLACK){
                MoveTo.add(new ChessboardPoint(x-1,y-1));
            }
            if(x!=0 &&y!=7&&getCurrentColor(chessboard[x-1][y+1].toString().charAt(0))==ChessColor.BLACK){
                MoveTo.add(new ChessboardPoint(x-1,y+1));
            }
        }
        if (chessColor1==ChessColor.BLACK){
            if(x!=7&&getCurrentColor(chessboard[x+1][y].toString().charAt(0))==ChessColor.NONE){
                MoveTo.add(new ChessboardPoint(x+1,y));
                if(x==1&&getCurrentColor(chessboard[x+2][y].toString().charAt(0))==ChessColor.NONE){
                    MoveTo.add(new ChessboardPoint(x+2,y));
                }
            }
            if(x!=7&&y!=0&&getCurrentColor(chessboard[x+1][y-1].toString().charAt(0))==ChessColor.WHITE){
                MoveTo.add(new ChessboardPoint(x+1,y-1));
            }
            if(x!=7&&y!=7&&getCurrentColor(chessboard[x+1][y+1].toString().charAt(0))==ChessColor.WHITE){
                MoveTo.add(new ChessboardPoint(x+1,y+1));
            }
        }
        return MoveTo;
    }
    public ChessboardPoint getSource(){
        return source1;
    }
}