import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent( ChessColor color,ChessboardPoint chessboardPoint) {
        super('R', color,chessboardPoint);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer=new ArrayList<>();
        answer.addAll(this.rowComponentCheck());
        answer.addAll(this.columnComponentCheck());
        Collections.sort(answer);
        return answer;
    }
}
