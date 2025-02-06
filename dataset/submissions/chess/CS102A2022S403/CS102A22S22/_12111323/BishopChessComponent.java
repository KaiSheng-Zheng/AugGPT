import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends  ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> r = new ArrayList<>();

        int x=getSource().getX()+1;
        int y=getSource().getY()+1;
        while (x<8&&y<8&&ConcreteChessGame.getC()[x][y].getChessColor()!=ConcreteChessGame.getC()[getSource().getX()][getSource().getY()].getChessColor())
        {
if(ConcreteChessGame.getC()[x][y].getChessColor()==ChessColor.NONE)
{ r.add(new ChessboardPoint(x,y));
            x++;
            y++;}
else {
    r.add(new ChessboardPoint(x,y));
    break;
}

        }

        x=getSource().getX()-1;
        y=getSource().getY()-1;
        while (x>=0&&y>=0&&ConcreteChessGame.getC()[x][y].getChessColor()!=ConcreteChessGame.getC()[getSource().getX()][getSource().getY()].getChessColor())
        {
            if(ConcreteChessGame.getC()[x][y].getChessColor()==ChessColor.NONE)
            { r.add(new ChessboardPoint(x,y));
            x--;
            y--;}
            else {
                r.add(new ChessboardPoint(x,y));
                break;
            }

        }

        x=getSource().getX()+1;
        y=getSource().getY()-1;
        while (x<8&&y>=0&&ConcreteChessGame.getC()[x][y].getChessColor()!=ConcreteChessGame.getC()[getSource().getX()][getSource().getY()].getChessColor())
        {
            if(ConcreteChessGame.getC()[x][y].getChessColor()==ChessColor.NONE)
            { r.add(new ChessboardPoint(x,y));
            x++;
            y--;}
            else {
                r.add(new ChessboardPoint(x,y));
                break;
            }

        }

        x=getSource().getX()-1;
        y=getSource().getY()+1;
        while (x>=0&&y<8&&ConcreteChessGame.getC()[x][y].getChessColor()!=ConcreteChessGame.getC()[getSource().getX()][getSource().getY()].getChessColor())
        {
            if(ConcreteChessGame.getC()[x][y].getChessColor()==ChessColor.NONE)
            {  r.add(new ChessboardPoint(x,y));
            x--;
            y++;}
            else {
                r.add(new ChessboardPoint(x,y));
                break;
            }

        }

        return r;
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
}
