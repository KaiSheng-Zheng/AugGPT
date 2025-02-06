import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    public RookChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name) {
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
            if (chessComponents[x][i].getChessColor() != getChessColor()) {
                int E = 0;
                for (int j = Math.min(i, y) + 1; j < Math.max(i, y); j++) {
                    if (chessComponents[x][j].getChessColor() != ChessColor.NONE) { 
                        E++;
                    }
                }
                if (E == 0) {
                    count++;
                    ChessboardPoint e = new ChessboardPoint(x, i);
                    output.add(e);
                }
            }
        }
        
        for (int i = 0; i < 8; i++) {
            if (chessComponents[i][y].getChessColor() != getChessColor()) {
                int E = 0;
                for (int j = Math.min(i, x) + 1; j < Math.max(i, x); j++) {
                    if (chessComponents[j][y].getChessColor() != ChessColor.NONE) { 
                        E++;
                    }
                }
                if (E == 0) {
                    count++;
                    ChessboardPoint e = new ChessboardPoint(i, y);
                    output.add(e);
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

