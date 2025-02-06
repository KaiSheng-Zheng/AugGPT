import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent( ChessColor color,ChessboardPoint chessboardPoint) {
        super('B', color,chessboardPoint);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer = new ArrayList<>();
        answer.addAll(this.crossLineComponentCheck());
        Collections.sort(answer);
        return answer;
    }
}
