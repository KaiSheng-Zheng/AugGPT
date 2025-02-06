import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move=new ArrayList<>();
        int x=this.getSource().getX();
        int y=this.getSource().getY();
        for (int i =0; i <8 ; i++) {
            for (int j =0; j <8 ; j++) {
                if ((Math.abs(x-i)==1)&&(Math.abs(y-j)==2)&& getChessComponents()[i][j].getChessColor()!=this.getChessColor()){
                    move.add(new ChessboardPoint(i,j));
                }
                if ((Math.abs(x-i)==2)&&(Math.abs(y-j)==1)&& getChessComponents()[i][j].getChessColor()!=this.getChessColor()){
                    move.add(new ChessboardPoint(i,j));
                }
            }
        }
        return move;
    }
}
