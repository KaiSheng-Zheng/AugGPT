import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent
{
    public BishopChessComponent(int x,int y,ChessColor chessColor,char name)
    {
        setSource(x,y);
        setChessColor(chessColor);
        setName(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo()
    {
        List<ChessboardPoint> output=new ArrayList<>();
        ChessColor color=this.getChessColor();

        for (int i = 1; i < 8; i++)
        {   int x= getSource().getX()+i;
            int y= getSource().getY()+i;
            if(x>=8 || y>=8){break;}
            if (Chessboard[x][y] instanceof EmptySlotComponent) {output.add(new ChessboardPoint(x, y));}
            else
            {if(color !=Chessboard[x][y].getChessColor()) {output.add(new ChessboardPoint(x, y));}
                break;}
        }

        for (int i = 1; i < 8; i++)
        {   int x= getSource().getX()-i;
            int y= getSource().getY()+i;
            if(x<0 || y>=8){break;}
            if (Chessboard[x][y] instanceof EmptySlotComponent) {output.add(new ChessboardPoint(x, y));}
            else
            {if(color !=Chessboard[x][y].getChessColor()) {output.add(new ChessboardPoint(x, y));}
                break;}
        }

        for (int i = 1; i < 8; i++)
        {   int x= getSource().getX()+i;
            int y= getSource().getY()-i;
            if(x>=8 || y<0){break;}
            if (Chessboard[x][y] instanceof EmptySlotComponent) {output.add(new ChessboardPoint(x, y));}
            else
            {if(color !=Chessboard[x][y].getChessColor()) {output.add(new ChessboardPoint(x, y));}
                break;}
        }

        for (int i = 1; i < 8; i++)
        {   int x= getSource().getX()-i;
            int y= getSource().getY()-i;
            if(x<0 || y<0){break;}
            if (Chessboard[x][y] instanceof EmptySlotComponent) {output.add(new ChessboardPoint(x, y));}
            else
            {if(color !=Chessboard[x][y].getChessColor()) {output.add(new ChessboardPoint(x, y));}
                break;}
        }

        return output;
    }
}