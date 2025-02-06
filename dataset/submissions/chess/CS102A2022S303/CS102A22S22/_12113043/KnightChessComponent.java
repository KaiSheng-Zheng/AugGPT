import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name) {
        super(chessboardPoint, chessColor);
        this.name = name;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = chessboard;
        ChessboardPoint source = getSource();
        int x = source.getX();
        int y = source.getY();
        int count = 0;
        List<ChessboardPoint> output = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getChessColor() !=getChessColor()) {
                    if ((i - x) * (i - x) + (j - y) * (j - y) == 5) {
                        count++;
                        ChessboardPoint e = new ChessboardPoint(i, j);
                        output.add(e);
                    }
                }
            }
        }
        if (count > 0) {
            return output;
        } else {
            return new ArrayList<>();
        }
    }
}
