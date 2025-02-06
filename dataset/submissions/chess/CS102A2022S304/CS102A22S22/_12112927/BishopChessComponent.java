import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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
        int xplus1 = x + 1;
        int xplus2 = x + 1;
        int yplus1 = y + 1;
        int yplus2 = y + 1;
        int xminus1 = x - 1;
        int xminus2 = x - 1;
        int yminus1 = y - 1;
        int yminus2 = y - 1;
        while (xplus1 <= 7 && yplus1 <= 7) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[xplus1][yplus1])) {
                chessboardPoints.add(new ChessboardPoint(xplus1, yplus1));
                xplus1++;
                yplus1++;
            } else {
                if (super.DifferentColorJudge(super.getChessColor(), ConcreteChessGame.getchessComponents[xplus1][yplus1])) {
                    chessboardPoints.add(new ChessboardPoint(xplus1, yplus1));
                    break;
                }
                break;
            }
        }
        while (xminus2 >= 0 && yplus2 <= 7) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[xminus2][yplus2])) {
                chessboardPoints.add(new ChessboardPoint(xminus2, yplus2));
                yplus2++;
                xminus2--;
            } else {
                if (super.DifferentColorJudge(super.getChessColor(), ConcreteChessGame.getchessComponents[xminus2][yplus2])) {
                    chessboardPoints.add(new ChessboardPoint(xminus2, yplus2));
                    break;
                }
                break;
            }
        }
        while (xplus2 <= 7 && yminus2 >= 0) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[xplus2][yminus2])) {
                chessboardPoints.add(new ChessboardPoint(xplus2, yminus2));
                xplus2++;
                yminus2--;
            } else {
                if (super.DifferentColorJudge(super.getChessColor(), ConcreteChessGame.getchessComponents[xplus2][yminus2])) {
                    chessboardPoints.add(new ChessboardPoint(xplus2, yminus2));
                    break;
                }
                break;
            }
        }
        while (xminus1 >= 0 && yminus1 >= 0) {
            if (EmptyJudge(ConcreteChessGame.getchessComponents[xminus1][yminus1])) {
                chessboardPoints.add(new ChessboardPoint(xminus1, yminus1));
                xminus1--;
                yminus1--;
            } else {
                if (super.DifferentColorJudge(super.getChessColor(), ConcreteChessGame.getchessComponents[xminus1][yminus1])) {
                    chessboardPoints.add(new ChessboardPoint(xminus1, yminus1));
                    break;
                }
                break;
            }
        }
        return chessboardPoints;
    }

}
