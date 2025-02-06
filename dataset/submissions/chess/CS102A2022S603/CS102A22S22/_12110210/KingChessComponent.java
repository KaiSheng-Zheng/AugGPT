import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(int x , int y,ChessColor chessColor,char c){
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
            if(x+1<8&&this.chessComponent[x+1][y].chessColor!=ChessColor.WHITE){value.add(new ChessboardPoint(x+1,y));}
            if(x-1>-1&&this.chessComponent[x-1][y].chessColor!=ChessColor.WHITE){value.add(new ChessboardPoint(x-1,y));}
            if(y+1<8&&this.chessComponent[x][y+1].chessColor!=ChessColor.WHITE){value.add(new ChessboardPoint(x,y+1));}
            if(y-1>-1&&this.chessComponent[x][y-1].chessColor!=ChessColor.WHITE){value.add(new ChessboardPoint(x,y-1));}

            if(x+1<8&&y+1<8&&this.chessComponent[x+1][y+1].chessColor!=ChessColor.WHITE){value.add(new ChessboardPoint(x+1,y+1));}
            if(x+1<8&&y-1>-1&&this.chessComponent[x+1][y-1].chessColor!=ChessColor.WHITE){value.add(new ChessboardPoint(x+1,y-1));}
            if(x-1>-1&&y+1<8&&this.chessComponent[x-1][y+1].chessColor!=ChessColor.WHITE){value.add(new ChessboardPoint(x-1,y+1));}
            if(x-1>-1&&y-1>-1&&this.chessComponent[x-1][y-1].chessColor!=ChessColor.WHITE){value.add(new ChessboardPoint(x-1,y-1));}
        }else{
            if(x+1<8&&this.chessComponent[x+1][y].chessColor!=ChessColor.BLACK){value.add(new ChessboardPoint(x+1,y));}
            if(x-1>-1&&this.chessComponent[x-1][y].chessColor!=ChessColor.BLACK){value.add(new ChessboardPoint(x-1,y));}
            if(y+1<8&&this.chessComponent[x][y+1].chessColor!=ChessColor.BLACK){value.add(new ChessboardPoint(x,y+1));}
            if(y-1>-1&&this.chessComponent[x][y-1].chessColor!=ChessColor.BLACK){value.add(new ChessboardPoint(x,y-1));}

            if(x+1<8&&y+1<8&&this.chessComponent[x+1][y+1].chessColor!=ChessColor.BLACK){value.add(new ChessboardPoint(x+1,y+1));}
            if(x+1<8&&y-1>-1&&this.chessComponent[x+1][y-1].chessColor!=ChessColor.BLACK){value.add(new ChessboardPoint(x+1,y-1));}
            if(x-1>-1&&y+1<8&&this.chessComponent[x-1][y+1].chessColor!=ChessColor.BLACK){value.add(new ChessboardPoint(x-1,y+1));}
            if(x-1>-1&&y-1>-1&&this.chessComponent[x-1][y-1].chessColor!=ChessColor.BLACK){value.add(new ChessboardPoint(x-1,y-1));}
        }

        return value;
    }
}
