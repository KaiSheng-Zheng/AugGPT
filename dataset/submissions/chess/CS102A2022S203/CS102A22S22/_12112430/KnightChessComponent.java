import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMoveTo= new ArrayList<>();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if ((canMoveTo(this.getChessboardPoint(),new ChessboardPoint(i,j)))
                        &&(this.getChessColor()!=chessComponents[i][j].getChessColor())){
                    canMoveTo.add(new ChessboardPoint(i,j));
                }
            }
        }
        return canMoveTo;
    }
    public boolean canMoveTo(ChessboardPoint source, ChessboardPoint destination) {
        int x=destination.getX()-source.getX();
        int y=destination.getY()-source.getY();
        // Not on the same row or the same column.
        if ((x==1&&y==2)||(x==-1&&y==2)||(x==1&&y==-2)||(x==-1&&y==-2)) {
            return true;
        }
        else return (x == 2 && y == 1) || (x == -2 && y == 1) || (x == 2 && y == -1) || (x == -2 && y == -1);
    }
}
