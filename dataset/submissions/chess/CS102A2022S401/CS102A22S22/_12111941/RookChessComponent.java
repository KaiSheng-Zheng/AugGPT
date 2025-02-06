import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public RookChessComponent(ChessboardPoint chessboardPoint,ChessColor color,char name) {
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
        if (chessComponents[destination.getX()][destination.getY()].getChessColor()==color)return false;
        if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY() == destination.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else { // Not on the same row or the same column.
            return false;
        }
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
