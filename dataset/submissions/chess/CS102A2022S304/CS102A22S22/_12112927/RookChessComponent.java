import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }


    @Override
    public String toString() {
        return String.valueOf(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int x = super.getSource().getX();
        int y = super.getSource().getY();
        int xplus = x + 1;
        int yplus = y + 1;
        int xminus = x - 1;
        int yminus = y - 1;
        while (xplus <= 7) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[xplus][y])) {
                chessboardPoints.add(new ChessboardPoint(xplus, y));
                xplus++;
            } else {
                if (super.DifferentColorJudge(super.getChessColor(), ConcreteChessGame.getchessComponents[xplus][y])) {
                    chessboardPoints.add(new ChessboardPoint(xplus, y));
                    break;
                }
                break;
            }
        }
        while (yplus <= 7) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x][yplus])) {
                chessboardPoints.add(new ChessboardPoint(x, yplus));
                yplus++;
            } else {
                if (super.DifferentColorJudge(super.getChessColor(), ConcreteChessGame.getchessComponents[x][yplus])) {
                    chessboardPoints.add(new ChessboardPoint(x, yplus));
                    break;
                }
                break;
            }
        }
        while (xminus >= 0) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[xminus][y])) {
                chessboardPoints.add(new ChessboardPoint(xminus, y));
                xminus--;
            } else {
                if (super.DifferentColorJudge(super.getChessColor(), ConcreteChessGame.getchessComponents[xminus][y])) {
                    chessboardPoints.add(new ChessboardPoint(xminus, y));
                    break;
                }
                break;
            }
        }
        while (yminus >= 0) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[x][yminus])) {
                chessboardPoints.add(new ChessboardPoint(x, yminus));
                yminus--;
            } else {
                if (super.DifferentColorJudge(super.getChessColor(), ConcreteChessGame.getchessComponents[x][yminus])) {
                    chessboardPoints.add(new ChessboardPoint(x, yminus));
                    break;
                }
                break;
            }
        }
        return chessboardPoints;
    }
}
