

import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move=new ArrayList<>();
        int x=this.getSource().getX();
        int y=this.getSource().getY();
        for (int i =x-1; i <=x+1 ; i++) {
            for (int j = y-1; j <=y+1 ; j++) {
                if (i<0||i>=8||j<0||j>=8) {
                }
                else if (this.getChessComponents()[i][j].getChessColor()!=this.getChessColor()){
                    move.add(new ChessboardPoint(i,j));
                }
            }
        }
        move.remove(this.getSource());
        return move;
    }
}
