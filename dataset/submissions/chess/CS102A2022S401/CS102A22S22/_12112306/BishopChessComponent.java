import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(char name, ChessboardPoint point, ChessColor color){
        super.name = name;
        super.setSource(point);
        super.setChessColor(color);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
       int X = getSource().getX();
       int Y = getSource().getY();
       ArrayList<ChessboardPoint> chessBoard = new ArrayList<>();
       ChessComponent chessComponent1 = chessboard[getSource().getX()][getSource().getY()];
        chessBoard = bishop1(chessBoard);
        return chessBoard;
    }
}
