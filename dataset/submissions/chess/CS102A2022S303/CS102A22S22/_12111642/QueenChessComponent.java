import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    ChessComponent[][] chessComponents;
    public QueenChessComponent(ChessColor color,int x,int y,ChessComponent[][] chessComponents){
        this.chessComponents = chessComponents;
        setSource(new ChessboardPoint(x,y));
        setChessColor(color);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> output = new ArrayList<>();
        for (int i = 0; i<8 ; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint n = new ChessboardPoint(i,j);
                if(canMove(n)) output.add(n);
            }
        }
        return output;
    }
    public boolean canMove(ChessboardPoint destination){
        ChessboardPoint source = super.getSource();
        if(chessComponents[destination.getX()][destination.getY()].getChessColor() ==
                chessComponents[source.getX()][source.getY()].getChessColor())
            return false;
        if (destination.getX()-source.getX() == destination.getY() - source.getY()) {
            int d = source.getX() - source.getY();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[col +d][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (destination.getX()-source.getX() ==source.getY() - destination.getY()) {
            int d = source.getX() + source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][d-row] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getX() == destination.getX()) {
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
        } else {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        if(super.getChessColor() == ChessColor.BLACK)
            return String.valueOf('Q');
        else return String.valueOf('q');
    }
}
