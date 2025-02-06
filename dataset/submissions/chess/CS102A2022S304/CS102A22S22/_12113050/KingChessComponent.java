import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{


    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super();
        setSource(source);
        setChessColor(chessColor);
        if (chessColor==ChessColor.WHITE){
            name='k';
        }else {
            name='K';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
     List<ChessboardPoint> King = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(getSource().getX()-i)<=1&&Math.abs(getSource().getY()-j)<=1&&
                        getChessComponents()[i][j].getChessColor()!=this.getChessColor()){
                    ChessboardPoint n = new ChessboardPoint(i,j);
                    King.add(n);
                }
            }
        }
        return King;
    }
}
