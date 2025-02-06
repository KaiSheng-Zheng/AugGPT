import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] chessComponents, char name) {
        super(source, chessColor, name);
        this.chessComponents = chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> outcome = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean isValid = ((Math.abs(getSource().getX() - i) == 1) && (Math.abs(getSource().getY() - j) == 2)) || ((Math.abs(getSource().getX() - i) == 2) && (Math.abs(getSource().getY() - j) == 1));
                if (isValid) {
                    if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                        outcome.add(new ChessboardPoint(i, j));
                    }//judgment for the validity of camp
                } else {

                }
            }
        }

        return outcome;
    }
}
