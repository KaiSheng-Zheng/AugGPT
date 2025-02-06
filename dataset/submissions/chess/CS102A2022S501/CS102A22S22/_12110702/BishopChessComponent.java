import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> kk=new ArrayList<>();
        int x=getSource().getX();
        int y=getSource().getY();
        while(true){
        x++;
        y++;
            if (x<8&&y<8) {
                if (chessBoard[x][y] instanceof EmptySlotComponent){
                    kk.add(new ChessboardPoint(x,y));
                }
                else if (chessBoard[x][y].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x,y));break;}
                else {break;}
            }
            else break;
        }
         x=getSource().getX();
         y=getSource().getY();
         while (true){
             x--;
             y--;
             if (x>=0&&y>=0){
                 if (chessBoard[x][y] instanceof EmptySlotComponent){kk.add(new ChessboardPoint(x,y));}
                 else if (chessBoard[x][y].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x,y));break;}
                 else break;
             }
             else break;
         }
         x=getSource().getX();
         y=getSource().getY();
         while (true){
             x++;
             y--;
             if (x<8&&y>=0){
                 if (chessBoard[x][y] instanceof EmptySlotComponent){kk.add(new ChessboardPoint(x,y));}
                 else if (chessBoard[x][y].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x,y));break;}
                 else{break;}
             }
             else break;
         }
         x=getSource().getX();
         y=getSource().getY();
         while (true){
             x--;
             y++;
             if (x>=0&&y<8){
                 if (chessBoard[x][y] instanceof EmptySlotComponent){kk.add(new ChessboardPoint(x,y));}
                 else if (chessBoard[x][y].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x,y));break;}
                 else {break;}
             }
             else break;
         }
         return kk;

    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessBoard){
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
        this.chessBoard = chessBoard;
    }
}
