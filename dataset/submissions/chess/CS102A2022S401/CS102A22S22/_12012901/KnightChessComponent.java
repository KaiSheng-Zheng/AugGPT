import java.util.*;

public class KnightChessComponent extends ChessComponent {
    private final ChessComponent[][] chessComponents;

    public KnightChessComponent(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> out = new ArrayList<ChessboardPoint>();
        ArrayList<ChessComponent> chessComponents1 = new ArrayList<ChessComponent>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents1.add(chessComponents[i][j]);
            }
        }
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2,  };
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1,  };
        int x0 = getSource().getX();
        int y0 = getSource().getY();

        for (int i = 0; i < 8; i++) {
            int x = x0;
            int y = y0;
            x += dx[i];
            y += dy[i];
            if ((0 <= x) && (x <= 7) && (0 <= y) && (y <= 7)) {
                for (ChessComponent chessComponent : chessComponents1) {
                    if ((chessComponent.getSource().getX() == x) && (chessComponent.getSource().getY() == y)) {
                        if (chessComponent.getChessColor() != this.getChessColor()) {
                            out.add(new ChessboardPoint(x, y));
                        }
                        break;
                    }
                }

            }
        }
        Collections.sort(out);
        return out;
    }

}

