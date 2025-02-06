import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char c) {
        super(chessboardPoint, chessColor, c);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = this.getSource();
        ArrayList<ChessboardPoint> CanMoveTo = new ArrayList<>();
        int[] dx = {-1, -1, 1, 1, -2, -2, 2, 2};
        int[] dy = {-2, 2, -2, 2, -1, 1, -1, 1};
        for (int i = 0;i < 8;i++) {
            ChessboardPoint target = source.offset(dx[i], dy[i]);
            if (target == null)
                continue;
            ChessComponent temp = this.getChessComponent(target);
            if (target.legal() && (attack(temp) || temp.name == '_'))
                CanMoveTo.add(target);
        }
        for (int i = 0;i < 8;i++)
            CanMoveTo.remove(null);
        return CanMoveTo;
    }

    public void myShowCanMoveTo(){
        List<ChessboardPoint> CanMoveTo = canMoveTo();
        for (ChessboardPoint i : CanMoveTo)
            System.out.print(i);
    }
}
