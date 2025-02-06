import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        int m = this.getSource().getX();
        int n = this.getSource().getY();

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (m+i < 8 && n+j < 8 && m+i >= 0 && n+j >= 0){
                    if (chessComponents[m + i][n + j].getChessColor() != this.getChessColor()) {
                        result.add(this.getSource().offset(i, j));
                    }
                }
            }
        }
        return result;
    }
}
