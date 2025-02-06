import javax.security.auth.callback.CallbackHandler;
import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] chessComponents, char name) {
        super(source, chessColor, name);
        this.chessComponents = chessComponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> outcome = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(getSource().getX() - i) <= 1 && Math.abs(getSource().getY() - j) <= 1) {
                    if (chessComponents[i][j].getChessColor() != this.getChessColor() && !(i == getSource().getX() && j == getSource().getY())) {
                        outcome.add(new ChessboardPoint(i, j));
                    }//judgment for the validity of camp
                }

            }
        }

        return outcome;

    }
}
