import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> kk=new ArrayList<>();
        int x=getSource().getX();
        int y=getSource().getY();
        if (x!=7&&x!=0&&y!=0&&y!=7){
            if (chessBoard[x-1][y-1].getChessColor()!=getChessColor())kk.add(new ChessboardPoint(x-1,y-1));
            if (chessBoard[x-1][y].getChessColor()!=getChessColor())kk.add(new ChessboardPoint(x-1,y));
            if (chessBoard[x-1][y+1].getChessColor()!=getChessColor())kk.add(new ChessboardPoint(x-1,y+1));
            if (chessBoard[x][y+1].getChessColor()!=getChessColor())kk.add(new ChessboardPoint(x,y+1));
            if (chessBoard[x][y-1].getChessColor()!=getChessColor())kk.add(new ChessboardPoint(x,y-1));
            if (chessBoard[x+1][y-1].getChessColor()!=getChessColor()) kk.add(new ChessboardPoint(x+1,y-1));
            if (chessBoard[x+1][y].getChessColor()!=getChessColor()) kk.add(new ChessboardPoint(x+1,y));
            if (chessBoard[x+1][y+1].getChessColor()!=getChessColor()) kk.add(new ChessboardPoint(x+1,y+1));
        }
        else{
            for (int i = x-1; i <x+2; i++) {
                for (int j = y-1; j < y+2; j++) {
                    if (i>=0&&i<8&&j>=0&&j<=8&&chessBoard[i][j].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(i,j));}
                }
            }
            kk.remove(new ChessboardPoint(x,y));
        }
        return kk;
    }

    public KingChessComponent (ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessBoard){
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
        this.chessBoard = chessBoard;
    }
}
