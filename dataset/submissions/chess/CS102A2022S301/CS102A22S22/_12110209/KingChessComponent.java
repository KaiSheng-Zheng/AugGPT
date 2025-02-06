import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessColor color, ChessboardPoint chessboardPoint) {
        super('K', color, chessboardPoint);
    }

    public List<ChessboardPoint> canMoveTo() {

        List<ChessboardPoint> answer = new ArrayList<>();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (this.getSource().getY() + j >= 0 && this.getSource().getY() + j <= 7 && (i != 0 || j != 0) && this.getSource().getX() + i >= 0 && this.getSource().getX() + i <= 7) {
                    if (this.chessboard[this.getSource().getX() + i][this.getSource().getY() + j].name == '_') {
                        answer.add(this.chessboard[this.getSource().getX() + i][this.getSource().getY() + j].getSource());
                    } else if (!Character.isLowerCase(this.name) && Character.isLowerCase(chessboard[this.getSource().getX() + i][this.getSource().getY() + j].name)) {
                        answer.add(this.chessboard[this.getSource().getX() + i][this.getSource().getY() + j].getSource());
                    }
                }
            }

        }
        Collections.sort(answer);
        return answer;
    }
}
