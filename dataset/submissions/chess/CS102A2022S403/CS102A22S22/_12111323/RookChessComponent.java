import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends  ChessComponent {


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
      return r;
    }






    public RookChessComponent(ChessboardPoint source, ChessColor chessColor,char name) {

super(source,chessColor,name);
    }
}