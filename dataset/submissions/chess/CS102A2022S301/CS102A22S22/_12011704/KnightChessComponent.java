import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor,char name) {
        super(source,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> point=new ArrayList<ChessboardPoint>();
        ChessboardPoint des=super.getSource();
        int x=des.getX();int y=des.getY();

        if(x+2<=7 && y+1<=7 && chessboard[x+2][y+1] .getChessColor()!=chessboard[x][y].getChessColor()){point.add(new ChessboardPoint(x+2,y+1));
            //System.out.println(new ChessboardPoint(x+2,y+1));
        }
        if(x+1<=7 && y+2<=7 && chessboard[x+1][y+2] .getChessColor()!=chessboard[x][y].getChessColor()){point.add(new ChessboardPoint(x+1,y+2));}
        if(x+2<=7 && y-1>=0 && chessboard[x+2][y-1] .getChessColor()!=chessboard[x][y].getChessColor()){point.add(new ChessboardPoint(x+2,y-1));}
        if(x+1<=7 && y-2>=0 && chessboard[x+1][y-2] .getChessColor()!=chessboard[x][y].getChessColor()){point.add(new ChessboardPoint(x+1,y-2));}
        if(x-1>=0 && y-2>=0 && chessboard[x-1][y-2] .getChessColor()!=chessboard[x][y].getChessColor()){point.add(new ChessboardPoint(x-1,y-2));}
        if(x-2>=0 && y-1>=0 && chessboard[x-2][y-1] .getChessColor()!=chessboard[x][y].getChessColor()){point.add(new ChessboardPoint(x-2,y-1));}
        if(x-2>=0 && y+1<=7 && chessboard[x-2][y+1] .getChessColor()!=chessboard[x][y].getChessColor()){point.add(new ChessboardPoint(x-2,y+1));}
        if(x-1>=0 && y+2<=7 && chessboard[x-1][y+2] .getChessColor()!=chessboard[x][y].getChessColor()){point.add(new ChessboardPoint(x-1,y+2));}
        return point;
    }

}
