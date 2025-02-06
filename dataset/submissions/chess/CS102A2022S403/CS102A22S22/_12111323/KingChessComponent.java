import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> r = new ArrayList<>();
        int x=getSource().getX();
        int y=getSource().getY();
        if(x+1>=0&&x+1<8&&y>=0&&y<8&&ConcreteChessGame.getC()[x+1][y].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        r.add(new ChessboardPoint(x+1,y));
        if(x-1>=0&&x-1<8&&y>=0&&y<8&&ConcreteChessGame.getC()[x-1][y].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        r.add(new ChessboardPoint(x-1,y));
        if(x>=0&&x<8&&y+1>=0&&y+1<8&&ConcreteChessGame.getC()[x][y+1].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        r.add(new ChessboardPoint(x,y+1));
        if(x>=0&&x<8&&y-1>=0&&y-1<8&&ConcreteChessGame.getC()[x][y-1].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        r.add(new ChessboardPoint(x,y-1));
        if(x+1>=0&&x+1<8&&y+1>=0&&y+1<8&&ConcreteChessGame.getC()[x+1][y+1].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        r.add(new ChessboardPoint(x+1,y+1));
        if(x+1>=0&&x+1<8&&y-1>=0&&y-1<8&&ConcreteChessGame.getC()[x+1][y-1].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        r.add(new ChessboardPoint(x+1,y-1));
        if(x-1>=0&&x-1<8&&y+1>=0&&y+1<8&&ConcreteChessGame.getC()[x-1][y+1].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        r.add(new ChessboardPoint(x-1,y+1));
        if(x-1>=0&&x-1<8&&y-1>=0&&y-1<8&&ConcreteChessGame.getC()[x-1][y-1].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        r.add(new ChessboardPoint(x-1,y-1));
        return r;
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
}
