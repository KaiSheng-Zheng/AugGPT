import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor,char name) {
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> point=new ArrayList<ChessboardPoint>();
        ChessboardPoint des=super.getSource();
        int x=des.getX();int y=des.getY();

        if(getChessColor()==ChessColor.BLACK){
            if(x+1<=7 && chessboard[x+1][y] .getChessColor()==ChessColor.NONE){
                point.add(new ChessboardPoint(x+1,y));
                if(x==1 && chessboard[3][y] .getChessColor()==ChessColor.NONE && chessboard[x+1][y] .getChessColor()==ChessColor.NONE){point.add(new ChessboardPoint(3,y));}
            }
            if(x+1<=7 && y+1<=7 && chessboard[x+1][y+1].getChessColor()==ChessColor.WHITE){
                point.add(new ChessboardPoint(x+1,y+1));
            }
            if(x+1<=7 && y-1>=0 && chessboard[x+1][y-1].getChessColor()==ChessColor.WHITE){
                point.add(new ChessboardPoint(x+1,y-1));
            }

        }
        if(getChessColor()==ChessColor.WHITE){
            if(x-1>=0 && chessboard[x-1][y] .getChessColor()==ChessColor.NONE){
                point.add(new ChessboardPoint(x-1,y));
                if(x==6 && chessboard[4][y] .getChessColor()==ChessColor.NONE && chessboard[x-1][y] .getChessColor()==ChessColor.NONE){point.add(new ChessboardPoint(4,y));}
            }
            if(x-1>=0 && y+1<=7 && chessboard[x-1][y+1] .getChessColor()==ChessColor.BLACK){
                point.add(new ChessboardPoint(x-1,y+1));
            }
            if(x-1>=0 && y-1>=0 && chessboard[x-1][y-1] .getChessColor()==ChessColor.BLACK){
                point.add(new ChessboardPoint(x-1,y-1));
            }
        }
        return point;
    }
}
