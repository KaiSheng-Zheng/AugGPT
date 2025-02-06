import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(int x, int y, ChessColor color,ConcreteChessGame concreteChessGame) {
        super(x, y, color,concreteChessGame);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints= new ArrayList<ChessboardPoint>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent e= belonging.getChessComponents()[i][j];
                if (this.move(belonging.getChessComponents(),e.getChessboardPoint()))chessboardPoints.add(e.getChessboardPoint());
            }

        }
        return chessboardPoints;
    }

    public boolean move(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
if (this.getChessColor()==chessComponents[destination.getX()][destination.getY()].getChessColor())return false;
        if (destination.getX() > 8 || destination.getX() < 0) return false;
        if (destination.getY() > 8 || destination.getY() < 0) return false;

        int rowD = source.getX() - destination.getX();
        int colD = source.getY() - destination.getY();
        if (rowD != 0 && colD == 0) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }else if (rowD == 0 && colD != 0) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }else if (rowD != 0 && Math.abs(colD) == Math.abs(rowD)) {
            int q=colD>0?-1:1;
            int p=rowD>0?-1:1;
            int col = source.getY();
            int row = source.getX();
            for (col+=q,row+=p; colD>0?col>destination.getY():col<destination.getY(); col+=q,row+=p) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }else return false;

        return true;
    }
}
