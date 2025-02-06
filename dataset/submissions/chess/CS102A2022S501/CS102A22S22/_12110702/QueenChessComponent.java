import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> kk=new ArrayList<>();
        int x=getSource().getX();
        int y=getSource().getY();
        for (int i = x+1; i < 8; i++) {
            if (chessBoard[i][y] instanceof EmptySlotComponent){kk.add(new ChessboardPoint(i,y));}
            else if (chessBoard[i][y].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(i,y));break;}
            else break;
        }
        for (int i = x-1; i >=0 ; i--) {
            if (chessBoard[i][y] instanceof EmptySlotComponent){kk.add(new ChessboardPoint(i,y));}
            else if (chessBoard[i][y].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(i,y));break;}
            else break;
        }
        for (int i = y+1; i <8; i++) {
            if (chessBoard[x][i] instanceof EmptySlotComponent){kk.add(new ChessboardPoint(x,i));}
            else if (chessBoard[x][i].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x,i));break;}
            else break;
        }
        for (int i = y-1; i >=0; i--) {
            if (chessBoard[x][i] instanceof EmptySlotComponent){kk.add(new ChessboardPoint(x,i));}
            else if (chessBoard[x][i].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x,i));break;}
            else break;
        }
        for (int i =x+1,j=y+1;i<8&&j<8; i++,j++) {
            if (chessBoard[i][j] instanceof EmptySlotComponent){kk.add(new ChessboardPoint(i,j));}
            else if (chessBoard[i][j].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(i,j));break;}
            else break;
        }
        for (int i =x-1,j=y-1;i>=0&&j>=0; i--,j--) {
            if (chessBoard[i][j] instanceof EmptySlotComponent){kk.add(new ChessboardPoint(i,j));}
            else if (chessBoard[i][j].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(i,j));break;}
            else break;
        }    for (int i =x-1,j=y+1;i>=0&&j<8; i--,j++) {
            if (chessBoard[i][j] instanceof EmptySlotComponent){kk.add(new ChessboardPoint(i,j));}
            else if (chessBoard[i][j].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(i,j));break;}
            else break;
        }        for (int i =x+1,j=y-1;i<8&&j>=0; i++,j--) {
            if (chessBoard[i][j] instanceof EmptySlotComponent){kk.add(new ChessboardPoint(i,j));}
            else if (chessBoard[i][j].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(i,j));break;}
            else break;
        }
        return kk;
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessBoard){
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
        this.chessBoard = chessBoard;
    }
}
