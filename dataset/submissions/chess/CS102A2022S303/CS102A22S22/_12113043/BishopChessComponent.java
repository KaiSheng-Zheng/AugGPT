import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name) {
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
                if (i + j == x + y
                        && chessComponents[i][j].getChessColor() != getChessColor()) {
                    int N = Math.abs(x - i);
                    int row = Math.min(x, i);
                    int col = Math.max(y, j);
                    int E = 0;
                    for (int k = 1; k < N; k++) {
                        if (chessComponents[row + k][col - k].getChessColor() != ChessColor.NONE) {
                            E++;
                        }
                    }
                    if (E == 0) {
                        count++;
                        ChessboardPoint e = new ChessboardPoint(i, j);
                        output.add(e);
                    }
                }
            }
        }
       
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i - j == x - y
                        && chessComponents[i][j].getChessColor() != getChessColor()) {
                    int N = Math.abs(x - i);
                    int row = Math.min(x, i);
                    int col = Math.min(y, j);
                    int E = 0;
                    for (int k = 1; k < N; k++) {
                        if (chessComponents[row + k][col + k].getChessColor() != ChessColor.NONE) {
                            E++;
                        }
                    }
                    if (E == 0) {
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

