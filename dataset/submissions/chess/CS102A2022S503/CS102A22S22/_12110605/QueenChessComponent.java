import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent
{
    private ChessboardPoint source= new ChessboardPoint(0,0);
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor chessColor;
    public QueenChessComponent(ChessComponent[][] chessComponents,int x,int y,ChessColor chessColor)
    {
        this.chessColor=chessColor;
        source.setX(x);
        source.setY(y);
        this.chessComponents=chessComponents;
        super.name =(chessColor==ChessColor.BLACK)?'Q':'q';
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
                boolean same =i==source.getX()&&j==source.getY();
                boolean a1 = i==source.getX()||j==source.getY();
                boolean a2 = source.getX()-i==source.getY()-j||source.getX()-i==j-source.getY();
                boolean a3 = a1||a2;
                    if(!same&&chessComponents[i][j].getChessColor()!=chessColor&&a3){
                        list.add(movePoint);
                    }
            }
        }
        int size = list.size();
        int count = 0;
        for(int i = 0;i<size;i++)
        {
            int x2=list.get(i-count).getX()-source.getX();
            int y2=list.get(i-count).getY()-source.getY();
            boolean hasRemoved = false;
            int jmi =Math.min(list.get(i-count).getX(),source.getX()),jma =Math.max(list.get(i-count).getX(), source.getX());
            int kmi=Math.min(list.get(i-count).getY(), source.getY()),kma=Math.max(list.get(i-count).getY(), source.getY());
            for( int j = jmi;!hasRemoved&&j<=jma;j++)
            {
                for(int k = kmi;!hasRemoved&&k<=kma;k++)
                {
                    int x1 =list.get(i-count).getX()-chessComponents[j][k].getSource().getX();
                    int y1 =list.get(i-count).getY()-chessComponents[j][k].getSource().getY();
                    boolean parallel = x1*y2==x2*y1;
                    boolean same1 = j==source.getX()&&k==source.getY();
                    boolean same2 = j==list.get(i-count).getX()&&k==list.get(i-count).getY();
                    if(!(chessComponents[j][k] instanceof EmptySlotComponent)&&parallel&&!same1&&!same2)
                    {
                        list.remove(i-count);
                        count++;
                        hasRemoved=true;
                    }

                }
            }

        }
        return list;
    }
}
