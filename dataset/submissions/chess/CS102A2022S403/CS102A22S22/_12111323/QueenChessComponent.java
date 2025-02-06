import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {


        List<ChessboardPoint> r = new ArrayList<>();
        int x=getSource().getX();
        int y= getSource().getY();
        int i=1;
        while (y+i<8&&ConcreteChessGame.getC()[x][y+i].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        {
            if(ConcreteChessGame.getC()[x][y+i].getChessColor()==ChessColor.NONE)
            {r.add(new ChessboardPoint(x,y+i));
                i++;}
            else
            {r.add(new ChessboardPoint(x,y+i));
                break;}
        }

        i=1;
        while (y-i>=0&&ConcreteChessGame.getC()[x][y-i].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        {if(ConcreteChessGame.getC()[x][y-i].getChessColor()==ChessColor.NONE)
        { r.add(new ChessboardPoint(x,y-i));
            i++;}
        else {
            r.add(new ChessboardPoint(x,y-i));
            break;
        }

        }

        i=1;
        while (x+i<8&&ConcreteChessGame.getC()[x+i][y].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor())
        {if(ConcreteChessGame.getC()[x+i][y].getChessColor()==ChessColor.NONE)
        { r.add(new ChessboardPoint(x+i,y));
            i++;}
        else {
            r.add(new ChessboardPoint(x+i,y));
            break;
        }
        }

        i=1;
        while (x-i>=0&&ConcreteChessGame.getC()[x-i][y].getChessColor()!=ConcreteChessGame.getC()[x][y].getChessColor()) {
            if(ConcreteChessGame.getC()[x-i][y].getChessColor()==ChessColor.NONE)
            {r.add(new ChessboardPoint(x - i, y));
                i++;}
            else {
                r.add(new ChessboardPoint(x - i, y));
                break;
            }
        }
         x=getSource().getX()+1;
         y=getSource().getY()+1;
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



    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
}
