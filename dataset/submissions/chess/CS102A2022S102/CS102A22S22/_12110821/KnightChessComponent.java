import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor, char name, int x, int y, ChessComponent[][] chessComponents) {
        super(chessColor, name, x, y, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        //horse
        ArrayList<ChessboardPoint> temp=new ArrayList<>();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                int tx=Math.abs(getSource().getX()-i);
                int ty=Math.abs(getSource().getY()-j);
                if ((tx==1&&ty==2)||(tx==2&&ty==1)){
                    temp.add(new ChessboardPoint(i,j));
                }
            }
        }
        temp.removeIf(dot -> array[getSource().getX()][getSource().getY()].getChessColor() .equals(array[dot.getX()][dot.getY()].getChessColor()) );
        return temp;
    }
}
