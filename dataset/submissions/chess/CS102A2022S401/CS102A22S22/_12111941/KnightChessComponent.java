import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public KnightChessComponent(ChessboardPoint chessboardPoint,ChessColor color,char name) {
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

    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination ,ChessColor color) {
        ChessboardPoint source = getChessboardPoint();
        int col = source.getY(), row = source.getX();

        if (destination.getY() == col || destination.getX() == row) return false;
        if (Math.abs(destination.getY() - col) + Math.abs(destination.getX() - row) !=3) {return false;}
        if (chessComponents[destination.getX()][destination.getY()].getChessColor()==color){return false;}

        return true;
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