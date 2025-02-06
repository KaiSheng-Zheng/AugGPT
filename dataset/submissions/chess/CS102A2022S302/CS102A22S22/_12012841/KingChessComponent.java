import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    int x=this.getSource().getX();
    int y=this.getSource().getY();
    public KingChessComponent(int indexOf, int i, ChessColor black, char b) {
        super(indexOf, i, black, b);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> point=new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <8 ; j++) {
               if ((Math.abs(x-i)==1&&Math.abs(y-j)==0)||(Math.abs(x-i)==0&&Math.abs(y-j)==1)||(Math.abs(x-i)==1&&Math.abs(y-j)==1)){
                   if (chessboard[i][j].getChessColor()!=this.getChessColor()){
                       point.add(new ChessboardPoint(i,j));
                   }
                }
            }

        }
        return point;
    }
}