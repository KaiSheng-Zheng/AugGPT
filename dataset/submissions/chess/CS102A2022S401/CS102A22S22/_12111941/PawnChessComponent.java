import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public PawnChessComponent(ChessboardPoint chessboardPoint,ChessColor color,char name) {
        this.source=chessboardPoint;
        this.chessColor=color;
        this.name=name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints=new ArrayList<ChessboardPoint>();
        for (int i=0;i<8;i++){
            for (int m=0;m<8;m++){
                ChessboardPoint chessboardPoint=new ChessboardPoint(i,m);
                if (this.canMoveTo(ConcreteChessGame.chessComponent2,chessboardPoint,chessColor))
                    chessboardPoints.add(chessboardPoint);
            }
        }

        return chessboardPoints;

    }

    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination,ChessColor color) {
        ChessboardPoint source = getChessboardPoint();
        int col = source.getY(), row = source.getX();

        if (chessComponents[destination.getX()][destination.getY()].getChessColor()==color)return false;

        if (this.chessColor==ChessColor.BLACK && row==1 && destination.getY()==col && destination.getX()-row>=1 && destination.getX()-row<=2 && (chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) return true;
        if (this.chessColor==ChessColor.BLACK && destination.getY()==col && destination.getX()-row==1 && (chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) return true;
        if (this.chessColor==ChessColor.BLACK && Math.abs(destination.getY()-col)==1 && destination.getX()-row==1 && !(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) return true;

        if (this.chessColor==ChessColor.WHITE && row==6 && destination.getY()==col && destination.getX()-row>=-2 && destination.getX()-row<=-1 && (chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) return true;
        if (this.chessColor==ChessColor.WHITE && destination.getY()==col && destination.getX()-row==-1 && (chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) return true;
        if (this.chessColor==ChessColor.WHITE && Math.abs(destination.getY()-col)==1 && destination.getX()-row==-1 && !(chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) return true;
        return false;
    }

    public ChessboardPoint getChessboardPoint() {
        return source;
    }

    public ChessColor getChessColor(){return chessColor;}

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
