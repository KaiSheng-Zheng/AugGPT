import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConcreteChessGame implements ChessGame {
    ChessColor ww = ChessColor.WHITE;
    ChessColor bb = ChessColor.BLACK;
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.BLACK;

    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        char[] black = new char[]{'K', 'Q', 'R', 'B', 'N', 'P'};
        char[] white = new char[]{'k', 'q', 'r', 'b', 'n', 'p'};
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char chessComponent = chessboard.get(i).charAt(j);
                if (chessComponent == '_') putChessOn(new EmptySlotComponent(chessComponents), i, j);
                else if (chessComponent == white[0]) putChessOn(new KingChessComponent(ww, chessComponents), i, j);
                else if (chessComponent == black[0]) putChessOn(new KingChessComponent(bb, chessComponents), i, j);
                else if (chessComponent == white[1]) putChessOn(new QueenChessComponent(ww, chessComponents), i, j);
                else if (chessComponent == black[1]) putChessOn(new QueenChessComponent(bb, chessComponents), i, j);
                else if (chessComponent == white[2]) putChessOn(new RookChessComponent(ww, chessComponents), i, j);
                else if (chessComponent == black[2]) putChessOn(new RookChessComponent(bb, chessComponents), i, j);
                else if (chessComponent == white[3]) putChessOn(new BishopChessComponent(ww, chessComponents), i, j);
                else if (chessComponent == black[3]) putChessOn(new BishopChessComponent(bb, chessComponents), i, j);
                else if (chessComponent == white[4]) putChessOn(new KnightChessComponent(ww, chessComponents), i, j);
                else if (chessComponent == black[4]) putChessOn(new KnightChessComponent(bb, chessComponents), i, j);
                else if (chessComponent == white[5]) putChessOn(new PawnChessComponent(ww, chessComponents), i, j);
                else if (chessComponent == black[5]) putChessOn(new PawnChessComponent(bb, chessComponents), i, j);
                else putChessOn(new EmptySlotComponent(chessComponents), i, j);
            }
        }
        setCurrentPlayer(chessboard.get(8).charAt(0) == 'w' ? ww : bb);
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(ChessColor chessColor) {
        this.currentPlayer = chessColor;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                ChessComponent p = chessComponents[i][j];
                line.append(p);
            }
            if (i < 7) line.append("\n");
        }
        return line.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder line = new StringBuilder();
        int[] BLACK = new int[]{1, 1, 2, 2, 2, 8};
        char[] black = new char[]{'K', 'Q', 'R', 'B', 'N', 'P'};
        int[] WHITE = BLACK.clone();
        char[] white = new char[]{'k', 'q', 'r', 'b', 'n', 'p'};
        /*int K = 1, Q = 1, R = 2, B = 2, N = 2, P = 8, k = 1, q = 1, r = 2, b = 2, n = 2, p = 8;*/
        for (int i = 0; i < chessComponents.length; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                ChessComponent component = chessComponents[i][j];
                if (component instanceof EmptySlotComponent) ;
                else if (component instanceof BishopChessComponent) {
                    if (component.getChessColor() == ChessColor.BLACK) BLACK[3] -= 1;
                    else WHITE[3] -= 1;
                } else if (component instanceof KingChessComponent) {
                    if (component.getChessColor() == ChessColor.BLACK) BLACK[0] -= 1;
                    else WHITE[0] -= 1;
                } else if (component instanceof KnightChessComponent) {
                    if (component.getChessColor() == ChessColor.BLACK) BLACK[4] -= 1;
                    else WHITE[4] -= 1;
                } else if (component instanceof PawnChessComponent) {
                    if (component.getChessColor() == ChessColor.BLACK) BLACK[5] -= 1;
                    else WHITE[5] -= 1;
                } else if (component instanceof QueenChessComponent) {
                    if (component.getChessColor() == ChessColor.BLACK) BLACK[1] -= 1;
                    else WHITE[1] -= 1;
                } else if (component instanceof RookChessComponent) {
                    if (component.getChessColor() == ChessColor.BLACK) BLACK[2] -= 1;
                    else WHITE[2] -= 1;
                }
            }
        }

        if (player == ChessColor.BLACK) {
            for (int i = 0; i < BLACK.length; i++) {
                if (BLACK[i] > 0) {
                    line.append(black[i]).append(" ").append(BLACK[i]).append("\n");
                }
            }
            return line.toString();
        } else if (player == ChessColor.WHITE) {
            for (int i = 0; i < WHITE.length; i++) {
                if (WHITE[i] > 0) {
                    line.append(white[i]).append(" ").append(WHITE[i]).append("\n");
                }
            }
            return line.toString();
        } else return null;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        ArrayList<ChessboardPoint> copy = new ArrayList<>(chess.canMoveTo());
        ArrayList<ChessboardPoint> result = new ArrayList<>();
        while (copy.size() > 0) {
            ChessboardPoint p0 = copy.get(copy.size() - 1);
            for (int j = 0; j < copy.size(); j++) {
                p0 = ChessboardPoint.min(p0, copy.get(j));
            }
            result.add(p0);
            copy.remove(p0);
        }
        return result;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint sourcePoint = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint targetPoint = new ChessboardPoint(targetX, targetY);
        if (currentPlayer!=getChess(sourceX,sourceY).getChessColor()) return false;
        boolean canMove = false;
        for (ChessboardPoint i : getCanMovePoints(sourcePoint)) {
            if (targetPoint.equal(i)) {
                canMove = true;
                swapCurrentColor();
                return canMove;
            }
        }
        return canMove;
    }

    private void swapCurrentColor() {
        currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
    }

    private void putChessOn(ChessComponent chessComponent, int xi, int yj) {
        chessComponents[xi][yj] = chessComponent;
        chessComponent.setSource(new ChessboardPoint(xi, yj));
    }
}