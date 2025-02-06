import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessColor color, ChessboardPoint chessboardPoint) {
        super('N', color, chessboardPoint);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer = new ArrayList<>();
        for (int i = -1; i < 2; i += 2) {
            if (this.getSource().getX() + i >= 0 && this.getSource().getX() + i <= 7 && this.getSource().getY() + 2 * i >= 0 && this.getSource().getY() + 2 * i <= 7) {
                if (this.chessboard[this.getSource().getX() + i][this.getSource().getY() + 2 * i].getChessColor() != this.getChessColor()) {
                    answer.add(this.chessboard[this.getSource().getX() + i][this.getSource().getY() + 2 * i].getSource());
                }
            }
        }
        for (int i = -1; i < 2; i += 2) {
            if (this.getSource().getX() + i >= 0 && this.getSource().getX() + i <= 7 && this.getSource().getY() - 2 * i >= 0 && this.getSource().getY() - 2 * i <= 7) {
                if (this.chessboard[this.getSource().getX() + i][this.getSource().getY() - 2 * i].getChessColor() != this.getChessColor()) {
                    answer.add(this.chessboard[this.getSource().getX() + i][this.getSource().getY() - 2 * i].getSource());
                }
            }
        }
        for (int i = -1; i < 2; i += 2) {
            if (this.getSource().getY() + i >= 0 && this.getSource().getY() + i <= 7 && this.getSource().getX() + 2 * i >= 0 && this.getSource().getX() + 2 * i <= 7) {
                if (this.chessboard[this.getSource().getX() + 2 * i][this.getSource().getY() + i].getChessColor() != this.getChessColor()) {
                    answer.add(this.chessboard[this.getSource().getX() + 2 * i][this.getSource().getY() + i].getSource());
                }
            }
        }
        for (int i = -1; i < 2; i += 2) {
            if (this.getSource().getY() + i >= 0 && this.getSource().getY() + i <= 7 && this.getSource().getX() - 2 * i >= 0 && this.getSource().getX() - 2 * i <= 7) {
                if (this.chessboard[this.getSource().getX() - 2 * i][this.getSource().getY() + i].getChessColor() != this.getChessColor()) {
                    answer.add(this.chessboard[this.getSource().getX() - 2 * i][this.getSource().getY() + i].getSource());
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
