import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> kk=new ArrayList<>();
        int x=getSource().getX();
        int y=getSource().getY();
        if (x-2>=0&&y+1<8&&chessBoard[x-2][y+1].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x-2,y+1));}
        if (x-1>=0&&y+2<8&&chessBoard[x-1][y+2].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x-1,y+2));}
        if (x-2>=0&&y-1>=0&&chessBoard[x-2][y-1].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x-2,y-1));}
        if (x-1>=0&&y-2>=0&&chessBoard[x-1][y-2].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x-1,y-2));}

        if (x+2<8&&y+1<8&&chessBoard[x+2][y+1].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x+2,y+1));}
        if (x+1<8&&y+2<8&&chessBoard[x+1][y+2].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x+1,y+2));}
        if (x+2<8&&y-1>=0&&chessBoard[x+2][y-1].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x+2,y-1));}
        if (x+1<8&&y-2>=0&&chessBoard[x+1][y-2].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x+1,y-2));}
        return kk;
    }
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessBoard){
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
        this.chessBoard = chessBoard;
    }
}
