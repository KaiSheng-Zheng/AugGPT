import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent
{
    private ChessboardPoint source = new ChessboardPoint(0,0);
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor chessColor;
    public KnightChessComponent(ChessComponent[][] chessComponents,int x,int y,ChessColor chessColor)
    {
        this.chessColor=chessColor;
        source.setX(x);
        source.setY(y);
        this.chessComponents=chessComponents;
        super.name =(chessColor==ChessColor.BLACK)?'N':'n';
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
        for(int i =0;i<8;i++)
        {
            for(int j = 0;j<8;j++)
            {
                ChessboardPoint movePoint = new ChessboardPoint(i,j);
                boolean a1 = i-source.getX()==2 || i-source.getX()==-2;
                boolean a2 = j-source.getY()==2 || j-source.getY()==-2;
                boolean a3 = j-source.getY()==1 || source.getY()-j==1;
                boolean a4 = i-source.getX()==1 || source.getX()-i==1;
                boolean a5 = a1&&a3;
                boolean a6 = a2&&a4;
                boolean a7= a5||a6;
                boolean canMove = chessComponents[i][j].getChessColor()!=chessColor;
                if(a7&&canMove)
                {
                    list.add(movePoint);
                }
            }
        }
        return list;
    }
}
