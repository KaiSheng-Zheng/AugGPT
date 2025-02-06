import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    int x;
    int y;
    public ChessComponent[][] chessComponents;

    public BishopChessComponent(int x, int y, char name) {
        super(x, y, name);
        this.name = 'B';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if(canMoveTo(chessboard,new ChessboardPoint(i,j))&&this.getChessColor()!=chessboard[i][j].getChessColor()){
                    canMoveTo.add(new ChessboardPoint(i,j));
                }
            }
        }
        return canMoveTo;
    }

    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = this.getSource();
        if (source.getX()-source.getY()==destination.getX()-destination.getY()) {
            int col = Math.min(source.getY(),destination.getY())+1;
            int row = Math.min(source.getX(),destination.getX())+1;
            for (;col<Math.max(source.getY(),destination.getY())
                    ;col++,row++)
            {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)){
                    return false;
                }
            }
        } else if (source.getX()+source.getY()==destination.getY()+destination.getX()){
            int col = Math.max(source.getY(),destination.getY())-1;
            int row = Math.min(source.getX(),destination.getX())+1;
            for (;row<Math.max(source.getX(),destination.getX());row++,col--){
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)){
                    return false;
                }
            }
        } else { // Not on the same row or the same column.
            return false;
        }
        return true;
    }

}



