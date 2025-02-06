
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessColor color,ChessboardPoint chessboardPoint) {
        super('P', color,chessboardPoint);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer = new ArrayList<>();
        if (this.getChessColor() == ChessColor.BLACK) {
            if (this.getSource().getX() + 1 <= 7) {
                if (this.chessboard[this.getSource().getX() + 1][this.getSource().getY()].name == '_') {
                    answer.add(this.chessboard[this.getSource().getX() + 1][this.getSource().getY()].getSource());
                }
            }
            if (this.getSource().getX() == 1) {
                if (this.chessboard[this.getSource().getX() + 2][this.getSource().getY()].name == '_'&&this.chessboard[this.getSource().getX() + 1][this.getSource().getY()].name == '_') {
                    answer.add(this.chessboard[this.getSource().getX() + 2][this.getSource().getY()].getSource());
                }
            }
            if (this.getSource().getX() + 1 <= 7 && this.getSource().getY() - 1 >= 0) {
                if (this.chessboard[this.getSource().getX() + 1][this.getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                    answer.add(this.chessboard[this.getSource().getX() + 1][this.getSource().getY() - 1].getSource());
                }
            }
            if (this.getSource().getX() + 1 <= 7 && this.getSource().getY() + 1 <=7) {
                if (this.chessboard[this.getSource().getX() + 1][this.getSource().getY() + 1].getChessColor() == ChessColor.WHITE) {
                    answer.add(this.chessboard[this.getSource().getX() + 1][this.getSource().getY() + 1].getSource());
                }
            }
        } else if (this.getChessColor()==ChessColor.WHITE){
            if (this.getSource().getX() -1>=0) {
                if (this.chessboard[this.getSource().getX() - 1][this.getSource().getY()].name == '_') {
                    answer.add(this.chessboard[this.getSource().getX() - 1][this.getSource().getY()].getSource());
                }
            }
            if (this.getSource().getX() == 6) {
                if (this.chessboard[this.getSource().getX()-2][this.getSource().getY()].name == '_'&&this.chessboard[this.getSource().getX() - 1][this.getSource().getY()].name == '_') {
                    answer.add(this.chessboard[this.getSource().getX() - 2][this.getSource().getY()].getSource());
                }
            }
            if (this.getSource().getX() -1>=0 && this.getSource().getY() - 1 >= 0) {
                if (this.chessboard[this.getSource().getX() -1][this.getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                    answer.add(this.chessboard[this.getSource().getX() - 1][this.getSource().getY() - 1].getSource());
                }
            }
            if (this.getSource().getX() -1>=0 && this.getSource().getY() + 1 <=7) {
                if (this.chessboard[this.getSource().getX() - 1][this.getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                    answer.add(this.chessboard[this.getSource().getX() - 1][this.getSource().getY() + 1].getSource());
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}
