import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent
{
    private ChessboardPoint source = new ChessboardPoint(0,0);
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor chessColor;
    public RookChessComponent(ChessComponent[][] chessComponents,int x,int y,ChessColor chessColor)
    {
        this.chessColor=chessColor;
        source.setX(x);
        source.setY(y);
        this.chessComponents=chessComponents;
        super.name =(chessColor==ChessColor.BLACK)?'R':'r';
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
            for(int i = source.getX(), j = 0;j<8;j++)
            {
                if(j==source.getY())
                {
                    continue;
                }
                ChessboardPoint movePoint = new ChessboardPoint(i,j);
                boolean canMove = chessComponents[i][j].getChessColor()!=chessColor;
                if(canMove){
                    list.add(movePoint);
                }
            }
            for(int j = source.getY(), i = 0;i<8;i++)
            {
                if(i==source.getX())
                {
                    continue;
                }
                ChessboardPoint movePoint = new ChessboardPoint(i,j);
                boolean canMove = chessComponents[i][j].getChessColor()!=chessColor;
                if(canMove){
                    list.add(movePoint);
                }
            }
            int count = 0;
            int size = list.size();

            for(int i = 0;i< size;i++)
            {
                int a = source.getX(),b = source.getY();
                int c = list.get(i-count).getX(),d=list.get(i-count).getY();
                int e =Math.max(a,c),f=Math.min(a,c);
                int g= Math.max(b,d),h=Math.min(b,d);
                boolean hasRemoved = false;
                for(int j = f+1;j<e;j++)
                {
                    if(!(chessComponents[j][b] instanceof EmptySlotComponent))
                    {
                        list.remove(i-count);
                        hasRemoved = true;
                        count++;
                        break;
                    }

                }
                for(int j=h+1;j<g&&!hasRemoved;j++)
                {
                    if(!(chessComponents[a][j] instanceof EmptySlotComponent))
                    {
                        list.remove(i-count);
                        count++;
                        break;
                    }
                }
            }
            return list;
    }
}

