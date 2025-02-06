import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(char c, int i, int j, ChessComponent[][] chessComponents) {
        super(c,i,j,chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        cmt.clear();
        cmt.add(getSource().offset(-2,-1));
        cmt.add(getSource().offset(-2,1));
        cmt.add(getSource().offset(-1,-2));
        cmt.add(getSource().offset(-1,2));
        cmt.add(getSource().offset(1,-2));
        cmt.add(getSource().offset(1,2));
        cmt.add(getSource().offset(2,-1));
        cmt.add(getSource().offset(2,1));
        cmt.removeIf(Objects::isNull);
        cmt.removeIf(chessboardPoint -> getChessComponent(chessboardPoint).getChessColor()==getChessColor());
        return cmt;
    }
}
