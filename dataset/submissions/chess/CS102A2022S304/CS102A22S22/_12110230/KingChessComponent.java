import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent
{
    public KingChessComponent(int x,int y,ChessColor chessColor,char name)
    {
        setSource(x,y);
        setChessColor(chessColor);
        setName(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> output=new ArrayList<>();
         ChessColor color=this.getChessColor();
        List<ChessboardPoint> shouldMove=new ArrayList<>();
        shouldMove.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()+1));
        shouldMove.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()));
        shouldMove.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()-1));
        shouldMove.add(new ChessboardPoint(getSource().getX(), getSource().getY()-1));
        shouldMove.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()-1));
        shouldMove.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()));
        shouldMove.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()+1));
        shouldMove.add(new ChessboardPoint(getSource().getX(), getSource().getY()+1));

        for (ChessboardPoint i:shouldMove)
        {
            if(i.getX()<=7 && i.getX()>=0 && i.getY()<=7 && i.getY()>=0)
            {

                if(Chessboard[i.getX()][i.getY()] instanceof EmptySlotComponent || Chessboard[i.getX()][i.getY()].getChessColor()!=color)
                {
                    output.add(i);
                }
            }
        }
        return output;
    }
}