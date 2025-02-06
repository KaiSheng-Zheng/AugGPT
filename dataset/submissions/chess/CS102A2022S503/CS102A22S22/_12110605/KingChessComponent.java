import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent
{
    private ChessboardPoint source = new ChessboardPoint(0,0);
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor chessColor;
    public KingChessComponent(ChessComponent[][] chessComponents,int x,int y,ChessColor chessColor)
{
    this.chessColor=chessColor;
    source.setX(x);
    source.setY(y);
    this.chessComponents=chessComponents;
    super.name =(chessColor==ChessColor.BLACK)?'K':'k';
}

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public List<ChessboardPoint> canMoveTo()
    {
        List<ChessboardPoint> list = new ArrayList<>();
        for(int i =0;i<8;i++)
        {
            for(int j = 0;j<8;j++)
            {
                ChessboardPoint movePoint = new ChessboardPoint(i,j);
                boolean a1 = i-source.getX()==1 || i-source.getX()==-1;
                boolean a2 = j-source.getY()==1 || j-source.getY()==-1;
                boolean a3 = a1&&j-source.getY()==0;
                boolean a4 = a2&&i-source.getX()==0;
                boolean a5 = a2&&a1;
                boolean a6= a3||a4||a5;
                if(a6&&chessComponents[i][j].getChessColor()!=chessColor)
                {
                    list.add(movePoint);
                }
            }
        }
        return list;
    }
}
