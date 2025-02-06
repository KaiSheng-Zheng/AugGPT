import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    boolean killed;
    public RookChessComponent(ChessColor chessColor,ChessboardPoint source)
    {
        super.chessColor=chessColor;
        super.source=source;
        if(chessColor==ChessColor.WHITE)
            super.name='r';
        else if(chessColor==ChessColor.BLACK)
            super.name='R';
    }
    public List<ChessboardPoint> canMoveTo()
    {
        List<ChessboardPoint> out=new ArrayList<ChessboardPoint>();

        return null;
    }
    public void setKilled(){
        killed=true;
        if(chessColor==ChessColor.WHITE)
            nokoru[1][2]--;
        else if(chessColor==ChessColor.BLACK)
            nokoru[0][2]--;
    }
    public String toString() {
        if(chessColor==ChessColor.WHITE)
            return "r";
        else if(chessColor==ChessColor.BLACK)
            return "R";
        else
            return "_";
    }
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination,ChessboardPoint source){
        if(source.getX()==destination.getX()&&source.getY()==destination.getY())
            return false;
        if(chessComponents[destination.getX()][destination.getY()].getChessColor()==chessComponents[source.getX()][source.getY()].getChessColor())
            return false;
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
}
