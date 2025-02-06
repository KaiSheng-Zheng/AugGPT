import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> sc=new ArrayList<>();
        for (int i = Math.max(0,super.getSource().getX()-1); i <= Math.min(7,super.getSource().getX()+1); i++) {
            for (int j = Math.max(0,super.getSource().getY()-1); j <= Math.min(7,super.getSource().getY()+1); j++) {
                if(i >= 0 && j >= 0 && (i != super.getSource().getX() || j != super.getSource().getY())){
                    if(chessBoard[i][j].getChessColor()!=super.getChessColor()){
                        sc.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        return sc;
    }
}
