import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent
{
    private ChessboardPoint source = new ChessboardPoint(0,0);
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor chessColor;
    public BishopChessComponent(ChessComponent[][] chessComponents,int x,int y,ChessColor chessColor)
    {
        this.chessColor=chessColor;
        source.setX(x);
        source.setY(y);
        this.chessComponents=chessComponents;
        super.name =(chessColor==ChessColor.BLACK)?'B':'b';
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    public List<ChessboardPoint> canMoveTo()
    {
        List<ChessboardPoint> list = new ArrayList<>();
       for(int i = source.getX()+1,j=source.getY()+1;i<8&&j<8;i++,j++)
       {
           ChessboardPoint movePoint = new ChessboardPoint(i,j);
               if(chessComponents[i][j] instanceof EmptySlotComponent){
                   list.add(movePoint);
               }
               else if(chessComponents[i][j].getChessColor()!=chessColor)
               {
                   list.add(movePoint);
                   break;
               }
               else if(chessComponents[i][j].getChessColor()==chessColor)
               {
                   break;
               }
       }
        for(int i = source.getX()-1,j=source.getY()-1;i>=0&&j>=0;i--,j--)
        {
            ChessboardPoint movePoint = new ChessboardPoint(i,j);
            if(chessComponents[i][j] instanceof EmptySlotComponent){
                list.add(movePoint);
            }
            else if(chessComponents[i][j].getChessColor()!=chessColor)
            {
                list.add(movePoint);
                break;
            }
            else if(chessComponents[i][j].getChessColor()==chessColor)
            {
                break;
            }
        }
        for(int i = source.getX()+1,j=source.getY()-1;i<8&&j>=0;i++,j--)
        {
            ChessboardPoint movePoint = new ChessboardPoint(i,j);
            if(chessComponents[i][j] instanceof EmptySlotComponent){
                list.add(movePoint);
            }
            else if(chessComponents[i][j].getChessColor()!=chessColor)
            {
                list.add(movePoint);
                break;
            }
            else if(chessComponents[i][j].getChessColor()==chessColor)
            {
                break;
            }
        }
        for(int i = source.getX()-1,j=source.getY()+1;i>=0&&j<8;i--,j++)
        {
            ChessboardPoint movePoint = new ChessboardPoint(i,j);
            if(chessComponents[i][j] instanceof EmptySlotComponent){
                list.add(movePoint);
            }
            else if(chessComponents[i][j].getChessColor()!=chessColor)
            {
                list.add(movePoint);
                break;
            }
            else if(chessComponents[i][j].getChessColor()==chessColor)
            {
                break;
            }
        }
       return list;
    }
}
