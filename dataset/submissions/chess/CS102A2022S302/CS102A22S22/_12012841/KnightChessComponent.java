import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    int x=this.getSource().getX();
    int y=this.getSource().getY();
    public KnightChessComponent(int indexOf, int i, ChessColor black, char b) {
        super(indexOf, i, black, b);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> point=new ArrayList<>();
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j < 8; j++) {
                if ((Math.abs(x-i)==1&&Math.abs(y-j)==2)||(Math.abs(x-i)==2&&Math.abs(y-j)==1)){
                    if (chessboard[i][j].getChessColor()!=this.getChessColor()){
                        point.add(new ChessboardPoint(i,j));
                    }
                }

            }

        }
        return point;
    }
}
