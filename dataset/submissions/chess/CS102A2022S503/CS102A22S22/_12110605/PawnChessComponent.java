import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent
{
    private ChessboardPoint source= new ChessboardPoint(0,0);
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor chessColor;
    boolean hasMoved = false;

    public PawnChessComponent(ChessComponent[][] chessComponents, int x, int y, ChessColor chessColor)
    {
        this.chessColor=chessColor;
        source.setX(x);
        source.setY(y);
        this.chessComponents=chessComponents;
        this.name =(chessColor==ChessColor.BLACK)?'P':'p';
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
        boolean a = false;
        for(int i = 0;i<8;i++)
        {
            for(int j = 0;j<8;j++)
            {
                if(chessComponents[i][j]instanceof KingChessComponent&&chessComponents[i][j].getChessColor()==ChessColor.BLACK&&i<=3)
                {
                    a = true;
                }

            }
        }
        boolean a1 =chessColor==ChessColor.BLACK&&a;
        boolean a2 =chessColor==ChessColor.WHITE&&!a;
        if(a1||a2)
        {
            hasMoved = source.getX() != 1;
        if(source.getX()+1<8&&chessComponents[source.getX()+1][source.getY()]instanceof EmptySlotComponent)
        {
            ChessboardPoint movePoint = new ChessboardPoint(source.getX()+1,source.getY());
            list.add(movePoint);
            if(!hasMoved&&source.getX()+2<8&&chessComponents[source.getX()+2][source.getY()]instanceof EmptySlotComponent)
            {
                ChessboardPoint movePoint0 = new ChessboardPoint(source.getX()+2,source.getY());
                list.add(movePoint0);
            }
        }
        boolean a3 = source.getX()+1<8&&source.getY()+1<8;
        boolean a4 = source.getX()+1<8&&source.getY()-1>=0;
        if(a3)
        {
            ChessboardPoint movePoint = new ChessboardPoint(source.getX()+1,source.getY()+1);
            if(chessComponents[source.getX()+1][source.getY()+1].getChessColor()!=chessColor&&!(chessComponents[source.getX()+1][source.getY()+1]instanceof EmptySlotComponent))
            {
                list.add(movePoint);
            }
        }
        if(a4)
        {
            ChessboardPoint movePoint0 = new ChessboardPoint(source.getX()+1,source.getY()-1);
            if(chessComponents[source.getX()+1][source.getY()-1].getChessColor()!=chessColor&&!(chessComponents[source.getX()+1][source.getY()-1]instanceof EmptySlotComponent))
            {
                list.add(movePoint0);
            }
        }

        }
        else
        {
            hasMoved = source.getX() != 6;
            if(source.getX()-1>=0&&chessComponents[source.getX()-1][source.getY()]instanceof EmptySlotComponent)
            {
                ChessboardPoint movePoint = new ChessboardPoint(source.getX()-1,source.getY());
                list.add(movePoint);
                if(!hasMoved&&source.getX()-2>=0&&chessComponents[source.getX()-2][source.getY()]instanceof EmptySlotComponent)
                {
                    ChessboardPoint movePoint0 = new ChessboardPoint(source.getX()-2,source.getY());
                    list.add(movePoint0);
                }
            }
            boolean a3 = source.getX()-1>=0&&source.getY()-1>=0;
            boolean a4 = source.getX()-1>=0&&source.getY()+1<8;
            if(a3)
            {
                ChessboardPoint movePoint0 = new ChessboardPoint(source.getX()-1,source.getY()-1);
                if(chessComponents[source.getX()-1][source.getY()-1].getChessColor()!=chessColor&&!(chessComponents[source.getX()-1][source.getY()-1]instanceof EmptySlotComponent))
                {
                    list.add(movePoint0);
                }
            }
            if(a4)
            {
                ChessboardPoint movePoint = new ChessboardPoint(source.getX()-1,source.getY()+1);
                if(chessComponents[source.getX()-1][source.getY()+1].getChessColor()!=chessColor&&!(chessComponents[source.getX()-1][source.getY()+1]instanceof EmptySlotComponent))
                {
                    list.add(movePoint);
                }
            }
        }
        return list;
    }



}
