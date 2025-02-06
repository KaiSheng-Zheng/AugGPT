import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends  ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> r = new ArrayList<>();
        int x=getSource().getX();
        int y=getSource().getY();
        if(x+1>=0&&x+1<8&y+2>=0&y+2<8&&ConcreteChessGame.getC()[x+1][y+2].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        {r.add(new ChessboardPoint(x+1,y+2));}
        if(x+1>=0&&x+1<8&y-2>=0&y-2<8&&ConcreteChessGame.getC()[x+1][y-2].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        {r.add(new ChessboardPoint(x+1,y-2));}
        if(x-1>=0&&x-1<8&y+2>=0&y+2<8&&ConcreteChessGame.getC()[x-1][y+2].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        {r.add(new ChessboardPoint(x-1,y+2));}
        if(x-1>=0&&x-1<8&y-2>=0&y-2<8&&ConcreteChessGame.getC()[x-1][y-2].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        {r.add(new ChessboardPoint(x-1,y-2));}
        if(x+2>=0&&x+2<8&y+1>=0&y+1<8&&ConcreteChessGame.getC()[x+2][y+1].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        {r.add(new ChessboardPoint(x+2,y+1));}
        if(x+2>=0&&x+2<8&y-1>=0&y-1<8&&ConcreteChessGame.getC()[x+2][y-1].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        {r.add(new ChessboardPoint(x+2,y-1));}
        if(x-2>=0&&x-2<8&y+1>=0&y+1<8&&ConcreteChessGame.getC()[x-2][y+1].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        {r.add(new ChessboardPoint(x-2,y+1));}
        if(x-2>=0&&x-2<8&y-1>=0&y-1<8&&ConcreteChessGame.getC()[x-2][y-1].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        {r.add(new ChessboardPoint(x-2,y-1));}
        return r;
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
}
