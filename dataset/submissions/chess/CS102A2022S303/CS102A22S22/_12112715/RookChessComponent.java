import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(char name, ChessComponent[][] chessComponents, ChessboardPoint source) {
        this.chessComponents = chessComponents;
        setSource(source);
        if (name == 'R') {
            this.name = 'R';
            setChessColor(ChessColor.BLACK);
        } else if (name == 'r') {
            this.name = 'r';
            setChessColor(ChessColor.WHITE);
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> output = new ArrayList<>();
        ChessboardPoint source = getSource();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                ChessComponent chess = chessComponents[i][j];
                //if two chess components have the same color, refuse to move
                if (getChessColor() == chess.getChessColor()) {
                    continue;
                }
                ChessboardPoint destination = new ChessboardPoint(i, j);
                boolean check1 = false;
                if (source.getX() == destination.getX()) {
                    int row = source.getX();
                    boolean check2 = true;
                    for (int col = Math.min(source.getY(), destination.getY()) + 1;
                         col < Math.max(source.getY(), destination.getY()); col++) {
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                            check2 = false;
                            break;
                        }
                    }
                    if (check2) {
                        check1 = true;
                    }
                } else if (source.getY() == destination.getY()) {
                    int col = source.getY();
                    boolean check2 = true;
                    for (int row = Math.min(source.getX(), destination.getX()) + 1;
                         row < Math.max(source.getX(), destination.getX()); row++) {
                        if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                            check2 = false;
                            break;
                        }
                    }
                    if (check2) {
                        check1 = true;
                    }
                }
                if (check1) {
                    output.add(new ChessboardPoint(i, j));
                }
            }
        }
        return output;
    }
}
