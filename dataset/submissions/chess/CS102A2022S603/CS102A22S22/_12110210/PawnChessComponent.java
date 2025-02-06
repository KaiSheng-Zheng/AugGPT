import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(int x , int y,ChessColor chessColor,char c){
        setSource(x,y);
        setChessColor(chessColor);
        setName(c);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> value = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if(getChessColor()==ChessColor.WHITE){
            if(x-1>-1&&this.chessComponent[x-1][y].chessColor==ChessColor.NONE){value.add(new ChessboardPoint(x-1,y));}
            if(x==6){value.add(new ChessboardPoint(x-2,y));}
            if(x-1>-1&&y+1<8&&this.chessComponent[x-1][y+1].chessColor==ChessColor.BLACK){value.add(new ChessboardPoint(x-1,y+1));}
            if(x-1>-1&&y-1>-1&&this.chessComponent[x-1][y-1].chessColor==ChessColor.BLACK){value.add(new ChessboardPoint(x-1,y-1));}
        }else{
            if(x+1<8&&this.chessComponent[x+1][y].chessColor==ChessColor.NONE){value.add(new ChessboardPoint(x+1,y));}
            if(x==1){value.add(new ChessboardPoint(x+2,y));}
            if(x+1<8&&y+1<8&&this.chessComponent[x+1][y+1].chessColor==ChessColor.WHITE){value.add(new ChessboardPoint(x+1,y+1));}
            if(x+1<8&&y-1>-1&&this.chessComponent[x+1][y-1].chessColor==ChessColor.WHITE){value.add(new ChessboardPoint(x+1,y-1));}
        }
        return value;
    }
}
