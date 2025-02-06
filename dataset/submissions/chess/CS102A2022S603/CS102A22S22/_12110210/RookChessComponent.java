import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(int x , int y,ChessColor chessColor,char c){
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
            for(int i = x+1 ;i<8;i++){
                if(this.chessComponent[i][y].chessColor==ChessColor.WHITE){break;}
                value.add(new ChessboardPoint(i,y));
                if(this.chessComponent[i][y].chessColor==ChessColor.BLACK){break;}
            }

            for(int i = x-1 ;i>-1;i--){
                if(this.chessComponent[i][y].chessColor==ChessColor.WHITE){break;}
                value.add(new ChessboardPoint(i,y));
                if(this.chessComponent[i][y].chessColor==ChessColor.BLACK){break;}
            }

            for(int i = y+1 ;i<8;i++){
                if(this.chessComponent[x][i].chessColor==ChessColor.WHITE){break;}
                value.add(new ChessboardPoint(x,i));
                if(this.chessComponent[x][i].chessColor==ChessColor.BLACK){break;}
            }

            for(int i = y-1 ;i>-1;i--){
                if(this.chessComponent[x][i].chessColor==ChessColor.WHITE){break;}
                value.add(new ChessboardPoint(x,i));
                if(this.chessComponent[x][i].chessColor==ChessColor.BLACK){break;}
            }
        }else{
            for(int i = x+1 ;i<8;i++){
                if(this.chessComponent[i][y].chessColor==ChessColor.BLACK){break;}
                value.add(new ChessboardPoint(i,y));
                if(this.chessComponent[i][y].chessColor==ChessColor.WHITE){break;}
            }

            for(int i = x-1 ;i>-1;i--){
                if(this.chessComponent[i][y].chessColor==ChessColor.BLACK){break;}
                value.add(new ChessboardPoint(i,y));
                if(this.chessComponent[i][y].chessColor==ChessColor.WHITE){break;}
            }

            for(int i = y+1 ;i<8;i++){
                if(this.chessComponent[x][i].chessColor==ChessColor.BLACK){break;}
                value.add(new ChessboardPoint(x,i));
                if(this.chessComponent[x][i].chessColor==ChessColor.WHITE){break;}
            }

            for(int i = y-1 ;i>-1;i--){
                if(this.chessComponent[x][i].chessColor==ChessColor.BLACK){break;}
                value.add(new ChessboardPoint(x,i));
                if(this.chessComponent[x][i].chessColor==ChessColor.WHITE){break;}
            }
        }

        return value;
    }
}
