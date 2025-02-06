import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(int x , int y,ChessColor chessColor,char c){
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
            for(int i = 1;x+i<8 && y+i<8;i++){
                if(this.chessComponent[x+i][y+i].chessColor==ChessColor.WHITE){break;}
                value.add(new ChessboardPoint(x+i,y+i));
                if(this.chessComponent[x+i][y+i].chessColor==ChessColor.BLACK){break;}
            }

            for(int i = 1;x-i>-1 && y-i>-1;i++){
                if(this.chessComponent[x-i][y-i].chessColor==ChessColor.WHITE){break;}
                value.add(new ChessboardPoint(x-i,y-i));
                if(this.chessComponent[x-i][y-i].chessColor==ChessColor.BLACK){break;}
            }

            for(int i = 1;x+i<8 && y-i>-1;i++){
                if(this.chessComponent[x+i][y-i].chessColor==ChessColor.WHITE){break;}
                value.add(new ChessboardPoint(x+i,y-i));
                if(this.chessComponent[x+i][y-i].chessColor==ChessColor.BLACK){break;}
            }

            for(int i = 1;x-i>-1 && y+i<8;i++){
                if(this.chessComponent[x-i][y+i].chessColor==ChessColor.WHITE){break;}
                value.add(new ChessboardPoint(x-i,y+i));
                if(this.chessComponent[x-i][y+i].chessColor==ChessColor.BLACK){break;}
            }
        }else{
            for(int i = 1;x+i<8 && y+i<8;i++){
                if(this.chessComponent[x+i][y+i].chessColor==ChessColor.BLACK){break;}
                value.add(new ChessboardPoint(x+i,y+i));
                if(this.chessComponent[x+i][y+i].chessColor==ChessColor.WHITE){break;}
            }

            for(int i = 1;x-i>-1 && y-i>-1;i++){
                if(this.chessComponent[x-i][y-i].chessColor==ChessColor.BLACK){break;}
                value.add(new ChessboardPoint(x-i,y-i));
                if(this.chessComponent[x-i][y-i].chessColor==ChessColor.WHITE){break;}
            }

            for(int i = 1;x+i<8 && y-i>-1;i++){
                if(this.chessComponent[x+i][y-i].chessColor==ChessColor.BLACK){break;}
                value.add(new ChessboardPoint(x+i,y-i));
                if(this.chessComponent[x+i][y-i].chessColor==ChessColor.WHITE){break;}
            }

            for(int i = 1;x-i>-1 && y+i<8;i++){
                if(this.chessComponent[x-i][y+i].chessColor==ChessColor.BLACK){break;}
                value.add(new ChessboardPoint(x-i,y+i));
                if(this.chessComponent[x-i][y+i].chessColor==ChessColor.WHITE){break;}
            }
        }

        return value;
    }
}
