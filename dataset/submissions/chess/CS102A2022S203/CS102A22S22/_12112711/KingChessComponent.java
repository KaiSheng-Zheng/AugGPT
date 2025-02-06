import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(char name,ChessboardPoint source,ChessColor chessColor){
        super(name,source,chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> king = new ArrayList<>();

        int row = getSource().getX();
        int col = getSource().getY();
        for (int i = row-1; i < row+2; i++) {
            for (int j = col-1; j < col+2; j++) {
                if (i < 0 || i > 7 || j < 0 || j > 7){
                    continue;
                }
                if (i == row && j == col){
                    continue;
                }
                if (getChessComponents()[i][j].getChessColor() != getChessColor()){
                    king.add(new ChessboardPoint(i,j));
                }
            }
        }
        return king;
    }

}
