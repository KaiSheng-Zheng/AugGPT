import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent
{
    public PawnChessComponent(int x,int y,ChessColor chessColor,char name)
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
        if(color==ChessColor.BLACK)
        {
            if (getSource().getX() == 1)
            {
                if(Chessboard[2][getSource().getY()] instanceof EmptySlotComponent && Chessboard[3][getSource().getY()] instanceof EmptySlotComponent )
                {output.add(new ChessboardPoint(3, getSource().getY()));}
            }
            if(getSource().getX()+1<=7)
            {
                if(Chessboard[getSource().getX()+1][getSource().getY()] instanceof EmptySlotComponent)output.add(new ChessboardPoint(getSource().getX()+1, getSource().getY() ));
                if(getSource().getY()+1<=7)
                {if(Chessboard[getSource().getX()+1][getSource().getY()+1].getChessColor()==ChessColor.WHITE){output.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()+1 ));}}
                if(getSource().getY()-1>=0)
                {if(Chessboard[getSource().getX()+1][getSource().getY()-1].getChessColor()==ChessColor.WHITE){output.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()-1 ));}}
            }
        }
        if(color==ChessColor.WHITE)
        {
            if (getSource().getX() == 6)
            {
                if(Chessboard[5][getSource().getY()] instanceof EmptySlotComponent && Chessboard[4][getSource().getY()] instanceof EmptySlotComponent )
                {output.add(new ChessboardPoint(4, getSource().getY()));}
            }
            if(getSource().getX()-1>=0)
            {
                if(Chessboard[getSource().getX()-1][getSource().getY()] instanceof EmptySlotComponent){output.add(new ChessboardPoint(getSource().getX()-1, getSource().getY() ));}
                if(getSource().getY()+1<=7)
                {if(Chessboard[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.BLACK){output.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()+1 ));}}
                if(getSource().getY()-1>=0)
                {if(Chessboard[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.BLACK){output.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()-1 ));}}
            }
        }
        return output;
    }
}