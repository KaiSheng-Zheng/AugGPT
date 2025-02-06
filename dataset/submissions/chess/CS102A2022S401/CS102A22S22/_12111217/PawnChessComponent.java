import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(int x, int y, ChessColor chessColor, ConcreteChessGame concreteChessGame) {
        this.concreteChessGame = concreteChessGame;
        setSource(new ChessboardPoint(x, y));
        setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK) {
            name = 'P';
        }
        if (chessColor == ChessColor.WHITE) {
            name = 'p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        ChessboardPoint w = this.getSource();
        if (getChessColor() == ChessColor.WHITE) {
            if (w.offset(-1, -1) != null
                    && concreteChessGame.getChess(w.offset(-1, -1)).getChessColor() == ChessColor.BLACK) {
                result.add(w.offset(-1, -1));
            }
            if (w.offset(-1, 1) != null
                    && concreteChessGame.getChess(w.offset(-1, 1)).getChessColor() == ChessColor.BLACK) {
                result.add(w.offset(-1, 1));
            }
            if (w.offset(-1, 0) != null
                    && concreteChessGame.getChess(w.offset(-1, 0)).getChessColor() == ChessColor.NONE) {
                result.add(w.offset(-1,0));
                if (w.getX()==6
                        && concreteChessGame.getChess(w.offset(-2, 0)).getChessColor() == ChessColor.NONE){
                    result.add(w.offset(-2,0));
                }
            }
        }

        if (getChessColor() == ChessColor.BLACK) {
            if (w.offset(1, -1) != null
                    && concreteChessGame.getChess(w.offset(1, -1)).getChessColor() == ChessColor.WHITE) {
                result.add(w.offset(1, -1));
            }
            if (w.offset(1, 1) != null
                    && concreteChessGame.getChess(w.offset(1, 1)).getChessColor() == ChessColor.WHITE) {
                result.add(w.offset(1, 1));
            }
            if (w.offset(1, 0) != null
                    && concreteChessGame.getChess(w.offset(1, 0)).getChessColor() == ChessColor.NONE) {
                result.add(w.offset(1,0));
                if (w.getX()==1
                        && concreteChessGame.getChess(w.offset(2, 0)).getChessColor() == ChessColor.NONE){
                    result.add(w.offset(2,0));
                }
            }
        }
        return result;
    }
}