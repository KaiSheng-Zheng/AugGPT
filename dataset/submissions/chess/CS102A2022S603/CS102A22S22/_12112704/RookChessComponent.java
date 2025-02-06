import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(char name) {
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        // get current position
        ChessboardPoint currentPoint = this.getSource();

        List<ChessboardPoint> canMoveToPoints = new ArrayList<>();
        // four directions
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        for (int i = 0; i < dx.length; i++) {
            for (int distance = 1; distance <= 8; distance++) {
                ChessboardPoint point = currentPoint.offset(dx[i] * distance, dy[i] * distance);
                if (point != null) {
                    int x = point.getX();
                    int y = point.getY();
                    if (chessComponents[x][y].name == '_') {
                        canMoveToPoints.add(point);
                    } else if (chessComponents[x][y].getChessColor() != this.getChessColor()) {
                        canMoveToPoints.add(point);
                        break;
                    }else if (chessComponents[x][y].getChessColor() == this.getChessColor()) {
                        break;
                    }
                }
            }
        }
        return canMoveToPoints;
    }

    public static void main(String[] args) {
        List<String> chessboard = new ArrayList<>();
        chessboard.add("R_BQK___");
        chessboard.add("PPP__PP_");
        chessboard.add("__NPP_n_");
        chessboard.add("___Np___");
        chessboard.add("___p____");
        chessboard.add("__p_____");
        chessboard.add("pp___pp_");
        chessboard.add("rnb_kb_R");
        chessboard.add("w");

        ConcreteChessGame game = new ConcreteChessGame();
        game.loadChessGame(chessboard);
        ChessComponent chess = game.getChess(7, 7);
        List<ChessboardPoint> chessComponents = chess.canMoveTo();
        for (ChessboardPoint c : chessComponents) {
            System.out.println(c);
        }
    }
}
