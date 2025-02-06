import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent( ChessColor color,ChessboardPoint chessboardPoint) {
        super('Q', color,chessboardPoint);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer=new ArrayList<>();
        answer.addAll(this.columnComponentCheck());
        answer.addAll(this.rowComponentCheck());
        answer.addAll(this.crossLineComponentCheck());
        Collections.sort(answer);
        return answer;
    }
}
