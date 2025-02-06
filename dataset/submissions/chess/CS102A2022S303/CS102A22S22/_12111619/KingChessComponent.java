import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> returnValue = new ArrayList<>();
        ChessboardPoint nowMovingTo;
        for (int i = 0; i < 8; i++) {
            nowMovingTo = this.source.offset(generalMoveDirection[i][0],generalMoveDirection[i][1]);
            if(nowMovingTo == null){
                continue;
            }
            if(chessComponents[nowMovingTo.getX()][nowMovingTo.getY()].getChessColor() != chessColor){
                returnValue.add(nowMovingTo);
            }
        }
        return returnValue;
    }
}
