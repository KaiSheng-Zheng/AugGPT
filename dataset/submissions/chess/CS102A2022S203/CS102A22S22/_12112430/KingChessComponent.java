import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
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
        if ((x==1&&y==1)||(x==-1&&y==1)||(x==1&&y==-1)||(x==-1&&y==-1)) {
            return true;
        }
        else if ((x == 1 && y == 0) || (x == -1 && y == 0) || (x == 0 && y == -1) || (x == 0 && y == 1)){
            return true;
        }
        else {return false;}
    }
}

