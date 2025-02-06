import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessBoard){
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
        this.chessBoard = chessBoard;
    }
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> kk=new ArrayList<>();
        for (int i = getSource().getX()+1; i<8; i++) {
            int yy=getSource().getY();
            if (chessBoard[i][yy] instanceof EmptySlotComponent){
                kk.add(new ChessboardPoint(i,yy));
            }else if (chessBoard[i][yy].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(i,yy));break;}
            else {break;}
        }
        for (int i = getSource().getX()-1; i >=0; i--) {
            int yy=getSource().getY();
            if (chessBoard[i][yy] instanceof EmptySlotComponent){kk.add(new ChessboardPoint(i,yy));}
            else if (chessBoard[i][yy].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(i,yy));break;}
            else {break;}
        }
        for (int i = getSource().getY()+1; i < 8; i++) {
            int xx=getSource().getX();
            if (chessBoard[xx][i] instanceof EmptySlotComponent){kk.add(new ChessboardPoint(xx,i));}
            else if (chessBoard[xx][i].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(xx,i));break;}
            else break;
        }
        for (int i = getSource().getY()-1; i >=0; i--) {
            int xx=getSource().getX();
            if (chessBoard[xx][i] instanceof EmptySlotComponent){kk.add(new ChessboardPoint(xx,i));}
            else if (chessBoard[xx][i].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(xx,i));break;}
            else break;
        }
        return kk;

    }
}
