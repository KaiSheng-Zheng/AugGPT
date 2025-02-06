import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;
    public void setSource(ChessboardPoint source)
    {
        this.source = source;
    }

    public void setChessComponents(ChessComponent[][] chessComponents)
    {
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] getChessComponents()
    {
        return chessComponents;
    }

    public void setChessColor(ChessColor chessColor)
    {
        this.chessColor = chessColor;
    }

    public void setName(char name)
    {
        this.name = name;
    }

    public ChessboardPoint getSource()
    {
        return source;
    }

    public ChessColor getChessColor()
    {
        return chessColor;
    }

    public char getName()
    {
        return name;
    }

    //should design
    public ChessComponent(){}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
class KingChessComponent extends ChessComponent
{
    public KingChessComponent(ChessColor color,ChessboardPoint point,ChessComponent[][] chessComponents)
    {
        setChessComponents(chessComponents);
        setChessColor(color);
        setSource(point);
        setName(color==ChessColor.BLACK?'K':'k');
    }

    @Override
    public List<ChessboardPoint> canMoveTo()
    {
        int x=getSource().getX();
        int y=getSource().getY();
        List<ChessboardPoint> points=new ArrayList<ChessboardPoint>();
        if(ChessboardPoint.check(x,y-1)) points.add(new ChessboardPoint(x,y-1));
        if(ChessboardPoint.check(x-1,y-1)) points.add(new ChessboardPoint(x-1,y-1));
        if(ChessboardPoint.check(x+1,y-1)) points.add(new ChessboardPoint(x+1,y-1));
        if(ChessboardPoint.check(x-1,y)) points.add(new ChessboardPoint(x-1,y));
        if(ChessboardPoint.check(x+1,y)) points.add(new ChessboardPoint(x+1,y));
        if(ChessboardPoint.check(x,y+1)) points.add(new ChessboardPoint(x,y+1));
        if(ChessboardPoint.check(x-1,y+1)) points.add(new ChessboardPoint(x-1,y+1));
        if(ChessboardPoint.check(x+1,y+1)) points.add(new ChessboardPoint(x+1,y+1));
        if(points!=null) ConcreteChessGame.kick(getSource(),getChessComponents(),points);
        return points;
    }
}
class QueenChessComponent extends ChessComponent
{
    public QueenChessComponent(ChessColor color,ChessboardPoint point,ChessComponent[][] chessComponents)
    {
        setChessComponents(chessComponents);
        setChessColor(color);
        setSource(point);
        setName(color==ChessColor.BLACK?'Q':'q');
    }
    @Override
    public List<ChessboardPoint> canMoveTo()
    {
        int x=getSource().getX();
        int y=getSource().getY();
        List<ChessboardPoint> points=new ArrayList<>();
        for(int i=0;i<=7;i++) points.add(new ChessboardPoint(i,y));
        for(int i=0;i<=7;i++) points.add(new ChessboardPoint(x,i));
        while(ChessboardPoint.check(x-1,y-1))
        {
            x--;y--;
        }
        while(ChessboardPoint.check(x,y))
        {
            points.add(new ChessboardPoint(x,y));
            x++;y++;
        }
        x=getSource().getX();
        y=getSource().getY();
        while (ChessboardPoint.check(x-1,y+1))
        {
            x--;y++;
        }
        while(ChessboardPoint.check(x,y))
        {
            points.add(new ChessboardPoint(x,y));
            x++;y--;
        }
        if(points!=null) ConcreteChessGame.kick(getSource(),getChessComponents(),points);
        return points;
    }
}
class RookChessComponent extends ChessComponent
{
    public RookChessComponent(ChessColor color,ChessboardPoint point,ChessComponent[][] chessComponents)
    {
        setChessComponents(chessComponents);
        setChessColor(color);
        setSource(point);
        setName(color==ChessColor.BLACK?'R':'r');
    }
    @Override
    public List<ChessboardPoint> canMoveTo()
    {
        int x=getSource().getX();
        int y=getSource().getY();
        List<ChessboardPoint> points=new ArrayList<ChessboardPoint>();
        for(int i=0;i<=7;i++) points.add(new ChessboardPoint(i,y));
        for(int i=0;i<=7;i++) points.add(new ChessboardPoint(x,i));
        if(points!=null) ConcreteChessGame.kick(getSource(),getChessComponents(),points);
        return points;
    }
    public static boolean check(ChessComponent[][] chessComponents,int x1,int y1,int x2,int y2)
    {
        if(x1!=x2 && y1!=y2) return false;
        if(x1==x2) {
            for(int i=Math.max(y1,y2)-1;i>=(Math.min(y1,y2)+1);i--)
            {
                if(chessComponents[x1][i] instanceof EmptyChessComponent) continue;
                else return false;
            }
        }
        if(y1==y2) {
            for(int i=Math.max(x1,x2)-1;i>=(Math.min(x1,x2)+1);i--)
            {
                if(chessComponents[i][y1] instanceof EmptyChessComponent) continue;
                else return false;
            }
        }
        return true;
    }
}
class BishopChessComponent extends ChessComponent
{
    public BishopChessComponent(ChessColor color,ChessboardPoint point,ChessComponent[][] chessComponents)
    {
        setChessComponents(chessComponents);
        setChessColor(color);
        setSource(point);
        setName(color==ChessColor.BLACK?'B':'b');
    }
    @Override
    public List<ChessboardPoint> canMoveTo()
    {
        int x=getSource().getX();
        int y=getSource().getY();
        List<ChessboardPoint> points=new ArrayList<ChessboardPoint>();
        while(ChessboardPoint.check(x-1,y-1))
        {
            x--;y--;
        }
        while(ChessboardPoint.check(x,y))
        {
            points.add(new ChessboardPoint(x,y));
            x++;y++;
        }
        x=getSource().getX();
        y=getSource().getY();
        while (ChessboardPoint.check(x-1,y+1))
        {
            x--;y++;
        }
        while(ChessboardPoint.check(x,y))
        {
            points.add(new ChessboardPoint(x,y));
            x++;y--;
        }
        if(points!=null) ConcreteChessGame.kick(getSource(),getChessComponents(),points);
        return points;
    }
    public static boolean check(ChessComponent[][] chessComponents,int x1,int y1,int x2,int y2)
    {
        if(Math.abs(x1-x2)!=Math.abs(y1-y2)) return false;
        if(x2>x1)
        {
            if(y2>y1)
            {
                for(int i=1;i<=(y2-y1-1);i++)
                {
                    if(chessComponents[x1+i][y1+i] instanceof EmptyChessComponent) continue;
                    else return false;
                }
            }
            if(y2<y1)
            {
                for(int i=1;i<=(y1-y2-1);i++)
                {
                    if(chessComponents[x1+i][y1-i] instanceof EmptyChessComponent) continue;
                    else return false;
                }
            }
        }
        if(x1>x2)
        {
            if(y2>y1)
            {
                for(int i=1;i<=(y2-y1-1);i++)
                {
                    if(chessComponents[x1-i][y1+i] instanceof EmptyChessComponent) continue;
                    else return false;
                }
            }
            if(y2<y1)
            {
                for(int i=1;i<=(y1-y2-1);i++)
                {
                    if(chessComponents[x1-i][y1-i] instanceof EmptyChessComponent) continue;
                    else return false;
                }
            }
        }
        return true;
    }
}
class KnightChessComponent extends ChessComponent
{
    public KnightChessComponent(ChessColor color,ChessboardPoint point,ChessComponent[][] chessComponents)
    {
        setChessComponents(chessComponents);
        setChessColor(color);
        setSource(point);
        setName(color==ChessColor.BLACK?'N':'n');
    }
    @Override
    public List<ChessboardPoint> canMoveTo()
    {
        int x=getSource().getX();
        int y=getSource().getY();
        List<ChessboardPoint> points=new ArrayList<ChessboardPoint>();
        if(ChessboardPoint.check(x-2,y-1)) points.add(new ChessboardPoint(x-2,y-1));
        if(ChessboardPoint.check(x-2,y+1)) points.add(new ChessboardPoint(x-2,y+1));
        if(ChessboardPoint.check(x-1,y-2)) points.add(new ChessboardPoint(x-1,y-2));
        if(ChessboardPoint.check(x-1,y+2)) points.add(new ChessboardPoint(x-1,y+2));
        if(ChessboardPoint.check(x+1,y-2)) points.add(new ChessboardPoint(x+1,y-2));
        if(ChessboardPoint.check(x+1,y+2)) points.add(new ChessboardPoint(x+1,y+2));
        if(ChessboardPoint.check(x+2,y-1)) points.add(new ChessboardPoint(x+2,y-1));
        if(ChessboardPoint.check(x+2,y+1)) points.add(new ChessboardPoint(x+2,y+1));
        if(points!=null) ConcreteChessGame.kick(getSource(),getChessComponents(),points);
        return points;
    }
}
class PawnChessComponent extends ChessComponent
{
    public PawnChessComponent(ChessColor color,ChessboardPoint point,ChessComponent[][] chessComponents)
    {
        setChessComponents(chessComponents);
        setChessColor(color);
        setSource(point);
        setName(color==ChessColor.BLACK?'P':'p');
    }
    @Override
    public List<ChessboardPoint> canMoveTo()
    {
        int x=getSource().getX();
        int y=getSource().getY();
        List<ChessboardPoint> points=new ArrayList<ChessboardPoint>();
        if (getChessColor() == ChessColor.WHITE)
        {
            if(x==6) points.add(new ChessboardPoint(x-2,y));
            if (ChessboardPoint.check(x - 1, y)) points.add(new ChessboardPoint(x-1, y ));
            if (ChessboardPoint.check(x - 1, y-1)) points.add(new ChessboardPoint(x-1, y-1 ));
            if (ChessboardPoint.check(x - 1, y+1)) points.add(new ChessboardPoint(x-1, y+1 ));
            if(points!=null) ConcreteChessGame.kick(getSource(),getChessComponents(),points);
            return points;
        }
        else
        {
            if(x==1) points.add(new ChessboardPoint(x+2,y));
            if (ChessboardPoint.check(x + 1, y)) points.add(new ChessboardPoint(x+1, y ));
            if (ChessboardPoint.check(x + 1, y-1)) points.add(new ChessboardPoint(x+1, y-1 ));
            if (ChessboardPoint.check(x + 1, y+1)) points.add(new ChessboardPoint(x+1, y+1 ));
            if(points!=null) ConcreteChessGame.kick(getSource(),getChessComponents(),points);
            return points;
        }
    }
}
class EmptyChessComponent extends ChessComponent
{
    public EmptyChessComponent()
    {
        setName('_');
    }
    @Override
    public List<ChessboardPoint> canMoveTo()
    {
        List<ChessboardPoint> points=new ArrayList<ChessboardPoint>();
        return points;
    }
}
