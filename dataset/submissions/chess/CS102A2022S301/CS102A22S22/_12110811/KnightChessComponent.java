import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{



    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> KnightCanMove=new ArrayList<ChessboardPoint>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((((2*Math.abs(getSource().getX()-i)==Math.abs(getSource().getY()-j))&&Math.abs(getSource().getY()-j)==2)||(2*Math.abs(getSource().getY()-j)==Math.abs(getSource().getX()-i)&&Math.abs(getSource().getX()-i)==2))&&(getNowBoard()[i][j].getChessColor()!=this.getChessColor())){
                    KnightCanMove.add(new ChessboardPoint(i,j));
                }
            }
        }
        return KnightCanMove;
    }
}
