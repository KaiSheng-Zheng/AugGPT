import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent(int x, int y, ChessColor color,ConcreteChessGame concreteChessGame) {
        super(x, y, color,concreteChessGame);
    }


    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints= new ArrayList<>();
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

        if (destination.getX()>8||destination.getX()<0)return false;
        if (destination.getY()>8||destination.getY()<0)return false;
        int rowD=source.getX()-destination.getX();
        int colD=source.getY()-destination.getY();


        if (rowD != 0 && Math.abs(colD) == Math.abs(rowD)) {
            int q=colD>0?-1:1;
            int p=rowD>0?-1:1;
            int col = source.getY();
            int row = source.getX();
            for (col+=q,row+=p; colD>0?col>destination.getY():col<destination.getY(); col+=q,row+=p) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }return true;
        }


        return false;
    }
}
