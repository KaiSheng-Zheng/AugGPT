import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(int i, int j, char identity){
        super(i,j,identity);
        this.name='N';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveTo = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        ChessboardPoint temp = new ChessboardPoint(x,y);
        canMoveTo.add(temp.offset(2,1));
        canMoveTo.add(temp.offset(2,-1));
        canMoveTo.add(temp.offset(-2,1));
        canMoveTo.add(temp.offset(-2,-1));
        canMoveTo.add(temp.offset(1,2));
        canMoveTo.add(temp.offset(1,-2));
        canMoveTo.add(temp.offset(-1,2));
        canMoveTo.add(temp.offset(-1,-2));
        while (canMoveTo.contains(null)){
            canMoveTo.remove(null);
        }
        for(int i=0;i<canMoveTo.size();i++){
            if(chessboard[canMoveTo.get(i).getX()][canMoveTo.get(i).getY()].chessColor()==this.chessColor()){
                canMoveTo.remove(i);
                i--;
            }
        }
        return canMoveTo;
    }
}
